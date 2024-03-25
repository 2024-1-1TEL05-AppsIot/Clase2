package com.example.clase2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "MAINACTDEBUG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "oncreate");

        /*Button button = findViewById(R.id.button2);
        button.setOnClickListener(view -> {
            TextView textView = findViewById(R.id.contadorEnVista);
            String contadorStr = textView.getText().toString();
            int contador = Integer.parseInt(contadorStr);
            textView.setText(String.valueOf(++contador));

        });*/

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            launcher.launch(intent);
        });

    }

    public void incrementarContador (View view) {
        TextView textView = findViewById(R.id.contadorEnVista);
        String contadorStr = textView.getText().toString();
        int contador = Integer.parseInt(contadorStr);
        contador++;
        Log.d ("contador", "" +  String.valueOf(contador));
        textView.setText(String.valueOf(contador));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_act,menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.wifi:
                break;
            case R.id.add:
                break;
        }

        return super.onOptionsItemSelected(item);
    }*/

    public void wifiBtn(MenuItem menuItem){
        Toast.makeText(this, "btn wifi presionado", Toast.LENGTH_SHORT).show();
    }

    public void addBtn(MenuItem menuItem){
        Toast.makeText(this, "btn ADD presionado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onresumed");
    }

    public void irAVentana2(View view) {

        EditText editText = findViewById(R.id.editTextNombre);
        String texto = editText.getText().toString();

        Persona persona = new Persona("Claudia");

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("texto", texto);
        //se envia un objeto
        intent.putExtra("alumna", persona);
        startActivity(intent);

    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                //aquí llegamos luego del setResult(RESULT_OK,intent);
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    String apellido = data.getStringExtra("apellido");
                    Toast.makeText(MainActivity.this,
                            "el apellido recibido es: " + apellido,
                            Toast.LENGTH_SHORT).show();
                }
            }
    );

}