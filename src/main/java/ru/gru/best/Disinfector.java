package ru.gru.best;

import ru.gru.best.annotation.InjectByType;
import ru.gru.best.impl.interfaces.Announcer;
import ru.gru.best.impl.interfaces.Policeman;

//@Deprecated
public class Disinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;


    @Deprecated
    public void start(Room room) {


        announcer.announce("Начинаем дезинфекцию, всем покинуть палубу !");
        policeman.makePeopleLeaveRoom();
        disinfect(room);
        announcer.announce("Прошла дезинфекция, все за работу, крысы трюмные !");
    }

    private void disinfect(Room room) {
        System.out.println("Идёт дезинфекция... Готово!");
    }
}
