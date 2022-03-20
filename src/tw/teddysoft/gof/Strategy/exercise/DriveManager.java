/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Strategy.exercise;

public class DriveManager {
	public void format(FileSystemEnum fileSystem){
		switch(fileSystem){
		case NTFS: 
			formatNtfs();
			break;
		case FAT32: 
			formatFat32();
			break;			
		case FAT: 
			formatFat();
			break;				
		}
	}
	private void formatNtfs() {}
	private void formatFat32() {}
	private void formatFat() {}
}


