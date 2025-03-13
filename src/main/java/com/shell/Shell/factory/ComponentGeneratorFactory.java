package com.shell.Shell.factory;

import com.shell.Shell.factory.annotations.ComponentInfo;
import com.shell.Shell.factory.interfaces.ComponentGenerator;
import com.shell.Shell.factory.types.ComponentType;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ComponentGeneratorFactory {

    private final Map<ComponentType, ComponentGenerator> generators = new HashMap<>();

    public ComponentGeneratorFactory(ApplicationContext context) {
        Map<String, ComponentGenerator> beans = context.getBeansOfType(ComponentGenerator.class);

        for (ComponentGenerator generator : beans.values()) {
            ComponentInfo annotation = generator.getClass().getAnnotation(ComponentInfo.class);
            if (annotation != null) {
                generators.put(annotation.type(), generator);
            }
        }
    }


    public ComponentGenerator getGenerator(ComponentType type) {
        return generators.get(type);
    }
}
