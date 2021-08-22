package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button dot;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button equal;
    private Button clear;
    private TextView info;
    private TextView result;
    private final char ADDITION ='+';
    private final char SUBTRACTION ='-';
    private final char MULTIPLICATION ='*';
    private final char DIVISION ='/';
    private  final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIviews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"9");
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+".");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                result.setText(String.valueOf(val1) + "+");
                info.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBTRACTION;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(val1) + "*");
                info.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                result.setText(String.valueOf(val1) + "/");
                info.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQU;
                info.setText(result.getText().toString() + String.valueOf(val2));
                result.setText(String.valueOf(val1));

                //result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                // 5+ 4  = 9
                //info.setText(null);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( info.getText().length() > 0) {
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length()-1));

                    //next2 lines trail for result deletion
                    //CharSequence name1 = result.getText().toString();
                    //result.setText(name.subSequence(0, name1.length()-1));
                }
                else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });
    }

    private void setupUIviews() {

        zero = (Button)findViewById(R.id.Btn0);
        one = (Button)findViewById(R.id.Btn1);
        two = (Button)findViewById(R.id.Btn2);
        three = (Button)findViewById(R.id.Btn3);
        four = (Button)findViewById(R.id.Btn4);
        five = (Button)findViewById(R.id.Btn5);
        six = (Button)findViewById(R.id.Btn6);
        seven = (Button)findViewById(R.id.Btn7);
        eight = (Button)findViewById(R.id.Btn8);
        nine = (Button)findViewById(R.id.Btn9);
        dot = (Button)findViewById(R.id.Btndot);
        add = (Button)findViewById(R.id.BtnAdd);
        sub = (Button)findViewById(R.id.BtnSub);
        mul = (Button)findViewById(R.id.BtnMul);
        div = (Button)findViewById(R.id.BtnDiv);
        equal = (Button)findViewById(R.id.BtnEqual);
        clear = (Button) findViewById(R.id.BtnClear);
        info = (TextView)findViewById(R.id.tvControl);
        result = (TextView)findViewById(R.id.tvResult);

    }

    private void compute() {
        if(!Double.isNaN(val1)) {
            val2 = Double.parseDouble(info.getText().toString());

            switch(ACTION) {
                case  ADDITION:
                    val1 = val1 + val2;
                    break;
                case  SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case  MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case  DIVISION:
                    val1 = val1 / val2;
                    break;
                case  EQU:
                    break;
            }
        }
        else{
            val1 = Double.parseDouble(info.getText().toString());
        }
    }
}