//MUHAMMED ADEYEMI
//THIS LAB WAS DONE INDIVIDUALLY
package com.example.caps;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CapsActivity extends AppCompatActivity implements View.OnClickListener{

    Game game;
    int score;
    int questionNum;
    String ans;
    String q;
    String data;
    String[] lines;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caps_layout);
        //initial instance and data
        game = new Game();
        score = 0;
        questionNum = 1;
        data = game.qa();
        lines = data.split(System.getProperty("line.separator"));
        q = lines[0];
        ans = lines[1];
        ((TextView) findViewById(R.id.question)).setText(q);
    }

//    private void ask() {
//        String[] cat = game.qa();
//        question = cat[0];
//        answer = cat[1];
//        ((TextView) findViewById(R.id.question)).setText(cat[0]);
//        ((TextView) findViewById(R.id.answer)).setText(cat[1]);
//        if (questionNum != 0) {
//            ((TextView) findViewById(R.id.questionNum)).setText("Q#" + questionNum);
//        }
//    }

    public void onDone(View v) {
//
        //current data:
        TextView qNum = (TextView) findViewById(R.id.questionNum);
        TextView question = (TextView) findViewById(R.id.question);
        TextView scoreOutput = (TextView) findViewById(R.id.score);
        TextView log = (TextView) findViewById(R.id.lbl_log);
        String answer = ((EditText) findViewById(R.id.answer)).getText().toString().toUpperCase();
        String output = "Q# " + questionNum + ": " + q + "\n";
        output += "Your answer: " + answer + "\n";
        output += "Correct answer: " + ans + "\n";
        String logOut = output + "\n" + log.getText();

        //compare answer input to correct answer
        if (answer.toLowerCase().equals(ans.toLowerCase())) {
            score += 1;
            String s = "SCORE = " + score;
            scoreOutput.setText(s);
        }
        //log current state result and get new question
        log.setText(logOut);
        questionNum += 1;
        Button doneBtn = (Button) findViewById(R.id.btn_done);
        if (questionNum > 10) {
            doneBtn.setEnabled(false);
            qNum.setText("Game Over!");
            question.setText(q);
            finish();
        } else {
            //ask a new question
            String qOut = "Q# " + questionNum;
            qNum.setText(qOut);
            //set new data
            data = game.qa();
            lines = data.split(System.getProperty("line.separator"));
            q = lines[0];
            ans = lines[1];
            question.setText(q);
        }
    }
}