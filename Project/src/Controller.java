import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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


    @FXML
    public void initialize() {

        List<RadioButton> list = new ArrayList<RadioButton>();
        list.add(choice1);
        list.add(choice2);
        list.add(choice3);
        list.add(choice4);


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