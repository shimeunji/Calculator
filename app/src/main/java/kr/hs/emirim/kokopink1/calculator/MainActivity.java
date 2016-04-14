package kr.hs.emirim.kokopink1.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //인터페이스안에 추상메소드 있어서 에러뜸 onClick메서드 추가해야
    Button butPlus,butMinus,butDivide,butMultitply;
    EditText editNum1,editNum2;
    TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butPlus=(Button)findViewById(R.id.but1);
        butMinus=(Button)findViewById(R.id.but2);
        butDivide=(Button)findViewById(R.id.but3);
        butMultitply=(Button)findViewById(R.id.but4);
        editNum1=(EditText)findViewById(R.id.edit_1);
        editNum2=(EditText)findViewById(R.id.edit_2);
        textResult=(TextView)findViewById(R.id.text_result);
        butPlus.setOnClickListener(this); //onClick호출
        butMinus.setOnClickListener(this);
        butDivide.setOnClickListener(this);
        butMultitply.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // 1)editText에 입력된 값 반환 -> 정수
        // 2)연산 (사칙)
        // 3) TextView에 설정
        String num1Str=editNum1.getText().toString(); //String 강제 형변환도 가능
        String num2Str=editNum2.getText().toString();
        int num1=Integer.parseInt(num1Str);
        int num2=Integer.parseInt(num2Str);
        double result=0;
        switch (v.getId())//객체가 갖고있는 ID값
        {
            case R.id.but1: result=num1+num2; break;
            case R.id.but2: if(num1>num2) result=num1-num2; else result=num2-num1; break;
            case R.id.but3: result=(double)num1/num2; break;
            case R.id.but4: result=num1*num2; break;
        }
        textResult.setText("계산결과 : "+result);
    }


}
