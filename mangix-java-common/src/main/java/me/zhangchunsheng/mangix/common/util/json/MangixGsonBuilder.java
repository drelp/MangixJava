package me.zhangchunsheng.mangix.common.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MangixGsonBuilder {
    private static final GsonBuilder INSTANCE = new GsonBuilder();

    static {
        INSTANCE.disableHtmlEscaping();
    }

    public static Gson create() {
        return INSTANCE.create();
    }
}
