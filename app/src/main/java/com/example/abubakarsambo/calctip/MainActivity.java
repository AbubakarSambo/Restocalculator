package com.example.abubakarsambo.calctip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

         double bill;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void findTip(View view){
        RadioGroup group = (RadioGroup) findViewById(R.id.radio_view);
        EditText final_resp = (EditText) findViewById(R.id.final_response_view);
        EditText waiter_msg = (EditText) findViewById(R.id.Waiter_message);
        Double final_ans;




        //group.getCheckedRadioButtonId()



      String double_string =  ((EditText) findViewById(R.id.bill_view)).getText().toString();
        String waitermsg;


    try {
        bill = Double.valueOf(double_string);
    }
    catch (Exception e){

        final_resp.setText("");
        waiter_msg.setText("");
        CharSequence text = "please enter a value";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, text, duration);
        toast.setGravity(Gravity.TOP|Gravity.LEFT, 370, 500);
        toast.show();




    }





        if(group.getCheckedRadioButtonId() == (R.id.high_button_view)){

            final_ans = bill*0.20 + bill;
            waitermsg = "glad we exceeded your expectations";

        }
        else if(group.getCheckedRadioButtonId() == (R.id.mid_button_view)){

            final_ans = bill*0.15 + bill;
            waitermsg = "We hope to serve you better next time";
        }

       else {

            final_ans = bill*0.10 + bill;
            waitermsg = "Aw that sucks, tell us what we can do to improve your experience";
        }




        final_resp.setText("your total bill is: " + final_ans);
        waiter_msg.setText(waitermsg);

    }

    public void splitBill(View view){

        Intent intent = new Intent(this, SplitBill.class);
        startActivity(intent);


    }

}
