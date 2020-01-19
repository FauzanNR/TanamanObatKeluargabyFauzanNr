package com.app.toga;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ContentLayout extends AppCompatActivity {

    ImageView gambarContent;
    TextView textContent, textName;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.content_layout );

        gambarContent = findViewById( R.id.gambar_content );
        textName = findViewById( R.id.nama_content );
        textContent = findViewById( R.id.detail_content );

        String getNama, getContent, getGambar;

        getNama = getIntent().getStringExtra( "SEND_NAMA" );
        textName.setText( getNama );

        getGambar = getIntent().getStringExtra( "SEND_GAMBAR" );
        Glide.with( this )
                .load( getGambar )
                .into( gambarContent );

        getContent = getIntent().getStringExtra( "SEND_CONTENT" );
        textContent.setText( getContent );

    }
}
