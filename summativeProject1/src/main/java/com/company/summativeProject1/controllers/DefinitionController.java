package com.company.summativeProject1.controllers;

import com.company.summativeProject1.models.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class DefinitionController {

    private List<Definition> definitionList;
    private static int idNumber = 0;

    public DefinitionController() {

        Definition word1 = new Definition();
        word1.setId(idNumber++);
        word1.setWord("chair");
        word1.setDefinition("A separate seat for one person, typically with a back and four legs.");

        Definition word2 = new Definition();
        word2.setId(idNumber++);
        word2.setWord("cat");
        word2.setDefinition("A small domesticated carnivorous mammal with soft fur, a short snout, and retractable claws.");

        Definition word3 = new Definition();
        word3.setId(idNumber++);
        word3.setWord("book");
        word3.setDefinition("A written or printed work consisting of pages bound together.");

        Definition word4 = new Definition();
        word4.setId(idNumber++);
        word4.setWord("tree");
        word4.setDefinition("A tall, perennial woody plant with a single main trunk and many branches.");

        Definition word5 = new Definition();
        word5.setId(idNumber++);
        word5.setWord("ball");
        word5.setDefinition("A solid or hollow spherical or egg-shaped object that is kicked, thrown, or hit in a game.");

        Definition word6 = new Definition();
        word6.setId(idNumber++);
        word6.setWord("sun");
        word6.setDefinition("The star around which the earth orbits.");

        Definition word7 = new Definition();
        word7.setId(idNumber++);
        word7.setWord("rain");
        word7.setDefinition("The moisture condensed from the atmosphere that falls visibly in separate drops.");

        Definition word8 = new Definition();
        word8.setId(idNumber++);
        word8.setWord("moon");
        word8.setDefinition("The natural satellite of the earth, visible (chiefly at night) by reflected light from the sun.");

        Definition word9 = new Definition();
        word9.setId(idNumber++);
        word9.setWord("house");
        word9.setDefinition("A building for human habitation, especially one that is lived in by a family or small group of people.");

        Definition word10 = new Definition();
        word10.setId(idNumber++);
        word10.setWord("car");
        word10.setDefinition("A four-wheeled road vehicle that is powered by an engine and is able to carry a small number of people.");

        Definition word11 = new Definition();
        word11.setId(idNumber++);
        word11.setWord("lamp");
        word11.setDefinition("A small appliance that holds an electric bulb and produces light.");

        Definition word12 = new Definition();
        word12.setId(idNumber++);
        word12.setWord("bird");
        word12.setDefinition("A warm-blooded vertebrate with feathers, beak, and wings, typically able to fly.");

        Definition word13 = new Definition();
        word13.setId(idNumber++);
        word13.setWord("hat");
        word13.setDefinition("A covering for the head, often worn as a fashion accessory or for protection");

        Definition word14 = new Definition();
        word14.setId(idNumber++);
        word14.setWord("smile");
        word14.setDefinition("A facial expression indicating happiness, pleasure, or amusement.");

        Definition word15 = new Definition();
        word15.setId(idNumber++);
        word15.setWord("poem");
        word15.setDefinition("A piece of writing, often with words that rhyme and have a particular rhythm. ");

        definitionList = Arrays.asList(word1, word2, word3, word4, word5, word6, word7, word8, word9, word10, word11, word12, word13, word14, word15);
    }

    @RequestMapping(value="/definitionList", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Definition> ReturnDefinitionList(){
        return definitionList;
    }

    @RequestMapping(value="/randomWordDefinition", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition ReturnRandomWordDefintion(){
        Random random = new Random();
        int randomNumber = random.nextInt(15) + 1;

        for(Definition definition: definitionList) {
            if (randomNumber == definition.getId()) {
                return definition;
            }
        }
        return null;
    }
}
