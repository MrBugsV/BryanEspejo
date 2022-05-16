package fisei.uta.edu.ec.bryanespejo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_Nombre, et_Apellido, et_Base, et_Exponente, et_Factorial, et_Potencia;

    Button btn_Siguiente, btn_Mostrar;

    ActivityResultLauncher<Intent> resultado;

    String datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_Nombre = findViewById(R.id.et_nombre1);
        et_Apellido = findViewById(R.id.et_apellido1);
        et_Base = findViewById(R.id.et_base1);
        et_Exponente = findViewById(R.id.et_exponente1);
        et_Factorial = findViewById(R.id.et_factorial1);
        et_Potencia = findViewById(R.id.et_potencia1);

        btn_Siguiente = findViewById(R.id.btn_siguiente1);
        btn_Mostrar = findViewById(R.id.btn_mostrar1);

        resultado = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK){
                            datos = result.getData().getDataString();
                            String[] items = datos.split("_");
                            et_Nombre.setText(items[0]);
                            et_Apellido.setText(items[1]);
                            et_Base.setText(items[2]);
                            et_Exponente.setText(items[3]);
                            btn_Mostrar.setEnabled(true);
                        }
                    }
                });

    }

    public void OnClickSiguiente(View view){
        Intent intent = new Intent(this,Pantalla2.class);
        resultado.launch(intent);
    }

    public void OnClickMostrar(View view){
        String[] items = datos.split("_");
        int factorial = Integer.valueOf(items[4]);
        int potencia = factorial;
        et_Factorial.setText(items[4]);
        et_Potencia.setText(String.valueOf(potencia));
    }
}