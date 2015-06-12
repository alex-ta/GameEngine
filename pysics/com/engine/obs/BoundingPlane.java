package com.engine.obs;

import com.math.Vector3D;

public class BoundingPlane extends Colider{

	public BoundingPlane(Vector3D position, Vector3D size) {
		super(position, size, Colider.PLANE);
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
