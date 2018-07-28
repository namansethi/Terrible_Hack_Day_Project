public class QuestionClass {
    private String question;
    private String[] answers;

    public QuestionClass() {
        this.question = null;
        this.answers= new String[4];
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }
}
