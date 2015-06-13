package com.engine.obs;

import com.math.Transform;
import com.math.Vector3D;

public abstract class Colider {

	public static final int RECT =0;
	public static final int SPHERE =1;
	public static final int PLANE =2;
	
	private Vector3D position;
	private Vector3D size;
	private int type;
	
	protected Colider (Vector3D position,Vector3D size, int type){
		this.position = position;
		this.size = size;
		this.type = type;
	}
	
	public abstract IntersectData intersect(BoundingBox other);
	public abstract IntersectData intersect(BoundingPlane other);
	public abstract IntersectData intersect(BoundingSphere other);
	
	public IntersectData intersects(Colider other){
		switch(other.type){
		case RECT: return this.intersect((BoundingBox)other);
		case SPHERE: return this.intersect((BoundingSphere)other);
		case PLANE: return this.intersect((BoundingPlane)(other));
		default:
			throw new NumberFormatException(type+" not supported");
		}
	}
	
	public static Colider createInstance(Vector3D position,Vector3D size, int type){
		switch(type){
		case RECT: return new BoundingBox(position,size);
		case SPHERE: return new BoundingSphere(position,size);
		case PLANE: return new BoundingPlane(position,size);
		default:
			throw new NumberFormatException(type+" not supported");
		}
	}
	
	public Vector3D getPosition() {
		return position;
	}

	public Vector3D getSize() {
		return size;
	}

	public void setSize(Vector3D size) {
		this.size = size;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
