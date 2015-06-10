package pcore;

import java.util.ArrayList;
import java.util.LinkedList;

import com.engine.obs.IntersectData;
import com.engine.rendering.objects.RenderingEngine;
import com.engine.scenegraph.GameComponent;
import com.engine.scenegraph.GameObject;
import com.engine.shader.Shader;

public class PhysicObjects extends GameObject{
	private static ArrayList<PhysicComponent> objs = new ArrayList<PhysicComponent>();

	public static void addObject(PhysicComponent obj) {
		objs.add(obj);
	}
	
	private void collision(){
		for(int i =0; i< objs.size(); i++){
			for(int j = i+1; j< objs.size(); j++){
				IntersectData data = objs.get(i).intersects(objs.get(j));
				if(data.isIntersect()){
					objs.get(i).setVelocity(objs.get(i).getVelocity().mul(-1));
					objs.get(j).setVelocity(objs.get(j).getVelocity().mul(-1));
				}
			}
		}
	}

	@Override
	public void update(float delta){
		collision();
	}

	@Override
	public void input(float delta) {
	}

	@Override
	public void render(Shader shader, RenderingEngine engine) {
		// TODO Auto-generated method stub
		
	}

	public static void removeObject(PhysicComponent physicComponent) {
		objs.remove(physicComponent);
	}
	
}
