package ru.gru.best.impl;

import ru.gru.best.annotation.InjectByType;
import ru.gru.best.impl.interfaces.Policeman;
import ru.gru.best.impl.interfaces.Recomendator;

import javax.annotation.PostConstruct;


public class PolicemanImpl implements Policeman {
    @InjectByType
    private Recomendator recomendator;

    @PostConstruct
    public void init() {
        System.out.println(recomendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println(recomendator.getClass().getName());
        System.out.println("Прочь с корабля, собаки капиталлистические !");
    }
}
