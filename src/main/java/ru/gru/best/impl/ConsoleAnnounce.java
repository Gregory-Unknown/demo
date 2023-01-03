package ru.gru.best.impl;

import ru.gru.best.ObjectFactory;
import ru.gru.best.annotation.InjectByType;
import ru.gru.best.impl.interfaces.Announcer;
import ru.gru.best.impl.interfaces.Recomendator;

public class ConsoleAnnounce implements Announcer {

    @InjectByType
    private Recomendator recomendator;

    @Override
    public void announce(String message) {
        System.out.println(message);
        recomendator.recommend();
    }
}
