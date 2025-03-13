package com.shell.Shell.factory.generator;

import com.shell.Shell.factory.AbstractComponentGenerator;
import com.shell.Shell.factory.annotations.ComponentInfo;
import com.shell.Shell.factory.types.ComponentType;
import com.shell.Shell.mustache.TemplateRenderer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ComponentInfo(type = ComponentType.CONTROLLER)
public class ControllerGenerator extends AbstractComponentGenerator {

    @Override
    public String generateContent(String packageName, String className) {
        return TemplateRenderer.render("controller.mustache", Map.of(
                "package", packageName,
                "className", className,
                "basePath", className.toLowerCase()
        ));
    }

}