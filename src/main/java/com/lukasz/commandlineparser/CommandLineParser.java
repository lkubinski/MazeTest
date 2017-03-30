package com.lukasz.commandlineparser;

import com.lukasz.userstory.UserStoryAction;

/**
 * Created by LKubinski on 30/03/2017.
 */
public interface CommandLineParser {
    UserStoryAction parse(String[] args);
}
