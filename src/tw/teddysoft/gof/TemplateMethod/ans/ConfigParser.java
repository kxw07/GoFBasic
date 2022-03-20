/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.TemplateMethod.ans;

public abstract class ConfigParser {
	protected PersonData personData = null;
	public final PersonData doParse(){
		readData();
		parseToken();
		buildModel();
		validate();
		return personData;
	}
	abstract protected void readData();
	abstract protected void parseToken();
	abstract protected void buildModel();
	abstract protected void validate();
}
