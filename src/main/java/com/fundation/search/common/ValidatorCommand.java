package com.fundation.search.common;

import org.apache.commons.codec.binary.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class ValidatorCommand to validate commands introduced by the user.
 *
 * @version 29 Mar 2018  * @Maria Canqui
 */
public class ValidatorCommand {
    private static final String FIRST_WORD = "java";
    private static final String SECOND_WORD = "search";
    private static final String INI_COMMAND = "-";
    private static final int SIZE_COMMAND = 2;
    private static final String[] COMMANDS = {"-p", "-n", "-h", "-r", "-s", "-ext", "-ow", "-type", "-ma", "-cd", "-md", "-size"};

    static final List<Character> INVALID_CHARACTERS = new ArrayList<>();

    /**
     * static method to fill list with characters that are not
     * allowed when a file or path directory is created in windows.
     */
    static {
        INVALID_CHARACTERS.add('/');
        INVALID_CHARACTERS.add(':');
        INVALID_CHARACTERS.add('*');
        INVALID_CHARACTERS.add('?');
        INVALID_CHARACTERS.add('<');
        INVALID_CHARACTERS.add('>');
        INVALID_CHARACTERS.add('|');
        INVALID_CHARACTERS.add('"');
        INVALID_CHARACTERS.add('\\');
    }

    /**
     * Method to validate if the command is followed by an argument.
     *
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidArgumentAfterCommand(String[] command) {
        for (int i = 0; i < command.length; i += 2) {
            if (command[i+1].substring(0, 1).equals(INI_COMMAND) ) {
                    return false;
            }
        }
        return true;
    }
    /**
     * Method to validate if the command is followed by an argument.
     *
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidNumberArguments(String[] command) {
        if ((command.length % 2) == 0) {
            return true;
        }
        return false;
    }

    /**
     * Method to validate if the command is followed by an argument.
     *
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean containAValidCommand(String[] command) {
        boolean contain = false;
        for (int i = 0; i < command.length; i += 2) {
            for (String singleCommand : COMMANDS) {
                if (command[i].compareTo(singleCommand) == 0) {
                    contain = true;
                    break;
                }
            }
            if (!contain) {
                return false;
            }
            contain = false;
        }
        return true;
    }
    /**
     * Method exeCmd receive a command, separe the string by command and set criteria attributes.
     *
     * @return list of files found
     */
    public boolean isNotEmptyCommand(String[] command) {
        if(command.length == 0) {
            return false;
        }
        return true;
    }
    /**
     * Method to validate if the command contain a capital letter.
     *
     * @param command file name.
     * @return boolean value is valid.
     */
    public static boolean isNotContainCapitalLetters(String[] command) {
        boolean hasUppercase = true;
        for (int i = 0; i < command.length; i ++) {
            hasUppercase = command[i].equals(command[i].toLowerCase());
            if (command[i].contains("-") && command[i].length() == 2 && !hasUppercase) {
                return false;
            }
            hasUppercase = true;
        }
        return hasUppercase;
    }
    /**
     * Method to validate if the command contain a path.
     *
     * @param command file name.
     * @return boolean value is valid.
     */
    public static boolean containPath(String[] command) {
        for (int i = 0; i < command.length; i += 2 ) {
            if (command[i].compareTo("-p") == 0) {
                return true;
            }
        }
        return false;
    }
    /**
     * Method to validate if the command contain a path.
     *
     * @param command file name.
     * @return boolean value is valid.
     */
    public static boolean containRepeatCommands(String[] command) {
        Set<String> lump = new HashSet<String>();
        for (String i : command)
        {
            if (lump.contains(i)) {
                return false;
            }
            lump.add(i);
        }
        return true;
    }

    /**
     * Method to validate file name, it should not contains special characters for windows..
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidName(String[] command) {
        for (int i = 0; i < command.length; i += 2 ) {
            char[] nameCharacters = command[i+1].toCharArray();
            System.out.print(nameCharacters);
            if (command[i+1].compareTo("-n") == 0) {
                for (char value : nameCharacters) {
                    System.out.print(value);
                    if (INVALID_CHARACTERS.contains(value)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
