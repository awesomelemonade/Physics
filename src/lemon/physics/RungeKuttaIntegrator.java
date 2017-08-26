package lemon.physics;

import java.util.Map;
import java.util.Set;

import lemon.engine.math.Vector;

public class RungeKuttaIntegrator<T extends Vector> implements Integrator<T> {
	@Override
	public Map<PhysicsEntity<T>, QueuedDisplacement<T>> integrate(Set<PhysicsEntity<T>> entities, float delta) {
		//TODO
		return null;
	}
}
