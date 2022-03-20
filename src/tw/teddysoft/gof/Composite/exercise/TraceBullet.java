/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Composite.exercise;

public class TraceBullet  extends Bullet {
	@Override
	public void fire() {
		System.out.println("發射追蹤子彈.");
	}
}
