package com.bistu.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1,textView2,textView_op,textView_res;
    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1=(TextView) findViewById(R.id.textview_num1);
        textView2=(TextView)findViewById(R.id.textview_num2);
        textView_op=(TextView)findViewById(R.id.textview_op);
        textView_res=(TextView)findViewById(R.id.textview_res);

        Button t_C=(Button) findViewById(R.id.C);
        Button t_genhao=(Button) findViewById(R.id.genhao);
        Button t_quyu=(Button) findViewById(R.id.quyu);
        Button t_add=(Button) findViewById(R.id.add);

        Button t_num7=(Button) findViewById(R.id.num7);
        Button t_num8=(Button) findViewById(R.id.num8);
        Button t_num9=(Button) findViewById(R.id.num9);
        Button t_sub=(Button) findViewById(R.id.sub);

        Button t_num4=(Button) findViewById(R.id.num4);
        Button t_num5=(Button) findViewById(R.id.num5);
        Button t_num6=(Button) findViewById(R.id.num6);
        Button t_xinghao=(Button) findViewById(R.id.xinghao);

        Button t_num1=(Button) findViewById(R.id.num1);
        Button t_num2=(Button) findViewById(R.id.num2);
        Button t_num3=(Button) findViewById(R.id.num3);
        Button t_chuhao=(Button) findViewById(R.id.chuhao);

        Button t_jiahuojian=(Button) findViewById(R.id.jiahuojian);
        Button t_num0=(Button) findViewById(R.id.num0);
        Button t_dian=(Button) findViewById(R.id.dian);
        Button t_denhao=(Button) findViewById(R.id.denhao);

        calculator=new Calculator();

        View.OnClickListener buttonlistener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String show=((Button)view).getText().toString();
                calculator.process(show);
                textView1.setText(calculator.getSnum1());
                textView_op.setText(calculator.getSop());
                textView2.setText(calculator.getSnum2());
                textView_res.setText(calculator.getSres());
            }
        };
        t_num0.setOnClickListener(buttonlistener);
        t_num1.setOnClickListener(buttonlistener);
        t_num2.setOnClickListener(buttonlistener);
        t_num3.setOnClickListener(buttonlistener);
        t_num4.setOnClickListener(buttonlistener);
        t_num5.setOnClickListener(buttonlistener);
        t_num6.setOnClickListener(buttonlistener);
        t_num7.setOnClickListener(buttonlistener);
        t_num8.setOnClickListener(buttonlistener);
        t_num9.setOnClickListener(buttonlistener);

        t_C.setOnClickListener(buttonlistener);
        t_genhao.setOnClickListener(buttonlistener);
        t_quyu.setOnClickListener(buttonlistener);
        t_jiahuojian.setOnClickListener(buttonlistener);

        t_add.setOnClickListener(buttonlistener);
        t_sub.setOnClickListener(buttonlistener);
        t_xinghao.setOnClickListener(buttonlistener);
        t_chuhao.setOnClickListener(buttonlistener);

        t_dian.setOnClickListener(buttonlistener);
        t_denhao.setOnClickListener(buttonlistener);

    }
}
