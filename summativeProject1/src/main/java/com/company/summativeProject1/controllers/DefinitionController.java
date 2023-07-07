package com.company.summativeProject1.controllers;

import com.company.summativeProject1.models.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DefinitionController {

    private List<Definition> definitionList;
    private static int idCounter = 1;

    public DefinitionController() {

        definitionList = new ArrayList<>();
        definitionList.add(new Definition(idCounter++, "chair","A separate seat for one person, typically with a back and four legs."));
        definitionList.add(new Definition(idCounter++, "cat", "A small domesticated carnivorous mammal with soft fur, a short snout, and retractable claws."));
        definitionList.add(new Definition(idCounter++, "book","A written or printed work consisting of pages bound together."));
        definitionList.add(new Definition(idCounter++, "tree", "A tall, perennial woody plant with a single main trunk and many branches."));
        definitionList.add(new Definition(idCounter++,"ball", "A solid or hollow spherical or egg-shaped object that is kicked, thrown, or hit in a game."));
        definitionList.add(new Definition(idCounter++,"sun", "The star around which the earth orbits."));
        definitionList.add(new Definition(idCounter++, "rain", "The moisture condensed from the atmosphere that falls visibly in separate drops."));
        definitionList.add(new Definition(idCounter++,"moon", "The natural satellite of the earth, visible (chiefly at night) by reflected light from the sun."));
        definitionList.add(new Definition(idCounter++, "house", "A building for human habitation, especially one that is lived in by a family or small group of people."));
        definitionList.add(new Definition(idCounter++, "car", "A four-wheeled road vehicle that is powered by an engine and is able to carry a small number of people."));
        definitionList.add(new Definition(idCounter++, "lamp", "A small appliance that holds an electric bulb and produces light."));
        definitionList.add(new Definition(idCounter++, "bird", "A warm-blooded vertebrate with feathers, beak, and wings, typically able to fly."));
        definitionList.add(new Definition(idCounter++, "hat", "A covering for the head, often worn as a fashion accessory or for protection"));
        definitionList.add(new Definition(idCounter++, "smile", "A facial expression indicating happiness, pleasure, or amusement."));
        definitionList.add(new Definition(idCounter++, "poem", "A piece of writing, often with words that rhyme and have a particular rhythm."));
    }

    @RequestMapping(value="/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition returnRandomWordDefinition() {
        int randomNum = definitionList.size();
        return definitionList.get((int)(Math.random()*randomNum));
    }
}
