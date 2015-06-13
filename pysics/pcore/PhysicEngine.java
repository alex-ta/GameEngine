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
	
	private void collision(){
		for(int i =0; i< objs.size(); i++){
			for(int j = i+1; j< objs.size(); j++){
				IntersectData data = objs.get(i).intersects(objs.get(j));
				// does not work propably
				if(data.isIntersect()){
					System.out.println("intersects"+ data.isIntersect());
					Vector3D direction = data.getDistance().normalized();
					Vector3D oDirection = direction.reflect(objs.get(i).getVelocity());
					objs.get(i).setVelocity(objs.get(i).getVelocity().reflect(direction));
					objs.get(j).setVelocity(objs.get(j).getVelocity().reflect(oDirection));
				}
			}
		}
	}

	@Override
	public void update(float delta){
		for(PhysicComponent comp : objs){
			comp.update(delta);
		}
		collision();
	}

	@Override
	public void input(float delta) {
		for(PhysicComponent comp : objs){
			comp.input(delta);
		}
	}

	@Override
	public void render(Shader shader, RenderingEngine engine) {
		// TODO Auto-generated method stub
	}

	public static void removeObject(PhysicComponent physicComponent) {
		objs.remove(physicComponent);
	}
	
	public GameObject wrappObject(GameObject obj,Vector3D speed,Vector3D size,int type){
		PhysicComponent component = new PhysicComponent(obj,speed,size,type);
		this.addComponent(component);
		return obj;
	}

	@Override
	public GameObject addComponent(GameComponent component) {
		objs.add((PhysicComponent)component);
		return this;
	}
}
