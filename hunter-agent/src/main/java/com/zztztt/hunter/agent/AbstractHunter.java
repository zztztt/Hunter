package com.zztztt.hunter.agent;

import com.zztztt.hunter.common.Annotation;
import com.zztztt.hunter.common.Span;
import com.zztztt.hunter.common.Utils;

public abstract class AbstractHunter implements IHunter {

    protected final static HunterContext context = new HunterContext();

    /**
     * start record hunter trace
     *
     * @param span make sure not null
     */
    public Span start(Span span) {
        span.setStart(System.currentTimeMillis());
        context.setServerSpan(span);
        return span;
    }

    public void addAnnotation(String key, String value) {
        Span span = getSpan();
        if (!Utils.isNull(span)) {
            span.addAnnotation(new Annotation(key, value));
        }
    }


    public Span complete() {
        Span span = getSpan();
        if (!Utils.isNull(span)) {
            int duration = (int) (System.currentTimeMillis() - span.getStart());
            span.setDuration(duration);
            doCollect(span);
            clearSpan();
        }
        return span;
    }

    public Span getSpan() {
        return context.getServerSpan();
    }

    protected void clearSpan() {
        context.setServerSpan(null);
    }

    protected void doCollect(Span span) {}

}
