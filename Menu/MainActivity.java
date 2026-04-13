package com.example.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_home) {
            Toast.makeText(this, "🏠 Home Selected", Toast.LENGTH_SHORT).show();
            return true;
        }

        else if (id == R.id.menu_profile) {
            Toast.makeText(this, "👤 Profile Selected", Toast.LENGTH_SHORT).show();
            return true;
        }

        else if (id == R.id.menu_settings) {
            Toast.makeText(this, "⚙️ Settings Selected", Toast.LENGTH_SHORT).show();
            return true;
        }

        else if (id == R.id.menu_logout) {
            Toast.makeText(this, "🚪 Logged Out", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
