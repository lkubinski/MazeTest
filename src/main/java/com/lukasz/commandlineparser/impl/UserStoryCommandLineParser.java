package com.lukasz.commandlineparser.impl;

import com.lukasz.commandlineparser.CommandLineOptions;
import com.lukasz.commandlineparser.CommandParser;
import com.lukasz.userstory.UserStoryAction;
import com.lukasz.userstory.impl.UserStoryOne;
import com.lukasz.userstory.impl.UserStoryThree;
import com.lukasz.userstory.impl.UserStoryTwo;
import org.apache.commons.cli.*;
import org.apache.commons.cli.Option.Builder;

/**
 * Created by LKubinski on 30/03/2017.
 */
public class UserStoryCommandLineParser implements CommandParser, CommandLineOptions {


    @Override
    public UserStoryAction parse(String[] args) {
        Options options = getOptions();
        CommandLineParser parser = new DefaultParser();
        UserStoryAction userStoryAction = null;
        try {
            CommandLine line = parser.parse(options, args);
            if (line.hasOption("us")){
                String usValue = line.getOptionValue("us");
                switch(usValue){
                    case "1":
                        userStoryAction = new UserStoryOne();
                        break;
                    case "2":
                        userStoryAction = new UserStoryTwo();
                        break;
                    case "3":
                        userStoryAction = new UserStoryThree();
                        break;
                    default:
                        throw new IllegalArgumentException("Add proper description");
                }
            }
        }
        catch(ParseException exp) {
            System.err.println( "Parsing failed.  Reason: " + exp.getMessage() );
            //throw new InvalidArgumentException(args);
        }
        return userStoryAction;
    }

    @Override
    public Options getOptions() {
        Options options = new Options();

        Builder userStoryBuilder = Option.builder("us");

        Option userStoryOption = userStoryBuilder
                .argName("userStory")
                .hasArg()
                .valueSeparator(' ')
                .build();

        options.addOption(userStoryOption);

        return options;
    }
}
