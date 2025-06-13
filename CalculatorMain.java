import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorMain implements ActionListener {

  JFrame jFrame;
  JTextField textField;
  JButton[] numberButtons = new JButton[10];
  JButton[] functionButtons = new JButton[8];
  JButton addButton, subButton, multiButton, divButton;
  JButton decButton, equButton, delButton, clearButton;
  JPanel panel;

  Font myFont = new Font("Albertus Medium", Font.BOLD, 30);
  double num1 = 0, num2 = 0, result = 0;
  char operator;

  CalculatorMain() {
    jFrame = new JFrame("Calculator");
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setSize(420, 550);
    jFrame.setLayout(null);

    textField = new JTextField();
    textField.setBounds(50, 25, 300, 50);
    textField.setFont(myFont);
    textField.setEditable(false);

    // function buttons
    addButton = new JButton("+");
    subButton = new JButton("-");
    multiButton = new JButton("*");
    divButton = new JButton("/");
    decButton = new JButton(".");
    equButton = new JButton("=");
    delButton = new JButton("Delete");
    clearButton = new JButton("Clear");

    functionButtons[0] = addButton;
    functionButtons[1] = subButton;
    functionButtons[2] = multiButton;
    functionButtons[3] = divButton;
    functionButtons[4] = decButton;
    functionButtons[5] = equButton;
    functionButtons[6] = delButton;
    functionButtons[7] = clearButton;

    for (int i = 0; i < functionButtons.length; i++) {
      functionButtons[i].addActionListener(this);
      functionButtons[i].setFont(myFont);
      functionButtons[i].setFocusable(false);
    }

    for (int i = 0; i < numberButtons.length; i++) {
      numberButtons[i] = new JButton(String.valueOf(i));
      numberButtons[i].addActionListener(this);
      numberButtons[i].setFont(myFont);
      numberButtons[i].setFocusable(false);
    }

    delButton.setBounds(50, 430, 145, 50);
    clearButton.setBounds(205, 430, 145, 50);
    jFrame.add(delButton);
    jFrame.add(clearButton);

    panel = new JPanel();
    panel.setBounds(50, 100, 300, 300);
    panel.setLayout(new GridLayout(4, 4, 10, 10));
    panel.setBackground(Color.lightGray);

    panel.add(numberButtons[1]);
    panel.add(numberButtons[2]);
    panel.add(numberButtons[3]);
    panel.add(addButton);

    panel.add(numberButtons[4]);
    panel.add(numberButtons[5]);
    panel.add(numberButtons[6]);
    panel.add(subButton);

    panel.add(numberButtons[7]);
    panel.add(numberButtons[8]);
    panel.add(numberButtons[9]);
    panel.add(multiButton);
    panel.add(decButton);
    panel.add(numberButtons[0]);
    panel.add(equButton);
    panel.add(divButton);
    jFrame.add(panel);
    jFrame.add(textField);
    jFrame.setVisible(true);

  }

  public static void main(String[] args) {
    @SuppressWarnings("unused")
    CalculatorMain calc = new CalculatorMain();

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < 10; i++) {
      if (e.getSource() == numberButtons[i]) {
        textField.setText(textField.getText().concat(String.valueOf(i)));
      }
    }
    if (e.getSource() == decButton) {
      textField.setText(textField.getText().concat(String.valueOf(".")));
    }
    if (e.getSource() == addButton) {
      num1 = Double.parseDouble(textField.getText());
      operator = '+';
      textField.setText("");
    }
    if (e.getSource() == subButton) {
      num1 = Double.parseDouble(textField.getText());
      operator = '-';
      textField.setText("");
    }
    if (e.getSource() == multiButton) {
      num1 = Double.parseDouble(textField.getText());
      operator = '*';
      textField.setText("");
    }
    if (e.getSource() == divButton) {
      num1 = Double.parseDouble(textField.getText());
      operator = '/';
      textField.setText("");
    }
    if (e.getSource() == equButton) {
      num2 = Double.parseDouble(textField.getText());
      switch (operator) {
        case '+':
          result = num1 + num2;
          break;
        case '-':
          result = num1 - num2;
          break;
        case '*':
          result = num1 * num2;
          break;
        case '/':
          result = num1 / num2;
          break;

      }
      textField.setText(String.valueOf(result));
      num1 = result;

    }
    if (e.getSource() == clearButton) {
      textField.setText("");
    }
    if (e.getSource() == delButton) {
      String string = textField.getText();
      textField.setText("");
      for (int i = 0; i < string.length() - 1; i++) {
        textField.setText(textField.getText() + string.charAt(i));
        ;
      }
    }

  }
}