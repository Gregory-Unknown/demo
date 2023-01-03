package ru.gru.best.impl;

import ru.gru.best.impl.interfaces.Policeman;

public class AngryPoliceman implements Policeman {
    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Пошли все вон, а то хребет перемолю !");
    }
}
