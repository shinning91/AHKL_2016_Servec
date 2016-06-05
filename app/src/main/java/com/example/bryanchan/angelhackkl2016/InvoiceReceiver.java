package com.example.bryanchan.angelhackkl2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class InvoiceReceiver extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView mScannerView;
    private String from;
    private String total;
    private String description;
    private String to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_receiver);

        startScanning();
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here

        String dataFromQR = rawResult.getText().toString();
        Log.e("handler", rawResult.getText()); // Prints scan results
        String[] parts = dataFromQR.split(",");
        total = parts[0]; //total
        from = parts[1]; //from
        description = parts[2]; //description
        to = parts[3]; //to
        Log.e("handler", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode)

        ViewGroup parent = (ViewGroup) mScannerView.getParent();
        parent.removeView(mScannerView);
        setContentView(R.layout.activity_invoice_receiver);
        loadInvoice(total, from, description, to);
        // show the scanner result into dialog box.
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Scan Result");
//        builder.setMessage(rawResult.getText());
//        AlertDialog alert1 = builder.create();
//        alert1.show();

        // If you would like to resume scanning, call this method below:
        // mScannerView.resumeCameraPreview(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();   // Stop camera on pause
    }

    public void loadInvoice(String total, String from, String description, String to)
    {
        Log.d("got string?", to + total + from + description);
        LinearLayout layout = (LinearLayout)findViewById(R.id.invoiceReceiverLayout);
        TextView toTxtView = (TextView)layout.findViewById(R.id.toTxtView);
        toTxtView.setText(to);

        TextView fromTxtView = (TextView)findViewById(R.id.fromTxtView);
        fromTxtView.setText(from);

        TextView totalTxtView = (TextView)findViewById(R.id.totalTxtView);
        totalTxtView.setText(total);

        TextView descriptionTxtView = (TextView)findViewById(R.id.nameTxtView);
        descriptionTxtView.setText(description);
    }

    public void goToMolPay(View view)
    {
        Intent molPayIntent = new Intent(InvoiceReceiver.this, MolPay.class);
        molPayIntent.putExtra("from", from);
        molPayIntent.putExtra("total", total);
        molPayIntent.putExtra("description", description);
        startActivity(molPayIntent);
    }

    private void startScanning()
    {
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();         // Start camera
    }
}
