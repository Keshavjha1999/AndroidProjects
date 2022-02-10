package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private int noOfCoffees = 0;
    private boolean whippedCreamRequirement;
    private boolean chocolateRequirement;
    private EditText name;
    private int bill = 0;
    private int basePrice = 5;
    private EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increaseOrder(View view){
        this.noOfCoffees+=1;
        if (this.noOfCoffees>20){
            this.noOfCoffees = 20;
        }
        display(this.noOfCoffees);
        displayPrice(this.noOfCoffees * this.basePrice);
    }

    public void decreaseOrder(View view){
        if(this.noOfCoffees==0){
            this.noOfCoffees=0;
        }
        else{
            this.noOfCoffees-=1;
        }
        display(this.noOfCoffees);
        displayPrice(this.noOfCoffees * this.basePrice);
    }

    public void whippedCreamFunction(View view){
        this.whippedCreamRequirement = ((CheckBox) view).isChecked();
        this.basePrice+=1;
    }

    public void chocolateFunction(View view){
        this.chocolateRequirement = ((CheckBox) view).isChecked();
        this.basePrice+=2;
    }

    public void submitOrder(View view) {
        this.name = (EditText) findViewById(R.id.name);
        this.email = (EditText) findViewById(R.id.email);
        String name = this.name.getText().toString();
        String content = getString(R.string.order_summary_name, name);
        if(this.chocolateRequirement){
            content += "\n" + getString(R.string.added_chocolate);
        } else {
            content += "\n" + getString(R.string.no_added_chocolate);
        }
        if(this.whippedCreamRequirement){
            content += "\n" + getString(R.string.added_whipped_cream);
        } else{
            content += "\n" + getString(R.string.no_added_whipped_crean);
        }
        this.bill += this.noOfCoffees * this.basePrice;
        this.noOfCoffees=0;
        content += "\n" + getString(R.string.thank_you_note);
        content += "\n" + getString(R.string.billing_note, String.valueOf(this.bill));
        String subject = getString(R.string.subject);
        String email = this.email.getText().toString();
        sharetoGmail(email, subject, content);
    }

    private void sharetoGmail(String email, String subject, String content){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, content);
        startActivity(emailIntent);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText("" + number);
    }
}