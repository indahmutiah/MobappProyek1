package com.example.bejostorelogin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PrediksiActivity extends AppCompatActivity {
    private EditText editTextNumber;
    private TextView textViewResult;
    private Button buttonPredict;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediksi);
        editTextNumber = findViewById(R.id.editTextNumber);
        textViewResult = findViewById(R.id.textView);
        buttonPredict = findViewById(R.id.buttonPredict);

        setButtonPredictListener();
    }
    private void setButtonPredictListener(){
        buttonPredict.setOnClickListener(e -> {
            int hari = Integer.parseInt(editTextNumber.getText().toString());
            textViewResult.setText("Prediksi Hari ke " + hari + "\n Rp." );
        });
    }
}
