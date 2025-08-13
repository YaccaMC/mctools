package me.yaccamc.mctools.util;

import me.yaccamc.mctools.api.Catcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class DownloadUtil {
    public static void download(String url, File output, Catcher catcher) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute();InputStream is = response.body().byteStream();
             FileOutputStream fos = new FileOutputStream(output);
             FileChannel channel = fos.getChannel()) {

            byte[] buffer = new byte[8192];
            int len;
            while ((len = is.read(buffer)) != -1) {
                channel.write(ByteBuffer.wrap(buffer, 0, len));
            }
        } catch (IOException e) {
            throw catcher.catches(e);
        }
    }
}
