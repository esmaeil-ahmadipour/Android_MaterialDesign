package ir.ea2.android_materialdesign;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SixActivity extends AppCompatActivity {
    private TextInputEditText textInputPassword, textInputUsername;
    private TextInputLayout textLayoutPassword, textLayoutUsername;
    private Toolbar toolbar;
    private Chip chipFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        setViews();
        setupToolbar();
        setCustomizedView();
        setListeners();
    }

    private void setCustomizedView() {
        textLayoutUsername.setCounterEnabled(true);
        textLayoutUsername.setCounterMaxLength(8);
    }

    private void setListeners() {
        chipFemale.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SixActivity.this, "Close", Toast.LENGTH_SHORT).show();
            }
        });
        chipFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(SixActivity.this, isChecked+"", Toast.LENGTH_SHORT).show();
            }
        });
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
                if (hasFocus) {
                    setInputTextError();
                } else {
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

    private void unsetInputTextError() {
        textLayoutUsername.setErrorEnabled(false);
    }
    private void setupToolbar() {
        toolbar = findViewById(R.id.ac_four_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }
    private void setViews() {
        chipFemale = findViewById(R.id.ac_six_chip_female);
        textInputPassword = findViewById(R.id.ac_six_password);
        textInputUsername = findViewById(R.id.ac_six_username);
        textLayoutPassword = findViewById(R.id.ac_six_password_layout);
        textLayoutUsername = findViewById(R.id.ac_six_username_layout);
    }

}
