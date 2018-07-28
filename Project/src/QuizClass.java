import java.util.ArrayList;

public class QuizClass{

    private DictionaryClass titlesDict;
    private DictionaryClass questionsDict;
    private DictionaryClass answersDict;
    private DictionaryClass resultsDict;
    public String quizTitle;
    public QuestionClass[] quizQuestions;
    public String[] quizResults;

    public QuizClass() {
        titlesDict = new DictionaryClass("titles.text");
        questionsDict = new DictionaryClass("questions.txt");
        answersDict = new DictionaryClass("answers.txt");
        resultsDict = new DictionaryClass("results.txt");

        quizTitle = generateSentenceFrom(titlesDict);
        quizQuestions = new QuestionClass[10];
        for(int i=0; i<10; i++) {
            quizQuestions[i].question = generateSentenceFrom(questionsDict);
            for(int k=0; k<4; k++) {
                quizQuestions[i].answers[k] = generateSentenceFrom(answersDict);
            }
        }
    }

    public String generateSentenceFrom(DictionaryClass dict) {
        String newSentence = null;
        String currentWord = dict.legalFirstWords.get((int)(Math.random()*dict.legalFirstWords.size()));
        while (!currentWord.equals(dict.SEPARATOR)) {
            newSentence += currentWord + " ";
            ArrayList<String> value = dict.get(currentWord);
            currentWord = value.get((int) (Math.random() * value.size()));
        }
        return newSentence;
    }
}