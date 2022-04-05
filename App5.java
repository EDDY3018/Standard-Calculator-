package com.App5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App5 {
    private JPanel framePanel;
    private JLabel titleLabel;
    private JTextField answerTextField;
    private JRadioButton onRadioButton;
    private JRadioButton offRadioButton;
    private JButton backspaceButton;
    private JButton clearAllButton;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton;
    private JButton divideButton;
    private JButton fourButton;
    private JButton fiveButton;
    private JButton sixButton;
    private JButton multiplyButton;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;
    private JButton minusButton;
    private JButton zeroButton;
    private JButton pointButton;
    private JButton equalsButton;
    private JButton plusButton;
    private String operand;
    private double answer;


    public App5() {

        //Select onRadioButton by default
        onRadioButton.setEnabled(true);
        zeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerTextField.setText(answerTextField.getText()+"0");
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==oneButton){
                    answerTextField.setText(answerTextField.getText()+"1");
                }
                else if (e.getSource()==twoButton){
                    answerTextField.setText(answerTextField.getText()+"2");
                }
                else if (e.getSource()==threeButton){
                    answerTextField.setText(answerTextField.getText()+"3");
                }
                else if (e.getSource()==fourButton){
                    answerTextField.setText(answerTextField.getText()+"4");
                }
                else if (e.getSource()==fiveButton){
                    answerTextField.setText(answerTextField.getText()+"5");
                }
                else if (e.getSource()==sixButton){
                    answerTextField.setText(answerTextField.getText()+"6");
                }
                else if (e.getSource()==sevenButton){
                    answerTextField.setText(answerTextField.getText()+"7");
                }
                else if (e.getSource()==eightButton){
                    answerTextField.setText(answerTextField.getText()+"8");
                }
                else if (e.getSource()==nineButton){
                    answerTextField.setText(answerTextField.getText()+"9");
                }
                else{
                    answerTextField.setText(answerTextField.getText()+".");
                }

            }
        };
        sevenButton.addActionListener(listener);
        eightButton.addActionListener(listener);
        nineButton.addActionListener(listener);
        fourButton.addActionListener(listener);
        fiveButton.addActionListener(listener);
        sixButton.addActionListener(listener);
        oneButton.addActionListener(listener);
        twoButton.addActionListener(listener);
        threeButton.addActionListener(listener);
        pointButton.addActionListener(listener);

        clearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerTextField.setText("");
            }
        });

        //Action listener for the one and off radio button
        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==onRadioButton){
                    enable();
                }
                else {
                    disable();
                }
            }
        };
        onRadioButton.addActionListener(listener1);
        offRadioButton.addActionListener(listener1);

        //Creating action listener for the multiply, divide, plus and minus buttons
        ActionListener listener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==divideButton){
                    operand = "Divide";
                    answerTextField.setText(answerTextField.getText()+"/");
                }
                else if (e.getSource()==multiplyButton){
                    operand = "Multiply";
                    answerTextField.setText(answerTextField.getText()+"*");
                }
                else if (e.getSource()==plusButton){
                    operand = "Addition";
                    answerTextField.setText(answerTextField.getText()+"+");
                }
                else{
                    operand = "Subtraction";
                    answerTextField.setText(answerTextField.getText()+"-");
                }
            }
        };
        divideButton.addActionListener(listener2);
        multiplyButton.addActionListener(listener2);
        minusButton.addActionListener(listener2);
        plusButton.addActionListener(listener2);

        //Creating action listener for the backspace
        backspaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = answerTextField.getText().length();
                int newLength = length -1;
                String temp;
                if (length >0) {
                    StringBuilder backSpace = new StringBuilder(answerTextField.getText());
                    backSpace.deleteCharAt(newLength);
                    temp= backSpace.toString();
                    answerTextField.setText(temp);
                }
            }
        });
        //Action listener for the equals sign
        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               arithmeticOperation();
            }
        });
    }
    private void enable(){
        onRadioButton.setEnabled(false);
        titleLabel.setEnabled(true);
        answerTextField.setEnabled(true);
        oneButton.setEnabled(true);
        twoButton.setEnabled(true);
        threeButton.setEnabled(true);
        fourButton.setEnabled(true);
        fiveButton.setEnabled(true);
        sixButton.setEnabled(true);
        sevenButton.setEnabled(true);
        eightButton.setEnabled(true);
        nineButton.setEnabled(true);
        zeroButton.setEnabled(true);
        divideButton.setEnabled(true);
        multiplyButton.setEnabled(true);
        plusButton.setEnabled(true);
        minusButton.setEnabled(true);
        pointButton.setEnabled(true);
        clearAllButton.setEnabled(true);
        backspaceButton.setEnabled(true);
        equalsButton.setEnabled(true);
    }
    private void disable(){
        onRadioButton.setEnabled(true);
        titleLabel.setEnabled(false);
        answerTextField.setEnabled(false);
        oneButton.setEnabled(false);
        twoButton.setEnabled(false);
        threeButton.setEnabled(false);
        fourButton.setEnabled(false);
        fiveButton.setEnabled(false);
        sixButton.setEnabled(false);
        sevenButton.setEnabled(false);
        eightButton.setEnabled(false);
        nineButton.setEnabled(false);
        zeroButton.setEnabled(false);
        divideButton.setEnabled(false);
        multiplyButton.setEnabled(false);
        plusButton.setEnabled(false);
        minusButton.setEnabled(false);
        pointButton.setEnabled(false);
        clearAllButton.setEnabled(false);
        backspaceButton.setEnabled(false);
        equalsButton.setEnabled(false);
    }
    private void arithmeticOperation(){
        String [] parts;
        String leftPart, rightPart;

        switch (operand){
            case( "Addition"):
                parts= answerTextField.getText().split("\\+");
                leftPart = parts[0];
                rightPart = parts[1];

                answer = Double.parseDouble(leftPart)+ Double.parseDouble(rightPart);
                answerTextField.setText(String.valueOf(answer));
                break;

            case ("Multiply"):
                parts = answerTextField.getText().split("\\*");
                leftPart  = parts[0];
                rightPart = parts[1];

                answer = Double.parseDouble(leftPart)*Double.parseDouble(rightPart);
                answerTextField.setText(String.valueOf(answer));
                break;
            case ("subtraction"):
                parts = answerTextField.getText().split("-");
                leftPart  = parts[0];
                rightPart = parts[1];

                answer = Double.parseDouble(leftPart)-Double.parseDouble(rightPart);
                answerTextField.setText(String.valueOf(answer));
                break;

            case ("Divide"):
                parts = answerTextField.getText().split("/");
                leftPart  = parts[0];
                rightPart = parts[1];

                answer = Double.parseDouble(leftPart)/Double.parseDouble(rightPart);
                answerTextField.setText(String.valueOf(answer));
                break;
            default:
                answerTextField.setText("");
                break;

        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new App5().framePanel);
        frame.setVisible(true);
    }

}
