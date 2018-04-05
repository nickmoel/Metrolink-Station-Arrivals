package com.moeller.launchcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Nick on 9/8/2017.
 */
@Component //tells spring there is objects here to be injected


public class MetrolinkCommandLineApp { //class is a blueprint used to make objects

    @Autowired //@Autowired annotation tells Spring where an injection needs to occur.

    public Validation validation;// Tells the application context to inject an instance of Validation here
    @Autowired //@Autowired annotation tells Spring where an injection needs to occur.

    public Stops stops;// Tells the application context to inject an instance of Stops here
    @Autowired

    public StartScreen screen;

    public static void main(String[] varArgs) {


        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        //The above line of code reads the config file and loads all the classes defined in the config file into the JVM. And it does not actually creates objects. Beans = objects.

        MetrolinkCommandLineApp metrolinkCommandLineApp =
                (MetrolinkCommandLineApp) context.getBean("metrolinkCommandLineApp");

        metrolinkCommandLineApp.start();
    }

    private void start() {

        screen.mainFrame();

    }

}