package br.com.philippesis.fragmentportandland.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import br.com.philippesis.fragmentportandland.R;

public class Utils {

    private String textCatcher = null;

    public String getValueDialog(Context parent) {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(parent);
        View promptView = layoutInflater.inflate(R.layout.input_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(parent);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        textCatcher = editText.getText().toString();
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();

        return textCatcher;
    }

}
