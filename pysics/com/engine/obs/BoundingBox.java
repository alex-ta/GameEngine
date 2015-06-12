package com.engine.obs;

import com.math.Vector3D;

public class BoundingBox extends Colider {
	
	private Vector3D halfSizePos;
	private Vector3D halfSizeMin;
	
	public BoundingBox(Vector3D position, Vector3D size) {
		super(position,size,Colider.RECT);
		halfSizePos = size.div(2);
		halfSizeMin = halfSizePos.mul(-1);
	}

	public Vector3D getHalfSizePos() {
		return halfSizePos;
	}

	public void setHalfSizePos(Vector3D halfSizePos) {
		this.halfSizePos = halfSizePos;
	}

	public Vector3D getHalfSizeMin() {
		return halfSizeMin;
	}

	public void setHalfSizeMin(Vector3D halfSizeMin) {
		this.halfSizeMin = halfSizeMin;
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
	
	public IntersectData intersect(BoundingBox other) {
		// does it work ?
		Vector3D colidePos = other.getPosition().add(other.getHalfSizePos()).sub(this.getHalfSizeMin());
		Vector3D colideMin = other.getPosition().add(other.getHalfSizeMin()).sub(this.getHalfSizePos());	
		IntersectData sect = new IntersectData(colidePos.greater(0)&&colideMin.less(0), getPosition().sub(other.getPosition()));
		return sect;
	}

}
