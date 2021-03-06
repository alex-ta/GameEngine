package com.effect;

import pcore.PhysicComponent;

import com.math.Vector3D;

public class Reflect extends Effect {
	
	public void collision(PhysicComponent obj,Vector3D normal,float joule){
		obj.setVelocity(obj.getVelocity().reflect(normal));
		// quickfix
		obj.setVelocity(obj.getVelocity().mul(-joule));
	}
}
