package com.example.ejercicio2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.VideoView;

public class ActivityListar extends AppCompatActivity {

    Spinner acl_SpinnerLista;
    VideoView acl_VideoViwer;
    Button acl_btnVerVideo;

    private String[] listaURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        acl_VideoViwer = (VideoView) findViewById(R.id.acl_VideoViwer);
        acl_btnVerVideo = (Button) findViewById(R.id.acl_btnVerVideo);
        acl_SpinnerLista = (Spinner) findViewById(R.id.acl_SpinnerLista);

        listaURL = fileList();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaURL);
        acl_SpinnerLista.setAdapter(adapter);

        acl_btnVerVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarVideo(view);
            }
        });

    }

    private void cargarVideo(View view) {
        int pos = acl_SpinnerLista.getSelectedItemPosition();
        acl_VideoViwer.setVideoPath(getFilesDir() + "/" + listaURL[pos]);
        acl_VideoViwer.start();
    }
}