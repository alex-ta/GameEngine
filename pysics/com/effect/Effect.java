package com.effect;

import pcore.PhysicComponent;
import com.math.Vector3D;

public class Effect {
	
	public void collision(PhysicComponent obj,Vector3D normal,float joule,float weight){
		obj.setVelocity(obj.getVelocity().reflect(normal));
		// quickfix
		obj.setVelocity(obj.getVelocity().mul(weight/joule));
	}

}
