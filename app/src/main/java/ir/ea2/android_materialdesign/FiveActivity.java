package ir.ea2.android_materialdesign;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FiveActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private AlertDialog alertDialogDiscard, alertDialogConfirmation, alertDialogMultiOptions,alertDialogSetItem;
    private AlertDialog.Builder builderDiscard, builderConfirmation, builderMultiOptions,builderSetItem;
    private Button btnDiscard, btnConfirmation, btnMultiOptions,btnSetItem;
    private String[] playersList = {"Daei", "Messi", "Salah", "CR7"};
    Context context = this;
    private List<String> selectedPlayers = new ArrayList<>();
    private String selectedPlayersString="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        setupToolbar();
        setupViews();
        setupListeners();
        setupAlertDialogDiscard();
        setupAlertDialogConfirmation();
        setupAlertDialogMultiOptions();
        setupAlertDialogSetItem();

    }

    private void setupListeners() {
        btnSetItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogSetItem();
            }
        });
        btnMultiOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogMultiOptions();
            }
        });

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
                Toast.makeText(context, (playersList[which + 1] + " is " + getResources().getString(R.string.alert_pBtn_confirmation)), Toast.LENGTH_SHORT)
                        .show();
            }
        });
        //Set Negative Button
        builderConfirmation.setNegativeButton(getResources().getString(R.string.alert_nBtn_confirmation), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, getResources().getString(R.string.alert_nBtn_confirmation), Toast.LENGTH_SHORT)
                        .show();
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

    private void setupAlertDialogMultiOptions() {
        builderMultiOptions = new AlertDialog.Builder(context);
        builderMultiOptions.setTitle(getResources().getString(R.string.alert_btn_confirmation_title));
        builderMultiOptions.setMultiChoiceItems(playersList, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                if (isChecked) {
                    selectedPlayers.add(playersList[which]);
                } else {
                    if(selectedPlayers.contains(playersList[which])){
                        selectedPlayers.remove(selectedPlayers.indexOf(playersList[which]));
                    }
                }
            }
        });
        //Set Positive Button
        builderMultiOptions.setPositiveButton(getResources().getString(R.string.alert_pBtn_confirmation), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(selectedPlayers.size()>0){
                    for (String selectedPlayer : selectedPlayers) {
                        selectedPlayersString+=(selectedPlayer+" ");
                    }
                    Toast.makeText(context, selectedPlayersString, Toast.LENGTH_SHORT).show();
                    selectedPlayersString="";
                }
                else{
                    Toast.makeText(context, selectedPlayersString, Toast.LENGTH_SHORT).show();
                }

            }
        })
                .setNegativeButton(getResources().getString(R.string.alert_nBtn_confirmation), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, getResources().getString(R.string.alert_nBtn_confirmation), Toast.LENGTH_SHORT)
                                .show();
                    }
                });
        //Set Negative Button
        alertDialogMultiOptions = builderMultiOptions.create();
        //Tap any Where Not Dismiss AlertDialog , Just on AlertDialogsButtons .
        alertDialogMultiOptions.setCancelable(false);

    }

    private void showAlertDialogMultiOptions() {
        alertDialogMultiOptions.show();
    }
    private void setupAlertDialogSetItem() {
        builderSetItem = new AlertDialog.Builder(context);
        builderSetItem.setTitle(getResources().getString(R.string.alert_btn_confirmation_title));
        builderSetItem.setItems(playersList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, playersList[which], Toast.LENGTH_SHORT).show();
            }
        });
        //Set Negative Button
        alertDialogSetItem = builderSetItem.create();
        //Tap any Where Not Dismiss AlertDialog , Just on AlertDialogsButtons .
        alertDialogSetItem.setCancelable(false);

    }

    private void showAlertDialogSetItem() {
        alertDialogSetItem.show();
    }

    private void setupViews() {
        btnSetItem = findViewById(R.id.ac_five_btn_set_item);
        btnDiscard = findViewById(R.id.ac_five_btn_discard);
        btnConfirmation = findViewById(R.id.ac_five_btn_confirmation);
        btnMultiOptions = findViewById(R.id.ac_five_btn_multi_options);

    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.ac_four_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }
}





