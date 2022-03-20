/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Composite.ans;

public abstract class Weapon {
	public abstract boolean add(Weapon weapon);
	public abstract boolean remove(Weapon weapon);
	public abstract Weapon getChild(int index);
	public abstract void fire();
}
