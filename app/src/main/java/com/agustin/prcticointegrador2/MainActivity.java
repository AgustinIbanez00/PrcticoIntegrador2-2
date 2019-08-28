package com.agustin.prcticointegrador2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final Button boton = findViewById(R.id.btnConvertir);
        final RadioButton euro_dolar = (RadioButton) findViewById(R.id.rbEuros);
        final RadioButton dolar_euro = (RadioButton) findViewById(R.id.rbDolares);
        final EditText euro = (EditText) findViewById(R.id.etDolares);
        final EditText dolar = (EditText) findViewById(R.id.etEuros);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try
                {
                    Double euro_double = Double.parseDouble(euro.getText().toString());
                    Double dolar_double = Double.parseDouble(dolar.getText().toString());


                EditText resultado = (EditText) findViewById(R.id.etResultado);

                Double res = 0.0;

                if(euro_dolar.isChecked())
                    res = euro_double*1.11;
                else res = dolar_double*0.90;

                resultado.setText(Double.toString(res));
                }
                catch (NumberFormatException ex)
                {
                    Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        euro_dolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                euro.setEnabled(false);
                euro.setText("0.0");
                dolar.setEnabled(true);
            }
        });

        dolar_euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dolar.setEnabled(false);
                dolar.setText("0.0");
                euro.setEnabled(true);
            }
        });

    }


}
