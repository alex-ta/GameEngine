package pcore;

import com.engine.obs.Colider;
import com.engine.obs.IntersectData;
import com.engine.rendering.objects.RenderingEngine;
import com.engine.scenegraph.GameComponent;
import com.engine.shader.Shader;
import com.math.Vector3D;

public class PhysicComponent extends GameComponent{
	private Vector3D position;
	private Vector3D velocity;
	private Colider intersects;

	public PhysicComponent(Vector3D position, Vector3D velocity,Colider insect) {
		super();
		PhysicObjects.addObject(this);
		this.setPosition(position);
		this.velocity = velocity;
		this.intersects = insect;
	}

	public Vector3D getPosition() {
		return position;
	}

	public void setPosition(Vector3D position) {
		this.position = position;
	}

	public Vector3D getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector3D velocity) {
		this.velocity = velocity;
	}

	public void integrate(float delta) {
		position = this.position.add(this.velocity.mul(delta));
	}
	
	@Override
	public void input(float delta) {
		this.integrate(delta);
	}

	@Override
	public void update(float delta) {
		this.getTransform().setPos(this.getPosition());
		intersects.update(position);
	}

	@Override
	public void render(Shader shader, RenderingEngine engine) {
		// TODO Auto-generated method stub
		
	}

	public Colider getIntersect() {
		return intersects;
	}

	public IntersectData intersects(PhysicComponent obj) {
		return getIntersect().intersects(obj.getIntersect());
	}
	
	public GameObject wrappObject(GameObject obj){
		// TODO
		
	}
	

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		PhysicObjects.removeObject(this);
	}
	

}
