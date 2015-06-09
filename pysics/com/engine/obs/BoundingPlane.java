package com.engine.obs;

import com.math.Vector3D;

public class BoundingPlane {

	private Vector3D normal;
	private float distance;

	public BoundingPlane(Vector3D normal, float distance) {
		this.normal = normal;
		this.distance = distance;
	}

	public BoundingPlane normalized() {
		float magnitude = normal.length();
		return new BoundingPlane(normal.div(magnitude), distance / magnitude);
	}

	public IntersectData intersects(BoundingSphere other) {
		float distance = (float) Math
				.abs((normal.dot(other.getPoint()) + this.distance))
				- other.getRadius();
		return new IntersectData(distance < 0, distance);
	}

	public Vector3D getNormal() {
		return normal;
	}

	public void setNormal(Vector3D normal) {
		this.normal = normal;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

}
