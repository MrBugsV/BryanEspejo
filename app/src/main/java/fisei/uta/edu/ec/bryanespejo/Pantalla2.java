package fisei.uta.edu.ec.bryanespejo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Pantalla2 extends AppCompatActivity {

    EditText et_Nombre, et_Base;

    Button btn_Siguiente, btn_Cerrar;

    ActivityResultLauncher<Intent> resultado;

    String datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        et_Nombre = findViewById(R.id.et_nombre2);
        et_Base = findViewById(R.id.et_base2);

        btn_Siguiente = findViewById(R.id.btn_siguiente2);
        btn_Cerrar = findViewById(R.id.btn_cerrar2);

        resultado = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK){
                            datos = result.getData().getDataString();
                            String[] items = datos.split("_");
                            et_Nombre.setText(items[0]);
                            et_Base.setText(items[2]);
                            btn_Cerrar.setEnabled(true);
                        }
                    }
                });
    }

    public void OnClickSiguiente(View view){
        Intent intent = new Intent(this,Pantalla3.class);
        resultado.launch(intent);
    }


    public void OnClickCerrar(View view){
        Intent intent = new Intent();
        intent.setData(Uri.parse(datos));

        setResult(Activity.RESULT_OK, intent);

        finish();
    }
}