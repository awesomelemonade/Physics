package lemon.physics;

import java.util.Map;

import lemon.engine.math.Vector;

public interface CollisionSystem<T extends Vector> {
	/**
	 * Resolves using O(n^2); Not recommended
	 * @param queuedDisplacements Generated by an integrator
	 */
	public default void resolve(Map<PhysicsEntity<T>, QueuedDisplacement<T>> queuedDisplacements){
		while(true){
			float bestPriority = Integer.MAX_VALUE;
			PhysicsEntity<T> bestEntityA = null;
			PhysicsEntity<T> bestEntityB = null;
			for(PhysicsEntity<T> entityA: queuedDisplacements.keySet()){
				for(PhysicsEntity<T> entityB: queuedDisplacements.keySet()){
					if(!entityA.equals(entityB)){
						bestPriority = Math.min(bestPriority, getPriority(entityA, queuedDisplacements.get(entityA), entityB, queuedDisplacements.get(entityB)));
					}
				}
			}
			if(bestPriority==Integer.MAX_VALUE){
				break;
			}else{
				resolve(bestEntityA, queuedDisplacements.get(bestEntityA), bestEntityB, queuedDisplacements.get(bestEntityB));
			}
		}
	}
	/**
	 * Priority usually defined by time
	 * @param entityA
	 * @param queuedDisplacementA
	 * @param entityB
	 * @param queuedDisplacementB
	 * @return
	 */
	public float getPriority(PhysicsEntity<T> entityA, QueuedDisplacement<T> queuedDisplacementA,
			PhysicsEntity<T> entityB, QueuedDisplacement<T> queuedDisplacementB);
	public void resolve(PhysicsEntity<T> entityA, QueuedDisplacement<T> queuedDisplacementA,
			PhysicsEntity<T> entityB, QueuedDisplacement<T> queuedDisplacementB);
}
