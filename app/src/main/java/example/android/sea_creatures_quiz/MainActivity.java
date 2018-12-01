package example.android.sea_creatures_quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int correctAnswers;
    String q4AnswerLowerCase = "carnivores";
    String q4AnswerFirstCapital = "Carnivores";
    String q4AnswerAllCaps = "CARNIVORES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file.
        setContentView(R.layout.activity_main);
    }

    /**
     * Method to check answers and display quiz results when submit button is pressed.
     */

    public void submitAnswers(android.view.View view) {

        // Checks the answer to the first question
        RadioButton leatherback;
        leatherback = findViewById(R.id.leatherback);
        leatherback.isChecked();

        // The user answered correctly and 10 points will be added to correctAnswers
        if (leatherback.isChecked()) correctAnswers += 10;

        // Checks the answer to the second question
        RadioButton beach;
        beach = findViewById(R.id.beach);
        beach.isChecked();

        // The user answered correctly and 10 points will be added to correctAnswers
        if (beach.isChecked()) correctAnswers += 10;

        // Checks the answer to the third question
        RadioButton over4500;
        over4500 = findViewById(R.id.over4500);
        over4500.isChecked();

        // The user answered correctly and 10 points will be added to correctAnswers
        if (over4500.isChecked()) correctAnswers += 10;

        // Checks the answer to the fourth question.
        final EditText answerText = (EditText) findViewById(R.id.editableAnswer);
        String questionFourAnswer = answerText.getText().toString();

        // The user answered correctly and 10 points will be added to correctAnswers
        if (questionFourAnswer.matches(q4AnswerLowerCase)) {
            correctAnswers += 10;
        } else if (questionFourAnswer.matches(q4AnswerFirstCapital)) {
            correctAnswers += 10;
        } else if (questionFourAnswer.matches(q4AnswerAllCaps)) {
            correctAnswers += 10;
        }

        // Checks the answer to the fifth question
        RadioButton dolphin;
        dolphin = findViewById(R.id.dolphin);
        dolphin.isChecked();

        // The user answered correctly and 10 points will be added to correctAnswers
        if (dolphin.isChecked()) correctAnswers += 10;

        // Checks the answer to the sixth question
        RadioButton tips;
        tips = findViewById(R.id.tips);
        tips.isChecked();

        // The user answered correctly and 10 points will be added to correctAnswers
        if (tips.isChecked()) correctAnswers += 10;

        // Checks the answer to the seventh question
        RadioButton no;
        no = findViewById(R.id.no);
        no.isChecked();

        // The user answered correctly and 10 points will be added to correctAnswers
        if (no.isChecked()) correctAnswers += 10;

        // Checks the answer to the eighth question
        RadioButton sting;
        sting = findViewById(R.id.sting);
        sting.isChecked();

        // The user answered correctly and 10 points will be added to correctAnswers
        if (sting.isChecked()) correctAnswers += 10;

        // Checks the answer to the ninth question
        RadioButton years20;
        years20 = findViewById(R.id.years20);
        years20.isChecked();

        // The user answered correctly and 10 points will be added to correctAnswers
        if (years20.isChecked()) correctAnswers += 10;

        // Checks the answer to the tenth question
        final CheckBox brainCheckBox = findViewById(R.id.brain);
        final CheckBox eyesCheckBox = findViewById(R.id.eyes);
        final CheckBox tentaclesCheckBox = findViewById(R.id.tentacles);
        final CheckBox heartCheckBox = findViewById(R.id.heart);
        final CheckBox defensesCheckBox = findViewById(R.id.defenses);
        final CheckBox bonesCheckBox = findViewById(R.id.bones);

        // The user answered correctly and 5 points will be added to correctAnswers
        if (brainCheckBox.isChecked() && eyesCheckBox.isChecked() && heartCheckBox.isChecked() &&
                bonesCheckBox.isChecked() && !tentaclesCheckBox.isChecked() && !defensesCheckBox.isChecked())
            correctAnswers += 10;

        // Toast message to show which answers are correct
        android.content.Context context = getApplicationContext();
        if (correctAnswers <= 60) {
            CharSequence failed = "Unfortunately, you have failed this quiz." +
                    "\n Your score is " + String.valueOf(correctAnswers) + "/100%";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, failed, duration);
            toast.show();
        }


        if (correctAnswers >= 70) {
            CharSequence passed = "Congratulations, you have passed this quiz!" +
                    "\n Your score is " + String.valueOf(correctAnswers) + "/100%";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, passed, duration);
            toast.show();
        }

        //Sets the submit button's visibility to gone and replaces with try again button.
        final Button submitButton;
        final Button resetButton;
        submitButton = findViewById(R.id.submit_answers);
        resetButton = findViewById(R.id.reset_quiz);
        submitButton.setVisibility(android.view.View.GONE);
        resetButton.setVisibility(android.view.View.VISIBLE);

        //Resets the activity.
        resetButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                android.content.Intent resetQuiz = new android.content.Intent(MainActivity.this, MainActivity.class);
                startActivity(resetQuiz);
                finish();
            }
        });
    }
}