package com.engine.obs;

import com.math.Vector3D;

public class BoundingSphere extends IntersectObject {

	private Vector3D point;
	private float radius;

	public IntersectData intersects(BoundingSphere other) {
		float radDist = this.getRadius() + other.getRadius();
		float centerDist = other.getPoint().sub(this.getPoint()).length();
		float distance = centerDist - radDist;
		return new IntersectData(centerDist < radDist, distance);
	}

	public BoundingSphere(Vector3D point, float radius) {
		super(Colider.SPHERE);
		this.point = point;
		this.radius = radius;
	}

	public Vector3D getPoint() {
		return point;
	}

	public void setPoint(Vector3D point) {
		this.point = point;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}
}
