/**
 * @(#)AssetFactory.java April, 11th 2018
 * Copyright (c) 2018 Jala Foundation.
 * Cochabamba, Bolivia.
 * Project Search for Prog102.
 */
package com.fundation.search.model;

public class AssetFactory {
    public Asset getAsset(String assetType, String path, String fileName, boolean hidden, double duration) {
        if (assetType == null) {
            return null;
        }
        if (assetType.equalsIgnoreCase("file")) {
            return new ResultFile(path, fileName, hidden);
        }
        if (assetType.equalsIgnoreCase("multimedia")) {
            return new ResultMultimediaFile(path, fileName, hidden, duration);
        }
        if (assetType.equalsIgnoreCase("directory")) {
            return new ResultDirectory(path, fileName, hidden);
        }
        return null;
    }
}
