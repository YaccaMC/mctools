package me.yaccamc.mctools.adapter;

public class BmclAdapter implements Adapter {
    @Override
    public String adapter(String version) {
        return String.format("https://bmclapi2.bangbang93.com/version/%s/server", version);
    }
}
