import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private Label title;
    @FXML
    private RadioButton choice1;
    @FXML
    private RadioButton choice2;
    @FXML
    private RadioButton choice3;
    @FXML
    private RadioButton choice4;
    private int currentRadioButtonIndex;
    QuizClass quizClass = new QuizClass();


    @FXML
    public void initialize() {
        List<RadioButton> list = new ArrayList<RadioButton>();
        list = allocateRadioButtonsToList(list,choice1,choice2,choice3,choice4);
        attachListenersToRadioButtons(list);

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

            currentRadioButton.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                    if (isNowSelected) {
                        limitSelection(list,currentRadioButton);
                    }
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
}