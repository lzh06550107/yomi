package cn.liaozh.service_base.enums;

public enum ConfigKey {
    CHAT_MSG("CHAT_MSG", "消息");

    private final String key;
    private final String info;

    private ConfigKey(String key, String info) {
        this.key = key;
        this.info = info;
    }

    public String getKey() {
        return this.key;
    }

    public String getInfo() {
        return this.info;
    }
}
