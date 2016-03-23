package com.zztztt.hunter;

import com.zztztt.hunter.agent.ClientHunter;
import com.zztztt.hunter.agent.Hunter;
import com.zztztt.hunter.common.Span;
import org.junit.Test;

public class ClientHunterTest {
    @Test
    public void test1() throws InterruptedException {
        Span span = new Span("service", "method");
        ClientHunter hunter = ClientHunter.getInstance();
        hunter.start(span);
        hunter.addAnnotation("testKey", "testValue");
        Thread.sleep(1000);
        System.out.println(hunter.complete());
    }

}
