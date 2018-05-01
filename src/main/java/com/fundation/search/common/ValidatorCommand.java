package com.fundation.search.common;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Class ValidatorCommand to validate commands introduced by the user.
 *
 * @version 29 Mar 2018  * @Maria Canqui
 */
public class ValidatorCommand {

     private static final String INI_COMMAND = "-";
      private static final List<String> VALID_COMMANDS = new ArrayList<>();
     /**
      * static method to fill list with characters that are
      * allowed when a file or path directory is searched by size.
      */
     static {
         VALID_COMMANDS.add("-p");
         VALID_COMMANDS.add("-n");
         VALID_COMMANDS.add("-h");
         VALID_COMMANDS.add("-r");
         VALID_COMMANDS.add("-s");
         VALID_COMMANDS.add("-ext");
         VALID_COMMANDS.add("-ow");
         VALID_COMMANDS.add("-type");
         VALID_COMMANDS.add("-cd");
         VALID_COMMANDS.add("-md");
         VALID_COMMANDS.add("-ad");
         VALID_COMMANDS.add("-size");
     }

    private static final List<String> VALID_RANGE = new ArrayList<>();
     /**
      * static method to fill list with characters that are
      * allowed when a file or path directory is searched by size.
      */
    static {
        VALID_RANGE.add("Major");
        VALID_RANGE.add("Minor");
        VALID_RANGE.add("Equals");
    }

     private static final List<String> VALID_SIZE = new ArrayList<>();
     /**
      * static method to fill list with characters that are
      * allowed when a file or path directory is searched by size.
      */
     static {
         VALID_SIZE.add("Bytes");
         VALID_SIZE.add("Kb");
         VALID_SIZE.add("Mb");
         VALID_SIZE.add("Gb");
     }

     private static final List<String> BOOLEAN_VALUE = new ArrayList<>();
     /**
      * static method to fill list with characters that are
      * allowed when a file or path directory is searched by size.
      */
     static {
         BOOLEAN_VALUE.add("true");
         BOOLEAN_VALUE.add("false");
     }

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
        VALID_TYPES.add('0');
    }

    /**
     * Method to validate if the command is followed by an argument.
     *
     * @param command command line.
     * @return boolean command is valid.
     */
    public boolean isAValidArgumentAfterCommand(String[] command) {
        for (int i = 0; i < command.length; i += 2) {
            if (command[i + 1].length() > 1) {
                if (command[i + 1].substring(0, 1).equals(INI_COMMAND)) {
                    return false;
                }
            }
            else if (command[i+1].equals(INI_COMMAND)) {
                return false;
            }

        }
        return true;
    }

    /**
     * Method to validate if the command has a number valid of arguments.
     * @param command command line.
     * @return boolean command is valid.
     */
    public boolean isAValidNumberArguments(String[] command) {
        return (command.length % 2) == 0;
    }

    /**
     * Method to validate if the command contain a valid command.
     * @param command command line.
     * @return boolean command is valid.
     */
    public boolean containAValidCommand(String[] command) {
        for (int i = 0; i < command.length; i += 2) {
            if (!VALID_COMMANDS.contains(command[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to valida if the commands are not empty.
     * @param command command line
     * @return list of files found
     */
    public boolean isNotEmptyCommand(String[] command) {
        return command.length != 0;
    }

    /**
     * Method to validate if the command contain a capital letter.
     * @param command Command line.
     * @return boolean command is valid.
     */
    public static boolean isNotContainCapitalLetters(String[] command) {
        for (int i = 0; i < command.length; i += 2) {
            if (command[i].length() == 2 && !command[i].equals(command[i].toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to validate if the command contain a path.
     * @param command command line.
     * @return boolean command is valid.
     */
    public static boolean containPath(String[] command) {
        return Arrays.asList(command).contains("-p");
    }

    /**
     * Method to validate if the command contain a repeat command.
     * @param command command line.
     * @return boolean command is valid.
     */
    public static boolean containRepeatCommands(String[] command) {
        Set<String> lump = new HashSet<String>();
        for (int i = 0; i < command.length; i += 2) {
            if (lump.contains(command[i])) {
                return false;
            }
            lump.add(command[i]);
        }
        return true;
    }

    /**
     * Method to validate file name, it should not contains special characters for windows.
     * @param command command line.
     * @return boolean command is valid.
     */
    public boolean isAValidName(String[] command) {
        INVALID_CHARACTERS.remove((Character) '*');
        if (Arrays.asList(command).contains("-n")) {
            int positionPath =  Arrays.asList(command).indexOf("-n");
            char[] nameCharacters = command[positionPath + 1].toCharArray();
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
     * Methods to validate help message, it should display the help message.
     *
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isValidHelp(String[] command) {
        if (Arrays.asList(command).contains("-help")) {
            return false;
        }
        return true;
    }
    /**
     * Method to validate hidden command.
     * @param command command line.
     * @return boolean command is valid.
     */
    public boolean isAValidHidden(String[] command) {
        Validator val = new Validator();
        if (Arrays.asList(command).contains("-h")) {
            int positionPath =  Arrays.asList(command).indexOf("-h");
            return containAValidValue(command[positionPath + 1], VALID_HIDDEN) && val.isANumber(command[positionPath + 1]) && command[positionPath + 1].length() == 1;
        }
        return true;
    }

    /**
     * Method to validate read only command.
     * @param command command line.
     * @return boolean command is valid.
     */
    public boolean isAValidReadOnly(String[] command) {
        Validator val = new Validator();
        if (Arrays.asList(command).contains("-r")) {
            int positionPath =  Arrays.asList(command).indexOf("-r");
            return containAValidValue(command[positionPath + 1], VALID_HIDDEN) && val.isANumber(command[positionPath + 1]) && command[positionPath + 1].length() == 1;
        }
        return true;
    }

    /**
     * Method to validate if is case sensitive name file.
     * @param command command line.
     * @return boolean command is valid.
     */
    public boolean isAValidCaseSensitive(String[] command) {
        if (Arrays.asList(command).contains("-s")) {
            int positionPath =  Arrays.asList(command).indexOf("-s");
            if (!BOOLEAN_VALUE.contains(command[positionPath + 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to validate case sensitive command have a name.
     *
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidCaseSensitiveContainName(String[] command) {
        if (Arrays.asList(command).contains("-s")) {
            return Arrays.asList(command).contains("-n");
        }
        return true;
    }
    /**
     * Method to validate type file.
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidType(String[] command) {
        Validator val = new Validator();
        if (Arrays.asList(command).contains("-type")) {
            int positionPath =  Arrays.asList(command).indexOf("-type");
            return containAValidValue(command[positionPath + 1], VALID_TYPES) && val.isANumber(command[positionPath + 1]) && command[positionPath + 1].length() == 1;
        }
        return true;
    }

    /**
     * Method to validate if is a valid date.
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidDate(String[] command) {
        if (!containDate(command, "-cd")) {
            return false;
        }
        if (!containDate(command, "-md")) {
            return false;
        }
        if (!containDate(command, "-ad")) {
            return false;
        }
        return true;
    }
     /**
      * Method to validate if cd, md, ad contain a valid date.
      * @param command file name.
      * @return boolean value is valid.
      */
    public boolean containDate (String[] command, String dateC) {
         if (Arrays.asList(command).contains(dateC)) {
            int positionPath =  Arrays.asList(command).indexOf(dateC);
            return validDate(command[positionPath + 1]);
        }
        return true;
    }

    /**
     * Method to validate if the date has a correct range.
     * @param command command line.
     * @return boolean range date is valid.
     */
    public boolean isAValidRangeDate(String[] command) {
        if (!containRangeDate(command, "-cd")) {
            return false;
        }
        if (!containRangeDate(command, "-md")) {
            return false;
        }
        if (!containRangeDate(command, "-ad")) {
            return false;
        }

        return true;
    }
     /**
      * Method to validate if cd, md, ad contain a valid date.
      * @param command file name.
      * @return boolean value is valid.
      */
     public boolean containRangeDate (String[] command, String date) {
         if (Arrays.asList(command).contains(date)) {
             int positionPath =  Arrays.asList(command).indexOf(date);
             return validRangeDate(command[positionPath + 1]);
         }
         return true;
     }
     /**
      * Method to validate a date range.
      * @param command command line.
      * @return boolean command is valid.
      */
    public boolean validRangeDate (String command) {
        String[] twoDates = command.split("_");
        Validator valNormal = new Validator();
        return valNormal.isAValidRangeDate(twoDates[0], twoDates[1]);
    }
     /**
      * Method to validate if the date is valid.
      * @param command command line.
      * @return boolean command is valid.
      */
    public boolean validDate(String command) {
        if (command.contains("_")) {
            String[] twoDates = command.split("_");
            if (twoDates.length == 2) {
                if (twoDates[0].length() == 10 && twoDates[1].length() == 10) {
                    String[] from = twoDates[0].split("-");
                    String[] to = twoDates[0].split("-");
                    return from.length == 3 && to.length == 3;
                }
            }
        }
        return false;
    }

    /**
     * Method to validate if a name contain a valid value.
     * @param command command line.
     * @return boolean command is valid.
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
     /**
      * Method to validate the path.
      * @param path path name.
      * @return boolean path is valid.
      */
    public boolean validatePath(String path){
        Validator validatorNormal = new Validator();
        if(!path.equals("")) {
            return validatorNormal.isAValidPath(path);
        }
        return false;
    }
     /**
      * Method to validate if the name contain wildcard.
      * @param name file name.
      * @return boolean name is valid.
      */
     public boolean isAValidWildCard(String[] name) {
         if (Arrays.asList(name).contains("*") && Arrays.toString(name).startsWith("*") && Arrays.toString(name).endsWith("*")) {
             System.out.println(Arrays.asList(name));
             return false;
         }
         return true;
     }
     /**
      * Method to validate if the size is valid.
      * @param command command line.
      * @return boolean size is valid.
      */
     public boolean isAValidSize(String[] command) {
         Validator validatorNormal = new Validator();
         if (Arrays.asList(command).contains("-size")) {
             String sizeText = command[Arrays.asList(command).indexOf("-size") + 1];
             String[] sizeCommand = sizeText.split(" ");
             if (sizeCommand.length != 3) {
                 return false;
             }
             else if (!firstWordSize(sizeCommand[0]) || !validatorNormal.isANumber(sizeCommand[1]) || !secondWordSize(sizeCommand[2])) {
                    return false;
             }
         }
         return true;
     }
     /**
      * Method to validate if the size is valid.
      * @param word size command.
      * @return boolean size first word is valid.
      */
     public boolean firstWordSize (String word) {
        if (VALID_RANGE.contains(word)) {
             return true;
         }
         return false;
     }
     /**
      * Method to validate if the size is valid.
      * @param word size command.
      * @return boolean size second word is valid.
      */
     public boolean secondWordSize (String word) {
         if (VALID_SIZE.contains(word)) {
             return true;
         }
         return false;
     }
}
