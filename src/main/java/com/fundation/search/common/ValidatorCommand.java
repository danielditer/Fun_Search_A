package com.fundation.search.common;

/**
 * Class ValidatorCommand to validate commands introduced by the user.
 * @version
 * 29 Mar 2018  * @Maria Canqui
 */
public class ValidatorCommand {
    private static final String FIRST_WORD = "java";
    private static final String SECOND_WORD = "search";
    private static final String INI_COMMAND = "-";
    private static final int SIZE_COMMAND = 2;
    private static final String[] COMMANDS = {"-p", "-n"};
    /**
     * Method to validate the two first words of the command.
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidFirstSecondWord(String command) {
        String[] commandArray = command.split(" ");
        if (!commandArray[0].equals(FIRST_WORD)) {
            return false;
        }
        if (!commandArray[1].equals(SECOND_WORD)) {
            return false;
        }
        return true;
    }

    /**
     * Method to validate if the command is followed by an argument.
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean isAValidArgumentAfterCommand(String command) {
        String[] commandArray = command.split(" ");
        for (int i = 2; i < commandArray.length; i++) {
            if (commandArray[i].substring(0, 1).equals(INI_COMMAND) && commandArray[i].length() == SIZE_COMMAND) {
                if (!containAValidCommand(commandArray[i + 1])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method to validate if the command is followed by an argument.
     * @param command file name.
     * @return boolean value is valid.
     */
    public boolean containAValidCommand(String command) {
        for (String singleCommand: COMMANDS) {
            if (command.contains(singleCommand) && command.length() == SIZE_COMMAND) {
                return false;
            }
        }
        return true;
    }
}
