package edna.ceniza.com.easycalc;

import android.content.Context;
import android.content.DialogInterface;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edna.ceniza.com.easycalc.controllers.Operations;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private double res = 0;
    Operations aOperations = new Operations();

    private EditText n1;
    private EditText n2;

    private double fnum = 0;
    private double snum = 0;

    private TextView txtres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();

    }

    public void findView(){
        n1 = (EditText)findViewById(R.id.fnum);
        n2 = (EditText)findViewById(R.id.snum);
        txtres = (TextView) findViewById(R.id. result);

        Button add = (Button) findViewById(R.id.add);
        Button minus = (Button) findViewById(R.id.minus);
        Button times = (Button) findViewById(R.id.times);
        Button divide = (Button) findViewById(R.id.divide);
        Button clear = (Button) findViewById(R.id.clear);
        Button exit = (Button) findViewById(R.id.exit);

        add.setOnClickListener(this);
        minus.setOnClickListener(this);
        times.setOnClickListener(this);
        divide.setOnClickListener(this);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1.setText("");
                n2.setText("");
                txtres.setText("0");
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }

    @Override
    public void onClick(View view) {
        String firstnum = n1.getText().toString();
        String secnum = n2.getText().toString();

        if (firstnum.matches("") || secnum.matches("")) {
            //System.exit(0);
            AlertDialog.Builder adialog = new AlertDialog.Builder(MainActivity.this);
            adialog.setTitle("Missing entry");
            adialog.setMessage("Please enter values for all fields.");
            adialog.setCancelable(false);
            adialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alert = adialog.create();
            alert.show();
        }

        else {
            fnum = Double.parseDouble(n1.getText().toString());
            snum = Double.parseDouble(n2.getText().toString());

            switch (view.getId()) {
                case R.id.add:
                    res = aOperations.add(fnum, snum);
                    break;

                case R.id.minus:
                    res = aOperations.minus(fnum, snum);
                    break;

                case R.id.times:
                    res = aOperations.times(fnum, snum);
                    break;

                case R.id.divide:
                    res = aOperations.divide(fnum, snum);
                    break;

            }

            String last = String.format("%,.2f", res);
            txtres.setText(last);


        }
    }


}

