import me.yaccamc.mctools.adapter.Adapter;
import me.yaccamc.mctools.adapter.MojangAdapter;
import org.junit.jupiter.api.Test;

public class AdapterTest {
    @Test
    public void test() {
        Adapter test = new MojangAdapter(
                "https://launchermeta.mojang.com/mc/game/version_manifest.json",
                RuntimeException::new
        );
        System.out.println(test.adapter("1.20.4"));
    }
}
