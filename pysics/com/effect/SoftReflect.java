package com.effect;

import pcore.PhysicComponent;

import com.math.Vector3D;

public class SoftReflect extends Effect{

	@Override
	public void collision(PhysicComponent obj, Vector3D normal, float weight,
			float joule) {
		if(obj.getWeight()>weight){
			joule *= -1;
		}
		obj.setVelocity(obj.getVelocity().reflect(normal));
		obj.setVelocity(obj.getVelocity().mul(joule));
	}

	
}
