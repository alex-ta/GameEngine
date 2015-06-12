package com.engine.obs;

import com.math.Vector3D;

public class IntersectData {

	public IntersectData(boolean isIntersect, Vector3D distance) {
		this.isIntersect = isIntersect;
		this.distance = distance;
	}

	private boolean isIntersect;
	private Vector3D distance;

	public boolean isIntersect() {
		return isIntersect;
	}

	public void setIntersect(boolean isIntersect) {
		this.isIntersect = isIntersect;
	}

	public Vector3D getDistance() {
		return distance;
	}

	public void setDistance(Vector3D distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Distance: " + distance + " Intersects:" + isIntersect;
	}

}
