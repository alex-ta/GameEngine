package com.effect;

import pcore.PhysicComponent;
import com.math.Vector3D;

public class Effect {
	
	public void collision(PhysicComponent obj,Vector3D normal,float weight,float joule){
		this.collision(obj, normal, weight/joule);
	}
	
	public void collision(PhysicComponent obj,Vector3D normal,float joule){
		obj.setVelocity(obj.getVelocity().reflect(normal));
		obj.setVelocity(obj.getVelocity().mul(joule));
	}

}
