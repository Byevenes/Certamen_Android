package curso.brayan.certamen_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button ButtonGenerar;

    private Button ButtonSumar;
    private Button ButtonRestar;
    private Button ButtonLimpiar;

    private Button ButtonMultiplicar;
    private Button ButtonDividir;

    private Button ButtonPar;
    private Button ButtonPrimo;

    private TextView primerNumero;
    private TextView operacionSimbolo;
    private TextView segundoNumero;

    private TextView ResultadoFinal;
    private TextView TextResultado;

    private double resFloat = 150.0;

    private double primero = 50;
    private double segundo = 20;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Casteo luego de definir las variables

        ButtonGenerar = (Button) findViewById(R.id.ButtonGenerar);

        ButtonSumar = (Button) findViewById(R.id.ButtonSumar);
        ButtonRestar = (Button) findViewById(R.id.ButtonRestar);
        ButtonLimpiar = (Button) findViewById(R.id.ButtonLimpiar);

        ButtonMultiplicar = (Button) findViewById(R.id.ButtonMultiplicar);
        ButtonDividir = (Button) findViewById(R.id.ButtonDividir);

        ButtonPar = (Button) findViewById(R.id.ButtonPar);
        ButtonPrimo = (Button) findViewById(R.id.ButtonPrimo);

        primerNumero = (TextView) findViewById(R.id.primerNumero);
        operacionSimbolo = (TextView) findViewById(R.id.operacionSimbolo);
        segundoNumero = (TextView) findViewById(R.id.segundoNumero);

        ResultadoFinal = (TextView) findViewById(R.id.ResultadoFinal);
        TextResultado = (TextView) findViewById(R.id.TextResultadoParPrimo);

        final Random randomico = new Random();

        ButtonGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 primero = randomico.nextInt(100); // creo numero random entero
                 segundo = randomico.nextInt(100); // creo numero random entero

                 primerNumero.setText(String.valueOf(primero)); // envio el string generado por los random
                 segundoNumero.setText(String.valueOf(segundo));


                 operacionSimbolo.setText("?"); // esta variable cambiara segun sea el caso de operacion a realizar
                 ResultadoFinal.setText("");
                 TextResultado.setText("");

            }
        });

        ButtonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( primero == 50 && segundo == 20){ // si se cumple este caso no hemos apretado todavia el ButtonGenerar por lo que señalamos el error
                    ResultadoFinal.setText("Error");
                    primero = 50;
                    segundo = 20;
                    resFloat = 150;
                } else { // se ha generado numero randomico
                    resFloat = Double.valueOf(primero + segundo);
                    ResultadoFinal.setText(String.valueOf(resFloat));
                    operacionSimbolo.setText("+");
                }
            }
        });

        ButtonRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( primero == 50 && segundo == 20){ // si se cumple este caso no hemos apretado todavia el ButtonGenerar por lo que señalamos el error
                    ResultadoFinal.setText("Error");
                    primero = 50;
                    segundo = 20;
                    resFloat = 150;
                } else { // se ha generado numero randomico
                    resFloat = Double.valueOf(primero - segundo);
                    ResultadoFinal.setText(String.valueOf(resFloat));
                    operacionSimbolo.setText("-");
                }
            }
        });

        ButtonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primerNumero.setText("");
                segundoNumero.setText("");

                operacionSimbolo.setText("?");
                ResultadoFinal.setText("-");
                TextResultado.setText("-");

                primero = 50;
                segundo = 20;
                resFloat = 150;

            }
        });

        ButtonMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( primero == 50 && segundo == 20){ // si se cumple este caso no hemos apretado todavia el ButtonGenerar por lo que señalamos el error
                    ResultadoFinal.setText("Error");
                    primero = 50;
                    segundo = 20;
                    resFloat = 150;
                } else { // se ha generado numero randomico
                    resFloat = Double.valueOf(primero * segundo);
                    ResultadoFinal.setText(String.valueOf(resFloat));
                    operacionSimbolo.setText("*");
                }
            }
        });

        ButtonDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( primero == 50 && segundo == 20){ // si se cumple este caso no hemos apretado todavia el ButtonGenerar por lo que señalamos el error
                    ResultadoFinal.setText("Error");
                    primero = 50;
                    segundo = 20;
                    resFloat = 150;
                } else { // se ha generado numero randomico
                    resFloat = Double.valueOf(primero / segundo);
                    ResultadoFinal.setText(String.valueOf(resFloat));
                    operacionSimbolo.setText("/");
                }
            }
        });

        ButtonPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( primero == 50 && segundo == 20){ // si se cumple este caso no hemos apretado todavia el ButtonGenerar por lo que señalamos el error
                    ResultadoFinal.setText("Error");
                    primero = 50;
                    segundo = 20;
                    resFloat = 150;
                } else { // se ha generado numero randomico
                    if( resFloat%2 == 0 ){ // si el numero es par
                        TextResultado.setText("Es par");
                    } else {
                        TextResultado.setText("Es impar");
                    }
                }
            }
        });

        ButtonPrimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( primero == 50 && segundo == 20){ // si se cumple este caso no hemos apretado todavia el ButtonGenerar por lo que señalamos el error
                    ResultadoFinal.setText("Error");
                    primero = 50;
                    segundo = 20;
                    resFloat = 150;
                } else { // se ha generado numero randomico
                    int auxPrimo = 0;
                    int aux = (int)resFloat; // creo una varialbe aux de una copia del valor flotante combertido a entero

                    if(aux < 0) aux *= -1; // si aux es menor a sero la multiplico *-1 para combertirlo a positivo y luego seguir con el proceso de validacion si es primo o no

                    for(int i = 1; i<=aux; i++){
                        if( aux%i == 0){
                            auxPrimo++;
                        }
                    }

                    if ( auxPrimo == 2){
                        TextResultado.setText("Es primo");
                    } else{
                        TextResultado.setText("No es primo");
                    }
                }
            }
        });

    }
}
