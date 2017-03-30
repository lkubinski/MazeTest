package com.lukasz;

import com.lukasz.commandlineparser.impl.UserStoryCommandLineParser;
import com.lukasz.userstory.UserStoryAction;

/**
 * Created by LKubinski on 30/03/2017.
 */
public class Main {

    public static void main(String[] args) {
        UserStoryAction userStoryAction = new UserStoryCommandLineParser().parse(args);
        userStoryAction.doAction();
    }

}
