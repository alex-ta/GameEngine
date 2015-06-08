package com.engine.obs;

public class IntersectData {
	
	public IntersectData(boolean isIntersect, float distance){
		this.isIntersect = isIntersect;
		this.distance = distance;
	}

	private boolean isIntersect;
	private float distance;
	
	
	public boolean isIntersect() {
		return isIntersect;
	}
	public void setIntersect(boolean isIntersect) {
		this.isIntersect = isIntersect;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	
	@Override
	public String toString(){
		return "Distance: "+distance+" Intersects:"+isIntersect;
	}
	
}
