package com.example.login_page;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Registration_page extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener

{
    private EditText username, usn;
    Button b1,b2,b3,b4;
    EditText u1,u2;
    // create array of Strings
    // and store name of courses
@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registartion_page);
        username=findViewById(R.id.u1);
        usn=findViewById(R.id.u2);
    b1=(Button)findViewById(R.id.camera_button);
    b2=(Button)findViewById(R.id.contacts);
    b3=(Button)findViewById(R.id.acess_login);
    b4=(Button)findViewById(R.id.dail_pad);
    u1=(EditText)findViewById(R.id.u1);
    u2=(EditText)findViewById(R.id.u2);

    // Take the instance of Spinner and
    // apply OnItemSelectedListener on it which
    // tells which item of spinner is clicked
    Spinner spino = findViewById(R.id.s1);
    spino.setOnItemSelectedListener(this);

    // Create the instance of ArrayAdapter
    // having the list of courses
    ArrayAdapter ad
            = new ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            courses);

    // set simple layout resource file
    // for each item of spinner
    ad.setDropDownViewResource(
            android.R.layout
                    .simple_spinner_dropdown_item);

    // Set the ArrayAdapter (ad) data on the
    // Spinner which binds data to spinner
    spino.setAdapter(ad);


    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        }
    });
    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
            startActivity(intent);
        }
    });

    b3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent obj = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(obj);
            obj.putExtra("one", u1.getText().toString());
            obj.putExtra("two", u2.getText().toString());
            startActivity(obj);
        }
    });
    b4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:0123456789"));
            startActivity(intent);
        }
    });
        }
@Override
protected void onResume() {
        super.onResume();
        // Fetching the stored data from the SharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sh.getString("username", "");
        String s2 = sh.getString("usn", "");

        // Setting the fetched data in the EditTexts
        username.setText(s1);
        usn.setText(s2);
        }

// Store the data in the SharedPreference in the onPause() method
// When the user closes the application onPause() will be called and data will be stored
@Override
protected void onPause() {
        super.onPause();
        // Creating a shared pref object with a file name "MySharedPref" in private mode
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("username", username.getText().toString());
        myEdit.putString("usn", usn.getText().toString());
        myEdit.apply();
        myEdit.commit();
    Toast.makeText(Registration_page.this,"Values Saved",Toast.LENGTH_LONG).show();

}
    String[] courses = { "","CSE", "ISE","AIML",
            "ECE", "EEE",
            "MECH", "CIVIL" };


    // Performing action when ItemSelected
    // from spinner, Overriding onItemSelected method
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       if(courses[position]!="") {
           Toast.makeText(getApplicationContext(),
                           courses[position],
                           Toast.LENGTH_LONG)
                   .show();
       }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    }
