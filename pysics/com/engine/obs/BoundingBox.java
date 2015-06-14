package com.engine.obs;

import com.math.Vector3D;

public class BoundingBox extends Colider {
	
	
	public BoundingBox(Vector3D position, Vector3D size) {
		super(position,size,Colider.BOX);
	}

	@Override
	public IntersectData intersect(BoundingSphere other) {
		// getting the center distance positiv
		Vector3D centerDistance = other.getPosition().sub(this.getPosition()).abs();
		// adding the hull 
		Vector3D bounding = other.getCircles().add(this.getSize());
		// checking distance
		Vector3D distance = centerDistance.sub(bounding);
		return new IntersectData(distance.less(0),distance);
	}
	
	public IntersectData intersect(BoundingBox other) {
		// getting the center distance positiv
		Vector3D centerDistance = other.getPosition().sub(this.getPosition()).abs();
		// adding the hull 
		Vector3D bounding = other.getSize().add(this.getSize());
		// checking distance
		Vector3D distance = centerDistance.sub(bounding);
		return new IntersectData(distance.less(0),distance);
	}

}
