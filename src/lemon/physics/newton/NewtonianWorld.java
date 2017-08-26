package lemon.physics.newton;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lemon.engine.math.Vector3D;
import lemon.physics.CollisionSystem;
import lemon.physics.EulerIntegrator;
import lemon.physics.Integrator;
import lemon.physics.PhysicsEntity;
import lemon.physics.QueuedDisplacement;
import lemon.physics.World;

//Euler3DWorld?
public class NewtonianWorld implements World<Vector3D> {
	
	public static final Vector3D GRAVITY = Vector3D.unmodifiableVector(new Vector3D(0, -9.8f, 0)); //Acceleration (9.8 m/s^2)
	private Set<PhysicsEntity<Vector3D>> entities;
	
	private Integrator<Vector3D> integrator;
	private CollisionSystem<Vector3D> collisionSystem;
	
	public NewtonianWorld(){
		entities = new HashSet<PhysicsEntity<Vector3D>>();
		integrator = new EulerIntegrator<Vector3D>(Vector3D.supplier); //Euler Integration
		collisionSystem = new NewtonianCollisionSystem();
	}
	@Override
	public void update(float delta) {
		for(PhysicsEntity<Vector3D> entity: entities){
			//Add Gravity
			entity.getVelocity().set(entity.getVelocity().add(GRAVITY.multiply(delta)));
		}
		Map<PhysicsEntity<Vector3D>, QueuedDisplacement<Vector3D>> queuedDisplacements = integrator.integrate(entities, delta);
		
		collisionSystem.resolve(queuedDisplacements);
		
		//Apply Displacements
		for(PhysicsEntity<Vector3D> entity: queuedDisplacements.keySet()){
			entity.getPosition().set(entity.getPosition().add(queuedDisplacements.get(entity).getDisplacement()));
		}
	}
	@Override
	public Set<PhysicsEntity<Vector3D>> getEntities() {
		return entities;
	}
}
