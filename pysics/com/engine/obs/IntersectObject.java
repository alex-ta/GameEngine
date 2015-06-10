package com.engine.obs;

import com.math.Vector3D;

public abstract class IntersectObject {

	private Colider type;
	
	public IntersectData intersects(IntersectObject other){
		switch(this.type){
		case BOX: 
			switch(other.type){
				case BOX:
					return ((BoundingBox) this).intersects((BoundingBox)other);
				case PLANE:
					break;
				case SIZE:
					break;
				case SPHERE:
					break;
				default:
					break;}
			break;
		case PLANE:switch(other.type){
				case BOX:
					break;
				case PLANE:
					break;
				case SIZE:
					break;
				case SPHERE:
					break;
				default:
					break;}
			break;
		case SIZE:switch(other.type){
				case BOX:
					break;
				case PLANE:
					break;
				case SIZE:
					break;
				case SPHERE:
					break;
				default:
					break;}
			break;
		case SPHERE:switch(other.type){
				case BOX:
					break;
				case PLANE:
					break;
				case SIZE:
					break;
				case SPHERE:
					return ((BoundingSphere)this).intersects((BoundingSphere)other);
				default:
					break;}
					break;
				default:
					break;}
		throw new NumberFormatException("not implemented");
	}

	IntersectObject(Colider col){
		this.type = col;
	}
	
	public Colider getType() {
		return type;
	}

	public void setType(Colider type) {
		this.type = type;
	}

}
