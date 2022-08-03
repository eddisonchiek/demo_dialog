package sg.edu.sg.c346.id21034014.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnDemo1;
    Button btnDemo2;
    Button btnDemo3;
    Button btnDemo4;
    Button btnDemo5;
    Button btnDemo6;
    TextView tvDemo2;
    TextView tvDemo3;
    TextView tvDemo4;
    TextView tvDemo5;
    TextView tvDemo6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);
        btnDemo6 = findViewById(R.id.buttonDemo6);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        tvDemo5 = findViewById(R.id.textViewDemo5);
        tvDemo6 = findViewById(R.id.textViewDemo6);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
//                myBuilder.setTitle("Demo 1-Simple Dialog");
//                myBuilder.setMessage("I can develop Android App.");
//                myBuilder.setCancelable(false);
//                myBuilder.setPositiveButton("Close",null);
                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(true);
                myBuilder.setPositiveButton("DIMISS",null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Button below");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                    tvDemo2.setText("You have selected Positive.");
                    }
                });


                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        tvDemo2.setText("You have selected Negative");
                    }
                });
                myBuilder.setNeutralButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();




            }

        });
        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String message = etInput.getText().toString();
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNeutralButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();


            }
        });
        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input2, null);
                //View viewDialog2 = inflater.inflate(R.layout.input,null);

                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);
                final EditText etInput2 = viewDialog.findViewById(R.id.editTextInput2);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String message2 = etInput2.getText().toString();
                        String message = etInput.getText().toString();
                        int number1 = Integer.parseInt(message);
                        int number2 = Integer.parseInt(message2);
                        int total = number1 + number2;

                        tvDemo4.setText("The sum is " + total);
                    }
                });
                myBuilder.setNeutralButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });
        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                      tvDemo5.setText("Date: " +  dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };
                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, year, month, day);

                myDateDialog.show();

            }


        });
        btnDemo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo6.setText("Time: "+hourOfDay + ":" + minute);

                    }
                };
                Calendar now = Calendar.getInstance();
                int hourOfDay = now.get(Calendar.HOUR_OF_DAY);  // Current Hour
                int minute = now.get(Calendar.MINUTE);  // Current Minute
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener, hourOfDay, minute, true);

                myTimeDialog.show();
            }
        });


    }
}