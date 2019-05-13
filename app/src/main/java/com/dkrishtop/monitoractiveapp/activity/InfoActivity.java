package com.dkrishtop.monitoractiveapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.monitoractiveapp.R;

public class InfoActivity extends AppCompatActivity {

    private final String[] apiData = {"Camera", "Contacts", "Storage"};
    private final String[] appData = {"HearthStone", "Kopatel`", "2048"};

    private static final String CHOOSE_API = "Choose Api";
    private static final String CHOOSE_APP = "Choose App";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);
        final RadioGroup mInfoRadioGroup = findViewById(R.id.info_radioGroup);
        Button mShowButton = findViewById(R.id.show_button);

        final Spinner mApiSpinner = getSpinner(R.id.api_spinner, CHOOSE_API, apiData);
        final Spinner mAppSpinner = getSpinner(R.id.app_spinner, CHOOSE_APP, appData);

        mInfoRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.api_radioButton:
                        mApiSpinner.setEnabled(true);
                        mAppSpinner.setEnabled(false);
                        break;
                    case R.id.app_radioButton:
                        mApiSpinner.setEnabled(false);
                        mAppSpinner.setEnabled(true);
                        break;
                    default:
                        break;
                }
            }
        });

        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton mCheckedRadiobutton = findViewById(mInfoRadioGroup.getCheckedRadioButtonId());

                //start another activity with table of information
            }
        });
    }

    private Spinner getSpinner(int idSpinner, String prompt, String [] data){
        Spinner spinner = findViewById(idSpinner);
        spinner.setPrompt(prompt);
        //adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, data);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setEnabled(false);
        return spinner;
    }
}
