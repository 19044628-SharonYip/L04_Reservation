package sg.edu.rp.c346.id19044628.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {


    EditText edName;
    EditText edPhone;
    EditText edPax;
    CheckBox chckBxSmoke;
    DatePicker dp;
    TimePicker tp;
    Button btnCfm;
    Button btnReset;
    TextView tvDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName=findViewById(R.id.editTextName);
        edPhone=findViewById(R.id.editTextPhone);
        edPax=findViewById(R.id.editTextPax);
        chckBxSmoke=findViewById(R.id.chckBxSmoke);
        dp=findViewById(R.id.datePicker);
        tp=findViewById(R.id.timePicker);
        btnCfm=findViewById(R.id.buttonCfm);
        btnReset=findViewById(R.id.buttonReset);
        tvDetails=findViewById(R.id.textViewDetails);


        btnCfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chckBxSmoke.isChecked())
                {
                    tvDetails.setText("Hi "+edName.getText()+", reservation confirmed on "+dp.getDayOfMonth()+"/"+(dp.getMonth()+1)+"/"+dp.getYear()+" at "+tp.getCurrentHour()+":"+tp.getCurrentMinute()+", seating in smoking area with total of "+edPax.getText()+". Thank you for your reservation!");
                }
                else
                {
                    tvDetails.setText("Hi "+edName.getText()+", reservation confirmed on "+dp.getDayOfMonth()+"/"+(dp.getMonth()+1)+"/"+dp.getYear()+" at "+tp.getCurrentHour()+":"+tp.getCurrentMinute()+", seating in non-smoking area with total of" +edPax.getText()+". Thank you for your reservation!");
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate(2019,12,1);
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                edName.setText("");
                edPhone.setText("");
                edPax.setText("");
                chckBxSmoke.setChecked(false);
                tvDetails.setText("");
            }
        });
    }
}