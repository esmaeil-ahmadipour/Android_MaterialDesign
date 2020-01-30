package ir.ea2.android_materialdesign;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SixActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputEditText textInputPassword, textInputUsername;
    private TextInputLayout textLayoutPassword, textLayoutUsername;
    private Toolbar toolbar;
    private Chip chipFemale;
    private ChipGroup chipGroup;
    private String[] strings = {"Female", "Male"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        setViews();
        setupToolbar();
        setCustomizedView();
        setListeners();
        declareChip();
    }

    private void declareChip() {
        Chip chip1 = new Chip(this);
        Chip chip2 = new Chip(this);

        chip1.setText(strings[0]);
        chip2.setText(strings[1]);

        chip1.setOnCloseIconClickListener(this);
        chip2.setOnCloseIconClickListener(this);

        chip1.setCheckable(true);
        chip2.setCheckable(true);

        chip1.setCloseIconVisible(true);
        chip2.setCloseIconVisible(true);

        chipGroup.addView(chip1);
        chipGroup.addView(chip2);

        chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup chipGroup, int checkId) {
                Chip selectedChip = chipGroup.findViewById(checkId);
                if (selectedChip != null) {
                    String s = selectedChip.getText().toString();
                    Toast.makeText(SixActivity.this, s, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setCustomizedView() {
        textLayoutUsername.setCounterEnabled(true);
        textLayoutUsername.setCounterMaxLength(8);
    }

    private void setListeners() {
//        chipFemale.setOnCloseIconClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(SixActivity.this, "Close", Toast.LENGTH_SHORT).show();
//            }
//        });
//        chipFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Toast.makeText(SixActivity.this, isChecked+"", Toast.LENGTH_SHORT).show();
//            }
//        });
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
        chipGroup = findViewById(R.id.chipgroup);
//        chipFemale = findViewById(R.id.ac_six_chip_female);
        textInputPassword = findViewById(R.id.ac_six_password);
        textInputUsername = findViewById(R.id.ac_six_username);
        textLayoutPassword = findViewById(R.id.ac_six_password_layout);
        textLayoutUsername = findViewById(R.id.ac_six_username_layout);
    }

    @Override
    public void onClick(View clickedView) {
        if (clickedView instanceof Chip) {
            chipGroup.removeView(clickedView);
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}
