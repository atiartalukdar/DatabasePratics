package database.com.example.talukdar.databasepratics;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import database.DBHelperAdepter;
import database.Message;

public class MainActivity extends AppCompatActivity {
    EditText username,pass;
    Button submit;
    DBHelperAdepter dbHelperAdepter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.username);
        pass= (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);
        dbHelperAdepter = new DBHelperAdepter(this);
    }
    public void submit(View view){
        String u=username.getText().toString();
        String p=pass.getText().toString();

       long id = dbHelperAdepter.insetData(u,p);
        if(id<0){
            Message.message(this,"Unsuccessfull");
        }
        else{
            Message.message(this,"Successfull");
        }
    }
}
