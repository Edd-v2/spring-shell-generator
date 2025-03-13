package com.shell.Shell.factory.annotations;

import com.shell.Shell.factory.types.ComponentType;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface ComponentInfo {
    ComponentType type();
}
