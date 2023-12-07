package com.example.sweeper;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class GameRestartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restart_main);

        // If you want to include a button to manually restart the game, you can add it here.
        Button restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartGame();
            }
        });
    }

    private void restartGame() {
        // Add logic to restart the game here if needed

        // Start the main game activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        // Close this activity
        finish();
    }
}
