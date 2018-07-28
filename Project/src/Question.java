public class Question {
    String question;
    String[] answers = new String[4];

    public Question(){
    }

    public Question(String q, String a1, String a2, String a3, String a4){
        question = q;
        answers[0] = a1;
        answers[1] = a2;
        answers[2] = a3;
        answers[3] = a4;
    }

    public Question(String q, String [] a) {
        question = q;
        answers[0] = a[0];
        answers[1] = a[1];
        answers[2] = a[2];
        answers[3] = a[3];
    }

    public String getQuestion() {
        return question;
    }

    public String [] getAnswers() {
        return answers;
    }
}
