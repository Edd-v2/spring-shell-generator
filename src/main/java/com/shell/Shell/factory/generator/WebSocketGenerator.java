package com.shell.Shell.factory.generator;

import com.shell.Shell.factory.AbstractComponentGenerator;
import com.shell.Shell.factory.annotations.ComponentInfo;
import com.shell.Shell.factory.types.ComponentType;
import com.shell.Shell.mustache.TemplateRenderer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ComponentInfo(type = ComponentType.WEBSOCKET)
public class WebSocketGenerator extends AbstractComponentGenerator {

    @Override
    public String generateContent(String packageName, String className) {
        return TemplateRenderer.render("websocket-config.mustache", Map.of(
                "package", packageName,
                "className", className,
                "basePath", className.toLowerCase()
        ));
    }

}