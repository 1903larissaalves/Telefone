package com.escolar.telefone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText telefone;
    Button ligar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ligar();
    }

    public void ligar(){

        ligar = (Button) findViewById(R.id.btnLigar);
        telefone = (EditText) findViewById(R.id.edtLigar);

        ligar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String numero = telefone.getText().toString();
                Uri uri = Uri.parse("tel:" + numero);
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);

                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    return;
                }
                startActivity(intent);
            }
        });
    }
}
