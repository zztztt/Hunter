package com.zztztt.hunter;

import com.zztztt.hunter.agent.ClientHunter;
import com.zztztt.hunter.agent.Hunter;
import com.zztztt.hunter.common.Span;
import org.junit.Test;

public class HunterTest {
    @Test
    public void test1() {
        Hunter hunter = Hunter.getInstance();
        hunter.start(new Span("server", "method"));
        ClientHunter clientHunter1 = ClientHunter.getInstance();
        clientHunter1.start(new Span("client1", "clientMethod1"));
        System.out.println(clientHunter1.complete());
        ClientHunter clientHunter2 = ClientHunter.getInstance();
        clientHunter2.start(new Span("client2", "clientMethod2"));
        System.out.println(clientHunter2.complete());
        System.out.println(hunter.complete());
    }
}
