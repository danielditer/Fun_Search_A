/**
 * @(#)ResultMultimediaFile.java  04/12/18.
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

/**
 * Class to store results if a multimedia file is found while searching.
 * @version April, 12th  * @Manuel Valdez
 */
public class ResultMultimediaFile extends Asset {

    /**
     * duration attribute to know its duration (hour minute second)
     */
    private double duration;

    /**
     * Constructor for this class, recieves the same as the father class,
     * it sends them with super and sets its own attribute duration
     * @param path the path of the file.
     * @param fileName the name of the file.
     * @param hidden if the file is hidden or not.
     * @param duration hour minute second of file.
     */
    public ResultMultimediaFile(String path, String fileName, boolean hidden, double duration, int typeFile) {
        super(path, fileName, hidden, true, typeFile);
        this.duration = duration;
    }

    /**
     * Getter of duration attribute.
     * @return  the attribute with values.
     */
    public double getDuration() {
        return this.duration;
    }
}
