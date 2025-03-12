package com.shell.Shell.factory;

import com.shell.Shell.factory.generator.ControllerGenerator;
import com.shell.Shell.factory.generator.RepositoryGenerator;
import com.shell.Shell.factory.generator.ServiceGenerator;
import com.shell.Shell.factory.interfaces.ComponentGenerator;
import com.shell.Shell.factory.types.ComponentType;

public class ComponentGeneratorFactory {
    public static ComponentGenerator getGenerator(ComponentType type) {
        return switch (type) {
            case CONTROLLER -> new ControllerGenerator();
            case SERVICE -> new ServiceGenerator();
            case REPOSITORY -> new RepositoryGenerator();
        };
    }
}
