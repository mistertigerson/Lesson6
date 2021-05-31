package com.example.lesson6;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private static TextView panel;
    private static String operation = "";
    private boolean isOperation = false;
    private static String intermediateNumber = "";
    private static double firstNumber;
    private double secondNumber;
    private double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        panel = findViewById(R.id.calc_title);


    }
    public static void setupNUmber(){

    }

    public void onClick_buttonTyping(View view) {
        if (isOperation) {
            panel.setText("");
            result = 0;
            operation = null;
            firstNumber = 0;
            secondNumber = 0;
            intermediateNumber = "";
            isOperation = false;
        }
        switch (view.getId()) {

            case R.id.zero:
                if (!intermediateNumber.startsWith("0") || intermediateNumber.contains(".")) {
                    intermediateNumber += "0";
                }
                break;

            case R.id.one:
                intermediateNumber += "1";
                break;

            case R.id.two:
                intermediateNumber += "2";
                break;

            case R.id.three:
                intermediateNumber += "3";
                break;

            case R.id.four:
                intermediateNumber += "4";
                break;

            case R.id.five:
                intermediateNumber += "5";
                break;

            case R.id.six:
                intermediateNumber += "6";
                break;

            case R.id.seven:
                intermediateNumber += "7";
                break;

            case R.id.eight:
                intermediateNumber += "8";
                break;

            case R.id.nine:
                intermediateNumber += "9";
                break;

            case R.id.dot:
                if (!intermediateNumber.contains(".")) {
                    intermediateNumber += ".";
                }
                break;

            case R.id.AC:
                intermediateNumber = "";
                break;
        }
        panel.setText(intermediateNumber);
    }


    public static void firstNumber(String one) {

        firstNumber = Double.parseDouble(intermediateNumber);
        operation = one;
        intermediateNumber = "";
        panel.setText(one);

    }

    @SuppressLint("SetTextI18n")
    public void Logic_onClick_buttonTyping(View view) {


        try {
            switch (view.getId()) {

                case R.id.pluus:

                    firstNumber("+");
                    break;
                case R.id.minus:
                    firstNumber("-");
                    break;


                case R.id.multiplication:
                    firstNumber("*");
                    break;

                case R.id.division:
                    firstNumber("/");
                    break;


                case R.id.equals:
                    secondNumber = Double.parseDouble(intermediateNumber);
                    switch (operation) {
                        case "+":
                            result = firstNumber + secondNumber;
                            break;
                        case "-":
                            result = firstNumber - secondNumber;
                            break;
                        case "*":
                            result = firstNumber * secondNumber;
                            break;

                        case "/":
                            if (firstNumber == 0 || secondNumber == 0) {
                                intermediateNumber = "Ошибка";
                                panel.setText(intermediateNumber);
                            } else {
                                result = firstNumber / secondNumber;
                            }
                            break;
                    }


                    if (!intermediateNumber.equals("Ошибка")) {
                        panel.setText(result + "");
                    }
                    isOperation = true;
                    break;
            }
        } catch (Exception ignore) {

        }
    }

}


