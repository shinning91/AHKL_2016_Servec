package com.example.bryanchan.angelhackkl2016;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class InvoiceGenerator extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_generator);

    }

    public void confirmInvoice(View view)
    {
        EditText fromEditText = (EditText)findViewById(R.id.fromEditText);
        String from = fromEditText.getText().toString();

        EditText toEditText = (EditText)findViewById(R.id.toEditText);
        String to = toEditText.getText().toString();

        EditText amountText = (EditText)findViewById(R.id.amountEditText);
        String amount1 = amountText.getText().toString();

        EditText quantityText = (EditText)findViewById(R.id.quantityEditText);
        String quantity1 = quantityText.getText().toString();

        EditText descriptionText = (EditText)findViewById(R.id.firstDescriptionEditText);
        String description1 = descriptionText.getText().toString();

        EditText amount2Text = (EditText)findViewById(R.id.amount2EditText);
        String amount2 = amount2Text.getText().toString();

        EditText quantity2Text = (EditText)findViewById(R.id.quantity2EditText);
        String quantity2 = quantity2Text.getText().toString();

        EditText description2Text = (EditText)findViewById(R.id.description2EditText);
        String description2 = description2Text.getText().toString();

        TextView totalTextView = (TextView)findViewById(R.id.totalTextView);
        String total = totalTextView.getText().toString();

        Intent goToQRGenerator = new Intent(InvoiceGenerator.this, QRGenerator.class);
        goToQRGenerator.putExtra("total", total);
        goToQRGenerator.putExtra("name", from);
        goToQRGenerator.putExtra("description", description1);
        goToQRGenerator.putExtra("to", to);
        startActivity(goToQRGenerator);
    }
}