package lemon.physics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import lemon.engine.math.Vector;

public class EulerIntegrator<T extends Vector> implements Integrator<T> {
	private final Function<float[], T> supplier;
	public EulerIntegrator(Function<float[], T> supplier){
		this.supplier = supplier;
	}
	@Override
	public Map<PhysicsEntity<T>, QueuedDisplacement<T>> integrate(Set<PhysicsEntity<T>> entities, float delta) {
		Map<PhysicsEntity<T>, QueuedDisplacement<T>> queuedDisplacements = new HashMap<PhysicsEntity<T>, QueuedDisplacement<T>>();
		for(PhysicsEntity<T> entity: entities){
			queuedDisplacements.put(entity, new QueuedDisplacement<T>(entity.getVelocity().multiply(delta, supplier)));
		}
		return queuedDisplacements;
	}
}
