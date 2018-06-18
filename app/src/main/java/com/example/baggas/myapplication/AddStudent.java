package com.example.baggas.myapplication;

/**
 * Created by BAGGAS on 6/18/2018.
 *
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class AddStudent  extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {

    static final String TAG = MainActivity.class.getName();


    DatabaseReference databaseReference;

    EditText studentName, studentPhone, studentAddress;
    Button submitBtn;
    String collegeName ;
    ProgressBar pb;
    LinearLayout ll;

    ArrayList<StudentData> studentArrayList = new ArrayList<StudentData>();

    Spinner spinnerCollegeNames;

    String collegeNames[] = new String[3];

    // String initial[]={"Select College"};

    //  ArrayList<String> collegen = new ArrayList<String>();

    DatabaseHelper databaseHelper;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student);

        studentName = findViewById(R.id.name);
        studentPhone = findViewById(R.id.phoneno);
        studentAddress = findViewById(R.id.address);
        submitBtn = findViewById(R.id.submit);
        ll = findViewById(R.id.layout);

        databaseHelper = new DatabaseHelper(this);

        spinnerCollegeNames = findViewById(R.id.spinner);
        pb = findViewById(R.id.progress);

        spinnerCollegeNames.setOnItemSelectedListener(this);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child("Spinner").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Log.d(TAG ,"Child count: " + dataSnapshot);
                int i = 0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    collegeNames[i] = String.valueOf(snapshot.child("name").getValue());
                    i++;
                }
                pb.setVisibility(View.GONE);

                arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, collegeNames);
                // arrayAdapter.notifyDataSetChanged();
                spinnerCollegeNames.setAdapter(arrayAdapter);
                enableAllViews();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = studentName.getText().toString();
                long phone = Long.parseLong(studentPhone.getText().toString());
                String address = studentAddress.getText().toString();

                databaseHelper.addNewStudent(new StudentData(name, collegeName, address, phone));
                studentArrayList.addAll(databaseHelper.allStudentsDetails());


                Toast.makeText(getApplicationContext(), "Details Entered Successfully", Toast.LENGTH_LONG).show();


            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        collegeName = String.valueOf(collegeNames[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    void disableAllViews() {

        ll.setVisibility(View.GONE);
    }

    void enableAllViews() {

        ll.setVisibility(View.VISIBLE);


    }
}

