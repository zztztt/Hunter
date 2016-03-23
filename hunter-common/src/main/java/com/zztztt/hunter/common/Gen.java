package com.zztztt.hunter.common;

import java.util.UUID;

public class Gen {

    public final static String INIT_SPAN_ID = "0";
    public static long traceId() {
        UUID uuid = UUID.randomUUID();
        return uuid.getMostSignificantBits() ^ uuid.getLeastSignificantBits();
    }
}
