package ir.ea2.android_materialdesign;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Context context = this;
    private Button btnShowNotification;
    RadioButton rdBtnActivity2,rdBtnActivity3,rdBtnActivity4, rdBtnActivity5, rdBtnActivity1;
    private RadioGroup rdGroup;
    private int checkedRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        clickListener();
    }

    private void clickListener() {
        btnShowNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedRadioButton = rdGroup.getCheckedRadioButtonId();
                switch (checkedRadioButton) {
                    case R.id.ac_main_rdBtn_activity1: {
                        Intent oneActivity = new Intent(MainActivity.this, OneActivity.class);
                        startActivity(oneActivity);
                    }
                    break;
                    case R.id.ac_main_rdBtn_activity2: {
                        Intent twoActivity = new Intent(MainActivity.this, TwoActivity.class);
                        startActivity(twoActivity);
                    }
                    break;
                    case R.id.ac_main_rdBtn_activity3: {
                        Intent threeActivity = new Intent(MainActivity.this, ThreeActivity.class);
                        startActivity(threeActivity);
                    }
                    break;
                    case R.id.ac_main_rdBtn_activity4: {
                        Intent fourActivity = new Intent(MainActivity.this, FourActivity.class);
                        startActivity(fourActivity);
                    }
                    break;
                    case R.id.ac_main_rdBtn_activity5: {
                        Intent fiveActivity = new Intent(MainActivity.this, FiveActivity.class);
                        startActivity(fiveActivity);
                    }
                    break;
                    default:
                        Toast.makeText(context, "Please , Select One Item!", Toast.LENGTH_SHORT)
                                .show();
                }
            }
        });
    }

    private void setViews() {
        rdBtnActivity5 = findViewById(R.id.ac_main_rdBtn_activity5);
        btnShowNotification = findViewById(R.id.ac_main_button);
        rdBtnActivity1 = findViewById(R.id.ac_main_rdBtn_activity1);
        rdBtnActivity2 = findViewById(R.id.ac_main_rdBtn_activity2);
        rdBtnActivity3 = findViewById(R.id.ac_main_rdBtn_activity3);
        rdBtnActivity4 = findViewById(R.id.ac_main_rdBtn_activity4);
        rdGroup = findViewById(R.id.ac_main_rdGroup);
    }


}
