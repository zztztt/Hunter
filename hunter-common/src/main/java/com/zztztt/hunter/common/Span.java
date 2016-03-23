package com.zztztt.hunter.common;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Span 一次调用的上下文
 */
public class Span {

    public enum Status {
        SUCCESS(0), EXCEPTION(1);

        Status(int i) {

        }
    }
    private final static String DEFAULT_NAME = "";

    private String name = DEFAULT_NAME;
    private final Endpoint endpoint = new Endpoint();
    private Long traceId;
    private String spanId;
    private AtomicInteger currentId = new AtomicInteger(0);
    private long start;
    private int duration;
    private Status status;
    private String type;
    private String size;
    private boolean clientSide = true;
    private List<Annotation> annotations;
    private int mask;

    public Span(String serviceName, String name) {
        this.endpoint.setServiceName(serviceName);
        this.name = name;
        this.traceId = Gen.traceId();
        this.spanId = Gen.INIT_SPAN_ID;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Endpoint getEndpoint() {
        return endpoint;
    }

    public void setServiceName(String name) {
        this.endpoint.setServiceName(name);
    }

    public void setIp(int ip) {
        this.endpoint.setIp(ip);
    }
    public void setPort(short port) {
        this.endpoint.setPort(port);
    }

    public Long getTraceId() {
        return traceId;
    }

    public void setTraceId(Long traceId) {
        this.traceId = traceId;
    }

    public String getSpanId() {
        return spanId;
    }

    public void setSpanId(String spanId) {
        this.spanId = spanId;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isClientSide() {
        return clientSide;
    }

    public void setClientSide(boolean clientSide) {
        this.clientSide = clientSide;
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void addAnnotation(Annotation annotation) {
        if (Utils.isNull(annotations)) {
            this.annotations = new LinkedList<Annotation>();
        }
        this.annotations.add(annotation);
    }

    public int getMask() {
        return mask;
    }

    public void setMask(int mask) {
        this.mask = mask;
    }

    public Span genNext(Span span) {
        if (!Utils.isNull(span)) {
            this.setTraceId(span.getTraceId());
            this.setSpanId(span.nextSpanId());
        }
        return this;
    }

    private String nextSpanId() {
        return spanId + "." + currentId.incrementAndGet();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Span(");
        sb.append("traceId:");
        sb.append(traceId);
        sb.append(",spanId:");
        sb.append(spanId);
        sb.append(",name:");
        sb.append(name);
        sb.append(",endpoint:");
        sb.append(endpoint);
        sb.append(",start:");
        sb.append(start);
        sb.append(",duration:");
        sb.append(duration);
        sb.append(",status:");
        sb.append(status);
        sb.append(",type:");
        sb.append(type);
        sb.append(",size:");
        sb.append(size);
        if (!Utils.isNull(this.annotations)) {
            sb.append(",annotations:");
            sb.append(annotations);
        }
        sb.append(",isClientSide:");
        sb.append(clientSide);
        sb.append(",mask:");
        sb.append(mask);
        sb.append(")");

        return sb.toString();
    }
}
