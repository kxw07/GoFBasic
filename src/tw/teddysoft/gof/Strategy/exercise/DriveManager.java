/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Strategy.exercise;

public class DriveManager {
	public void format(FileSystemEnum fileSystem){
		createFormatter(fileSystem).format();
	}

	private Formatter createFormatter(FileSystemEnum fileSystem) {
		switch(fileSystem){
			case NTFS:
				return new NTFSFormatter();
			case FAT32:
				return new FAT32Formatter();
			case FAT:
				return new FATFormatter();
			default:
				throw new RuntimeException("Unsupported type");
		}
	}
}


