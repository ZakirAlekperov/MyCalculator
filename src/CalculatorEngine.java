import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorEngine implements ActionListener {

    Calculator parent;

    String selectAction = "";
    double currentResult = 0;
    boolean equal_clicked = false;

    CalculatorEngine(Calculator parent){

        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton clickedButton = (JButton) e.getSource();

       double displayValue = getDisplayValue();

        if(clickedButton == parent.buttonPlus){
            action_click(parent.buttonPlus);
        } else if (clickedButton ==parent.buttonMinus) {
            action_click(parent.buttonMinus);
        }else if (clickedButton== parent.buttonMulti){
            action_click(parent.buttonMulti);
        } else if (clickedButton == parent.buttonDiv) {
            action_click(parent.buttonDiv);
        } else if (clickedButton == parent.buttonPoint) {
            point_click();
        }else if (clickedButton == parent.buttonEqual){
            parent.displayField.setText(""+ equal_click(selectAction, currentResult));
            equal_clicked = true;
        }else {
            number_click(clickedButton, equal_clicked);
        }
    }

    private void point_click() {
        String displayFieldText = parent.displayField.getText();

        if (!displayFieldText.contains(".") && displayFieldText.length() > 0){
            parent.displayField.setText(displayFieldText + ".");
        }
    }

    private void action_click(JButton button ){

        double displayValue = getDisplayValue();

        selectAction = button.getText();
        currentResult = displayValue;
        parent.displayField.setText("");
    }
    private double equal_click(String selectAction, double currentResult){

        double displayValue = getDisplayValue();
        double result = 0;

        if (selectAction == "+"){
            result =  currentResult + displayValue;
        } else if (selectAction =="-") {
            result = currentResult - displayValue;
        } else if (selectAction == "*") {
            result = currentResult * displayValue;
        } else if (selectAction == "/") {
            result = currentResult / displayValue;
        }

        return result;
    }
    private void number_click(JButton button, boolean equal_click){
        String displayFieldText = parent.displayField.getText();

        if (equal_click){
            parent.displayField.setText(button.getText());
        }else {
            parent.displayField.setText(displayFieldText + button.getText());
        }
    }
    private double getDisplayValue(){
        String displayFieldText = parent.displayField.getText();

        double displayValue = 0;

        if(!"".equals(displayFieldText)){
            displayValue = Double.parseDouble(displayFieldText);
        }
        return displayValue;
    }
}
