package me.yaccamc.mctools;

import me.yaccamc.mctools.adapter.Adapter;
import me.yaccamc.mctools.api.Catcher;
import me.yaccamc.mctools.util.DownloadUtil;
import me.yaccamc.mctools.util.LambdaUtil;

import java.io.File;

public class MCDownloader {
    private final String version;
    private File output = null;
    private Adapter adapter = null;
    private Catcher catcher = LambdaUtil.DEFAULT_CATCHER;

    public MCDownloader(String version) {
        this.version = version;
    }

    public MCDownloader setOutput(File output) {
        this.output = output;
        return this;
    }

    public MCDownloader setCatcher(Catcher catcher) {
        this.catcher = catcher;
        return this;
    }

    public MCDownloader setAdapter(Adapter adapter) {
        this.adapter = adapter;
        return this;
    }

    public void download() {
        if (adapter == null) {
            throw catcher.catches(new RuntimeException("Missing Adapter."));
        }

        if (output == null) {
            throw catcher.catches(new RuntimeException("Missing Output."));
        }

        DownloadUtil.download(adapter.adapter(version), output, catcher);
    }
}
