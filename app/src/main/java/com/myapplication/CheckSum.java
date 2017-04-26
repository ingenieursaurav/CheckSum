package com.myapplication;

import android.util.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by saurav on 11/4/17.
 */

public class CheckSum {


    private static final String TAG = "checksum";

    public static Boolean validateTheCheckSum(String filePath, String md5Origin) {
        try {
            String md5Checksum = generateTheCheckSum(filePath);
            Log.d(TAG, "generatedchecksum: "+md5Checksum);
            Log.d(TAG, "origionalchecksum: "+md5Origin);
            if (md5Checksum.equals(md5Origin)) {
                Log.d(TAG, "validateCheckSum: "+md5Checksum);
                return true;
            } else {
                Log.d(TAG, "InvalidateCheckSum: "+md5Checksum);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String generateTheCheckSum(String path) {
        String checksum = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[8192];
            int numOfBytesRead;
            while ((numOfBytesRead = fis.read(buffer)) > 0) {
                md.update(buffer, 0, numOfBytesRead);
            }
            byte[] hash = md.digest();
            checksum = new BigInteger(1, hash).toString(16);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }

        return checksum;
    }
}
