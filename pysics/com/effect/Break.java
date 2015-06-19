package com.effect;

import pcore.PhysicComponent;

import com.math.Vector3D;

public class Break extends Effect{

	public void collision(PhysicComponent obj,Vector3D normal,float joule){
		obj.setWeight(0);
		obj.breakup();
	
	}
	
}
