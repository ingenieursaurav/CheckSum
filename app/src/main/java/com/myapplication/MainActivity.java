package com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends Activity {

    String filePath="/mnt/usb_storage/USB_DISK0/OD-PM-32-1/Wildlife.wmv";
    String md5Origin="d8c2eafd90c266e19ab9dcacc479f8af";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (CheckSum.validateTheCheckSum(filePath, md5Origin)) {
            Toast.makeText(this, "Checksum validated..Please play the movie", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Checksum Invalid", Toast.LENGTH_LONG).show();
        }

    }
}
