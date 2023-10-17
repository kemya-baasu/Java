package com.kemya.learnings;
import java.lang.reflect.*;
import java.util.Arrays;

public class ParameterType {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<ParameterType> classObj = ParameterType.class;
        Method method = classObj.getMethod("sendParams", int.class, String.class, ParameterType.class);
        Parameter[] ParamType = method.getParameters();
        System.out.println(Arrays.toString(ParamType));
        sendParams(1, "hi", new ParameterType());
    }
    public static void sendParams(int i,String s,ParameterType obj){
        System.out.println(obj + " is of type " + ((Object)obj).getClass().getSimpleName());
    }
}
