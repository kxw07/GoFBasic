/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.TemplateMethod.ans;

/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
public class FileConfigParser extends ConfigParser{
	private String fileName = null;
	public FileConfigParser(String aFileName){
		fileName = aFileName;
	}
	@Override
	protected void readData() {
		System.out.println("Read config data "
				+ "from file: " + fileName);
	}
	@Override
	protected void parseToken() {
		System.out.println("parseToken...");
	}
	@Override
	protected void buildModel() {
		personData = new PersonData();
		personData.setName("Teddy");
		personData.setHP(100);
	}
	@Override
	protected void validate() {
		System.out.println("validate config data "
				+ "built from file...");
	}
}
