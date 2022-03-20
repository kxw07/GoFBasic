package tw.teddysoft.gof.Composite.ans;

public abstract class Bullet extends Weapon {
	@Override
	public boolean add(Weapon weapon) {
		throw new RuntimeException("Operation is not supported.");
	}
	@Override
	public boolean remove(Weapon weapon) {
		throw new RuntimeException("Operation is not supported.");
	}
	@Override
	public Weapon getChild(int aIndex) {
		throw new RuntimeException("Operation is not supported.");
	}
}
