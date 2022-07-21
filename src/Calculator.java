import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;


public class Calculator {

    //Объявление всех компонентов калькулятора
    JPanel windowsContent;
    JTextField displayField;
    JButton numButtons[] = new JButton[10];
    JButton buttonPoint;
    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonDiv;
    JButton buttonMulti;


    JButton buttonEqual;
    JPanel p1;
    JPanel p2;

    //В конструкторе создаются все компоненты и добавляются на фрейм
    //с помощью комбинации Borderlayout и Gridlayout
    Calculator(){

        windowsContent = new JPanel();

        //Создаем схему для заполнения панели
        BorderLayout borderLayout = new BorderLayout();
        windowsContent.setLayout(borderLayout);

        //Создаем и отображаем поле
        //Добавляем его в северную область окна

        //displayField = new JTextField(30);
        displayField = new JFormattedTextField();
        windowsContent.add("North",displayField);

        //Создаем кнопки, используя конструктор класса JButton,
        //который приниммает текст внопки в качестве параметра
        for(int i=0; i<=9; i++){
            numButtons[i] = new JButton(String.valueOf(i));
        }
        buttonPoint = new JButton(".");
        buttonEqual = new JButton("=");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonMulti = new JButton("*");
        buttonDiv = new JButton("/");


        //Создем панель с GridLayout которая содержит 12 кнопок - 10 с числами, точка, равно

        p1 = new JPanel();
        GridLayout gridLayout = new GridLayout(4,3);
        p1.setLayout(gridLayout);

        //Добавляем кнопки на панель
        for(int i=0; i<numButtons.length; i++){
            p1.add(numButtons[i]);
        }
        p1.add(buttonPoint);
        p1.add(buttonEqual);


        p2 = new JPanel();
        GridLayout gridLayout2 = new  GridLayout(4,1);
        p2.setLayout(gridLayout);

        p2.add(buttonPlus);
        p2.add(buttonMinus);
        p2.add(buttonMulti);
        p2.add(buttonDiv);


        //Помещаем панель p1  в центральную область окна
        windowsContent.add("Center", p1);
        windowsContent.add("East", p2);

        //Создаем фрейм и задаем его основную панель
        JFrame  frame = new JFrame("Calculator");
        frame.setContentPane(windowsContent);

        //Делаем размеры окна достаточными для того, чтобы вместить все компонеты
        frame.pack();

        //Отображаем окно
        frame.setVisible(true);

        CalculatorEngine calculatorEngine = new CalculatorEngine(this);
        for(int i =0; i< numButtons.length; i++){
            numButtons[i].addActionListener(calculatorEngine);
        }
        buttonPoint.addActionListener(calculatorEngine);
        buttonDiv.addActionListener(calculatorEngine);
        buttonMulti.addActionListener(calculatorEngine);
        buttonMinus.addActionListener(calculatorEngine);
        buttonEqual.addActionListener(calculatorEngine);
        buttonPlus.addActionListener(calculatorEngine);

    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }
}
