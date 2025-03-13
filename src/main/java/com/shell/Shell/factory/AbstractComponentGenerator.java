package com.shell.Shell.factory;

import com.shell.Shell.factory.annotations.ComponentInfo;
import com.shell.Shell.factory.interfaces.ComponentGenerator;
import com.shell.Shell.factory.types.ComponentType;

import java.nio.file.Files;
import java.nio.file.Path;

public abstract class AbstractComponentGenerator implements ComponentGenerator {

    /**
     * Genera il file per qualsiasi tipo di componente.
     */
    public void generateFile(String basePackagePath, String basePackage, String className, StringBuilder result) {
        try {
            Path dir = Path.of("src/main/java", basePackagePath, getFolderName());
            Files.createDirectories(dir);

            String fileName = className + getClassSuffix() + ".java";
            Path filePath = dir.resolve(fileName);

            String content = generateContent(basePackage + "." + getFolderName(), className);
            Files.writeString(filePath, content);

            result.append("[v] Successfully generated : ").append(getComponentType().name()).append(" ").append(filePath).append("\n");

        } catch (Exception ex) {
            result.append("[x] Error occurred ").append(getClassSuffix()).append(": ").append(ex.getMessage()).append("\n");
        }
    }

    private ComponentType getComponentType() {
        ComponentInfo annotation = this.getClass().getAnnotation(ComponentInfo.class);
        return (annotation != null) ? annotation.type() : ComponentType.CONTROLLER;
    }

    @Override
    public String getFolderName() {
        return getComponentType().getValue().toLowerCase();
    }

    @Override
    public String getClassSuffix() {
        return getComponentType().getValue();
    }

    // Metodo astratto per il contenuto del file
    public abstract String generateContent(String basePackage, String className);
}
