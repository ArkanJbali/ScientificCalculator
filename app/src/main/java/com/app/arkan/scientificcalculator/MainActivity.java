package com.app.arkan.scientificcalculator;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Button MRbtn, MCbtn, MPbtn, Nbtn,
            one, two,three,four,five,six,seven,eight,nine,zero, dot,equal,plus,div, mult, min, clear, del, fact, squared, cubed;
    ImageView rotate;
    TextView resultCal;
    float savedNumber; // for MC, MR, M+, N operations
    float firstValue = 0.0f,secondValue = 0.0f;
    char operation = ' ';
    public long fact(long n){
        if(n==1 || n==0){
            return 1;
        }
        return n*fact(n-1);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        resultCal = findViewById(R.id.resultCalc);
        outState.putString("txt", resultCal.getText().toString());
        Log.d("SaveSS",resultCal.getText().toString());
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        resultCal = findViewById(R.id.resultCalc);
        resultCal.setText(savedInstanceState.getString("txt"));
        Log.d("SaveSS",resultCal.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_landscape);
        //---get the current display info---
        WindowManager wm = getWindowManager();
        Display dd = wm.getDefaultDisplay();
        if (dd.getWidth() >= dd.getHeight()) {
            //---landscape mode---
            setContentView(R.layout.activity_landscape);
             Log.d("Orientation", "Landscape mode");
        }
        else {
            //---portrait mode---
            setContentView(R.layout.activity_main);
            Log.d("Orientation", "Portrait mode");
        }

        rotate = findViewById(R.id.rotate);
        resultCal = findViewById(R.id.resultCalc);
        del = findViewById(R.id.delBtn);
        one = findViewById(R.id.oneBtn);
        two = findViewById(R.id.twoBtn);
        three = findViewById(R.id.threeBtn);
        four = findViewById(R.id.fourBtn);
        five = findViewById(R.id.fiveBtn);
        six = findViewById(R.id.sixBtn);
        seven = findViewById(R.id.sevBtn);
        eight = findViewById(R.id.eightBtn);
        nine = findViewById(R.id.nineBtn);
        zero = findViewById(R.id.zeroBtn);
        dot = findViewById(R.id.dotBtn);
        equal = findViewById(R.id.equalBtn);
        plus = findViewById(R.id.pluBtn);
        div = findViewById(R.id.divBtn);
        mult = findViewById(R.id.mulBtn);
        min = findViewById(R.id.minBtn);
        clear = findViewById(R.id.clearBtn);
        fact = findViewById(R.id.factBtn);
        squared  = findViewById(R.id.seqBtn);
        cubed = findViewById(R.id.cubeBtn);

        MRbtn = findViewById(R.id.MRBtn);
        MCbtn = findViewById(R.id.MCBtn);
        MPbtn = findViewById(R.id.MpBtn);
        Nbtn = findViewById(R.id.NBtn);
        MRbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedNumber !=0.0f) {
                    resultCal.setText(resultCal.getText().toString() + String.valueOf(savedNumber));
                } else{
                    Toast t = Toast.makeText(getApplicationContext(),"There is no number stored in memory", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });
        MPbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedNumber = Float.parseFloat(resultCal.getText().toString());
                resultCal.setText("");
            }
        });
        MCbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedNumber = 0.0f;
            }
        });
        Nbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operation == ' ') {
                    float negationNo = Float.parseFloat(resultCal.getText().toString());
                    negationNo *= -1;
                    resultCal.setText(String.valueOf(negationNo));
                }else{
                    String txt = resultCal.getText().toString();
                    String txt2 =txt.substring(txt.lastIndexOf(operation)+1);
                    float negationNo = Float.parseFloat(txt2);
                    resultCal.setText(txt.substring(0,txt.lastIndexOf(operation)+1) +" "+ negationNo*-1);

                }
            }
        });
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WindowManager wm = getWindowManager();
                Display dd = wm.getDefaultDisplay();
                if (dd.getWidth() >= dd.getHeight()) {
                    //---landscape mode---
                    setContentView(R.layout.activity_main);
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    Log.d("Orientation", "Landscape mode");
                }
                else {
                    //---portrait mode---
                    setContentView(R.layout.activity_landscape);
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
                    Log.d("Orientation", "Portrait mode");
                }
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCal.setText(resultCal.getText() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCal.setText(resultCal.getText() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCal.setText(resultCal.getText() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCal.setText(resultCal.getText() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCal.setText(resultCal.getText() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCal.setText(resultCal.getText() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCal.setText(resultCal.getText() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCal.setText(resultCal.getText() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCal.setText(resultCal.getText() + "9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCal.setText(resultCal.getText() + "0");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultCal.setText("");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = resultCal.getText().toString();
                if(!s.endsWith(".")) {
                    if(s.equals("")){
                        resultCal.setText(resultCal.getText() + "0.");
                    }
                    else if(!(s.contains("."))){
                        resultCal.setText(resultCal.getText() + ".");
                    }
                    else if(s.contains(operation+" ")){
                        if(!s.substring(s.indexOf(operation)+1,s.length()).contains(".")){
                            resultCal.setText(resultCal.getText() + ".");
                        }else if(s.substring(s.indexOf(operation)+1,s.length()).equals("  ")){
                            resultCal.setText(resultCal.getText() + "0.");
                        }
                        // Log.d("ok",s.substring(s.indexOf(operation),s.length()));
                    }

                }

            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //resultCal = findViewById(R.id.resultCalc);
               String txt = resultCal.getText().toString();
                if(!txt.equals("")) {
                    if (operation == ' ') {
                        firstValue = Float.parseFloat(txt);
                        operation = '+';
                        resultCal.setText(resultCal.getText() + " + ");
                    }
                }
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = resultCal.getText().toString();
                if(!txt.equals("")) {
                    if (operation == ' ') {
                        firstValue = Float.parseFloat(txt);
                        operation = '*';
                        resultCal.setText(resultCal.getText() + " * ");
                    }
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = resultCal.getText().toString();
                if(!txt.equals("")) {
                    if (operation == ' ') {
                        firstValue = Float.parseFloat(txt);
                        operation = '/';
                        resultCal.setText(resultCal.getText() + " / ");
                    }
                }
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = resultCal.getText().toString();
                if(!txt.equals("")) {
                    if (operation == ' ') {
                        firstValue = Float.parseFloat(txt);
                        operation = '-';
                        resultCal.setText(resultCal.getText() + " - ");
                    }
                }
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = resultCal.getText().toString();
                if(!txt.equals("")) {
                    txt = txt.substring(0, txt.length() - 1);
                    resultCal.setText(txt);
                }
                if(!txt.contains(operation+"")){
                    operation = ' ';
                }
                if(txt.equals("")){
                    firstValue = 0.0f;
                    secondValue = 0.0f;
                    operation = ' ';
                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt = resultCal.getText().toString();
                if(!txt.equals("")){
                    if(operation == '+') {
                        String txt2 =txt.substring(txt.lastIndexOf('+')+1);
                      //  Log.d("addd", txt2);
                        if(!txt2.equals(" ")) {
                            secondValue = Float.parseFloat(txt2);
                            resultCal.setText((firstValue + secondValue) + "");
                            operation = ' ';
                        }
                        else{
                            operation = '+';
                        }
                    }
                    if(operation == '*') {
                        String txt2 =txt.substring(txt.lastIndexOf('*')+1);
                        //  Log.d("addd", txt2);
                        if(!txt2.equals(" ")) {
                            secondValue = Float.parseFloat(txt2);
                            resultCal.setText((firstValue * secondValue) + "");
                            operation = ' ';
                        }
                        else{
                            operation = '*';
                        }
                    }
                    if(operation == '-') {
                        String txt2 =txt.substring(txt.lastIndexOf('-')+1);
                        //  Log.d("addd", txt2);
                        if(!txt2.equals(" ")) {
                            secondValue = Float.parseFloat(txt2);
                            resultCal.setText((firstValue - secondValue) + "");
                            operation = ' ';
                        }
                        else{
                            operation = '-';
                        }
                    }
                    if(operation == '/') {
                        try{
                                String txt2 =txt.substring(txt.lastIndexOf('/')+1);
                                //  Log.d("addd", txt2);
                                if(!txt2.equals(" ")) {
                                    secondValue = Float.parseFloat(txt2);
                                    resultCal.setText((firstValue / secondValue) + "");
                                    operation = ' ';
                                }
                                else{
                                    operation = '/';
                                }
                        if( Double.isInfinite((firstValue / secondValue))){
                            resultCal.setText("" + firstValue);
                            Toast t = Toast.makeText(getApplicationContext(),"Can't Devide on Zero!! Infinity",Toast.LENGTH_LONG);
                            t.show();
                        }
                        if(Double.isNaN((firstValue / secondValue))){
                            resultCal.setText("" + firstValue);
                            Toast t = Toast.makeText(getApplicationContext(),"Can't Devide on Zero!! NaN",Toast.LENGTH_LONG);
                            t.show();
                        }
                        }catch (ArithmeticException e){
                            resultCal.setText("");
                            Toast t = Toast.makeText(getApplicationContext(),"Can't Devide on Zero!!",Toast.LENGTH_LONG);
                            t.show();
                        }
                    }
                }
                //operation = ' ';
            }
        });
        squared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = resultCal.getText().toString();
                if(!txt.equals("")) {
                    if(operation == ' '){
                        resultCal.setText(Float.parseFloat(txt)*Float.parseFloat(txt) + "");
                    }
                }
            }
        });
        cubed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = resultCal.getText().toString();
                if(!txt.equals("")) {
                    if(operation == ' '){
                        resultCal.setText(Float.parseFloat(txt)*Float.parseFloat(txt)*Float.parseFloat(txt) + "");
                    }
                }
            }
        });
        fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = resultCal.getText().toString();
                if(!txt.equals("")) {
                    if(operation == ' '){
                        resultCal.setText(fact(Long.parseLong(txt)) + "");
                    }
                }
            }
        });
    }
}
