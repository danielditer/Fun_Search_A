package com.fundation.search.common;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * Class that contain test to commandExecutor.
 * @version
 * 29 Mar 2018  * @Maria Canqui
 */
public class ValidatorCommandTest {
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
    private ValidatorCommand valcom;
    /**
     * * initialize CommandController.
     * */
    @Before
    public void initialize() {
        valcom = new ValidatorCommand();
    }

    /**
     * the isAValidArgumentAfterCommand method provide a positive test for the word after command.
     */
    @Test
    public void isATwoValidArgumentAfterCommand() {
        String[] command = {"-p","C:/","-n","test"};
        assertTrue( valcom.isAValidArgumentAfterCommand(command));
    }

    /**
     * the isANotValidArgumentAfterCommand method provide a negative test for the word after command.
     */
    @Test
    public void isANotValidArgumentAfterCommand() {
        String[] command = {"-p","C:/","-n","-h"};
        assertFalse( valcom.isAValidArgumentAfterCommand(command));
    }
    /**
     * the isAInvalidLineArgumentAfterCommand method provide a negative test for the word after command.
     */
    @Test
    public void isAInvalidLineArgumentAfterCommand() {
        String[] command = {"-p","C:/","-n","-"};
        assertFalse( valcom.isAValidArgumentAfterCommand(command));
    }
    /**
     * the isAInvalidLineArgumentAfterCommand method provide a negative test for the word after command.
     */
    @Test
    public void isAOneInvalidArgumentAfterCommand() {
        String[] command = {"-p","C:/","-n", "t"};
        assertTrue( valcom.isAValidArgumentAfterCommand(command));
    }

    /**
     * the isAValidNumberArguments method provide a positive test for the command size.
     */
    @Test
    public void isAValidNumberArguments() {
        String[] command = {"-p","C:/","-n", "t"};
        assertTrue( valcom.isAValidNumberArguments(command));
    }

    /**
     * the isAValidNumberArguments method provide a negative test for the command size.
     */
    @Test
    public void isNotAValidNumberArguments() {
        String[] command = {"-p","C:/","-n", "t", "-s"};
        assertFalse( valcom.isAValidNumberArguments(command));
    }

    /**
     * the isAValidNumberArguments method provide a positive test for receive valid commands.
     */
    @Test
    public void containAValidCommand() {
        String[] command = {"-p","C:/","-n", "t", "-h", "1"};
        assertTrue( valcom.isAValidNumberArguments(command));
    }

    /**
     * the isAValidNumberArguments method provide a negative test for receive valid commands.
     */
    @Test
    public void containANotValidCommand() {
        String[] command = {"-p","C:/","-n", "t", "-k", "1"};
        assertTrue( valcom.isAValidNumberArguments(command));
    }

    /**
     * the isNotEmptyCommand method provide a negative test for receive valid commands.
     */
    @Test
    public void isNotEmptyCommand() {
        String[] command = {};
        assertFalse( valcom.isNotEmptyCommand(command));
    }

    /**
     * the isEmptyCommand method provide a positive test for receive valid commands.
     */
    @Test
    public void isEmptyCommand() {
        String[] command = {"-p"};
        assertTrue( valcom.isNotEmptyCommand(command));
    }

    /**
     * the isNotContainCapitalLetters method provide test to verify if the command contain capital letters.
     */
    @Test
    public void isContainCapitalLetters() {
        String[] command = {"-p", "C:/magico", "-N", "test"};
        assertFalse( ValidatorCommand.isNotContainCapitalLetters(command));
    }

    /**
     * the isNotContainCapitalLetters method provide test to verify if the command contain capital letters.
     */
    @Test
    public void isNotContainCapitalLetters() {
        String[] command = {"-p", "C:/magico", "-n", "test"};
        assertTrue( ValidatorCommand.isNotContainCapitalLetters(command));
    }

    /**
     * the containPath method provide a test to verify if the command contain the path.
     */
    @Test
    public void containPath() {
        String[] command = {"-p", "C:/magico", "-N", "test"};
        assertTrue( ValidatorCommand.containPath(command));
    }

    /**
     * the containPath method provide a test to verify if the command contain the path.
     */
    @Test
    public void notContainPath() {
        String[] command = {"-h", "1", "-n", "test"};
        assertFalse( ValidatorCommand.containPath(command));
    }

    /**
     * the NotContainRepeatCommands method provide a test to verify if the command not contain repeat commands.
     */
    @Test
    public void NotContainRepeatCommands() {
        String[] command = {"-p", "C:/magico", "-n", "test", "-h", "1"};
        assertTrue( ValidatorCommand.containRepeatCommands(command));
    }
    /**
     * the ContainRepeatCommands method provide a test to verify if the command contain repeat commands.
     */
    @Test
    public void ContainRepeatCommands() {
        String[] command = {"-p", "C:/magico", "-n", "test", "-n", "1"};
        assertFalse( ValidatorCommand.containRepeatCommands(command));
    }

    /**
     * the isAValidName method provide a test to verify if the command contain a valid name.
     */
    @Test
    public void isAValidName() {
        String[] command = {"-p", "C:/magico", "-n", "test"};
        assertTrue( valcom.isAValidName(command));
    }

    /**
     * the isNotAValidName method provide a test to verify if the command not contain a valid name.
     */
    @Test
    public void isNotAValidName() {
        String[] command = {"-p", "C:/magico", "-n", "tes:t<"};
        assertFalse( valcom.isAValidName(command));
    }

    /**
     * the isAValidHidden method provide a test to verify if the command contain a valid hidden value.
     */
    @Test
    public void isAValidHidden() {
        String[] commandOne = {"-p", "C:/magico", "-h", "1"};
        assertTrue( valcom.isAValidHidden(commandOne));

        String[] commandTwo = {"-p", "C:/magico", "-h", "2"};
        assertTrue( valcom.isAValidHidden(commandTwo));

        String[] commandThree = {"-p", "C:/magico", "-h", "3"};
        assertTrue( valcom.isAValidHidden(commandThree));
    }

    /**
     * the isANotValidHidden method provide a test to verify if the command contain a not valid hidden value.
     */
    @Test
    public void isANotValidHidden() {
        String[] commandOne = {"-p", "C:/magico", "-h", "4"};
        assertFalse( valcom.isAValidHidden(commandOne));
    }


    /**
     * the isAValidReadOnly method provide a test to verify if the command contain a valid readonly value.
     */
    @Test
    public void isAValidReadOnly() {
        String[] commandOne = {"-p", "C:/magico", "-r", "1"};
        assertTrue( valcom.isAValidReadOnly(commandOne));

        String[] commandTwo = {"-p", "C:/magico", "-r", "2"};
        assertTrue( valcom.isAValidReadOnly(commandTwo));

        String[] commandThree = {"-p", "C:/magico", "-r", "3"};
        assertTrue( valcom.isAValidReadOnly(commandThree));
    }

    /**
     * the isANotValidReadOnly method provide a test to verify if the command contain a not valid readonly value.
     */
    @Test
    public void isANotValidReadOnly() {
        String[] commandOne = {"-p", "C:/magico", "-r", "4"};
        assertFalse( valcom.isAValidReadOnly(commandOne));
    }

    /**
     * the isAValidCaseSensitiveTrue method provide a test to verify if the command contain a valid case sensitive value.
     */
    @Test
    public void isAValidCaseSensitiveTrue() {
        String[] commandOne = {"-p", "C:/magico", "-s", "true"};
        assertTrue( valcom.isAValidCaseSensitive(commandOne));
    }

    /**
     * the isAValidCaseSensitiveFalse method provide a test to verify if the command contain a valid case sensitive value.
     */
    @Test
    public void isAValidCaseSensitiveFalse() {
        String[] commandOne = {"-p", "C:/magico", "-s", "false"};
        assertTrue( valcom.isAValidCaseSensitive(commandOne));
    }

    /**
     * the isANotValidCaseSensitive method provide a test to verify if the command contain an invalid case sensitive value.
     */
    @Test
    public void isANotValidCaseSensitive() {
        String[] commandOne = {"-p", "C:/magico", "-s", "4"};
        assertFalse( valcom.isAValidCaseSensitive(commandOne));
    }

    /**
     * the isAValidCaseSensitiveContainName method provide a test to verify if the command contain a name with case sensitive.
     */
    @Test
    public void isAValidCaseSensitiveContainName() {
        String[] commandOne = {"-p", "C:/magico", "-s", "false", "-n", "test"};
        assertTrue( valcom.isAValidCaseSensitiveContainName(commandOne));
    }

    /**
     * the isANotValidCaseSensitiveContainName method provide a test to verify if the command contain a case sensitve without name.
     */
    @Test
    public void isANotValidCaseSensitiveContainName() {
        String[] commandOne = {"-p", "C:/magico", "-s", "false", "-h", "1"};
        assertFalse( valcom.isAValidCaseSensitiveContainName(commandOne));
    }

    /**
     * the isAValidType method provide a test to verify if the command contain a valid type.
     */
    @Test
    public void isAValidType() {
        String[] commandOne = {"-p", "C:/magico", "-type", "1"};
        assertTrue( valcom.isAValidType(commandOne));

        String[] commandTwo = {"-p", "C:/magico", "-type", "2"};
        assertTrue( valcom.isAValidType(commandTwo));

        String[] commandThree = {"-p", "C:/magico", "-type", "3"};
        assertTrue( valcom.isAValidType(commandThree));

        String[] commandZero = {"-p", "C:/magico", "-type", "0"};
        assertTrue( valcom.isAValidType(commandZero));
    }

    /**
     * the isANotValidType method provide a test to verify if the command contain an invalid type.
     */
    @Test
    public void isANotValidType() {
        String[] commandOne = {"-p", "C:/magico", "-type", "5"};
        assertFalse( valcom.isAValidType(commandOne));
    }

    /**
     * the isAValidCreationDate method provide a test to verify if the command contain a valid date.
     */
    @Test
    public void isAValidCreationDate() {
        String[] commandOne = {"-p", "C:/magico", "-cd", "10-10-2018_12-12-2018"};
        assertTrue( valcom.isAValidDate(commandOne));
    }

    /**
     * the isANotValidCreationDate method provide a test to verify if the command contain an invalid date.
     */
    @Test
    public void isANotValidCreationDate() {
        String[] commandOne = {"-p", "C:/magico", "-cd", "10-10-2018_12-12-20183"};
        assertFalse( valcom.isAValidDate(commandOne));
    }

    /**
     * the isAValidModifiedDate method provide a test to verify if the command contain a valid date.
     */
    @Test
    public void isAValidModifiedDate() {
        String[] commandOne = {"-p", "C:/magico", "-md", "10-10-2018_12-12-2018"};
        assertTrue( valcom.isAValidDate(commandOne));
    }

    /**
     * the isANotValidModifiedDate method provide a test to verify if the command contain an invalid date.
     */
    @Test
    public void isANotValidModifiedDate() {
        String[] commandOne = {"-p", "C:/magico", "-md", "10-10-2018_12-12-20183"};
        assertFalse( valcom.isAValidDate(commandOne));
    }

    /**
     * the isAValidModifiedDate method provide a test to verify if the command contain a valid date.
     */
    @Test
    public void isAValidAccessDate() {
        String[] commandOne = {"-p", "C:/magico", "-ad", "10-10-2018_12-12-2018"};
        assertTrue( valcom.isAValidDate(commandOne));
    }

    /**
     * the isANotValidModifiedDate method provide a test to verify if the command contain an invalid date.
     */
    @Test
    public void isANotValidAccessDate() {
        String[] commandOne = {"-p", "C:/magico", "-ad", "10-10-2018_12-12-20183"};
        assertFalse( valcom.isAValidDate(commandOne));
    }

    /**
     * the isAValidRangeDateCreation method provide a test to verify if the command contain a valid range date.
     */
    @Test
    public void isAValidRangeDateCreation() {
        String[] commandOne = {"-p", "C:/magico", "-cd", "10-10-2018_12-12-2018"};
        assertTrue( valcom.isAValidRangeDate(commandOne));
    }

    /**
     * the isANotValidRangeDateCreation method provide a test to verify if the command contain an invalid range date.
     */
    @Test
    public void isANotValidRangeDateCreation() {
        String[] commandOne = {"-p", "C:/magico", "-cd", "12-12-2018_10-10-2018"};
        assertFalse( valcom.isAValidRangeDate(commandOne));
    }

    /**
     * the isAValidRangeDateCreation method provide a test to verify if the command contain a valid range date.
     */
    @Test
    public void isAValidRangeDateModify() {
        String[] commandOne = {"-p", "C:/magico", "-md", "10-10-2018_12-12-2018"};
        assertTrue( valcom.isAValidRangeDate(commandOne));
    }

    /**
     * the isANotValidRangeDateCreation method provide a test to verify if the command contain an invalid range date.
     */
    @Test
    public void isANotValidRangeDateModify() {
        String[] commandOne = {"-p", "C:/magico", "-md", "12-12-2018_10-10-2018"};
        assertFalse( valcom.isAValidRangeDate(commandOne));
    }

    /**
     * the isAValidRangeDateCreation method provide a test to verify if the command contain a valid range date.
     */
    @Test
    public void isAValidRangeDateAccess() {
        String[] commandOne = {"-p", "C:/magico", "-ad", "10-10-2018_12-12-2018"};
        assertTrue( valcom.isAValidRangeDate(commandOne));
    }

    /**
     * the containAValidValue method provide a test to verify if the command contain a valid value.
     */
    @Test
    public void containAValidValue() {
        assertFalse( valcom.containAValidValue("Nombre",INVALID_CHARACTERS));
        assertFalse( valcom.containAValidValue("Apellido",INVALID_CHARACTERS));
    }

    /**
     * the containANotValidValue method provide a test to verify if the command contain an invalid value.
     */
    @Test
    public void containANotValidValue() {
        assertTrue( valcom.containAValidValue("Nombre:",INVALID_CHARACTERS));
        assertTrue( valcom.containAValidValue("Apellido?",INVALID_CHARACTERS));
    }

    /**
     * the validatePath method provide a test to verify if the command contain a valid path.
     */
    @Test
    public void validatePath() {
        assertTrue( valcom.validatePath("C:/magico"));
    }

    /**
     * the validateNotPath method provide a test to verify if the command contain an invalid path.
     */
    @Test
    public void validateNotPath() {
        assertFalse( valcom.validatePath("asdasd"));
    }

    /**
     * the isAValidWildCard method provide a test to verify if the command contain a valid wildcar.
     */
    @Test
    public void isAValidWildCard() {
        String[] commandOne = {"-n","*test*"};
        assertTrue( valcom.isAValidWildCard(commandOne));
    }

    /**
     * the isNotAValidWildCard method provide a test to verify if the command contain an invalid wildcar.
     */
    @Test
    public void isNotAValidWildCard() {
        String[] commandOne = {"-n", "test"};
        assertTrue( valcom.isAValidWildCard(commandOne));
    }

    /**
     * the secondWordSize method is a test to validate the second word of the size command.
     */
    @Test
    public void secondWordSize() {
        assertTrue( valcom.secondWordSize("Bytes"));
        assertTrue( valcom.secondWordSize("Kb"));
        assertTrue( valcom.secondWordSize("Mb"));
        assertTrue( valcom.secondWordSize("Gb"));
    }
    /**
     * the badSecondWordSize method is a test to validate the second word of the size command.
     */
    @Test
    public void badSecondWordSize() {
        assertFalse( valcom.secondWordSize("Megas"));
    }
    /**
     * the firstWordSize method is a test to validate the first word of the size command.
     */
    @Test
    public void firstWordSize() {
        assertTrue( valcom.firstWordSize("Major"));
        assertTrue( valcom.firstWordSize("Minor"));
        assertTrue( valcom.firstWordSize("Equals"));
    }
    /**
     * the badFirstWordSize method is a test to validate the first word of the size command.
     */
    @Test
    public void badFirstWordSize() {
        assertFalse( valcom.firstWordSize("Different"));
    }

    /**
     * the isAValidSize method is a test to validate the size command.
     */
    @Test
    public void isAValidSize() {
        String[] commandOne = {"-size","Major 300 Bytes"};
        assertTrue( valcom.isAValidSize(commandOne));
    }
    /**
     * the isAValidSize method is a test to validate the size command.
     */
    @Test
    public void isNotAValidSize() {
        String[] commandOne = {"-size","Major 300"};
        assertFalse( valcom.isAValidSize(commandOne));
    }
    /**
     * the isAValidSize method is a test to validate the size command.
     */
    @Test
    public void isNotNumberValidSize() {
        String[] commandOne = {"-size","Major 30a0 bytes"};
        assertFalse( valcom.isAValidSize(commandOne));
    }

    /**
     * the validDate method is a test to validate the date.
     */
    @Test
    public void validDate() {
        assertTrue( valcom.validDate("10-10-2018_12-12-2018"));
    }

    /**
     * the notValidDate method is a test to validate the date.
     */
    @Test
    public void notValidDate() {
        assertFalse( valcom.validDate("12-12-2018"));
    }
    /**
     * the notValidDateThreeDates method is a test to validate the date.
     */
    @Test
    public void notValidDateThreeDates() {
        assertFalse( valcom.validDate("12-12-2018_12-12-2018_12-12-2018"));
    }
    /**
     * the notValidDateFormatFirst method is a test to validate the date.
     */
    @Test
    public void notValidDateFormatFirst() {
        assertFalse( valcom.validDate("10-10-2018A_12-12-2018"));
    }
    /**
     * the notValidDateFormatSecond method is a test to validate the date.
     */
    @Test
    public void notValidDateFormatSecond() {
        assertFalse( valcom.validDate("10-10-2018_12-12-2018S"));
    }

    /**
     * the containRangeDate method is a test to validate the date.
     */
    @Test
    public void containRangeDate() {
        String[] commandOne = {"-cd","10-10-2018_12-12-2018"};
        assertTrue( valcom.containRangeDate(commandOne, "-cd"));

        String[] commandTwo = {"-md","10-10-2018_12-12-2018"};
        assertTrue( valcom.containRangeDate(commandTwo, "-md"));

        String[] commandThree = {"-ad","10-10-2018_12-12-2018"};
        assertTrue( valcom.containRangeDate(commandThree, "-ad"));
    }

    /**
     * the containANotRangeDate method is a test to validate the date.
     */
    @Test
    public void containANotRangeDate() {
        String[] commandOne = {"-cd","12-12-2018_10-10-2018"};
        assertFalse( valcom.containRangeDate(commandOne, "-cd"));

        String[] commandTwo = {"-md","12-12-2018_10-10-2018"};
        assertFalse( valcom.containRangeDate(commandTwo, "-md"));

        String[] commandThree = {"-ad","12-12-2018_10-10-2018"};
        assertFalse( valcom.containRangeDate(commandThree, "-ad"));
    }

    /**
     * the containANotRangeDate method is a test to validate the date.
     */
    @Test
    public void containANotRangeDateCommand() {
        String[] commandOne = {"-cdd","12-12-2018_10-10-2018"};
        assertTrue( valcom.containRangeDate(commandOne, "-cd"));
    }
    /**
     * the containDate method is a test to validate the date command.
     */
    @Test
    public void containDate() {
        String[] commandOne = {"-cd","10-10-2018_12-12-2018"};
        assertTrue( valcom.containDate(commandOne, "-cd"));

        String[] commandTwo = {"-md","10-10-2018_12-12-2018"};
        assertTrue( valcom.containDate(commandTwo, "-md"));

        String[] commandThree = {"-ad","10-10-2018_12-12-2018"};
        assertTrue( valcom.containDate(commandThree, "-ad"));
    }
    /**
     * the containDate method is a test to validate the date command.
     */
    @Test
    public void containNotValidDate() {
        String[] commandOne = {"-cds","10-10-2018_12-12-2018"};
        assertTrue( valcom.containDate(commandOne, "-cd"));
    }
}
