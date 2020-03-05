package com.google.instrumenttest;

import android.os.RecoverySystem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecoverySystem.verifyPackage();
        RecoverySystem.installPackage();
    }

    /**
     * @param packageFile        待验证的升级包
     * @param listener           升级进度监听器，验证的进度
     * @param deviceCertsZipFile 验证证书文件，如果为null, 系统默认的是 "/system/etc/security/otacerts.zip"
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public static void verifyPackage(File packageFile, RecoverySystem.ProgressListener listener, File deviceCertsZipFile) throws GeneralSecurityException, IOException {
        throw new RuntimeException("Stub!");
    }
}
