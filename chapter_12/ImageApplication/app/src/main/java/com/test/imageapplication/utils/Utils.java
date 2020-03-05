package com.test.imageapplication.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.test.imageapplication.entity.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Utils {
    public static String INTENT_KEY = "product";

    public static List<Product> getList(Context context) {
        Gson gson = new GsonBuilder().create();
        List<Product> list = gson.fromJson(readAssetsTxt(context, "json"), new TypeToken<List<Product>>() {
        }.getType());
        return list;
    }

    public static String readAssetsTxt(Context context, String fileName) {
        try {
            //Return an AssetManager instance for your application's package
            InputStream is = context.getAssets().open(fileName + ".txt");
            int size = is.available();
            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            // Convert the buffer into a string.
            String text = new String(buffer, "utf-8");
            // Finally stick the string into the text view.
            return text;
        } catch (IOException e) {
            // Should never happen!
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        return "读取错误，请检查文件名";
    }

}
