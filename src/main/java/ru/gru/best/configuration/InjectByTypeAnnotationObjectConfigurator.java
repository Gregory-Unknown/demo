package ru.gru.best.configuration;

import lombok.SneakyThrows;
import ru.gru.best.ApplicationContext;
import ru.gru.best.ObjectFactory;
import ru.gru.best.annotation.InjectByType;
import ru.gru.best.configuration.interfaces.ObjectConfigurator;

import java.lang.reflect.Field;

public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {

    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                Object object = context.getObject(field.getType());
                field.set(t, object);
            }
        }
    }
}
