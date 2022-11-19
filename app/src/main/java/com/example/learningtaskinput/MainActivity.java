package com.example.learningtaskinput;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText prelimgrade, midtermgrade, endtermgrade;
    String strprelimgrade, strmidtermgrade, strendtermgrade , resultMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCompute = (Button) findViewById(R.id.button);

        btnCompute.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Calculating....", Toast.LENGTH_SHORT).show();
        ComputeResult();
    }

    public void ComputeResult(){
        prelimgrade = (EditText) findViewById(R.id.prelimgrade);
        midtermgrade = (EditText) findViewById(R.id.midtermgrade);
        endtermgrade = (EditText) findViewById(R.id.endtermgrade);

        if(prelimgrade.getText().toString().isEmpty() || midtermgrade.getText().toString().isEmpty() || endtermgrade.getText().toString().isEmpty()){
            strprelimgrade = "0";
            strmidtermgrade = "0";
            strendtermgrade = "0";

        }else{
            strprelimgrade = prelimgrade.getText().toString();
            strmidtermgrade = midtermgrade.getText().toString();
            strendtermgrade = endtermgrade.getText().toString();
        }
        double pre = Double.parseDouble(strprelimgrade);
        double mid = Double.parseDouble(strmidtermgrade);
        double end = Double.parseDouble(strendtermgrade);

        pre = (pre * .30);
        mid = (mid * .30);
        end = (end * .40);

        double result = pre + mid + end;


        resultMessage = "Your Final Grade is :" +"  "+ result;




        // Create Bundle instance, this will allow transfer of data from Activity to DialogFragment
        Bundle args = new Bundle();
        args.putString("result", resultMessage);

        // Create a dialog instance
        DialogFragmentCustom dialogFragmentImp = new DialogFragmentCustom();
        // Pass on dialog argument(args), the result
        dialogFragmentImp.setArguments(args);
        // Display the Dialog
        dialogFragmentImp.show(getSupportFragmentManager(),"Display Result");
        // Reset EditTexts
        clearEditText();
    }
    public void clearEditText(){
        prelimgrade.getText().clear();
        midtermgrade.getText().clear();
        endtermgrade.getText().clear();
        prelimgrade.requestFocus();
    }
    public double ToDecimal(double nbr){
        nbr = nbr/100;
        return nbr;
    }
}
