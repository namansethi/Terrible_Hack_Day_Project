import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;

public class DictionaryClass extends HashMap<String, ArrayList<String>> {

    public static String SEPARATOR = "**********";
    public ArrayList<String> legalFirstWords;

    public DictionaryClass(String fileName) {
        legalFirstWords = new ArrayList<String>();
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String line = null;

            while((line = file.readLine()) != null) {
                line = line.toUpperCase();
                line = SEPARATOR + " " + line + " " + SEPARATOR;
                line = line.replaceAll("[.?!]+", " $0 " + SEPARATOR + " ");
                line = line.replaceAll("[,;:'&|\"$+=-]+", " $0 ");
                line = line.replaceAll("[\"(\\[{)\\]}]+", " ");
                String[] words = line.split("\\s+");
                for(int i=0; i<words.length-1; i++) {
                    if (!(words[i].equals(SEPARATOR) && words[i+1].equals(SEPARATOR))) {
                        if (words[i].equals(SEPARATOR)) legalFirstWords.add(words[i+1]);
                        else {
                            String newKey = words[i];
                            if (!this.containsKey(newKey)) this.put(newKey, new ArrayList<String>());
                            this.get(newKey).add(words[i+1]);
                        }
                    }
                }
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Cannot open file for reading");
        } catch (IOException e) {
            System.out.println("Error: Cannot read from file");
        }
    }
}
