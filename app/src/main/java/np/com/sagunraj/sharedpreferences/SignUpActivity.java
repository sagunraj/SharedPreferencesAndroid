package np.com.sagunraj.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText username, password;
    Button signupBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupBtn = findViewById(R.id.signupBtn);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("myfile", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                    Toast.makeText(SignUpActivity.this, "Username and password fields cannot be empty.", Toast.LENGTH_SHORT).show();
                }
                else {
                    editor.putString("user", user);
                    editor.putString("pass", pass);
                    editor.apply();
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                }
             }
        });
    }
}
