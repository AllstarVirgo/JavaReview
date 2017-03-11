package com.potato.test;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDownloader {

    private static final String REMOTE_FILE_URL = "http://www.cninfo.com.cn/cninfo-new/disclosure/szse/download/1202226085";
    private static final String LOCAL_FILE_PATH = "test.pdf"; // 改成你保存 文件的路径

    public static void main(String[] args) {
        new HttpDownloader(REMOTE_FILE_URL, LOCAL_FILE_PATH).download();
    }

    private String remoteFileUrl;
    private String localFilePath;

    public HttpDownloader(String remoteFileUrl, String localFilePath) {
        this.remoteFileUrl = remoteFileUrl;
        this.localFilePath = localFilePath;
    }

    public void download() {
        try {
            URL url = new URL(remoteFileUrl);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5 * 1000); // 5000 毫秒内没有连接上 则放弃连接
            httpURLConnection.connect(); // 连接
            System.out.println("连接 URL 成功~");

            int fileLenght = httpURLConnection.getContentLength();
            System.out.println("文件大小：" + (fileLenght / 1024.0) + " KB");

            System.out.println("开始下载...");
            try (DataInputStream dis = new DataInputStream(httpURLConnection.getInputStream());
                 FileOutputStream fos = new FileOutputStream(localFilePath)) {
                byte[] buf = new byte[10240]; // 根据实际情况可以 增大 buf 大小
                for (int readSize; (readSize = dis.read(buf)) > 0;) {
                    fos.write(buf, 0, readSize);
                }
                System.out.println("下载完毕~");
            } catch (IOException ex) {
                System.out.println("下载时出错");
            }

            httpURLConnection.disconnect();
        } catch (IOException ex) {
            System.out.println("URL 不存在或者连接超时");
        }
    }
}
