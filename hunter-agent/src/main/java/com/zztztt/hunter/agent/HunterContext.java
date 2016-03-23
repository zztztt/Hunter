package com.zztztt.hunter.agent;

import com.zztztt.hunter.common.Span;

public class HunterContext {
    private final ThreadLocal<Span> clientContexts = new ThreadLocal<Span>();
    private final ThreadLocal<Span> serverContexts = new ThreadLocal<Span>();

    public Span getClientSpan() {
        return clientContexts.get();
    }

    public Span getServerSpan() {
        return serverContexts.get();
    }

    public void setClientSpan(Span span) {
        clientContexts.set(span);
    }

    public void setServerSpan(Span span) {
        serverContexts.set(span);
    }
}
