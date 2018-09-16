package cn.gdxhlm.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button horn=findViewById(R.id.btn_horn);
        Button plus=findViewById(R.id.btn_plus);
        Button minus=findViewById(R.id.minus);
        Button delate=findViewById(R.id.btn_delate);

        Button button1=findViewById(R.id.btn_1);
        Button button2=findViewById(R.id.btn_2);
        Button button3=findViewById(R.id.btn_3);
        Button multiply=findViewById(R.id.btn_multiply);

        Button button4=findViewById(R.id.btn_4);
        Button button5=findViewById(R.id.btn_5);
        Button button6=findViewById(R.id.btn_6);
        Button division=findViewById(R.id.btn_division);

        Button button7=findViewById(R.id.btn_7);
        Button button8=findViewById(R.id.btn_8);
        Button button9=findViewById(R.id.btn_9);
        Button equals=findViewById(R.id.btn_equals);

        Button button0=findViewById(R.id.btn_0);
        Button dian=findViewById(R.id.btn_dian);
        Button about=findViewById(R.id.btn_about);


        horn.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        delate.setOnClickListener(this);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        multiply.setOnClickListener(this);

        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        division.setOnClickListener(this);

        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        equals.setOnClickListener(this);

        button0.setOnClickListener(this);
        dian.setOnClickListener(this);
        about.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        editText1=findViewById(R.id.edit_1);
        String str=editText1.getText().toString();
        switch (v.getId()){
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
                editText1.setText(str+((Button)v).getText());
                break;
            case R.id.btn_plus:
            case R.id.minus:
            case R.id.btn_multiply:
            case R.id.btn_division:
                editText1.setText(str+" "+((Button)v).getText()+" ");
                break;
            case R.id.btn_delate:
                if(str!=null&&!str.equals(" ")){
                    editText1.setText(str.substring(0,editText1.length()-1));
                }
                break;
            case R.id.btn_equals:
                getResult();
                break;
        }
    }
    private void getResult(){
        editText1=findViewById(R.id.edit_1);
        Double r=0.0;
        String exp=editText1.getText().toString();
        int space=exp.indexOf(" ");
        if(exp==null){
            return;
        }
        String s1=exp.substring(0,space);
        String fh=exp.substring(space+1,space+2);
        String s2=exp.substring(space+3);

        Double d1=Double.parseDouble(s1);
        Double d2=Double.parseDouble(s2);
        switch (fh){
            case "+":
                r=d1+d2;
               break;
            case "—":
                r=d1-d2;
                break;
            case "*":
                r=d1*d2;
              break;
            case "÷":
                r=d1/d2;
              break;
        }
        String jg=String.valueOf(r);
        editText1.setText(jg);

    }




}
