package com.fundation.search.view;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Strings;

/**
 * Class created in order to show table console.
 */
public class ConsoleStringTable {

    /**
     * Index class to execute the table console.
     */
    private class Index {

        int row;
        int column;

        /**
         * Constructor method for the index.
         *
         * @param r is the row.
         * @param c is the column.
         */
        public Index(int r, int c) {
            row = r;
            column = c;
        }

        /**
         * Override method to know what the object is equals.
         *
         * @param obj the object.
         * @return boolean value depending the equality.
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Index other = (Index) obj;
            if (column != other.column)
                return false;
            if (row != other.row)
                return false;
            return true;
        }

        /**
         * Override method for the hashcode.
         *
         * @return the result for adding the columns and rows.
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + column;
            result = prime * result + row;
            return result;
        }
    }

    Map<Index, String> strings = new HashMap<>();
    Map<Integer, Integer> columSizes = new HashMap<>();

    int numRows = 0;
    int numColumns = 0;

    /**
     * Method to add the row, column and content in the console table.
     *
     * @param row     the position of the row.
     * @param column  the position of the column.
     * @param content the content of the row and column.
     */
    public void addString(int row, int column, String content) {
        numRows = Math.max(numRows, row + 1);
        numColumns = Math.max(numColumns, column + 1);

        Index index = new Index(row, column);
        strings.put(index, content);

        setMaxColumnSize(column, content);
    }

    /**
     * Method to set the maximun size for the column.
     *
     * @param column  the column.
     * @param content the content.
     */
    private void setMaxColumnSize(int column, String content) {
        int size = content.length();
        Integer currentSize = columSizes.get(column);
        if (currentSize == null || (currentSize != null && currentSize < size)) {
            columSizes.put(column, size);
        }
    }

    /**
     * Method to obtain the column size.
     *
     * @param colum the column of the console table.
     * @return the size of the column.
     */
    public int getColumSize(int colum) {
        Integer size = columSizes.get(colum);
        if (size == null) {
            return 0;
        } else {
            return size;
        }
    }

    /**
     * Method to obtain the string of the index.
     *
     * @param row   the row for the console table.
     * @param colum the column for the console table.
     * @return the string for setting the content.
     */
    public String getString(int row, int colum) {
        Index index = new Index(row, colum);
        String string = strings.get(index);
        if (string == null) {
            return "";
        } else {
            return string;
        }
    }

    /**
     * Method to obtain the table as a string.
     *
     * @param padding
     * @return
     */
    public String getTableAsString(int padding) {
        String out = "";
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numColumns; c++) {
                int columSize = getColumSize(c);
                String content = getString(r, c);
                int pad = c == numColumns - 1 ? 0 : padding;
                out += Strings.padEnd(content, columSize + pad, ' ');
            }
            if (r < numRows - 1) {
                out += "\n";
            }
        }
        return out;
    }

    /**
     * Override method to get the table as a string.
     *
     * @return the table as a string.
     */
    @Override
    public String toString() {
        return getTableAsString(1);
    }
}
