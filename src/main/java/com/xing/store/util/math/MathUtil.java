package com.xing.store.util.math;

public class MathUtil {
    public static Double round(Double oldDouble,int weishu){
        return Math.round(oldDouble * Math.pow(10,weishu))/Math.pow(10,weishu);
    }
    public static String getRandomStr(int weishu){
        String s="";
        for (int x=0;x<weishu;x++){
            s+=(int) (Math.random() * 10);
        }
        return s;
    }

}
