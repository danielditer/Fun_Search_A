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
    private static final String[] COMMANDS = {"-p", "-n", "-h", "-r", "-s", "-ext", "-ow", "-type", "-ma", "-dc", "-dm", "-da", "-size"};
    private static final String[] BOOLEAN_VALUES = {"true", "false"};

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

    static final List<Character> VALID_HIDDEN = new ArrayList<>();
    /**
     * static method to fill list with valid hidden values.
     * */
    static {
        VALID_HIDDEN.add('1');
        VALID_HIDDEN.add('2');
        VALID_HIDDEN.add('3');
    }
    static final List<Character> VALID_TYPES = new ArrayList<>();
    /**
     * static method to fill list with valid type file values.
     * */
    static {
        VALID_TYPES.add('1');
        VALID_TYPES.add('2');
        VALID_TYPES.add('3');
        VALID_TYPES.add('3');
    }


    /**
     * Method to validate if the command is followed by an argument.
     *
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidArgumentAfterCommand(String[] command) {
        for (int i = 0; i < command.length; i += 2) {
            if(command[i+1].length() > 1) {
                if (command[i+1].substring(0, 1).equals(INI_COMMAND) ) {
                    return false;
                } 
            }
            else if (command[i+1].equals(INI_COMMAND) ) {
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
        if (Arrays.asList(command).contains("-p")) {
            return true;
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
        for (int i = 0; i < command.length; i += 2)
        {
            if (lump.contains(command[i])) {
                return false;
            }
            lump.add(command[i]);
        }
        return true;
    }

    /**
     * Method to validate file name, it should not contains special characters for windows..
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidName(String[] command) {
        INVALID_CHARACTERS.remove((Character) '*');
        if (Arrays.asList(command).contains("-n")) {
        int positionPath =  Arrays.asList(command).indexOf("-n");
            char[] nameCharacters = command[positionPath+1].toCharArray();
            for (char value : nameCharacters) {
                if (INVALID_CHARACTERS.contains(value)) {
                    INVALID_CHARACTERS.add('*');
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Method to validate hidden command, it should not contains special characters for windows..
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidHidden(String[] command) {
        Validator val = new Validator();
        if (Arrays.asList(command).contains("-h")) {
            int positionPath =  Arrays.asList(command).indexOf("-h");
            if (!containAValidValue(command[positionPath + 1], VALID_HIDDEN) || !val.isANumber(command[positionPath + 1]) || command[positionPath + 1].length() != 1) {
                return false;
            }
        }
        return true;
    }
    /**
     * Method to validate read only command, it should not contains special characters for windows..
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidReadOnly(String[] command) {
        Validator val = new Validator();
        if (Arrays.asList(command).contains("-r")) {
            int positionPath =  Arrays.asList(command).indexOf("-r");
            if (command[positionPath].compareTo("-r") == 0) {
                if (!containAValidValue(command[positionPath + 1], VALID_HIDDEN) || !val.isANumber(command[positionPath + 1]) || command[positionPath + 1].length() != 1) {
                    return false;
                }

            }
        }
        return true;
    }


    /**
     * Method to validate hidden command, it should not contains special characters for windows..
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidCaseSensitive(String[] command) {
        int count = 0;
        if (Arrays.asList(command).contains("-s")) {
            int positionPath =  Arrays.asList(command).indexOf("-s");
            if (command[positionPath + 1].equals("false")) {
                count++;
            }
            if (command[positionPath + 1].equals("true")) {
                count++;
            }
            if (count == 0)
            {
                return false;
            }
        }

        return true;
    }
    /**
     * Method to validate case sensitive command have a name.
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidCaseSensitiveContainName(String[] command) {
        if (Arrays.asList(command).contains("-s")) {
            if (!Arrays.asList(command).contains("-n")) {
                return false;
            }
        }

        return true;
    }

    /**
     * Method to validate hidden command, it should not contains special characters for windows..
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidType(String[] command) {
        Validator val = new Validator();
        if (Arrays.asList(command).contains("-type")) {
            int positionPath =  Arrays.asList(command).indexOf("-type");
            if (!containAValidValue(command[positionPath + 1], VALID_TYPES) || !val.isANumber(command[positionPath + 1]) || command[positionPath + 1].length() != 1) {
                return false;
            }
        }
        return true;
    }
    /**
     * Method to validate hidden command, it should not contains special characters for windows..
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidDate(String[] command) {
        Validator val = new Validator();
        if (Arrays.asList(command).contains("-dc")) {
            int positionPath =  Arrays.asList(command).indexOf("-dc");
            if (!validDate(command[positionPath + 1])) {
                return false;
            }

        }
        if (Arrays.asList(command).contains("-dm")) {
            int positionPath =  Arrays.asList(command).indexOf("-dc");
            if (!validDate(command[positionPath + 1])) {
                return false;
            }

        }
        if (Arrays.asList(command).contains("-da")) {
            int positionPath =  Arrays.asList(command).indexOf("-dc");
            if (!validDate(command[positionPath + 1])) {
                return false;
            }

        }
        return true;
    }
    /**
     * Method to validate hidden command, it should not contains special characters for windows..
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidRangeDate(String[] command) {
        Validator val = new Validator();
        if (Arrays.asList(command).contains("-dc")) {
            int positionPath =  Arrays.asList(command).indexOf("-dc");
            if (!validRangeDate(command[positionPath + 1])) {
                return false;
            }

        }
        if (Arrays.asList(command).contains("-dm")) {
            int positionPath =  Arrays.asList(command).indexOf("-dc");
            if (!validRangeDate(command[positionPath + 1])) {
                return false;
            }

        }
        if (Arrays.asList(command).contains("-da")) {
            int positionPath =  Arrays.asList(command).indexOf("-dc");
            if (!validRangeDate(command[positionPath + 1])) {
                return false;
            }

        }
        return true;
    }

    public boolean validRangeDate (String command) {
        String[] twoDates = command.split("_");
        Validator valNormal = new Validator();
        if (valNormal.isAValidRangeDate(twoDates[0],twoDates[1])) {
            return true;
        }
        return false;
    }
    public boolean validDate(String command) {
       String[] twoDates = command.split("_");
       if (twoDates.length == 2) {
           if (twoDates[0].length() == 10 && twoDates[1].length() == 10) {
               String[] from = twoDates[0].split("-");
               String[] to = twoDates[0].split("-");
               if (from.length == 3 && to.length == 3) {
                    return true;
               }
            }
       }
       return false;
    }
    /**
     * Method to validate hidden command, it should not contains special characters for windows..
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean containAValidValue(String command, List<Character> VALID_VALUES) {
        char[] nameCharacters = command.toCharArray();
        for (char value : nameCharacters) {
            if (VALID_VALUES.contains(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean validatePath(String path){
        Validator validatorNormal = new Validator();
        if(!path.equals("")) {
            if (validatorNormal.isAValidPath(path)) {
                return true;
            }
        }
        return false;
    }

}
