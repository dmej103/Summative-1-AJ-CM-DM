package com.company.summativeProject1.controller;

import com.company.summativeProject1.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class QuoteController {
    private List<Quote> quoteList;
    private int id = 1;
    public QuoteController(){
        Quote Steve = new Quote("Steve Jobs", "The most important thing is to enjoy your life",id++);
        Quote Oprah = new Quote("Oprah Winfrey", "In order to be truly happy, you must pursue your dreams and goals",id++);
        Quote Barack = new Quote("Barack Obama", "Don't let anyone tell you what you can't do. Follow your dreams and persist",id++);
        Quote Napoleon = new Quote("Napoleon Hill", "Life is what we make it and how we make it – whether we realize it or not",id++);
        Quote Lily = new Quote("Lily Tomlin", "The road to success is always under construction",id++);
        Quote Stan = new Quote("Stan Lee", "I'm not a self-made man. I've had a lot of help",id++);
        Quote Tony = new Quote("Tony Robbins", "You've got to be in it to win it",id++);
        Quote Zig = new Quote("Zig Ziglar", "People often say that motivation doesn't last. Well, neither does bathing. That's why we recommend it daily",id++);
        Quote Franklin = new Quote("Franklin D. Roosevelt", "The only limit to our realization of tomorrow will be our doubts of today",id++);
        Quote Albert = new Quote("Albert Einstein", "If you want to live a happy life, tie it to a goal, not to people or things",id++);
        quoteList = Arrays.asList(Steve,Oprah,Barack,Napoleon, Lily, Stan, Tony, Zig, Franklin, Albert);
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote returnRandomQuote(){
        int randomNum = quoteList.size();
        return quoteList.get((int)(Math.random()*randomNum));
    }

}
