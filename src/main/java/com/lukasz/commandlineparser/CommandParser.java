package com.lukasz.commandlineparser;

import com.lukasz.userstory.UserStoryAction;

/**
 * Created by LKubinski on 30/03/2017.
 */
public interface CommandParser {
    UserStoryAction parse(String[] args);
}
