import me.yaccamc.mctools.MCDownloader;
import me.yaccamc.mctools.adapter.BmclAdapter;
import org.junit.jupiter.api.Test;

import java.io.File;

public class DownloaderTest {
    @Test
    public void test() {
        new MCDownloader("1.21.8")
                .setAdapter(new BmclAdapter())
                .setOutput(new File("D:\\mctools\\src\\test\\resources\\server-v1.21.8.jar"))
                .download();
    }
}
