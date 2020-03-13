package com.example.calcuator31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.content.pm.ActivityInfo;

public class MainActivity extends AppCompatActivity {

    TextView result_field;
    Double firstValues;
    Double secondValues;
    Double result;
    String operation;
    String savedString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_field = findViewById(R.id.result1);
        if (savedInstanceState != null){
            savedString = savedInstanceState.getString("savedString");
            result_field.setText(savedString);
            Log.d("ololo","onCreate"+ savedString);
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ololo","onStart");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ololo","onStop");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("ololo","onSaveInstanceState");
        outState.putString("savedString", result_field.getText().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ololo","onDestroy");
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {

            case R.id.seven:
                result_field.append("7");
                break;
            case R.id.eight:
                result_field.append("8");
                break;
            case R.id.nine:
                result_field.append("9");
                break;
            case R.id.four:
                result_field.append("4");
                break;
            case R.id.five:
                result_field.append("5");
                break;
            case R.id.six:
                result_field.append("6");
                break;
            case R.id.one:
                result_field.append("1");
                break;
            case R.id.two:
                result_field.append("2");
                break;
            case R.id.three:
                result_field.append("3");
                break;
            case R.id.zero:
                result_field.append("0");
                break;
            case R.id.clear:
                result_field.setText("");
                break;
            case R.id.dot:
                result_field.append(".");
                break;
        }
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                operation = "+";
                firstValues = Double.valueOf(result_field.getText().toString());
                result_field.setText(firstValues + "+");
                break;
            case R.id.divide:
                operation = "/";
                firstValues = Double.valueOf(result_field.getText().toString());
                result_field.setText(firstValues + "/");
                break;
            case R.id.minus:
                operation = "-";
                firstValues = Double.valueOf(result_field.getText().toString());
                result_field.setText(firstValues + "-");
                break;
            case R.id.multiply2:
                operation = "*";
                firstValues = Double.valueOf(result_field.getText().toString());
                result_field.setText(firstValues + "*");
                break;
                case R.id.equal:
                if (operation != null) {
                    String two = result_field.getText().toString().replace(firstValues + operation + "", "");
                    secondValues = Double.valueOf(two);

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
                }
        }

    //todo            firstValues + operation + secondValues + "=" + result
    //todo            append("=" + result.toString());

    public void plus() {
        result = firstValues + secondValues;
        result_field.setText(result.toString());
    }
    public void divide() {
        result = firstValues / secondValues;
        result_field.setText(result.toString());
    }
    public void multiply2() {
        result = firstValues * secondValues;
        result_field.setText(result.toString());
    }
    public void minus() {
        result = firstValues - secondValues;
        result_field.setText(result.toString());
        }

    public void saver(View view) {
        String text =result_field.getText().toString();
        Intent intent= new Intent();
        intent.putExtra("resultat",text);
        setResult(RESULT_OK, intent);
        finish();

    }
}
