/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Composite.ans2;

import java.util.LinkedList;
import java.util.List;

public class Clip extends Weapon {
	List<Weapon> weapons = new LinkedList<>();
	public boolean add(Weapon weapon) {
		return weapons.add(weapon);
	}
	public boolean remove(Weapon weapon) {
		return weapons.remove(weapon);
	}
	public Weapon getChild(int index) {
		return weapons.get(index);
	}
	public void fire() {
		for(Weapon weapon : weapons){
			weapon.fire();
		}
	}
}
