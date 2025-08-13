package me.yaccamc.mctools.util;

import me.yaccamc.mctools.api.Catcher;

public class LambdaUtil {
    public static final Catcher DEFAULT_CATCHER = new DefaultCatcher();

    private static final class DefaultCatcher implements Catcher {
        @Override
        public RuntimeException catches(Exception e) {
            return new RuntimeException(e);
        }
    }
}
