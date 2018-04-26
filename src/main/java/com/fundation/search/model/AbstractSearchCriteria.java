package com.fundation.search.model;

public abstract class AbstractSearchCriteria {

    public abstract String getCodec();

    public abstract void setCodec(String codec);

    public abstract String getFrameRate();

    public abstract void setFrameRate(String frameRate);

    public abstract int getBitRate();

    public abstract void setBitRate(int bitRate);

    public abstract String getVideoSize();

    public abstract void setVideoSize(String videoSize);

    public abstract String getAspectRatio();

    public abstract void setAspectRatio(String aspectRatio);

    public abstract double getMinorDuration();

    public abstract void setMinorDuration(double minorDuration);

    public abstract double getMajorDuration();

    public abstract void setMajorDuration(double majorDuration);

    public abstract void setSearchCriteriaName(String searchCriteriaName);

    public abstract void setName(String name);

    public abstract void setPath(String path);

    public abstract void setHidden(String hidden);

    public abstract void setReadOnly(String readOnly);

    public abstract void setTypeFile(int setTypeFile);

    public abstract void setNameFileCaseSensitive(boolean nameFileCaseSensitive);

    public abstract void setOwner(String owner);

    public abstract void setExtension(String extension);

    public abstract void setSizeSign(String sizeSign);

    public abstract void setSizeRequired(String sizeRequired);

    public abstract void setSizeMeasure(String sizeMeasure);

    public abstract void setCreateDate(boolean createDate);

    public abstract void setModifiedDate(boolean modifiedDate);

    public abstract void setAccessedDate(boolean accessedDate);

    public abstract void setFromDate(String fromDate);

    public abstract void setToDate(String toDate);

    public abstract void setContent(String content);

    public abstract void setContentCaseSensitive(boolean contentCaseSensitive);

    public abstract String getSearchCriteriaName();

    public abstract String getName();

    public abstract String getPath();

    public abstract String getHidden();

    public abstract String getReadOnly();

    public abstract int getTypeFile();

    public abstract boolean getNameFileCaseSensitive();

    public abstract String getOwner();

    public abstract String getExtension();

    public abstract String getSizeSign();

    public abstract String getSizeRequired();

    public abstract String getSizeMeasure();

    public abstract boolean getCreatedDate();

    public abstract boolean getModifiedDate();

    public abstract boolean getAccessedDate();

    public abstract String getFromDate();

    public abstract String getToDate();

    public abstract String getContent();

    public abstract boolean getContentCaseSensitive();
}
