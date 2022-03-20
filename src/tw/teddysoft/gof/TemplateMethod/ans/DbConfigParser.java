/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.TemplateMethod.ans;

/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
public class DbConfigParser extends ConfigParser{
	private String connStr = null;
	public DbConfigParser(String connStr){
		this.connStr = connStr;
	}
	@Override
	protected void readData() {
		System.out.println("Read config data "
				+ "from database: " + connStr);
	}
	@Override
	protected void parseToken() {
		System.out.println("parseToken...");
	}
	@Override
	protected void buildModel() {
		personData = new PersonData();
		personData.setName("Kay");
		personData.setHP(100);
	}
	@Override
	protected void validate() {
		System.out.println("validate config data "
				+ "built from database...");
	}
}
