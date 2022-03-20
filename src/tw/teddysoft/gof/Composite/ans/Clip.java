/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Composite.ans;

import java.util.LinkedList;
import java.util.List;

public class Clip extends Weapon {
	List<Weapon> weapons = new LinkedList<>();
	@Override
	public boolean add(Weapon weapon) {
		return weapons.add(weapon);
	}
	@Override
	public boolean remove(Weapon weapon) {
		return weapons.remove(weapon);
	}
	@Override
	public Weapon getChild(int index) {
		return weapons.get(index);
	}
	@Override
	public void fire() {
		for(Weapon weapon : weapons){
			weapon.fire();
		}
	}
}
