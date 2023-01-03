package ru.gru.best.configuration;

import lombok.Getter;
import org.reflections.Reflections;
import ru.gru.best.impl.interfaces.Config;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {

    @Getter
    private Reflections scanner;
    private Map<Class, Class> ifc2ImpClass;

    public JavaConfig(String packageToScan, Map<Class, Class> ifc2ImpClass) {
        this.ifc2ImpClass = ifc2ImpClass;
        this.scanner = new Reflections(packageToScan);
    }
    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        return ifc2ImpClass.computeIfAbsent(ifc, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if(classes.size() != 1) {
                throw new RuntimeException(ifc + " has 0 or more than one impl, please update your config");
            }
            return classes.iterator().next();
        });
    }
}
