package com.zztztt.hunter.agent;

/**
 * Hunter is the server hunter
 */
public final class Hunter extends AbstractHunter {
    private static Hunter instance = new Hunter();
    public static Hunter getInstance() {
        return instance;
    }
}
