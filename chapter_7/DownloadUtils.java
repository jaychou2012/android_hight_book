package com.td.assist.utils;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;

public class DownloadUtils {
    private Context context;
    private String url;
    private DownloadManager downloadManager;
    private long downloadId;
    private String savaPath = Environment.getExternalStorageDirectory() + "/app/download.apk";

    public DownloadUtils(Context context, String url) {
        this.context = context;
        this.url = url;
        File fileDir = new File(Environment.getExternalStorageDirectory() + "/app/");
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        File file = new File(savaPath);
        if (file.exists()) {
            file.delete();
        }
        showToast("开始下载...");
    }

    public void download() {
        //创建下载任务
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        //移动网络情况下是否允许漫游
        request.setAllowedOverRoaming(true);
        //在通知栏中显示，默认就是显示的
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
//        request.setTitle("标题");
//        request.setDescription("描述");
        request.setVisibleInDownloadsUi(true);
        //设置下载的路径
        File file = new File(savaPath);
        request.setDestinationUri(Uri.fromFile(file));
        //获取DownloadManager
        if (downloadManager == null) {
            downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        }
        if (downloadManager != null) {
            downloadId = downloadManager.enqueue(request);
        }
        Utils.putDownloadId(context, downloadId);
    }

    public void showToast(String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

}
