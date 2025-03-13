package com.shell.Shell.factory.types;

public enum ComponentType {
    CONTROLLER("Controller"),
    SERVICE("Service"),
    REPOSITORY("Repository"),
    SECURITY("Security"),
    WEBCONFIG("Webconfig"),
    WEBSOCKET("Websocket");

    private final String value;

    ComponentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
