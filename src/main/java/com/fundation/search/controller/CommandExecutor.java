package com.fundation.search.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 Class CommandExecutor to execute cmd commands.
 *
 * @version
0.0 27 Mar 2018  * @autor
Maria Canqui  */

public class CommandExecutor {
    /**
     * @param comandString command
     * @return results command execution
     */
    private String exeCmd(String comandString) {
        String messaje = "";
        try {

            Process p = Runtime.getRuntime().exec("javac Printer.java", null, new File("C:/Users/Administrator/katas/src"));
            p = Runtime.getRuntime().exec(comandString, null, new File("C:/Users/Administrator/katas/src"));
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            while ((messaje = stdInput.readLine()) != null) {
                System.out.println("output: " + messaje);
            }

            while ((messaje = stdError.readLine()) != null) {
                System.out.println("error:" + messaje);
            }

            System.exit(0);
        } catch (IOException e) {
            System.out.println("exception: ");
            e.printStackTrace();
            System.exit(-1);
        }

        return messaje;
    }

}
