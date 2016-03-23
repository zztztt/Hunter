package com.zztztt.hunter.common;

public class Annotation {

    private String key;
    private String value;

    public Annotation(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Annotataion(");
        sb.append("key:");
        sb.append(key);
        sb.append(",value:");
        sb.append(value);
        sb.append(")");
        return sb.toString();
    }
}
