package com.gavrilol.tutorials.quickfix.server.beans;

import quickfix.Session;
import quickfix.field.OfferPx;
import quickfix.field.OfferSize;
import quickfix.field.QuoteID;
import quickfix.field.Symbol;
import quickfix.fix44.Quote;
import quickfix.fix44.component.Instrument;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class FixMessageGenerator {
    private Session session;

    public void generateAndSend() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(getJob());
    }

    public FixMessageGenerator(Session session) {
        this.session = session;
    }

    private Runnable getJob() {
        return () -> {
            Random random = new Random(100);
            random.nextInt();
            while (true) {
                if (session.isLoggedOn()) {
                    Quote quote = new Quote(new QuoteID("" + System.currentTimeMillis()));
                    quote.set(new Instrument(new Symbol("" + random.nextInt(100))));
                    quote.set(new OfferPx(101));
                    quote.set(new OfferSize(10000));
                    session.send(quote);
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

    }
}
