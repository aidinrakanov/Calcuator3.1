package com.example.calcuator31;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FragmentCalculator extends Fragment {

    TextView result_field;
    Double firstValues;
    Double secondValues;
    Double result;
    String operation;
    String res_text;
    Button save;
    Button one, two,three, four, five, six,
            seven, eight, nine, zero, dot, clear;
    Button plus,minus,divide,multiply2,equals;

    public FragmentCalculator() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculator, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        result_field = view.findViewById(R.id.result1);
        save = view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res_text = result_field.getText().toString();
                MainActivity activity=(MainActivity) getActivity();
                activity.sendNumber(res_text);
            }
        });

        one = view.findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result_field.append("1");
            }
        });
        two = view.findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result_field.append("2");
            }
        });
        three = view.findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {
                        result_field.append("3");
                    }
            });
        four = view.findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result_field.append("4");
            }
        });
        five = view.findViewById(R.id.five);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result_field.append("5");
            }
        });
        six = view.findViewById(R.id.six);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result_field.append("6");
            }
        });
        seven = view.findViewById(R.id.seven);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result_field.append("7");
            }
        });
        eight = view.findViewById(R.id.eight);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result_field.append("8");
            }
        });
        nine = view.findViewById(R.id.nine);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result_field.append("9");
            }
        });
        zero = view.findViewById(R.id.zero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result_field.append("0");
            }
        });
        dot = view.findViewById(R.id.dot);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result_field.append(".");
            }
        });
        clear = view.findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result_field.setText("");
            }
        });
        plus = view.findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "+";
                firstValues = Double.valueOf(result_field.getText().toString());
                result_field.setText(firstValues + "+");
            }
        });
        minus = view.findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "-";
                firstValues = Double.valueOf(result_field.getText().toString());
                result_field.setText(firstValues + "-");
            }
        });
        divide = view.findViewById(R.id.divide);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "/";
                firstValues = Double.valueOf(result_field.getText().toString());
                result_field.setText(firstValues + "/");
            }
        });
        multiply2 = view.findViewById(R.id.multiply2);
        multiply2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "X";
                firstValues = Double.valueOf(result_field.getText().toString());
                result_field.setText(firstValues + "X");
            }
        });
        Button equally=view.findViewById(R.id.equal);
        equally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (result_field != null) {
                    String second = result_field.getText().toString().replace(firstValues + operation + "", "");
                    secondValues = Double.valueOf(second);
                }

                switch (operation) {
                    case "+":
                        plus();
                        break;
                    case "-":
                        minus();
                        break;
                    case "*":
                        multiply2();
                        break;
                    case "/":
                        divide();
                        break;
                }
            }
        });
    }


    public void plus() {
        result = firstValues + secondValues;
        result_field.setText(firstValues + operation + secondValues + "=" + result);
    }
    public void divide() {
        result = firstValues / secondValues;
        result_field.setText(firstValues + operation + secondValues + "=" + result);
    }
    public void multiply2() {
        result = firstValues * secondValues;
        result_field.setText(firstValues + operation + secondValues + "=" + result);
    }
    public void minus() {
        result = firstValues - secondValues;
        result_field.setText(firstValues + operation + secondValues + "=" + result);
    }

}
