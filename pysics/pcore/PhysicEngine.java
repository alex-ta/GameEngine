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
		/**add Physic and scales Object*/
		obj.getTransform().setScale(obj.getTransform().getScale().mul(size.mul(2)));
		return this.wrappObject(obj, speed, size, type, 1);
	}

	private void collision(){
		for(int i =0; i< objs.size(); i++){
			for(int j = i+1; j< objs.size(); j++){
				IntersectData data = objs.get(i).intersects(objs.get(j));
				if(data.isIntersect()){
					PhysicComponent obj1 = objs.get(i);
					PhysicComponent obj2 = objs.get(j);
					float joule = (obj1.getVelocity().mul(obj1.getWeight()).abs().add(obj2.getVelocity().mul(obj2.getWeight()).abs())).dot(0.1f);
					Vector3D direction = data.getDistance().normalized();
						obj1.collision(direction.normalized(),obj2.getWeight(),joule);
						obj2.collision(direction.normalized(),obj1.getWeight(),joule);
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
