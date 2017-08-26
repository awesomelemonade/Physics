package lemon.physics.newton;

import lemon.engine.math.Vector3D;
import lemon.physics.CollisionSystem;
import lemon.physics.PhysicsEntity;
import lemon.physics.QueuedDisplacement;

public class NewtonianCollisionSystem implements CollisionSystem<Vector3D> {
	@Override
	public float getPriority(PhysicsEntity<Vector3D> entityA, QueuedDisplacement<Vector3D> queuedDisplacementA,
			PhysicsEntity<Vector3D> entityB, QueuedDisplacement<Vector3D> queuedDisplacementB) {
		return 0;
	}
	@Override
	public void resolve(PhysicsEntity<Vector3D> entityA, QueuedDisplacement<Vector3D> queuedDisplacementA,
			PhysicsEntity<Vector3D> entityB, QueuedDisplacement<Vector3D> queuedDisplacementB) {
		
	}
}
