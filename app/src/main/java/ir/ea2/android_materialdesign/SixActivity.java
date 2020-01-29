package ir.ea2.android_materialdesign;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SixActivity extends AppCompatActivity {
    private TextInputEditText textInputPassword, textInputUsername;
    private TextInputLayout textLayoutPassword, textLayoutUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        setViews();
        setListeners();
    }

    private void setListeners()  {
        textInputUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setInputTextError();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        textInputUsername.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    setInputTextError();
                }else{
                    unsetInputTextError();
                }
            }
        });
    }

    private void setInputTextError() {
        if (textInputUsername.getText().toString().isEmpty()) {
            textLayoutUsername.setErrorEnabled(true);
            textLayoutUsername.setError(getResources().getString(R.string.username_error_default));
        } else {
            unsetInputTextError();
        }

    }
    private void unsetInputTextError(){
        textLayoutUsername.setErrorEnabled(false);
    }

    private void setViews() {
        textInputPassword = findViewById(R.id.ac_six_password);
        textInputUsername = findViewById(R.id.ac_six_username);
        textLayoutPassword = findViewById(R.id.ac_six_password_layout);
        textLayoutUsername = findViewById(R.id.ac_six_username_layout);
    }
}
