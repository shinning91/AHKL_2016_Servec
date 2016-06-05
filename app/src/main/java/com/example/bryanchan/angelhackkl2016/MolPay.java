package com.example.bryanchan.angelhackkl2016;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.Result;
import com.molpay.molpayxdk.MOLPayActivity;

import org.json.JSONObject;

import java.util.HashMap;

public class MolPay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mol_pay);

        String total = getIntent().getExtras().getString("total");
        String from = getIntent().getExtras().getString("from");
        String description = getIntent().getExtras().getString("description");

        loadMolPoints(total, from, description);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == MOLPayActivity.MOLPayXDK && resultCode == RESULT_OK){
            Log.d(MOLPayActivity.MOLPAY, "MOLPay result = "+data.getStringExtra(MOLPayActivity.MOLPayTransactionResult));
            String resultString = data.getStringExtra(MOLPayActivity.MOLPayTransactionResult);

            try
            {
                JSONObject resultObj = new JSONObject(resultString);
                TextView orderID = (TextView)findViewById(R.id.orderIDTxt);
                TextView amount = (TextView)findViewById(R.id.amountTxt);
                TextView date = (TextView)findViewById(R.id.dateTxt);

                orderID.setText(resultObj.getString("order_id"));
                amount.setText(resultObj.getString("amount"));
                date.setText(resultObj.getString("paydate"));

            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }

    private void loadMolPoints(String total, String from, String description)
    {
        HashMap<String, Object> paymentDetails = new HashMap<>();

        // Mandatory String. A value not less than '1.00'
        paymentDetails.put(MOLPayActivity.mp_amount, total);

        // Mandatory String. Values obtained from MOLPay
        paymentDetails.put(MOLPayActivity.mp_username, "api_MOLWallet_Dev2");
        paymentDetails.put(MOLPayActivity.mp_password, "api_walletdev2");
        paymentDetails.put(MOLPayActivity.mp_merchant_ID, "MOLWallet_Dev2");
        paymentDetails.put(MOLPayActivity.mp_app_name, "ahkl02");
        paymentDetails.put(MOLPayActivity.mp_verification_key, "c69cb3012ea622600c409888bec0706b");

        // Mandatory String. Payment values
        paymentDetails.put(MOLPayActivity.mp_order_ID, "orderid123");
        paymentDetails.put(MOLPayActivity.mp_currency, "MYR");
        paymentDetails.put(MOLPayActivity.mp_country, "MY");
        paymentDetails.put("domain_mode","1");

        // Optional String.
//        paymentDetails.put(MOLPayActivity.mp_channel, "multi"); // Use 'multi' for all available channels option. For individual channel seletion, please refer to "Channel Parameter" in "Channel Lists" in the MOLPay API Spec for Merchant pdf.
//        paymentDetails.put(MOLPayActivity.mp_bill_description, "billdesc");
        paymentDetails.put(MOLPayActivity.mp_bill_name, description);
        paymentDetails.put(MOLPayActivity.mp_bill_email, from + "@gmail.com");
        paymentDetails.put(MOLPayActivity.mp_bill_mobile, "+60175076570");
//        paymentDetails.put(MOLPayActivity.mp_channel_editing, false); // Option to allow channel selection.
//        paymentDetails.put(MOLPayActivity.mp_editing_enabled, false); // Option to allow billing information editing.

        // Optional for Escrow "FOR SAFETY" <<
//        paymentDetails.put(MOLPayActivity.mp_is_escrow, ""); // Put "1" to enable escrow

        // Optional for credit card BIN restrictions
//        String binlock[] = {"414170","414171"};
//        paymentDetails.put(MOLPayActivity.mp_bin_lock, binlock);
//        paymentDetails.put(MOLPayActivity.mp_bin_lock_err_msg, "Only UOB allowed");

        // For transaction request use only, do not use this on payment process
//        paymentDetails.put(MOLPayActivity.mp_transaction_id, ""); // Optional, provide a valid cash channel transaction id here will display a payment instruction screen.
//        paymentDetails.put(MOLPayActivity.mp_request_type, "");

        Intent intent = new Intent(MolPay.this, MOLPayActivity.class);
        intent.putExtra(MOLPayActivity.MOLPayPaymentDetails, paymentDetails);
        startActivityForResult(intent, MOLPayActivity.MOLPayXDK);
    }

    public void goBackHome(View view)
    {
        Intent homeIntent = new Intent(MolPay.this, MainActivity.class);
        startActivity(homeIntent);
    }
}
