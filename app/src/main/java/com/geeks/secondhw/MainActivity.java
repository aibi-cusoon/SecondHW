package com.geeks.secondhw;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });


        EditText loginEditText = findViewById(R.id.login);
        EditText passwordEditText = findViewById(R.id.password);
        Button button = findViewById(R.id.button);
        LinearLayout container = findViewById(R.id.login_info);
        TextView entrance = findViewById(R.id.enter);
        TextView instructions = findViewById(R.id.enter_text);


        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String login = loginEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                button.setEnabled(!login.isEmpty() && !password.isEmpty());

            }

            @Override
            public void afterTextChanged(Editable s) {}

        };

        loginEditText.addTextChangedListener(watcher);
        passwordEditText.addTextChangedListener(watcher);

        button.setOnClickListener(v -> {
            String login = loginEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (login.equals("admin") && password.equals("admin")) {
                Toast.makeText(this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                container.setVisibility(View.GONE);
                entrance.setVisibility(View.GONE);
                instructions.setVisibility(View.GONE);
            }else{
                Toast.makeText(this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();


            };

        });
    }

}