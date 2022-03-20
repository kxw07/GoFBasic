/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Strategy.ans;

public class DriveManager {
	public void format(String fileSystem){
		createFormater(fileSystem).execute();
	}
	private  Formater createFormater(String fileSystem)  {
		String fullyQualifiedName = "tw.teddysoft.gof.Strategy.ans." + fileSystem;
		try {
			Formater formater = (Formater) 
					Class.forName(fullyQualifiedName).newInstance();
			return formater;
		} catch (Exception e) {
			throw new RuntimeException("Cannot create formater.", e);
		}
	}	
}
