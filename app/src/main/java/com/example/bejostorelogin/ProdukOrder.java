package com.example.bejostorelogin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.midtrans.sdk.corekit.callback.TransactionFinishedCallback;
import com.midtrans.sdk.corekit.core.MidtransSDK;
import com.midtrans.sdk.corekit.core.themes.CustomColorTheme;
import com.midtrans.sdk.corekit.models.snap.TransactionResult;
import com.midtrans.sdk.uikit.SdkUIFlowBuilder;
import com.squareup.picasso.Picasso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProdukOrder extends AppCompatActivity implements TransactionFinishedCallback {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_review);

        initMidtransSdk();
        init();
    }

    private void initMidtransSdk() {
        SdkUIFlowBuilder.init()
                .setContext(this)
                .setMerchantBaseUrl("https://bejostore.herokuapp.com/index.php/")
                .setClientKey("SB-Mid-client-U0nrK0Btc-4QvraO")
                .setTransactionFinishedCallback(this)
               .enableLog(true)
                .setColorTheme(new CustomColorTheme("#FFE51155", "#B61548", "#FFE51255"))
                .buildSDK();

    }



    @SuppressLint("SetTextI18n")
    private void init(){
        ((TextView) findViewById(R.id.text_amount)).setText("Rp"+getIntent().getIntExtra("qty", 0)*getIntent().getIntExtra("price",0));

        Picasso.with(this)
                .load(getIntent().getIntExtra("image",0))
                .resize(100,100)
                .into(((ImageView) findViewById(R.id.product_image)));

        ((TextView) findViewById(R.id.product_name)).setText(getIntent().getStringExtra("name"));
        ((TextView) findViewById(R.id.product_price_amount)).setText("Rp. "+getIntent().getIntExtra("price",0));
        ((TextView) findViewById(R.id.product_qty)).setText(getIntent().getStringExtra("qty"));



        findViewById(R.id.button_primary1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionButton();
            }
        });
    }
    private void actionButton(){
        MidtransSDK.getInstance().setTransactionRequest(Data.transactionRequest(
                "1",
                getIntent().getIntExtra("price",0),
                getIntent().getIntExtra("qty",0),
                getIntent().getStringExtra("name")
        ));
        MidtransSDK.getInstance().startPaymentUiFlow(this);

    }

    @Override
    public void onTransactionFinished(TransactionResult result){
        if(result.getResponse() != null) {
            switch (result.getStatus()) {
                case TransactionResult.STATUS_SUCCESS:
                    Toast.makeText(this, "Transaction Finished ID :" + result.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                    break;
                case TransactionResult.STATUS_PENDING:
                    Toast.makeText(this, "Transaction Pending ID :" + result.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                    break;
                case TransactionResult.STATUS_FAILED:
                    Toast.makeText(this, "Transaction Failed ID :" + result.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                    break;
            }

            result.getResponse().getValidationMessages();
        }else if(result.isTransactionCanceled()){
            Toast.makeText(this, "Transaction Canceled" , Toast.LENGTH_SHORT).show();

        }else{
            if(result.getStatus().equalsIgnoreCase(TransactionResult.STATUS_INVALID)){
                Toast.makeText(this, "Transaction Invalid" , Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Transaction Finished with failure" , Toast.LENGTH_SHORT).show();
            }
        }
    }
}
