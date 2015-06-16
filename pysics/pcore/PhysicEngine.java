package pcore;

import java.util.ArrayList;

import com.engine.obs.IntersectData;
import com.engine.rendering.objects.RenderingEngine;
import com.engine.scenegraph.GameComponent;
import com.engine.scenegraph.GameObject;
import com.engine.shader.Shader;
import com.math.Vector3D;

public class PhysicEngine extends GameObject{
	private static ArrayList<PhysicComponent> objs = new ArrayList<PhysicComponent>();
	
	public static void removeObject(PhysicComponent physicComponent) {
		objs.remove(physicComponent);
	}
	
	public PhysicComponent wrappObject(GameObject obj,Vector3D speed,Vector3D size,int type,int weight){
		PhysicComponent component = new PhysicComponent(obj,speed,size,type,weight);
		this.addComponent(component);
		return component;
	}
	
	public PhysicComponent wrappObject(GameObject obj,Vector3D speed,Vector3D size,int type){
		return this.wrappObject(obj, speed, size, type, 1);
	}

	private void collision(){
		for(int i =0; i< objs.size(); i++){
			for(int j = i+1; j< objs.size(); j++){
				IntersectData data = objs.get(i).intersects(objs.get(j));
				if(data.isIntersect()){
					float joule = (objs.get(i).getVelocity().mul(objs.get(i).getWeight()).abs().add(objs.get(j).getVelocity().mul(objs.get(j).getWeight()).abs())).dot(0.5f);
					Vector3D direction = data.getDistance().normalized();
					objs.get(i).collision(direction.normalized(),joule,objs.get(j).getWeight());
					objs.get(j).collision(direction.normalized(),joule,objs.get(i).getWeight());
				}
			}
		}
	}

	

	@Override
	public void input(float delta) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void update(float delta){
		for(PhysicComponent comp : objs){
			comp.update(delta);
		}
		collision();
	}
	
	@Override
	public void render(Shader shader, RenderingEngine engine) {
		// TODO Auto-generated method stub
	}

	@Override
	public GameObject addComponent(GameComponent component) {
		objs.add((PhysicComponent)component);
		return this;
	}
}
