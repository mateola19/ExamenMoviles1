package fp.dam.pmdm.examenmoviles1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Juego extends AppCompatActivity {

int valorClick = 1;
Button Play;
    BigInteger mil = new BigInteger("1000");
    BigInteger millon = new BigInteger("1000000");
    BigInteger billon= new BigInteger("1000000000");
    TextView View;
    ListView Recycle;
Button Pausa;

BigInteger num = BigInteger.ZERO;

int numero = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        valorClick = valorClick + 1;
        Play = (Button) findViewById(R.id.button4);
        Pausa = (Button) findViewById(R.id.button3);
        Play.setText(""+num);
        View = findViewById(R.id.textView);
        //El RecyclerView
        //View = findViewById(R.id.recyclerView);
    }
    //"Autoclicker" que inicia al darle al boton PLAY
    public String numFormato (BigInteger valor) {
        String formattedValue = valor.toString();

        if (valor.compareTo(mil)>= 0 && valor.compareTo(millon) < 0) {
            formattedValue=Double.toString(valor.divide(BigInteger.valueOf(1000)).doubleValue()).substring(0,3) + "Mil";
        } else if (valor.compareTo(millon)>= 0 && valor.compareTo(billon) < 0) {
            formattedValue = Double.toString(valor.divide(BigInteger.valueOf(1000000)).doubleValue()).substring(0,4) + "M";
        }
        else if (valor.compareTo(billon)>= 0 && valor.compareTo(billon) < 0) {
            formattedValue = Double.toString(valor.divide(BigInteger.valueOf(1000000000)).doubleValue()).substring(0,5) + "B";
        }
        return formattedValue;
    }
    //Un cambio de int a BigInteger que me esta arruinando el examen

    //public void sumar(View v){
        //num += (1* valorClick);
       // Play.setText(""+num);


    //}
    //El resto del "autoclicker"
    public void Play(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                num = num.add(BigInteger.valueOf(numero));

                handler.post(() -> {
                    ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    fade_in.setDuration(100);

                });
            }
        });
    }
}