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
import android.widget.Toast;

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
                if(!(edName.getText().toString().isEmpty()) && !(edPhone.getText().toString().isEmpty()) && !(edPax.getText().toString().isEmpty())) {
                    if (chckBxSmoke.isChecked()) {
                        tvDetails.setText("Hi " + edName.getText() + ", reservation confirmed on " + dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear() + " at " + tp.getCurrentHour() + ":" + tp.getCurrentMinute() + ", seating in smoking area with total of " + edPax.getText() + ". Thank you for your reservation!");
                    } else {
                        tvDetails.setText("Hi " + edName.getText() + ", reservation confirmed on " + dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear() + " at " + tp.getCurrentHour() + ":" + tp.getCurrentMinute() + ", seating in non-smoking area with total of" + edPax.getText() + ".Your phone number is "+edPhone.getText()+". Thank you for your reservation!");
                    }
                    Toast.makeText(MainActivity.this, "Reservation Made!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please fill in the details!", Toast.LENGTH_LONG).show();
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

                Toast.makeText(MainActivity.this,"Reset details", Toast.LENGTH_SHORT).show();
            }
        });

                tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker v, int hourOfDay, int minute) {
                        if (tp.getCurrentHour() > 20 || tp.getCurrentHour() < 8)
                        {
                            Toast.makeText(getApplicationContext(), "Please choose a time between 8AM and 8:59PM inclusive!", Toast.LENGTH_LONG).show();
                            tp.setCurrentHour(19);
                            tp.setCurrentMinute(30);
                        }
                    }
        });
    }
}