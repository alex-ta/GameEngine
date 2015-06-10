package com.engine.obs;

import com.math.Vector3D;

public class BoundingSphere extends IntersectObject {

	private float radius;

	public IntersectData intersects(BoundingSphere other) {
		float radDist = this.getRadius() + other.getRadius();
		float centerDist = other.getPosition().sub(this.getPosition()).length();
		float distance = centerDist - radDist;
		return new IntersectData(centerDist < radDist, distance);
	}

	public BoundingSphere(Vector3D point, float radius) {
		super(Colider.SPHERE);
		this.setPosition(point);
		this.radius = radius;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}
}
