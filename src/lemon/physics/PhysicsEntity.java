package lemon.physics;

import lemon.engine.math.Vector;

public interface PhysicsEntity<T extends Vector> {
	public T getPosition();
	public T getVelocity();
	public float getMass();
	public default void applyForce(T force){
		if(this.getMass()==Float.MAX_VALUE){ //Infinite Mass (fixed structure)
			return; //Not Moving
		}
		//Newton's 2nd Law: F = m * a
		this.getVelocity().set(this.getVelocity().add(force.divide(this.getMass())));
	}
}
