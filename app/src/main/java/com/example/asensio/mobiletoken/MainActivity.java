package com.example.asensio.mobiletoken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.asensio.mobiletoken.GenerateToken;

public class MainActivity extends AppCompatActivity {

    private TextView generateToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateToken = (TextView) findViewById(R.id.txvToken);
    }

    public void gerarToken(View view){
        String tokem;
        GenerateToken gt = new GenerateToken();
        tokem = gt.generateNonce();
        generateToken.setText(tokem);

    }
}
