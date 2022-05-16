package fisei.uta.edu.ec.bryanespejo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Pantalla3 extends AppCompatActivity {


    EditText et_Nombre, et_Apellido, et_Base, et_Exponente, et_Factorial;

    Button btn_Cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        et_Nombre = findViewById(R.id.et_nombre3);
        et_Apellido = findViewById(R.id.et_apellido3);
        et_Base = findViewById(R.id.et_base3);
        et_Exponente = findViewById(R.id.et_exponente3);
        et_Factorial = findViewById(R.id.et_factorial3);

        btn_Cerrar = findViewById(R.id.btn_cerrar3);
    }

    public void OnClickCerrar(View view){
        String items = et_Nombre.getText().toString() + "_" + et_Apellido.getText().toString() + "_"
                + et_Base.getText().toString() + "_" + et_Exponente.getText().toString() + "_" + et_Factorial.getText().toString();

        Intent intent = new Intent();
        intent.setData(Uri.parse(items));

        setResult(Activity.RESULT_OK, intent);

        finish();
    }
}