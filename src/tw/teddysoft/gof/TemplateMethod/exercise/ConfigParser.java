/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 *
 */
package tw.teddysoft.gof.TemplateMethod.exercise;

public abstract class ConfigParser {
    PersonData pData = null;
    private final String fileName;

    ConfigParser(String aFileName) {
        fileName = aFileName;
    }

    public final PersonData doParse() {
        readConfigFromFile(fileName);
        parseToken();
        pData = buildModel();
        validate();
        return pData;
    }

    protected void readConfigFromFile(String aFileName) {
    }

    protected void parseToken() {
    }

    abstract PersonData buildModel();

    protected void validate() {
    }
}
