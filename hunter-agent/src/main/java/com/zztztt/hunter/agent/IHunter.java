package com.zztztt.hunter.agent;

import com.zztztt.hunter.common.Span;

public interface IHunter {

    public Span start(Span span);
    public Span complete();
    public Span getSpan();
}
