package fr.eni.testapp.Controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import fr.eni.testapp.Model.Question;
import fr.eni.testapp.Model.QuestionBank;
import fr.eni.testapp.R;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionText;
    private Button mReponseButton1;
    private Button mReponseButton2;
    private Button mReponseButton3;
    private Button mReponseButton4;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    private int mScore;
    private int mNombreDeQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Méthode pour les questions
        mQuestionBank = this.generateQuestions();

        //Récup score
        mScore = 0;
        mNombreDeQuestions = 5;

        mQuestionText = findViewById(R.id.activity_game_question_txt);
        mReponseButton1 = findViewById(R.id.activity_game_reponse1_btn);
        mReponseButton2 = findViewById(R.id.activity_game_reponse2_btn);
        mReponseButton3 = findViewById(R.id.activity_game_reponse3_btn);
        mReponseButton4 = findViewById(R.id.activity_game_reponse4_btn);

        //Valorisation des boutons pour connaitre la bonne réponse
        mReponseButton1.setTag(0);
        mReponseButton2.setTag(1);
        mReponseButton3.setTag(2);
        mReponseButton4.setTag(3);

        mReponseButton1.setOnClickListener(this);
        mReponseButton2.setOnClickListener(this);
        mReponseButton3.setOnClickListener(this);
        mReponseButton4.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getQustion();
        this.displayQuestion(mCurrentQuestion);
    }

    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();

        if (responseIndex == mCurrentQuestion.getReponseIndex()) {
            //bonne réponse
            Toast.makeText(this, "Excellent!", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            //mauvaise réponse
            Toast.makeText(this, "Mauvaise réponse!", Toast.LENGTH_SHORT).show();
        }

        //Si le nombre de question = 0, fin du jeu.
        //Sinon nouvelle question
        if (--mNombreDeQuestions == 0) {
            //Fin du jeu
            finJeu();
        } else {
            mCurrentQuestion = mQuestionBank.getQustion();
            displayQuestion(mCurrentQuestion);
        }
    }

    private void finJeu() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Bien joué!")
                .setMessage("Votre score is " + mScore)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Fin de l'ativité
                        finish();
                    }
                })
                .create()
                .show();
    }

    //mettre les textes des questions et boutons
    private void displayQuestion(final Question question) {
        mQuestionText.setText(question.getQuestion());
        mReponseButton1.setText(question.getChoiceList().get(0));
        mReponseButton2.setText(question.getChoiceList().get(1));
        mReponseButton3.setText(question.getChoiceList().get(2));
        mReponseButton4.setText(question.getChoiceList().get(3));
    }


    private QuestionBank generateQuestions() {
        Question question1 = new Question("Sélectionner les éléments principaux d'une application Android",
                                          Arrays.asList("Activity,res", "Activity, main_activity.xml","Activity, AndroidManifest.xml et src","Activity, AndroidManifest.xml et res"),
                                         3);

        Question question2 = new Question("Où les activités sont déclarées",
                                          Arrays.asList("Dans l'activité principale", "Dans une interface","Dans les ressources","Dans le fichier de manifest"),
                                         3);

        Question question3 = new Question("Sélectionner le layout qui permet de placer les composants les uns à la suite des autres selon la place disponible ?",
                                          Arrays.asList("LinearLayout", "RelativeLayout","GridLayout","constraintLayout"),
                                          1);

        Question question4 = new Question("A quoi sert R.java ?",
                                          Arrays.asList("Représente les ressources", "Représente les RelativeLayout","Réprésente des résultats","Ne sert à rien"),
                                          0);

        Question question5 = new Question("Quel enchaînement de méthodes est permis dans le cycle de vie d'une Activity ?",
                                          Arrays.asList("onCreate onStart onStop", "onCreate onStart onResume onDestroy","onCreate onStart onPause onStop","onCreate onStart onResume onPause"),
                                         3);

        Question question6 = new Question("Quelle méthode permet de naviguer vers une autre activité ?",
                                          Arrays.asList("startService()", "startIntent()","startActivity()","stopService()"),
                                         2);

        Question question7 = new Question("Quelle méthode permet de lier des données à une intention ?",
                                          Arrays.asList("setExtra()", "setData()","putData()","putExtra()"),
                                         3);

        Question question8 = new Question("Dans quel fichier est-il possible de spécifier les permissions ?",
                                          Arrays.asList("la classe principale d'activité", "le fichier manifest","une interface","un fichier de layout"),
                                         1);

        Question question9 = new Question("Quelle contrainte impose la Toolbar pour être visible ?",
                                          Arrays.asList("De cacher l'ActionBar", "De créer un layout","De la déclarer dans le manifeste","Rien n'est nécessaire"),
                                         0);

        Question question10 = new Question("Quelle méthode de la classe Activity permet de retrouver un composant d'interface utilisateur ?",
                                          Arrays.asList("findComponentById", "findViewById","finById","findId"),
                                         1);

        return new QuestionBank(Arrays.asList(question1,
                                              question2,
                                              question3,
                                              question4,
                                              question5,
                                              question6,
                                              question7,
                                              question8,
                                              question9,
                                              question10));
    }
}