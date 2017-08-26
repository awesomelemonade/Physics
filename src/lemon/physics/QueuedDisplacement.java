package lemon.physics;

import lemon.engine.math.Vector;

public class QueuedDisplacement<T extends Vector> {
	private T displacement;
	private float timespan;
	public QueuedDisplacement(T displacement){
		this(displacement, 1f);
	}
	public QueuedDisplacement(T displacement, float timespan){
		this.displacement = displacement;
		this.timespan = timespan;
	}
	public T getDisplacement(){
		return displacement;
	}
	public float getTimespan(){
		return timespan;
	}
}
