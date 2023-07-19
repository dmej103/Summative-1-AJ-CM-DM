package com.company.summativeProject1.controllers;

import com.company.summativeProject1.models.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Magic8BallController {
    private List<String> answerList;
    private int idCounter = 1;

    public Magic8BallController() {
        answerList = new ArrayList<>();
        // List will contain all 20 possible Magic 8 Ball Answers from the original toy.
        answerList.add("It is certain.");
        answerList.add("It is decidedly so.");
        answerList.add("Yes definitely.");
        answerList.add("You may rely on it.");
        answerList.add("Without a doubt.");
        answerList.add("As I see it, yes.");
        answerList.add("Most likely.");
        answerList.add("Outlook good.");
        answerList.add("Yes.");
        answerList.add("Signs point to yes.");

        answerList.add("Reply hazy, try again.");
        answerList.add("Better not tell you now.");
        answerList.add("Cannot predict now.");
        answerList.add("Concentrate and ask again.");
        answerList.add("Ask again later.");

        answerList.add("My reply is no.");
        answerList.add("Outlook not so good.");
        answerList.add("Don't count on it.");
        answerList.add("My sources say no.");
        answerList.add("Very doubtful.");
    }

    // Http request method that should return a random Magic 8 Ball answer.
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer returnMagic8BallAnswer(@RequestBody Answer question) {
        int randomIndex = (int) (Math.random() * answerList.size());

        //Spring is doing Deserialization. Its mapping whatever is sent in to the object I declared on line 51.
        //It's associating the request body (input) with the answer object. Looks for a match with this new object.
        question.setAnswer(answerList.get(randomIndex));
        question.setId(idCounter++);

        return question;
    }
}
