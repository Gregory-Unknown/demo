package ru.gru.best.configuration.interfaces;

import ru.gru.best.ApplicationContext;

public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);
}
