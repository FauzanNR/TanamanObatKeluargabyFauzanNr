package com.app.toga;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rev;
    private ArrayList<Tanaman> listT = new ArrayList<>(  );
    ImageButton btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        rev = findViewById( R.id.listitem);
        rev.setHasFixedSize( true );

        listT.addAll( DataToga.ambilData() );
        ListViewItem();

        btnAbout = findViewById( R.id.btn_me );
        btnAbout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, AboutMe.class );
                startActivity( intent );
            }
        } );
    }


    private void ListViewItem()
    {
        rev.setLayoutManager( new LinearLayoutManager( this ) );
        DataAdapter dataAdapter = new DataAdapter( listT);
        rev.setAdapter( dataAdapter );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.share){
            Intent Share = new Intent(Intent.ACTION_SEND);
            Share.setType("text/plain");
            String body = "your message or link";
            Share.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(Share, "Share Via"));
        }
        return super.onOptionsItemSelected(item);
    }
}
