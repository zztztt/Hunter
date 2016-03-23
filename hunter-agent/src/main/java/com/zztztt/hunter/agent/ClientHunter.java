package com.zztztt.hunter.agent;

import com.zztztt.hunter.common.Span;
import com.zztztt.hunter.common.Utils;

public final class ClientHunter extends AbstractHunter {

    private static ClientHunter instance = new ClientHunter();
    public static ClientHunter getInstance() {
        return instance;
    }

    public Span start(Span span) {
        Span serverSpan = context.getServerSpan();
        if (!Utils.isNull(serverSpan)) {
            span.genNext(serverSpan);
        }
        span.setStart(System.currentTimeMillis());
        context.setClientSpan(span);
        return span;
    }

    public Span getSpan() {
        return context.getClientSpan();
    }

    protected void clearSpan() {
        context.setClientSpan(null);
    }

    protected void doCollect(Span span) {

    }
}
