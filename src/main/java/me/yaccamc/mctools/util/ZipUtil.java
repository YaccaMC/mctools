package me.yaccamc.mctools.util;

import me.yaccamc.mctools.api.Catcher;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ZipUtil {
    public static void unzip(ZipFile zip, String path, File output, Catcher catcher) {
        try {
            zip.extractFile(path, output.getAbsolutePath());
        } catch (ZipException e) {
            throw catcher.catches(e);
        }
    }

    public static void unzip(ZipFile zip, String path, File output, String name, Catcher catcher) {
        try {
            zip.extractFile(path, output.getAbsolutePath(), name);
        } catch (ZipException e) {
            throw catcher.catches(e);
        }
    }

    public static String readZipFileString(ZipFile zip, String path, Catcher catcher) {
        try {
            FileHeader fileHeader = zip.getFileHeader(path);

            if (fileHeader != null) {
                try (InputStream is = zip.getInputStream(fileHeader)) {
                    byte[] content = is.readAllBytes();
                    return new String(content, StandardCharsets.UTF_8);
                } catch (IOException e) {
                    throw catcher.catches(e);
                }
            } else {
                throw catcher.catches(new IOException(path + " is not found!!"));
            }
        } catch (ZipException e) {
            throw catcher.catches(e);
        }
    }
}
