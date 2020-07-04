package com.gavrilol.tutorials.store.controller;

import com.gavrilol.tutorials.store.beans.FixModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

@RestController
public class MessageStoreRestController {

    @Autowired
    private ConcurrentMap<String, FixModel> quotes;

    @GetMapping("/store")
    public List<FixModel> filterStore(@RequestParam Map<String, Object> params) {
//        FixModel fixModel = new FixModel("id", 101, 1000, "symbol");
        return new ArrayList<>(quotes.values());
    }

    @GetMapping("/get/{id}")
    public FixModel getQuote(@PathVariable String id) {
        return quotes.get(id);
    }


    public void setQuotes(ConcurrentMap<String, FixModel> quotes) {
        this.quotes = quotes;
    }
}
