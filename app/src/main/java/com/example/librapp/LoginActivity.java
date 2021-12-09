package com.example.librapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthWebException;

public class LoginActivity extends AppCompatActivity {
private Button IngresarLogin;
private Button RegistrarseLogin;
private EditText NumeroUsuario;
private EditText ContraseñaUsuario;
FirebaseAuth firebaseAuth;
AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        RegistrarseLogin=(Button) findViewById(R.id.ButtonRegistrarLogin);
        NumeroUsuario=(EditText) findViewById(R.id.email_text);
        ContraseñaUsuario=(EditText) findViewById(R.id.editTextNumberPassword);
        IngresarLogin=(Button) findViewById(R.id.ButtonIngresarLogin);
        firebaseAuth=FirebaseAuth.getInstance();
        awesomeValidation= new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.email_text, Patterns.EMAIL_ADDRESS,R.string.invalid_mail);
        awesomeValidation.addValidation(this,R.id.editTextNumberPassword,".{6,}",R.string.invalid_password);


        IngresarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo =NumeroUsuario.getText().toString();
                String contraseña =ContraseñaUsuario.getText().toString();
                 if (NumeroUsuario.getText() != null &&  ContraseñaUsuario.getText()!=null) {

                             if (awesomeValidation.validate()){
                                firebaseAuth.createUserWithEmailAndPassword(NumeroUsuario.getText().toString(),ContraseñaUsuario.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()){
                                            Toast.makeText(LoginActivity.this,"complete los recuadros",Toast.LENGTH_SHORT).show();
                                        finish();
                                        }else{
                                            String errorcode=((FirebaseAuthWebException) task.getException()).getErrorCode();
                                            dameToastdeerror(errorcode);
                                        }
                                    }
                                });
                             }else{
                                 Toast.makeText(LoginActivity.this,"complete los recuadros",Toast.LENGTH_SHORT).show();
                             }


                     /**    if(ContraseñaUsuario.getText()!=null) {
                         FirebaseAuth.getInstance().createUserWithEmailAndPassword(NumeroUsuario.getText().toString(),ContraseñaUsuario.getText().toString());
                         Intent volverbuscar = new  Intent(LoginActivity.this,MainActivity.class);
                         ShowHome(NumeroUsuario.getText(), ProviderType.BASIC);
                 }else{
                         ShowAlert();
                     }
                      */   }

            }
        });
    }




    /**public void ShowAlert(){
setTitle("Autentication");
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("error");
        builder.setMessage("aceptar");
builder.show();
        }
        public void ShowHome(int usuario, ProviderType proveedor){
            Intent volverhome= new  Intent(this,MainActivity.class);
            volverhome.putExtra("usuario",usuario);
            volverhome.putExtra("proveedor", (Parcelable) proveedor);
    startActivity(volverhome);
        }
*/    public void MenuPrincipal(View view2) {
        Intent ingresar;
        ingresar = new Intent(this, MainActivity.class);
        startActivity(ingresar);

    }
    private void dameToastdeerror(String error) {

        switch (error) {

            case "ERROR_INVALID_CUSTOM_TOKEN":
                Toast.makeText(LoginActivity.this, "El formato del token personalizado es incorrecto. Por favor revise la documentación", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_CUSTOM_TOKEN_MISMATCH":
                Toast.makeText(LoginActivity.this, "El token personalizado corresponde a una audiencia diferente.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_INVALID_CREDENTIAL":
                Toast.makeText(LoginActivity.this, "La credencial de autenticación proporcionada tiene un formato incorrecto o ha caducado.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_INVALID_EMAIL":
                Toast.makeText(LoginActivity.this, "La dirección de correo electrónico está mal formateada.", Toast.LENGTH_LONG).show();
                NumeroUsuario.setError("La dirección de correo electrónico está mal formateada.");
                NumeroUsuario.requestFocus();
                break;

            case "ERROR_WRONG_PASSWORD":
                Toast.makeText(LoginActivity.this, "La contraseña no es válida o el usuario no tiene contraseña.", Toast.LENGTH_LONG).show();
                ContraseñaUsuario.setError("la contraseña es incorrecta ");
                ContraseñaUsuario.requestFocus();
                ContraseñaUsuario.setText("");
                break;

            case "ERROR_USER_MISMATCH":
                Toast.makeText(LoginActivity.this, "Las credenciales proporcionadas no corresponden al usuario que inició sesión anteriormente..", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_REQUIRES_RECENT_LOGIN":
                Toast.makeText(LoginActivity.this,"Esta operación es sensible y requiere autenticación reciente. Inicie sesión nuevamente antes de volver a intentar esta solicitud.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL":
                Toast.makeText(LoginActivity.this, "Ya existe una cuenta con la misma dirección de correo electrónico pero diferentes credenciales de inicio de sesión. Inicie sesión con un proveedor asociado a esta dirección de correo electrónico.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_EMAIL_ALREADY_IN_USE":
                Toast.makeText(LoginActivity.this, "La dirección de correo electrónico ya está siendo utilizada por otra cuenta..   ", Toast.LENGTH_LONG).show();
                NumeroUsuario.setError("La dirección de correo electrónico ya está siendo utilizada por otra cuenta.");
                break;

            case "ERROR_CREDENTIAL_ALREADY_IN_USE":
                Toast.makeText(LoginActivity.this, "Esta credencial ya está asociada con una cuenta de usuario diferente.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_USER_DISABLED":
                Toast.makeText(LoginActivity.this, "La cuenta de usuario ha sido inhabilitada por un administrador..", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_USER_TOKEN_EXPIRED":
                Toast.makeText(LoginActivity.this, "La credencial del usuario ya no es válida. El usuario debe iniciar sesión nuevamente.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_USER_NOT_FOUND":
                Toast.makeText(LoginActivity.this, "No hay ningún registro de usuario que corresponda a este identificador. Es posible que se haya eliminado al usuario.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_INVALID_USER_TOKEN":
                Toast.makeText(LoginActivity.this, "La credencial del usuario ya no es válida. El usuario debe iniciar sesión nuevamente.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_OPERATION_NOT_ALLOWED":
                Toast.makeText(LoginActivity.this, "Esta operación no está permitida. Debes habilitar este servicio en la consola.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_WEAK_PASSWORD":
                Toast.makeText(LoginActivity.this, "La contraseña proporcionada no es válida..", Toast.LENGTH_LONG).show();
                ContraseñaUsuario.setError("La contraseña no es válida, debe tener al menos 6 caracteres");
                ContraseñaUsuario.requestFocus();
                break;

        }

    }

}

