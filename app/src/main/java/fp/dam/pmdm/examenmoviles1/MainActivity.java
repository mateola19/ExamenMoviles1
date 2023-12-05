package fp.dam.pmdm.examenmoviles1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Salida;
    Button Cronometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Salida = findViewById(R.id.button2);
        Cronometro = findViewById(R.id.button);
        //Codigo de ir salida
        Salida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){mostrarDialogo();}
        });
        //codigo del boton cronometro para ir a la clase juego
        Cronometro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                irCronometro();

            }
        });
    }

        public void irCronometro() {
            Intent intent = new Intent(this, Juego.class);
            startActivity(intent);


        }
        //Pestaña de dialogo que sale al dar al boton Salida
    //La pestaña sirve para confirmar si quieres salir
    public void mostrarDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cerrar Aplicacion")
                .setMessage("Esta seguro de que quiere salir?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", null);
        AlertDialog dialogo=builder.create();
        dialogo.show();
    }

}


