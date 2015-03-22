package com.example.savan.readwrite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends ActionBarActivity {
    EditText fname, fcontent;
    EditText fcontentphone, fcontentemail, fcontentaddress, fcontentobjective;
    EditText fcontenteducation, fcontentcoursework, fcontenttechskill, fcontentexperience, fcontentproject;
    Button write;
    TextView filecon;
    private final int ID_MENU_EXIT =1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
          case R.id.exit:
             this.finish();
             break;
          case R.id.clear:
             this.finish();
             startActivity(new Intent(this,MainActivity.class));
             break;
        }
    return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = (EditText) findViewById(R.id.fname);
        fcontent = (EditText) findViewById(R.id.ftext);
        write = (Button) findViewById(R.id.btnwrite);
        // edited part after modification
        fcontentphone = (EditText) findViewById(R.id.fphone);
        fcontentemail = (EditText) findViewById(R.id.femail);
        fcontentaddress = (EditText) findViewById(R.id.faddress);
        fcontentobjective = (EditText) findViewById(R.id.fobjective);

        fcontenteducation = (EditText) findViewById(R.id.feducation);
        fcontentcoursework = (EditText) findViewById(R.id.fcoursework);
        fcontenttechskill = (EditText) findViewById(R.id.ftechskill);
        fcontentexperience = (EditText) findViewById(R.id.fexperience);
        fcontentproject = (EditText) findViewById(R.id.fproject);

        //Main part of coding begins

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String filename = fname.getText().toString();

                String filecontent = fcontent.getText().toString();
                // Modified part
                String filephone = fcontentphone.getText().toString();
                String fileemail = fcontentemail.getText().toString();
                String fileaddress = fcontentaddress.getText().toString();
                String fileobjective = fcontentobjective.getText().toString();
                String fileeducation = fcontenteducation.getText().toString();
                String filecourse = fcontentcoursework.getText().toString();
                String filetechskill = fcontenttechskill.getText().toString();
                String fileexperience = fcontentexperience.getText().toString();
                String fileproject = fcontentproject.getText().toString();

                FileOperations fop = new FileOperations();
                fop.write(filename, filecontent, filephone, fileemail, fileaddress, fileobjective, fileeducation, filecourse, filetechskill, fileexperience, fileproject);
                if (fop.write(filename, filecontent, filephone, fileemail, fileaddress, fileobjective, fileeducation, filecourse, filetechskill, fileexperience, fileproject)) {
                    Toast.makeText(getApplicationContext(),
                            filename + ".pdf created", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Toast.makeText(getApplicationContext(), "I/O error",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button viewButton = (Button) findViewById(R.id.viewsd);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("file/*");
                startActivity(intent);

            }
        });




    }
}

