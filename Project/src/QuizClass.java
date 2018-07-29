import java.util.ArrayList;

public class QuizClass{

    private DictionaryClass titlesDict;
    private DictionaryClass questionsDict;
    private DictionaryClass answersDict;
    private DictionaryClass resultsDict;
    private String quizTitle;
    private QuestionClass[] quizQuestions;
    private String[] quizResults;
    private int topResult;

    public QuizClass() {
        //topResult = (int)Math.random()*40;
        titlesDict = new DictionaryClass("titles.txt");
        questionsDict = new DictionaryClass("questions.txt");
        answersDict = new DictionaryClass("choices.txt");
        resultsDict = new DictionaryClass("results.txt");

        quizTitle = generateSentenceFrom(titlesDict);
        quizQuestions = new QuestionClass[10];
        for(int i=0; i<10; i++) {
            quizQuestions[i] = new QuestionClass();
            quizQuestions[i].setQuestion(generateSentenceFrom(questionsDict));
            for(int k=0; k<4; k++) {
                quizQuestions[i].getChoices()[k] = generateSentenceFrom(answersDict);
            }
        }
    }

    public String generateSentenceFrom(DictionaryClass dict) {
        String newSentence = "";
        String currentWord = dict.legalFirstWords.get((int)(Math.random()*dict.legalFirstWords.size()));
        while (!currentWord.equals(dict.SEPARATOR)) {
            newSentence += currentWord + " ";
            ArrayList<String> value = dict.get(currentWord);
            currentWord = value.get((int) (Math.random() * value.size()));
        }
        return newSentence;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public QuestionClass[] getQuizQuestions() {
        return quizQuestions;
    }

    public DictionaryClass getResultsDict() {
        return resultsDict;
    }

    public double calculateScore(int[] choiceNumber){
        int sumScore = 0;
        int percentageScore = 0;
        for(int i = 0; i<10; i++){
            sumScore = sumScore + choiceNumber[i];
        }
        //if (sumScore < topResult) {
            //percentageScore = 100 - (Math.abs(sumScore - topResult));
        //}
        percentageScore = (int)Math.random()*100;
        return percentageScore;
    }

}