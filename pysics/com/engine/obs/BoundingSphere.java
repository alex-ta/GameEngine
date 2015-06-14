package com.engine.obs;

import com.math.Vector3D;

public class BoundingSphere extends Colider {

	private Vector3D circles;
	
	public BoundingSphere(Vector3D position, Vector3D size) {
		super(position, size, Colider.SPHERE);
		float base = (float)Math.PI;
		setCircles(new Vector3D(base*size.x*size.x,base*size.y*size.y,base*size.z*size.z));
	}

	@Override
	public IntersectData intersect(BoundingBox other) {
		// getting the center distance positiv
		Vector3D centerDistance = other.getPosition().sub(this.getPosition()).abs();
		// adding the hull 
		Vector3D bounding = other.getSize().add(this.getCircles());
		// checking distance
		Vector3D distance = centerDistance.sub(bounding);
		return new IntersectData(distance.less(0),distance);
	}

	@Override
	public IntersectData intersect(BoundingSphere other) {
		// getting the center distance positiv
		Vector3D centerDistance = other.getPosition().sub(this.getPosition()).abs();
		// adding the hull 
		Vector3D bounding = other.getCircles().add(this.getCircles());
		// checking distance
		Vector3D distance = centerDistance.sub(bounding);
		return new IntersectData(distance.less(0),distance);
	}

	public Vector3D getCircles() {
		return circles;
	}

	public void setCircles(Vector3D circles) {
		this.circles = circles;
	}
}
