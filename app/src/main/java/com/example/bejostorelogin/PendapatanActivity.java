package com.example.bejostorelogin;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PendapatanActivity extends AppCompatActivity {
    Workbook workbook;
    AsyncHttpClient asyncHttpClient;
    List<String> tanggal, linkaja, ovo, total;
    RecyclerView recyclerView;
    PendapatanAdapter adapter;
    ProgressBar progressBar;
    TextView wait;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendapatan);
        recyclerView = findViewById(R.id.recyclerViewDeliveryProductList);
        progressBar = findViewById(R.id.progressBar);
        wait = findViewById(R.id.wait);

        String URL = "https://drive.google.com/uc?export=download&id=1j8zSDnpoAWj1BPHfiZpWalXHZnPOnqwl";
        tanggal = new ArrayList<>();
        linkaja = new ArrayList<>();
        ovo = new ArrayList<>();
        total = new ArrayList<>();

        asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(URL, new FileAsyncHttpResponseHandler(this) {
            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, Throwable throwable, File file) {
                Toast.makeText(PendapatanActivity.this, "Error in Downloading Excel File", Toast.LENGTH_SHORT).show();
                wait.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, File file) {
                WorkbookSettings ws = new WorkbookSettings();
                ws.setGCDisabled(true);
                if (file != null) {
                    wait.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);

                    try {
                        workbook = Workbook.getWorkbook(file);
                        Sheet sheet = workbook.getSheet(0);
                        for (int i = 0; i < sheet.getRows(); i++) {
                            Cell[] row = sheet.getRow(i);
                            tanggal.add(row[0].getContents());
                            linkaja.add(row[1].getContents());
                            ovo.add(row[2].getContents());
                            total.add(row[3].getContents());
                        }

                        showData();


                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (BiffException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
    private void showData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PendapatanAdapter(tanggal, linkaja, ovo, total,this);
        recyclerView.setAdapter(adapter);
    }

}
