package com.engine.obs;

import com.math.Vector3D;

public class BoundingBox implements IntersectObject {

	private Vector3D minExtends, maxExtends;

	public BoundingBox(Vector3D minExtend, Vector3D maxExtend) {
		this.minExtends = minExtend;
		this.maxExtends = maxExtend;
	}

	public IntersectData intersects(BoundingBox other) {
		Vector3D distance1 = other.getMinExtends().sub(this.getMaxExtends());
		Vector3D distance2 = this.getMinExtends().sub(other.getMaxExtends());
		Vector3D distance = distance1.max(distance2);

		float maxDistance = distance.max();

		return new IntersectData(maxDistance < 0, maxDistance);

	}

	public Vector3D getMinExtends() {
		return minExtends;
	}

	public void setMinExtends(Vector3D minExtends) {
		this.minExtends = minExtends;
	}

	public Vector3D getMaxExtends() {
		return maxExtends;
	}

	public void setMaxExtends(Vector3D maxExtends) {
		this.maxExtends = maxExtends;
	}

}
