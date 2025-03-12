package com.shell.Shell.factory.interfaces;

public interface ComponentGenerator {

    String generateContent(String basePackage, String className);
    String getFolderName();
    String getClassSuffix();
}
