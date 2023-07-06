package com.company.summativeProject1.controllers;

import com.company.summativeProject1.models.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.lang.Math;

@RestController
public class Magic8BallController {
    private List<Answer> answerList;

    private int idCounter = 1;

    public Magic8BallController(){
        answerList = new ArrayList<>();

        // List will contain all 20 possible Magic 8 Ball Answers from the original toy.
        answerList.add(new Answer("", "It is certain.", idCounter++));
        answerList.add(new Answer("", "It is decidedly so.", idCounter++));
        answerList.add(new Answer("", "Yes definitely.", idCounter++));
        answerList.add(new Answer("", "You may rely on it.", idCounter++));
        answerList.add(new Answer("", "Without a doubt.", idCounter++));
        answerList.add(new Answer("", "As I see it, yes.", idCounter++));
        answerList.add(new Answer("", "Most likely.", idCounter++));
        answerList.add(new Answer("", "Outlook good.", idCounter++));
        answerList.add(new Answer("", "Yes.", idCounter++));
        answerList.add(new Answer("", "Signs point to yes.", idCounter++));

        answerList.add(new Answer("", "Reply hazy, try again.", idCounter++));
        answerList.add(new Answer("", "Better not tell you now.", idCounter++));
        answerList.add(new Answer("", "Cannot predict now.", idCounter++));
        answerList.add(new Answer("", "Concentrate and ask again.", idCounter++));
        answerList.add(new Answer("", "Ask again later.", idCounter++));

        answerList.add(new Answer("", "My reply is no.", idCounter++));
        answerList.add(new Answer("", "Outlook not so good.", idCounter++));
        answerList.add(new Answer("", "Don't count on it.", idCounter++));
        answerList.add(new Answer("", "My sources say no.", idCounter++));
        answerList.add(new Answer("", "Very doubtful.", idCounter++));
    }

    // Http request method that should return a random Magic 8 Ball answer.
    // answerList should not be increased when questions are posted.
    @RequestMapping(value = "/magic8ball/answers", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer returnMagic8BallAnswer(@RequestBody Answer question){
        int index = (int)(Math.random()*answerList.size());

        Answer reply = new Answer(question.getQuestion(), answerList.get(index).getAnswer(), idCounter++);

        return reply;
    }

    // Http request method to see if the answer list is being increased when questions are posted.
    @RequestMapping(value = "/magic8ball", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Answer> returnAnswerList(){
        return answerList;
    }

}
