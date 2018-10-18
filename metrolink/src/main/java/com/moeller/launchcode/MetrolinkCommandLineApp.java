package com.moeller.launchcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Nick on 9/8/2017.
 */
@Component


public class MetrolinkCommandLineApp {


    @Autowired
    public Stops stops;

    @Autowired
    public StartScreen screen;

    public static void main(String[] varArgs) {


        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");


        MetrolinkCommandLineApp metrolinkCommandLineApp =
                (MetrolinkCommandLineApp) context.getBean("metrolinkCommandLineApp");

        metrolinkCommandLineApp.start();
    }

    private void start() {

        screen.mainFrame();

    }

}