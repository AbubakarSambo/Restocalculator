package com.example.abubakarsambo.calctip;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class SplitBill extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_bill);
        SQLiteDatabase menuDB = openOrCreateDatabase("foodMenuuu.db", MODE_PRIVATE, null);

        menuDB.execSQL("CREATE TABLE IF NOT EXISTS menu(menuItems text, price text)");
        menuDB.execSQL("DELETE FROM menu");
        menuDB.execSQL("INSERT INTO menu  VALUES ('chicken fried rice',11.75)");
        menuDB.execSQL("INSERT INTO menu  VALUES ('fish fried rice',13.75)");
        menuDB.execSQL("INSERT INTO menu  VALUES ('lamb fried rice',12.75)");
        menuDB.execSQL("INSERT INTO menu  VALUES ('beef fried rice',10.75)");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_split_bill, menu);
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


    public void splitter(View view) {

        RadioGroup group = (RadioGroup) findViewById(R.id.radio_view);
        RadioGroup group2 = (RadioGroup) findViewById(R.id.radio_view2);
        RadioGroup group3 = (RadioGroup) findViewById(R.id.radio_view3);
        RadioGroup group4 = (RadioGroup) findViewById(R.id.radio_view4);
        double ans1;
        double ans2;
        double ans3;
        double ans4;
        TextView amount_1 = (TextView) findViewById(R.id.name1amt);
        TextView amount_2 = (TextView) findViewById(R.id.name2amt);
        TextView amount_3 = (TextView) findViewById(R.id.name3amt);
        TextView amount_4 = (TextView) findViewById(R.id.name4amt);


        EditText name_1 = (EditText) findViewById(R.id.name1);
        EditText name_2 = (EditText) findViewById(R.id.name2);
        EditText name_3 = (EditText) findViewById(R.id.name3);
        EditText name_4 = (EditText) findViewById(R.id.name4);


        ArrayList<String> menuItems = getMenuItemFromDatabase();
        ArrayList<String> menuItemsPrice = getMenuItemPriceFromDatabase();

        String menuItem = name_1.getText().toString();
        String menuItem2 = name_2.getText().toString();
        String menuItem3 = name_3.getText().toString();
        String menuItem4 = name_4.getText().toString();

        Double menuItemPrice = 0.0;
        Double menuItemPrice2 = 0.0;
        Double menuItemPrice3 = 0.0;
        Double menuItemPrice4 = 0.0;
        //Log.d("sambo","name: "+menuItem);

        //get prices
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItem.equals(menuItems.get(i))) {
                menuItemPrice = Double.parseDouble(getMenuItemPriceFromDatabase().get(i));
                Log.d("sambo", "name: " + menuItemPrice);
            }
        }

        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItem2.equals(menuItems.get(i))) {
                menuItemPrice2 = Double.parseDouble(getMenuItemPriceFromDatabase().get(i));
                Log.d("sambo", "name: " + menuItemPrice);
            }
        }
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItem3.equals(menuItems.get(i))) {
                menuItemPrice3 = Double.parseDouble(getMenuItemPriceFromDatabase().get(i));
                Log.d("sambo", "name: " + menuItemPrice);
            }
        }
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItem4.equals(menuItems.get(i))) {
                menuItemPrice4 = Double.parseDouble(getMenuItemPriceFromDatabase().get(i));
                Log.d("sambo", "name: " + menuItemPrice);
            }
        }


        //radio group 1
        if (group.getCheckedRadioButtonId() == (R.id.high_button_view)) {
            ans1 = menuItemPrice + 0.20 * menuItemPrice;
            amount_1.setText(String.format("$%.2f.",ans1));
        } else if (group.getCheckedRadioButtonId() == (R.id.mid_button_view)) {
            ans1 = menuItemPrice + 0.15 * menuItemPrice;
            amount_1.setText(String.format("$%.2f.",ans1));
        } else if (group.getCheckedRadioButtonId() == (R.id.low_button_view)) {
            ans1 = menuItemPrice + 0.10 * menuItemPrice;
            amount_1.setText(String.format("$%.2f.",ans1));
        }

        //radio group 2
        if (!(menuItem2.equals(""))) {
            if (group2.getCheckedRadioButtonId() == (R.id.high_button_view2)) {
                ans2 = menuItemPrice2 + 0.20 * menuItemPrice2;
                amount_2.setText(String.format("$%.2f.",ans2));
            } else if (group2.getCheckedRadioButtonId() == (R.id.mid_button_view2)) {
                ans2 = menuItemPrice2 + 0.15 * menuItemPrice2;
                amount_2.setText(String.format("$%.2f.",ans2));
            } else if (group2.getCheckedRadioButtonId() == (R.id.low_button_view2)) {
                ans2 = menuItemPrice2 + 0.10 * menuItemPrice2;
                amount_2.setText(String.format("$%.2f.",ans2));
            }

        }
        //radio group 3
        if (!(menuItem3.equals(""))) {
            if (group3.getCheckedRadioButtonId() == (R.id.high_button_view3)) {
                ans3 = menuItemPrice3 + 0.20 * menuItemPrice3;
                amount_3.setText(String.format("$%.2f.",ans3));
            } else if (group3.getCheckedRadioButtonId() == (R.id.mid_button_view3)) {
                ans3 = menuItemPrice2 + 0.15 * menuItemPrice2;
                amount_3.setText(String.format("$%.2f.",ans3));
            } else if (group3.getCheckedRadioButtonId() == (R.id.low_button_view3)) {
                ans3 = menuItemPrice3 + 0.10 * menuItemPrice3;
                amount_3.setText(String.format("$%.2f.",ans3));
            }

        }
        //radio group 4
        if (!(menuItem4.equals(""))) {
            if (group4.getCheckedRadioButtonId() == (R.id.high_button_view4)) {
                ans4 = menuItemPrice4 + 0.20 * menuItemPrice4;
                amount_4.setText(String.format("$%.2f",ans4));
            } else if (group4.getCheckedRadioButtonId() == (R.id.mid_button_view4)) {
                ans4 = menuItemPrice4 + 0.15 * menuItemPrice4;
                amount_4.setText(String.format("$%.2f",ans4));
            } else if (group4.getCheckedRadioButtonId() == (R.id.low_button_view4)) {
                ans4 = menuItemPrice4 + 0.10 * menuItemPrice4;
                amount_4.setText(String.format("$%.2f",ans4));
            }

        }
    }


    public ArrayList<String> getMenuItemFromDatabase() {
        ArrayList<String> menuItem = new ArrayList<String>();


        SQLiteDatabase menuDB = openOrCreateDatabase("foodMenuuu.db", MODE_PRIVATE, null);
        Cursor items = menuDB.rawQuery("SELECT menuItems,Price FROM menu", null);
        items.moveToFirst();
        while (!items.isAfterLast()) {
            menuItem.add(items.getString(0));
            items.moveToNext();
        }
        return menuItem;
    }

    public ArrayList<String> getMenuItemPriceFromDatabase() {

        ArrayList<String> menuItemPrice = new ArrayList<String>();

        SQLiteDatabase menuDB = openOrCreateDatabase("foodMenuuu.db", MODE_PRIVATE, null);
        Cursor items = menuDB.rawQuery("SELECT menuItems,Price FROM menu", null);
        items.moveToFirst();
        while (!items.isAfterLast()) {
            menuItemPrice.add(items.getString(1));
            items.moveToNext();
        }
        return menuItemPrice;
    }


}
