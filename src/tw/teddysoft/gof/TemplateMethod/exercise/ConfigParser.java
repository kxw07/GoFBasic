/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.TemplateMethod.exercise;

public class ConfigParser {
	PersonData pData = null;
	private String fileName = null;
	
	ConfigParser(String aFileName){
		fileName = aFileName;
	}
	
	public PersonData doParse(){
		readConfigFromFile(fileName);
		parseToken();
		pData = buildModel();
		validate();
		return pData;
	}
	
	private void readConfigFromFile(String aFileName){}
	private void parseToken(){}
	private PersonData buildModel(){return null;}
	private void validate(){}
}
