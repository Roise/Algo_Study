package com.test.algo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultView = (TextView)findViewById(R.id.result);


        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

//        result.setText(list.toString());
//        DoublyLinkedList.ListIterator i =

        Stack<Integer> s = new Stack<>();
        s.push(20);
        s.push(7);
        s.push(30);
        SortStack sortStack = new SortStack();
//        resultView.setText(sortStack.sortStack(s));

        StringTest stringTest = new StringTest();
        Log.e("JUN", "STRING TEST = " + stringTest.isUniqueCharBit("hi BYE B"));
        Log.e("JUN", "STRING REVERSE = " + stringTest.reverse("hi hyung jun"));
    }
}
