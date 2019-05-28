package com.example.materialapp.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.materialapp.R;

public class MainActivity extends AppCompatActivity {

    //  https://www.materialpalette.com/
    //  https://materialdesignicons.com/
    //  https://developer.android.com/?hl=pt-BR
    //  https://developer.android.com/docs
    //  https://www.youtube.com/watch?v=PMX7zRD3dhg&list=PLBA57K2L2RIKq7_IpaZRTL96CyLNDzF2F&index=2

    private static final String TAG = "LOG";
    private Toolbar mToolbar;
    private Toolbar mToolbarBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbatConfig();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_second_activity){
            startActivity(new Intent(this, SecondActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private void toolbatConfig() {
        mToolbar = findViewById(R.id.tb_main);
        mToolbar.setTitle("Main Activity");
        mToolbar.setSubtitle("Just a subtitle");
        mToolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(mToolbar);
        mToolbarBottom = findViewById(R.id.inc_tb_bottom);
        mToolbarBottom.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = null;
                switch (menuItem.getItemId()) {
                    case R.id.action_facebook:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://www.facebook.com"));
                        break;
                    case R.id.action_youtube:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://www.youtube.com"));
                        break;
                    case R.id.action_google_plus:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://plus.google.com"));
                        break;
                    case R.id.action_linkedin:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://www.linkedin.com"));
                        break;
                    case R.id.action_whatsapp:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://www.whatsapp.com"));
                        break;
                }
                startActivity(intent);
                return true;
            }
        });
        mToolbarBottom.inflateMenu(R.menu.menu_bottom);
        mToolbarBottom.findViewById(R.id.iv_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Settings pressed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
