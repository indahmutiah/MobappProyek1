package com.example.bejostorelogin;

import com.midtrans.sdk.corekit.core.MidtransSDK;
import com.midtrans.sdk.corekit.core.TransactionRequest;
import com.midtrans.sdk.corekit.core.UIKitCustomSetting;
import com.midtrans.sdk.corekit.models.BankType;
import com.midtrans.sdk.corekit.models.ItemDetails;
import com.midtrans.sdk.corekit.models.snap.Authentication;
import com.midtrans.sdk.corekit.models.snap.CreditCard;

import java.util.ArrayList;
import java.util.List;

public class Data {



    public static List<produk> getListProduct(){
        List<produk> list = new ArrayList<>();
        list.add(new produk(
                R.drawable.gery,
                "Gery Sereal",
                1,
                4000
        ));
        list.add(new produk(
                R.drawable.good_day,
                "Good Day",
                1,
                4000
        ));
        list.add(new produk(
                R.drawable.yakult,
                "Yakult",
                1,
                4000
        ));
        list.add(new produk(
                R.drawable.scarlett,
                "Scarlatt Lotion",
                1,
                4000
        ));
        list.add(new produk(
                R.drawable.cheetos,
                "Cheetos Stick",
                1,
                4000
        ));
        list.add(new produk(
                R.drawable.beng_beng,
                "Beng-Beng",
                1,
                4000
        ));
        list.add(new produk(
                R.drawable.marimas,
                "Marimas Jeruk",
                1,
                4000
        ));
        list.add(new produk(
                R.drawable.kecap_bango,
                "Kecap Bango",
                1,
                4000
        ));
        return list;
    }


    public static TransactionRequest transactionRequest(String id, int price, int qty, String name){
        TransactionRequest request = new TransactionRequest(System.currentTimeMillis()+" ",4000);

        ItemDetails details = new ItemDetails(id, price, qty, name);
        ArrayList<ItemDetails> itemDetails = new ArrayList<>();
        itemDetails.add(details);
        request.setItemDetails(itemDetails);

        CreditCard creditCard = new CreditCard();
        creditCard.setSaveCard(false);
        creditCard.setAuthentication(Authentication.AUTH_RBA);
        creditCard.setBank(BankType.BNI);
        request.setCreditCard(creditCard);

        UIKitCustomSetting setting = MidtransSDK.getInstance().getUIKitCustomSetting();
        setting.setSkipCustomerDetailsPages(true);
        MidtransSDK.getInstance().setUIKitCustomSetting(setting);


        return request;
    }
}
