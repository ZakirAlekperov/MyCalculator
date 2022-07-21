import javax.swing.*;
import java.awt.GridLayout;

public class SimpleCalculator {
    public static void main(String[] args) {
        //Создаем панель

        JPanel windowContent = new JPanel();

        //Задаем менеджер отображения этой панели

        GridLayout gl = new GridLayout(4,2);
        windowContent.setLayout(gl);

        //Создаем компоненты в памяти

        JLabel label1 = new JLabel("Number 1:");
        JTextField textField1 = new JTextField(10);
        JLabel label2 = new JLabel("Number 2:");
        JTextField textField2 = new JTextField(10);
        JLabel label3 = new JLabel("Sum:");
        JTextField rezult = new JTextField(10);
        JButton go = new JButton("Add");

        //Добавляем компоненты на панель
        windowContent.add(label1);
        windowContent.add(textField1);
        windowContent.add(label2);
        windowContent.add(textField2);
        windowContent.add(label3);
        windowContent.add(rezult);
        windowContent.add(go);

        //Создаем фрейм и задаем для него панель
        JFrame frame = new JFrame("My first Calculator");
        frame.setContentPane(windowContent);

        //Задаем размер и делаем фрейм видимым

        frame.setSize(500,300);
        frame.setVisible(true);
    }
}
