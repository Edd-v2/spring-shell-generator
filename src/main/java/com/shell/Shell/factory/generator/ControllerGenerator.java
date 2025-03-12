package com.shell.Shell.factory.generator;

import com.shell.Shell.factory.AbstractComponentGenerator;
import com.shell.Shell.factory.types.ComponentType;
import com.shell.Shell.mustache.TemplateRenderer;

import java.util.Map;

public class ControllerGenerator extends AbstractComponentGenerator {


    @Override
    public String getFolderName() {
        return ComponentType.CONTROLLER.getValue().toLowerCase();
    }

    @Override
    public String getClassSuffix() {
        return ComponentType.CONTROLLER.getValue();
    }


    @Override
    public String generateContent(String packageName, String className) {
        return TemplateRenderer.render("controller.mustache", Map.of(
                "package", packageName,
                "className", className,
                "basePath", className.toLowerCase()
        ));
    }

}