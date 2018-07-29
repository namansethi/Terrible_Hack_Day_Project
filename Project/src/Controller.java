import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private Label questionLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private RadioButton choice1;
    @FXML
    private RadioButton choice2;
    @FXML
    private RadioButton choice3;
    @FXML
    private RadioButton choice4;
    @FXML
    private Button nextQuestionButton;
    @FXML
    private Button previousQuestionButton;
    private int currentQuestionNumber=0;
    private int selectedChoice;
    private int answerArray[];
    private int counter = 0;
    QuizClass quizClass = new QuizClass();


    @FXML
    public void initialize() {
        List<RadioButton> list = new ArrayList<>();
        list = allocateRadioButtonsToList(list,choice1,choice2,choice3,choice4);
        attachListenersToRadioButtons(list);
        nextQuestionButton.setOnAction((event) -> {
                loadNextQuestion(titleLabel,questionLabel,choice1,choice2,choice3,choice4);

        });
        previousQuestionButton.setOnAction((event) -> {
            if(currentQuestionNumber>0){

                loadPreviousQuestion(titleLabel,questionLabel,choice1,choice2,choice3,choice4);
            }
            else{
            }
        });

    }




    private List<RadioButton> allocateRadioButtonsToList(List<RadioButton> list, RadioButton choice1, RadioButton choice2, RadioButton choice3, RadioButton choice4) {
        list.add(choice1);
        list.add(choice2);
        list.add(choice3);
        list.add(choice4);
        return list;
    }

    private void attachListenersToRadioButtons(List<RadioButton> list) {

        for (int i = 0; i < list.size(); i++) {

            RadioButton currentRadioButton = list.get(i);

            currentRadioButton.selectedProperty().addListener((obs, wasPreviouslySelected, isNowSelected) -> {
                if (isNowSelected) {
                    selectedChoice = currentRadioButton.getId().indexOf(6)-1;
                    limitSelection(list,currentRadioButton);
                }
            });
        }
    }

    private void limitSelection(List<RadioButton> list,RadioButton radioButton) {

        for (int i = 0; i < list.size(); i++) {

            if(list.get(i).isSelected()&list.get(i)!=radioButton){

                list.get(i).setSelected(false);
            }

        }


    }
    private void loadNextQuestion(Label titleLabel, Label questionLabel, RadioButton choice1, RadioButton choice2, RadioButton choice3, RadioButton choice4) {
        titleLabel.setText(quizClass.getQuizTitle());

        currentQuestionNumber++;
        questionLabel.setText(quizClass.getQuizQuestions()[currentQuestionNumber].getQuestion());
        choice1.setText(quizClass.getQuizQuestions()[currentQuestionNumber].getChoices()[0]);
        choice2.setText(quizClass.getQuizQuestions()[currentQuestionNumber].getChoices()[1]);
        choice3.setText(quizClass.getQuizQuestions()[currentQuestionNumber].getChoices()[2]);
        choice4.setText(quizClass.getQuizQuestions()[currentQuestionNumber].getChoices()[3]);
    }
    private void loadPreviousQuestion(Label titleLabel, Label questionLabel, RadioButton choice1, RadioButton choice2, RadioButton choice3, RadioButton choice4) {

        currentQuestionNumber--;
        titleLabel.setText(quizClass.getQuizTitle());
        questionLabel.setText(quizClass.getQuizQuestions()[currentQuestionNumber].getQuestion());
        choice1.setText(quizClass.getQuizQuestions()[currentQuestionNumber].getChoices()[0]);
        choice2.setText(quizClass.getQuizQuestions()[currentQuestionNumber].getChoices()[1]);
        choice3.setText(quizClass.getQuizQuestions()[currentQuestionNumber].getChoices()[2]);
        choice4.setText(quizClass.getQuizQuestions()[currentQuestionNumber].getChoices()[3]);


    }
}