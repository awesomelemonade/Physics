package lemon.physics;

import java.util.Map;
import java.util.Set;

import lemon.engine.math.Vector;

public interface Integrator<T extends Vector> {
	public Map<PhysicsEntity<T>, QueuedDisplacement<T>> integrate(Set<PhysicsEntity<T>> entities, float delta);
}
