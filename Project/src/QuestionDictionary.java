import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class QuestionDictionary {
    public static void main(String args[]) {

        ArrayList<String> legalFirstWords = new ArrayList<String>();
        HashMap<String, ArrayList<String>> dict = new HashMap<String, ArrayList<String>>();
        String separator = "**********";

        try {
            BufferedReader file = new BufferedReader(new FileReader("questions.txt"));
            String line = null;

            while((line = file.readLine()) != null) {
                line = line.toUpperCase();
                line = separator + " " + line + " " + separator;
                line = line.replaceAll("[.?!]+", " $0 " + separator + " ");
                line = line.replaceAll("[,;:'&|\"$+=-]+", " $0 ");
                line = line.replaceAll("[\"(\\[{)\\]}]+", " ");
                String[] words = line.split("\\s+");
                for(int i=0; i<words.length-1; i++) {
                    if (!(words[i].equals(separator) && words[i+1].equals(separator))) {
                        if (words[i].equals(separator)) legalFirstWords.add(words[i+1]);
                        else {
                            String newKey = words[i];
                            if (!dict.containsKey(newKey)) dict.put(newKey, new ArrayList<String>());
                            dict.get(newKey).add(words[i+1]);
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

        String currentWord = legalFirstWords.get((int)(Math.random()*legalFirstWords.size()));

        while (!currentWord.equals(separator)) {
            System.out.print(currentWord + " ");

            ArrayList<String> value = dict.get(currentWord);

            currentWord = value.get((int) (Math.random() * value.size()));
        }

    }
}
