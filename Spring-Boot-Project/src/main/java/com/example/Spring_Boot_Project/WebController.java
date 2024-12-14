package com.example.Spring_Boot_Project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class WebController {

    @RequestMapping("/items")
    public List<Items> retrieveAllItems(){
        return Arrays.asList(
                new Items(1,"Books","Arpita"),
                new Items(2,"Clothes","Arpita"),
                new Items(3,"Learning","Arpita"),
                new Items(4,"Learning1","Arpita"),
                new Items(5,"Learning2","Arpita"),
                new Items(6,"Learning3","Arpita"),
                new Items(88,"Learning3","Arpita")
        );
    }
}
