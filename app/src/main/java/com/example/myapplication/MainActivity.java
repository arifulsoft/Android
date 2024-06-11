package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;

    String[] items={"Add","Sub","Multi","Div"};
    String selecteditem;
    EditText text1,text2,text3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

         button=findViewById(R.id.btn);
         text1=findViewById(R.id.t1);
        text2=findViewById(R.id.t2);
        text3=findViewById(R.id.res);

        spinner=findViewById(R.id.spinner);

//        ------------ string array diya kora -------------

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(1);

//        ---------------------values// strings.xml ya array diya kora -----------------------

//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.dropdown_items, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setSelection(1);

//        ------------------ selected dropdown ---------------------
        spinner.setOnItemSelectedListener(this);

    }

    //------------- click button & show --------------
    public void show(View v){
        String n1=String.valueOf(text1.getText());
        String n2=String.valueOf(text2.getText());

        double x1=Double.parseDouble(n1);
        double x2=Double.parseDouble(n2);
        double result=0;
        if(selecteditem=="Add"){
            result=x1+x2;
        } else if (selecteditem=="Sub"){
            result=x1-x2;
        } else if (selecteditem=="Multi"){
            result=x1*x2;
        } else if (selecteditem=="Div"){
            result=x1/x2;
        }
        text3.setText(String.valueOf(result));

       Toast.makeText(MainActivity.this, "the result is = "+result , Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        selecteditem=items[position];

        if (items[position]=="A"){
            Toast.makeText(MainActivity.this, "America", Toast.LENGTH_SHORT).show();
        } else if (items[position]=="B") {
            Toast.makeText(MainActivity.this, "Bangladesh", Toast.LENGTH_SHORT).show();
        } else if (items[position]=="C") {
            Toast.makeText(MainActivity.this, "Canada", Toast.LENGTH_SHORT).show();
        } else if (items[position]=="D") {
            Toast.makeText(MainActivity.this, "Danmark", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}