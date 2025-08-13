import me.yaccamc.mctools.util.ZipUtil;
import net.lingala.zip4j.ZipFile;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class UnpackTest {
    @Test
    public void test() {
        try(ZipFile zipFile = new ZipFile(new File("D:\\mctools\\src\\test\\resources\\server-v1.21.4.jar"))) {
            System.out.println(ZipUtil.readZipFileString(zipFile,
                    "META-INF/main-class",
                    RuntimeException::new
            ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
