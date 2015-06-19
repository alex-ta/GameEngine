package com.effect;

import pcore.PhysicComponent;

import com.math.Vector3D;

public class Throught  extends Effect{

	public void collision(PhysicComponent obj,Vector3D normal,float joule){
		obj.setVelocity(obj.getVelocity().mul(joule));
	}
	
	
}
