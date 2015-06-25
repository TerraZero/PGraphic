package tz.pgraphic.components.api;

/**
 * 
 * @author terrazero
 * @created Dec 18, 2014
 * 
 * @file TransformInt.java
 * @project G7C
 * @identifier TZ.G7.Animation
 *
 */
public class GTransition {

	protected float value;
	
	protected float target;
	protected float speed;
	/**
	 * true  : this.target < this.value
	 * false : this.target > this.value
	 */
	protected boolean direction;
	
	public GTransition() {
		this.init();
	}
	
	public GTransition(float value) {
		this.init();
		this.set(value);
	}
	
	public void init() {
		this.speed = 1;
	}
	
	public GTransition speed(float speed) {
		this.speed = speed;
		this.direction = this.speed <= 0;
		return this;
	}
	
	public GTransition set(float value) {
		this.value = value;
		this.target = value;
		return this;
	}
	
	public GTransition ani(float target) {
		this.target = target;
		this.checkSpeed();
		return this;
	}
	
	private void checkSpeed() {
		boolean newDirection = this.target < this.value; 
		if (newDirection != this.direction) this.speed = -this.speed;
		this.direction = newDirection;
	}
	
	public float get() {
		return this.value;
	}
	
	public int getInt() {
		return (int)this.value;
	}
	
	public float target() {
		return this.target;
	}
	
	public int getTarget() {
		return (int)this.target;
	}
	
	public float speed() {
		return this.speed;
	}
	
	public boolean isTarget() {
		return this.target == this.value;
	}
	
	public void update(float delta) {
		if (this.target != this.value) {
			this.value += this.speed * delta;
			if (this.direction && this.target > this.value || !this.direction && this.target < this.value) this.value = this.target;
		}
	}
	
	/* 
	 * @see TZ.G7.GObj#toString()
	 */
	@Override
	public String toString() {
		return "[" + this.value + " -> " + this.target + " (" + this.speed + ")]";
	}
	
}
