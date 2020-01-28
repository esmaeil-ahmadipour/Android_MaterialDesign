package ir.ea2.android_materialdesign;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FiveActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private AlertDialog alertDialogDiscard;
    private AlertDialog.Builder builderDiscard;
    private AlertDialog alertDialogConfirmation;
    private AlertDialog.Builder builderConfirmation;
    private Button btnDiscard;
    private Button btnConfirmation;
    private String[] playersList = {"None", "Messi", "Salah", "CR7"};
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        setupToolbar();
        setupViews();
        setupListeners();
        setupAlertDialogDiscard();
        setupAlertDialogConfirmation();

    }

    private void setupListeners() {
        btnConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogConfirmarion();
            }
        });
        btnDiscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogDiscard();
            }
        });
    }

    private void setupAlertDialogConfirmation() {
        builderConfirmation = new AlertDialog.Builder(context);
        builderConfirmation.setTitle(getResources().getString(R.string.alert_btn_confirmation_title));
        builderConfirmation.setSingleChoiceItems(playersList, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, which + " / " + playersList[which], Toast.LENGTH_SHORT)
                        .show();
            }
        });
        //Set Positive Button
        builderConfirmation.setPositiveButton(getResources().getString(R.string.alert_pBtn_confirmation), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, (playersList[which+1]+" is "+getResources().getString(R.string.alert_pBtn_confirmation)), Toast.LENGTH_SHORT).show();
            }
        });
        //Set Negative Button
        builderConfirmation.setNegativeButton(getResources().getString(R.string.alert_nBtn_confirmation), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, getResources().getString(R.string.alert_nBtn_confirmation), Toast.LENGTH_SHORT).show();
            }
        });
        alertDialogConfirmation = builderConfirmation.create();
        //Tap any Where Not Dismiss AlertDialog , Just on AlertDialogsButtons .
        alertDialogConfirmation.setCancelable(false);

    }

    private void showAlertDialogConfirmarion() {
        alertDialogConfirmation.show();
    }

    private void setupAlertDialogDiscard() {
        builderDiscard = new AlertDialog.Builder(context);
        builderDiscard.setMessage(getResources().getString(R.string.alert_message_discard));
        //Set Positive Button
        builderDiscard.setPositiveButton(getResources().getString(R.string.alert_pBtn_discard), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, getResources().getString(R.string.alert_successfully_discard), Toast.LENGTH_SHORT)
                        .show();
            }
        });

        //Set Negative Button
        builderDiscard.setNegativeButton(getResources().getString(R.string.alert_nBtn_discard), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, getResources().getString(R.string.alert_failed_discard), Toast.LENGTH_SHORT)
                        .show();
            }
        });
        alertDialogDiscard = builderDiscard.create();
        //Tap any Where Dismiss AlertDialog
        alertDialogDiscard.setCancelable(true);
    }

    private void showAlertDialogDiscard() {
        alertDialogDiscard.show();
    }

    private void setupViews() {
        btnDiscard = findViewById(R.id.ac_five_btn_discard);
        btnConfirmation = findViewById(R.id.ac_five_btn_confirmation);
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.ac_four_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }
}
