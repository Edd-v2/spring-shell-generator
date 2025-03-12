package com.shell.Shell.factory.generator;

import com.shell.Shell.factory.AbstractComponentGenerator;
import com.shell.Shell.factory.types.ComponentType;
import com.shell.Shell.mustache.TemplateRenderer;

import java.util.Map;

public class RepositoryGenerator extends AbstractComponentGenerator {


    @Override
    public String getFolderName() {
        return ComponentType.REPOSITORY.getValue().toLowerCase();
    }

    @Override
    public String getClassSuffix() {
        return ComponentType.REPOSITORY.getValue();
    }

    @Override
    public String generateContent(String packageName, String className) {
        return TemplateRenderer.render("repository.mustache", Map.of(
                "package", packageName,
                "className", className,
                "basePath", className.toLowerCase()
        ));
    }

}
