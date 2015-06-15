package com.effect;

import pcore.PhysicComponent;
import com.math.Vector3D;

public class Effect {
	
	public void collision(PhysicComponent obj,Vector3D normal,int otherWeight){
		obj.setVelocity(obj.getVelocity().reflect(normal));
	}

}
