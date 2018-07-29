public class QuestionClass {
    private String question;
    private String[] choices;

    public QuestionClass() {
        this.question = null;
        this.choices = new String[4];
    }

    public String getQuestion() {
        return question;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }
}
