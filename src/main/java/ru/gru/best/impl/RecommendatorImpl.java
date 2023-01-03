package ru.gru.best.impl;

import ru.gru.best.annotation.InjectProperty;
import ru.gru.best.annotation.Singleton;
import ru.gru.best.impl.interfaces.Recomendator;

@Singleton
//@Deprecated
public class RecommendatorImpl implements Recomendator {
    @InjectProperty("tequila")
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("recommendator was created !");
    }

    @Override
    public void recommend() {
        System.out.println("to protect from sadness and illness drink " + alcohol + " !");
    }
}
