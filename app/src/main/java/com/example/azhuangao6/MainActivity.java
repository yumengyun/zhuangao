package com.example.azhuangao6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        Class<? extends ArrayList> clazz = list.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {

            if (method.getName().equals("add")){
                if (method.getGenericParameterTypes().length == 1){
                    try {
                        method.invoke(list,10);
                        method.invoke(list,100F);
                        method.invoke(list,1000L);


                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
            }

        }
        for (Object obj : list) {

            Log.i("--a", "onCreate: "+obj);
        }
    }
}