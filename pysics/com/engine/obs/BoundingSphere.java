package com.engine.obs;

import com.math.Vector3D;

public class BoundingSphere extends Colider {

	public BoundingSphere(Vector3D position, Vector3D size) {
		super(position, size, Colider.SPHERE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public IntersectData intersect(BoundingBox other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IntersectData intersect(BoundingPlane other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IntersectData intersect(BoundingSphere other) {
		// TODO Auto-generated method stub
		return null;
	}

}
