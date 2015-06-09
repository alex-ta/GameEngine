package pcore;

import com.engine.obs.BoundingBox;
import com.engine.obs.IntersectData;
import com.engine.obs.IntersectObject;
import com.engine.rendering.objects.RenderingEngine;
import com.engine.scenegraph.GameComponent;
import com.engine.shader.Shader;
import com.math.Vector3D;

public class PhysicComponent extends GameComponent{
	private Vector3D position;
	private Vector3D velocity;
	private IntersectObject intersect;

	public PhysicComponent(Vector3D position, Vector3D velocity) {
		super();
		PhysicObjects.addObject(this);
		this.setPosition(position);
		this.velocity = velocity;
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
	}

	@Override
	public void render(Shader shader, RenderingEngine engine) {
		// TODO Auto-generated method stub
		
	}

	public BoundingBox getIntersect() {
		return new BoundingBox(position, new Vector3D(8f,8f,8f));
	}

	
	//public IntersectData intersects(PhysicComponent obj) {
	//	return obj.intersect.intersects(obj.getIntersect());
	//}

}
