package com.example.guess;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import java.util.Arrays;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListener();
        newWord();
    }
    String mix_words(String f){
        char[] tempArray=f.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
    String generate_word(){
        String[] words={"grade","everest","calculate","guess","first","second","mango","potato","circle","orange",
                "triangle","whereabouts","forgive","run ","marvel","frank","seeds","desk","mask","fan","dammed","spun","dread"};
        Random n=new Random();
        int randomWord=n.nextInt(words.length);

        return (words[randomWord]);
    }
    String compare(String d,String h){
        String remark;
        if(d.equals(h)){
            remark="You guessed the word correctly";
        }
        else{
            remark="You did not guess the correct word try again";
        }
        return  remark;
    }
        String correct;
        String generated;
        public  void newWord(){
        Button newB=findViewById(R.id.button2);
        newB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correct=generate_word();
                generated=mix_words(correct);
                final TextView gen= findViewById(R.id.genword);
                gen.setText(generated);
            }
        });
        }

    public void myButtonListener(){
        Button button= findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText input= findViewById(R.id.guessed);
                String guessedWord=input.getText().toString();
                String result=compare(guessedWord,correct);
                final TextView remark=findViewById(R.id.remark);
                remark.setText(result);
            }
        });


    }
}
