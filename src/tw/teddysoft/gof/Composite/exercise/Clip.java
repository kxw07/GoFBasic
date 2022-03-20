/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
package tw.teddysoft.gof.Composite.exercise;

import java.util.LinkedList;
import java.util.List;

public class Clip {
	List<Clip> clips = new LinkedList<>();
	List<Bullet> bullets = new LinkedList<>();
	public boolean addClip(Clip clip) {
		return clips.add(clip);
	}
	public boolean removeClip(Clip clip) {
		return clips.remove(clip);
	}
	public Clip getClip(int aIndex) {
		return clips.get(aIndex);
	}
	public boolean addBullet(Bullet bullet) {
		return bullets.add(bullet);
	}
	public boolean removeBullet(Bullet bullet) {
		return bullets.remove(bullet);
	}
	public Bullet getBullet(int aIndex) {
		return bullets.get(aIndex);
	}
	public void fire() {
		for(Bullet bullet : bullets){
			bullet.fire();
		}
		for(Clip clip : clips){
			clip.fire();
		}
	}
}
