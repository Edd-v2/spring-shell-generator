package com.shell.Shell.factory;

import com.shell.Shell.factory.interfaces.ComponentGenerator;

import java.nio.file.Files;
import java.nio.file.Path;

public abstract class AbstractComponentGenerator implements ComponentGenerator {

    /**
     * Common logic to generate file for any component type.
     */
    public void generateFile(String basePackagePath, String basePackage, String className, StringBuilder result) {
        try {
            Path dir = Path.of("src/main/java", basePackagePath, getFolderName());
            Files.createDirectories(dir);

            String fileName = className + getClassSuffix() + ".java";
            Path filePath = dir.resolve(fileName);

            String content = generateContent(basePackage + "." + getFolderName(), className);
            Files.writeString(filePath, content);

            result.append(getClassSuffix()).append("[V] generated: ").append(filePath).append("\n");

        } catch (Exception ex) {
            result.append("[ERR] Failed to generate ").append(getClassSuffix()).append(": ").append(ex.getMessage()).append("\n");
        }
    }


    // These must be implemented by subclasses
    public abstract String getFolderName();
    public abstract String getClassSuffix();
    public abstract String generateContent(String basePackage, String className);
}