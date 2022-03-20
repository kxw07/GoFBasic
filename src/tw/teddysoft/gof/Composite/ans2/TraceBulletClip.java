/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Composite.ans2;

public class TraceBulletClip extends Clip {
	@Override
	public boolean add(Weapon weapon) {
		if (weapon instanceof TraceBullet || 
				weapon instanceof TraceBulletClip)
			return super.add(weapon);
		else
			throw new RuntimeException("只能裝填追蹤子彈或追蹤彈匣，但卻裝填 :" 
					+ weapon.toString());
	}
}
