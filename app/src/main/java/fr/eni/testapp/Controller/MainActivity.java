package fr.eni.testapp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fr.eni.testapp.Model.User;
import fr.eni.testapp.R;

public class MainActivity extends AppCompatActivity {

    private TextView mPseudoText;
    private EditText mPseudoInput;
    private Button mPlayButton;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUser = new User();

        // référencement des éléments graphiques
        mPseudoText = findViewById(R.id.activity_main_pseudo_txt);
        mPseudoInput = findViewById(R.id.activity_main_pseudo_edit);
        mPlayButton = findViewById(R.id.activity_main_jouer_btn);

        //Empêche l'utilisateur d'accéder au jeu sans avoir saisi un pseudo
        mPlayButton.setEnabled(false);

        //méthode pour notif de saisi utilisateur pour activer le bouton
        mPseudoInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //click bouton
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Récupère le pseudo pour le click
                String pseudo = mPseudoInput.getText().toString();
                mUser.setPseudo(pseudo);

                //Démarrer l'activité
                Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameActivityIntent);
            }
        });
    }
}