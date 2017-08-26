package lemon.physics;

import java.util.Set;

import lemon.engine.math.Vector;

public interface World<T extends Vector> {
	public Set<PhysicsEntity<T>> getEntities();
	public void update(float delta);
}
