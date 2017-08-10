package com.test.algo;

import android.util.Log;

import java.util.Stack;

/**
 * Created by JUN on 2017-08-04.
 */

public class SortStack {


    public void swap(int a, int b) {

    }

    public String sortStack(Stack<Integer> temp) {
        Stack<Integer> result = new Stack<>();
        Log.e("JUN","SIZE11 = " + temp.size());


        while(!temp.isEmpty()) {
            int s = temp.pop();
            while(!result.isEmpty()) {
                if(s < result.peek()) {
                    temp.push(result.pop());
                }
            }
            result.push(s);
        }

Log.e("JUN","SIZE = " + result.size());
        return result.toString();
    }
}
