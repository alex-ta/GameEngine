package pcore;
import com.engine.obs.Colider;
import com.engine.obs.IntersectData;
import com.engine.rendering.objects.RenderingEngine;
import com.engine.scenegraph.GameComponent;
import com.engine.scenegraph.GameObject;
import com.engine.shader.Shader;
import com.math.Vector3D;

public class PhysicComponent extends GameComponent{
	private GameObject wrapped;
	private Vector3D velocity;
	private Colider intersects;

	public PhysicComponent(GameObject wrapped, Vector3D velocity, Vector3D size, int type) {
		super();
		this.setWrapped(wrapped);
		this.velocity = velocity;
		this.intersects = Colider.createInstance(wrapped.getTransform().getPos(), size, type);
	}

	public GameObject getWrapped() {
		return wrapped;
	}

	public void setWrapped(GameObject wrapped) {
		this.wrapped = wrapped;
	}

	public Vector3D getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector3D velocity) {
		this.velocity = velocity;
	}
	
	public Colider getIntersect() {
		return intersects;
	}
	
	@Override
	public void input(float delta) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(float delta) {
		Vector3D newPos = wrapped.getTransform().getPos().add(this.velocity.mul(delta));
		wrapped.getTransform().setPos(newPos);
		intersects.setPosition(newPos);
	}

	@Override
	public void render(Shader shader, RenderingEngine engine) {
		// TODO Auto-generated method stub
	}

	public IntersectData intersects(PhysicComponent obj) {
		return getIntersect().intersects(obj.getIntersect());
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		PhysicEngine.removeObject(this);
	}
	

}
