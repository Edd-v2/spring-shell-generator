 # Spring Shell Generator

Spring Shell Generator is a CLI tool that allows you to generate Spring Boot components (Controller, Service, Repository) directly from the command line.

🎯 Features
* Easily generate Spring Boot components with a single command.
* Supports Controller, Service, and Repository creation.
* Seamlessly integrates with any Java/Spring Boot project.


## 📌 Installation

Follow these steps to install and use the tool.

## Create the Executable JAR

From the root of your project, run:


```bash
  mvn clean install
```

If you have Spring Boot configured, the JAR file will be located at:

```path
    target/spring-shell-generator-0.1.jar
```

## Add the JAR to Your PATH

Follow these steps to easily run the spring-shell.jar from any terminal window.
1. Create a Directory for the JAR File

   Open File Explorer and navigate to your C: drive or User folder under C.
   Create a new folder called tools in the root of the C: drive.
   Right-click and select New > Folder.
   Name the folder tools.

2. Move and Rename the JAR File

   Move the spring-shell.jar file into the C:\tools directory.
   Rename the file to spring-shell.jar (if it's not already named that).

3. Set Up an Environment Variable

   Open the System Properties:
   Press Win + X and select System.
   Click Advanced system settings on the left.
   Click the Environment Variables button at the bottom.
   Create a new system environment variable:
   Under System variables, click New.
   For Variable name, enter SHELL_HOME.
   For Variable value, enter C:\tools.
   Click OK to save.

4. Create a Batch File to Run the JAR

   Open Notepad and create a new file.

   Add the following line to the file:

   java -jar C:\tools\spring-shell.jar

   Save the file as spring-shell.bat in the C:\tools folder.
   Make sure to select All Files under "Save as type" when saving the file.

5. Test the Setup

   Open a Command Prompt window (press Win + R, type cmd, and press Enter).
   Type spring-shell and press Enter.
   The Spring Shell JAR should now run, and you can access it from any terminal.



## Test the Command

Now you can generate components anywhere in your project!
Navigate to your project folder and run:

```bash
spring-shell
```

If everything is set up correctly, this will open our Spring Shell to generate Controller, Service, and Repository files in your project.

Use following command to generate all three components or use appropriate flag : 

```bash
g -n User --all
```

### (Optional) Create a Wrapper Script

If you want an even simpler execution, create a script named g:

Paste this inside the file:

```bash
java -jar ~/tools/spring-shell-generator-0.1.jar "$@"
```

Save it in /usr/local/bin/g and make it executable:

```bash
chmod +x /usr/local/bin/g
```

Now you can run commands directly:

```bash
g -n User -c -s -r
```

📢 Contributing

If you want to improve the project, feel free to open a Pull Request or report an issue in the Issues section.

🚀 Your generator is now ready to use in any project! 🎉