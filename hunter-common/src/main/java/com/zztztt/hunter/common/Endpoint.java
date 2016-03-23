package com.zztztt.hunter.common;

public class Endpoint {
    private final static String DEFAULT_SERVICE_NAME = "";
    private String serviceName = DEFAULT_SERVICE_NAME;
    private int ip;
    private short port;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

    public short getPort() {
        return port;
    }

    public void setPort(short port) {
        this.port = port;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Endpoint(");
        sb.append("serviceName:");
        sb.append(serviceName);
        sb.append(",ip:");
        sb.append(ip);
        sb.append(",port:");
        sb.append(port);
        sb.append(")");
        return sb.toString();
    }

}
