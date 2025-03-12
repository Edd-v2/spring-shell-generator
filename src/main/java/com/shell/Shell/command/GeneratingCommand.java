package com.shell.Shell.command;

import com.shell.Shell.factory.AbstractComponentGenerator;
import com.shell.Shell.factory.ComponentGeneratorFactory;
import com.shell.Shell.factory.interfaces.ComponentGenerator;
import com.shell.Shell.factory.types.ComponentType;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class GeneratingCommand {

    @ShellMethod(
            key = {"generate", "g"},
            value = "Generates Spring Boot components based on the provided options.\n" +
                    "Usage: generate -n <name> [options]\n\n" +
                    "-n, --name          : Base name for the component to generate (required)\n" +
                    "-c, --controller    : Generate a Controller (optional, default is false)\n" +
                    "-s, --service       : Generate a Service (optional, default is false)\n" +
                    "-r, --repository    : Generate a Repository (optional, default is false)\n" +
                    "--all               : Generate all components (Controller, Service, Repository) (optional, default is false)\n" +
                    "For more details, type 'help' at any time."
    )
    public String generate(
            @ShellOption(value = {"-n", "--name"}, help = "Base name of the component") String name,
            @ShellOption(value = {"-c", "--controller"}, defaultValue = "false", help = "Generate Controller") boolean generateController,
            @ShellOption(value = {"-s", "--service"}, defaultValue = "false", help = "Generate Service") boolean generateService,
            @ShellOption(value = {"-r", "--repository"}, defaultValue = "false", help = "Generate Repository") boolean generateRepository,
            @ShellOption(value = {"--all"}, defaultValue = "false", help = "Generate all components") boolean generateAll
    ) {

        String basePackage = this.getClass().getPackage().getName().replace(".command", "");
        String basePackagePath = basePackage.replace(".", "/");
        String className = capitalize(name);
        StringBuilder result = new StringBuilder();

        List<ComponentType> componentsToGenerate = new ArrayList<>();
        if(generateAll || generateController) componentsToGenerate.add(ComponentType.CONTROLLER);
        if(generateAll || generateService) componentsToGenerate.add(ComponentType.SERVICE);
        if(generateAll || generateRepository) componentsToGenerate.add(ComponentType.REPOSITORY);

        if (componentsToGenerate.isEmpty()) {
            result.append("No component selected. Use -c, -s, -r or --all flags.");
            return result.toString();
        }

        for (ComponentType type : componentsToGenerate) {
            ComponentGenerator generator = ComponentGeneratorFactory.getGenerator(type);

            if (generator instanceof AbstractComponentGenerator abstractGen){
                abstractGen.generateFile(basePackagePath, basePackage, className, result);
            }else {
                result.append("Unknown component type: ").append(type).append("\n");
            }
        }

        return result.toString();
    }

    private String capitalize(String name) {
        if (name == null || name.isEmpty()) return name;
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}