package com.shell.Shell.mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.Map;

public class TemplateRenderer {
    private static final MustacheFactory MUSTACHE_FACTORY = new DefaultMustacheFactory();
    public static String render(String templateName, Map<String, Object> dataModel){

        try {
            Reader templateReader = new InputStreamReader(
              TemplateRenderer.class.getClassLoader().getResourceAsStream("templates/"+ templateName)
            );

            Mustache mustache = MUSTACHE_FACTORY.compile(templateReader, templateName);
            StringWriter stringWriter = new StringWriter();
            mustache.execute(stringWriter, dataModel).flush();
            return stringWriter.toString();

        }catch(Exception ex){
            throw new RuntimeException("Error compiling template" + ex.getMessage(), ex);
        }


    }
}
