package me.yaccamc.mctools.adapter;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import me.yaccamc.mctools.api.Catcher;
import me.yaccamc.mctools.util.NetworkUtil;

public class MojangAdapter implements Adapter {
    private final String meta;
    private final Catcher catcher;

    public MojangAdapter(String meta, Catcher catcher) {
        this.meta = meta;
        this.catcher = catcher;
    }

    @Override
    public String adapter(String version) {
        String s = NetworkUtil.requestFile(meta, catcher);
        Gson gson = new Gson();
        JsonObject object = gson.fromJson(s, JsonObject.class);

        String url = "";
        for (JsonElement element : object.get("versions").getAsJsonArray()) {
            JsonObject versions = element.getAsJsonObject();
            if (versions.get("id").getAsString().equals(version)) {
                url = versions.get("url").getAsString();
            }
        }

        String s1 = NetworkUtil.requestFile(url, catcher);
        JsonObject object1 = gson.fromJson(s1, JsonObject.class);


        return object1.get("downloads").getAsJsonObject().get("server").getAsJsonObject().get("url").getAsString();
    }
}
