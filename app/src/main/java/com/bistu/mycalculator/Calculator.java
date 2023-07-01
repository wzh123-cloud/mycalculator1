package com.bistu.mycalculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {
    BigDecimal b1,b2,bres;
    int scale;
    String snum1,snum2,sop,sres;
    enum state{state_i1,state_i2,state_init,state_res};
    state s;

    public Calculator(){
        scale=3;
        clear();
    }

    public void process(String show)
    {
        if(show.charAt(0)>='0'&& show.charAt(0)<='9')//输入数字
        {
            switch (s)
            {
                case state_init:
                    if(show.charAt(0)=='0')break;
                    snum1=show;
                    s=state.state_i1;
                    break;
                case state_i1:
                    snum1+=show;
                    break;
                case state_i2:
                    snum2+=show;
                    break;
                case state_res:
                    clear();
                    process(show);
                    break;
            }
        }
        else//输入操作符
        {
            switch (show)
            {
                case "C":
                    clear();
                    break;
                case "+":
                    switch (s)
                    {
                        case state_init: sop=show;s=state.state_i2;
                            break;
                        case state_i1: sop=show;s=state.state_i2;
                            break;
                        case state_i2:
                            if(snum2=="")
                            {
                                sop=show;
                                break;
                            }
                            snum1=getres(2);snum2="";sres="";sop=show;
                            break;
                        case state_res:
                            if(sres.contains("error"))
                            {
                                clear();
                                break;
                            }
                            sop=show;snum1=sres;snum2="";sres="";s=state.state_i2;
                            break;
                    }
                    break;
                case "=":
                    switch (s)
                    {
                        case state_i1:
                            if(snum1.charAt(snum1.length()-1)=='.')snum1+="0";
                            sres=snum1;
                            snum1="";
                            snum2="";
                            sop="";
                            s=state.state_res;
                            break;
                        case state_i2:
                            if(snum2=="")break;
                            if(snum2.charAt(snum2.length()-1)=='.')break;
                            sres=getres(2);
                            snum1="";
                            snum2="";
                            sop="";
                            s=state.state_res;
                            break;
                        default:break;
                    }
                    break;
                case "-":
                    switch (s)
                    {
                        case state_init: sop=show;s=state.state_i2;
                            break;
                        case state_i1: sop=show;s=state.state_i2;
                            break;
                        case state_i2:
                            if(snum2=="")
                            {
                                sop=show;
                                break;
                            }
                            snum1=getres(2);snum2="";sres="";sop=show;
                            break;
                        case state_res:
                            if(sres.contains("error"))
                            {
                                clear();
                                break;
                            }
                            sop=show;snum1=sres;snum2="";sres="";s=state.state_i2;
                            break;
                    }
                    break;
                case "*":
                    switch (s)
                    {
                        case state_init: sop=show;s=state.state_i2;
                            break;
                        case state_i1: sop=show;s=state.state_i2;
                            break;
                        case state_i2:
                            if(snum2=="")
                            {
                                sop=show;
                                break;
                            }
                            snum1=getres(2);snum2="";sres="";sop=show;
                            break;
                        case state_res:
                            if(sres.contains("error"))
                            {
                                clear();
                                break;
                            }
                            sop=show;snum1=sres;snum2="";sres="";s=state.state_i2;
                            break;
                    }
                    break;
                case "/":
                    switch (s)
                    {
                        case state_init: sop=show;s=state.state_i2;
                            break;
                        case state_i1: sop=show;s=state.state_i2;
                            break;
                        case state_i2:
                            if(snum2=="")
                            {
                                sop=show;
                                break;
                            }
                            snum1=getres(2);snum2="";sres="";sop=show;
                            break;
                        case state_res:
                            if(sres.contains("error"))
                            {
                                clear();
                                break;
                            }
                            sop=show;snum1=sres;snum2="";sres="";s=state.state_i2;
                            break;
                    }
                    break;
                case "√":
                    switch (s)
                    {
                        case state_init: snum1="";snum2="";sop="";sres="0";s=state.state_res;
                            break;
                        case state_i1: sop=show;sres=getres(1);snum1="";snum2="";sop="";s=state.state_res;
                            break;
                        case state_i2:
                            if(snum2=="")break;
                            String t=snum1;snum1=snum2;
                            String t_op=sop;sop=show;
                            snum2=getres(1);
                            snum1=t;
                            sop=t_op;
                            sres="";
                            break;
                        case state_res:
                            if(sres.contains("error"))
                            {
                                clear();
                                break;
                            }
                            sop=show;
                            snum1=sres;
                            sres=getres(1);
                            snum1="";
                            sop="";
                            break;
                    }
                    break;
                case "%":
                    switch (s)
                    {
                        case state_init:
                            break;
                        case state_i1:
                            if(snum1.contains("."))break;
                            sop=show;s=state.state_i2;
                            break;
                        case state_i2:
                            if(snum2=="")
                            {
                                if(!snum1.contains("."))
                                    sop=show;
                                break;
                            }
                            snum1=getres(2);snum2="";sres="";sop=show;
                            break;
                        case state_res:
                            if(sres.contains("error"))
                            {
                                clear();
                                break;
                            }
                            if(sres.contains("."))break;
                            sop=show;snum1=sres;snum2="";sres="";s=state.state_i2;
                            break;
                    }
                    break;
                case "+/-":
                    switch (s)
                    {
                        case state_init:
                            break;
                        case state_i1:
                            if(snum1.charAt(0)!='-')
                                snum1="-"+snum1;
                            else snum1=snum1.substring(1);
                            break;
                        case state_i2:
                            if(snum2=="")break;
                            if(snum2.charAt(0)!='-')
                                snum2="-"+snum2;
                            else snum2=snum2.substring(1);
                            break;
                        case state_res:
                            if(sres.contains("error"))
                            {
                                clear();
                                break;
                            }
                            if(sres.charAt(0)!='-'&& !sres.equals(0))
                                sres="-"+sres;
                            else sres=sres.substring(1);
                            snum1=sres;
                            snum2="";
                            sres="";
                            sop="";
                            if(snum1.equals("0"))
                                s=state.state_init;
                            else
                                s=state.state_i1;
                            break;
                    }
                    break;
                case ".":
                    switch (s)
                    {
                        case state_init:
                            snum1+=show;
                            s=state.state_i1;
                            break;
                        case state_i1:
                            if(snum1.contains("."))break;
                            else snum1+=show;
                            break;
                        case state_i2:
                            if(snum2.equals("")){
                                if(sop.equals("%"))break;
                                snum2="0.";
                                break;
                            }
                            if(sop.equals("%")||snum2.contains("."))break;
                            else snum2+=show;
                            break;
                        case state_res:
                            break;
                    }
                    break;
            }
        }
    }

    public String getSnum1()
    {
        return  snum1;
    }
    public String getSnum2()
    {
        return snum2;
    }
    public String getSop()
    {
        return sop;
    }
    public String getSres()
    {
        return sres;
    }

    public void clear()
    {
        snum1="0";
        snum2="";
        sop="";
        sres="";
        s=state.state_init;
        b1=BigDecimal.valueOf(0);
        b2=BigDecimal.valueOf(0);
        bres=BigDecimal.valueOf(0);
    }

    public String getres(int flag)
    {
        String t="null";
        if(flag==1)
        {
            b1=new BigDecimal(snum1);
            if(snum1.equals("0"))return t="0";
            if(sop.equals("√"))
            {
                bres=sqrt(b1,scale);
                if(bres.compareTo(BigDecimal.valueOf(-1)) == 0){
                    return "error:√ the value must be greater than zero";
                }else{
                    t=bres.toString();
                    return t;
                }
            }
            else if(sop.equals("+/-"))
            {
                //略了，直接字符串处理
            }
        }
        else if(flag==2)
        {
            b1=new BigDecimal(snum1);
            b2=new BigDecimal(snum2);
            switch (sop)
            {
                case "+":
                    bres=b1.add(b2);
                    t=bres.toString();
                    break;
                case "-":
                    bres=b1.subtract(b2);
                    t=bres.toString();
                    break;
                case "*":
                    bres=b1.multiply(b2);
                    t=bres.toString();
                    break;
                case "/":
                    if(b2.equals(BigDecimal.valueOf(0)))return t="error: / by zero";
                    bres=b1.divide(b2,scale,RoundingMode.HALF_UP);
                    t=bres.toString();
                    break;
                case "%":
                    if(b2.equals(BigDecimal.valueOf(0)))return t="error: / by zero";
                    bres=b1.remainder(b2);
                    t=bres.toString();
                    break;
            }
        }
        return t;
    }

    public static BigDecimal sqrt(BigDecimal value, int scale){         //高精度浮点数开根号
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            return BigDecimal.valueOf(-1);
        }else {
            BigDecimal num2 = BigDecimal.valueOf(2);
            int precision = 100;
            MathContext mc = new MathContext(precision, RoundingMode.HALF_UP);
            BigDecimal deviation = value;
            int cnt = 0;
            while (cnt < precision) {
                deviation = (deviation.add(value.divide(deviation, mc))).divide(num2, mc);
                cnt++;
            }
            deviation = deviation.setScale(scale, BigDecimal.ROUND_HALF_UP);
            return deviation;
        }
    }
}