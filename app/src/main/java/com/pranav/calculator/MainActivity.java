package com.pranav.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import org.mariuszgromada.math.mxparser.*;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;


import com.pranav.calculator.R;

public class MainActivity extends AppCompatActivity {

    private EditText display;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        display=findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);

    }
    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos=display.getSelectionStart();
        String leftStr=oldStr.substring(0,cursorPos);
        String rightStr=oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
        display.setSelection(cursorPos+1 );

    }
    public void zero(View view){
        updateText("0");

    }
    public void one(View view){
        updateText("1");

    }
    public void two(View view){
        updateText("2");

    }
    public void three(View view) {
        updateText("3");

    }
    public void four(View view){
        updateText("4");

    }
    public void five(View view){
        updateText("5");

    }
    public void six(View view){
        updateText("6");

    }
    public void seven(View view){
        updateText("7");

    }
    public void eight(View view){
        updateText("8");

    }
    public void nine(View view){
        updateText("9");

    }
    public void multiply(View view){
        updateText("×");

    }
    public void divide(View view){
        updateText("÷");

    }
    public void subtract(View view){
        updateText("-");

    }
    public void add(View view){
        updateText("+");

    }
    public void clear(View view){
        display.setText("");

    }
    public void paro(View view){
        updateText("(");


    }
    public void parc(View view){
        updateText(")");


    }
    public void exp(View view){
        updateText("^");

    }
    public void plusMinus(View view){
        updateText("-");

    }
    public void point(View view){
        updateText(".");

    }
    public void backspace(View view){
        int cursorPos= display.getSelectionStart();
        int textLen = display.getText().length();
        if (cursorPos!=0 && textLen!=0){
            SpannableStringBuilder selection= (SpannableStringBuilder) display.getText();
            //SpannableStringBuilder allows to replace  different characters within our string
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }

    }
    public void eql(View view){
        String userExp=display.getText().toString();
         userExp=userExp.replaceAll("÷","/");
        userExp=userExp.replaceAll("×","*");

        Expression exp =new Expression(userExp);
        String result=String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());

    }

}
