package ru.gru.best;

import ru.gru.best.impl.AngryPoliceman;
import ru.gru.best.impl.PolicemanImpl;
import ru.gru.best.impl.interfaces.Policeman;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = Application.run("ru.gru.best", new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
        Disinfector disinfector = context.getObject(Disinfector.class);
        disinfector.start(new Room());

    }
}
