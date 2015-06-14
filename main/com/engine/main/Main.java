package com.engine.main;


import com.engine.components.MeshRenderer;
import com.engine.core.CoreEngine;
import com.engine.obs.BoundingBox;
import com.engine.obs.BoundingSphere;
import com.engine.obs.IntersectData;
import com.engine.rendering.objects.Material;
import com.engine.rendering.objects.Mesh;
import com.engine.rendering.objects.Texture;
import com.engine.scenegraph.GameObject;
import com.math.Vector3D;

public class Main
{
	public static void main(String[] args){
		
//	{
//		BoundingSphere s1 = new BoundingSphere(new Vector3D(0f,0f,0f),1f);
//		BoundingSphere s2 = new BoundingSphere(new Vector3D(0f,3f,0f),1f);
//		BoundingSphere s3 = new BoundingSphere(new Vector3D(0f,0f,2f),1f);
//		BoundingSphere s4 = new BoundingSphere(new Vector3D(1f,0f,0f),1f);
//				
//				
//		IntersectData s1d = s1.intersects(s2);
//		IntersectData s2d = s1.intersects(s3);
//		IntersectData s3d = s1.intersects(s4);
//				
//		BoundingBox b1 = new BoundingBox(new Vector3D(0f,0f,0f),new Vector3D(1f,1f,1f));
//		BoundingBox b2 = new BoundingBox(new Vector3D(2f,2f,2f),new Vector3D(1f,2f,1f));
//		BoundingBox b3 = new BoundingBox(new Vector3D(2f,2f,2f),new Vector3D(0.5f,0.5f,0.5f));
//		BoundingBox b4 = new BoundingBox(new Vector3D(2f,3f,2f),new Vector3D(0f,2f,0f));
//		BoundingBox b5 = new BoundingBox(new Vector3D(-3f,-3f,-3f),new Vector3D(2f,2f,2f));
//		
//		
//		
//		
//		IntersectData s1d = b1.intersects(b2);
//		IntersectData s2d = b1.intersects(b3);
//		IntersectData s3d = b1.intersects(b4);
//		IntersectData s4d = b1.intersects(b5);
//		
//		System.out.println(s1d+"\r\n"+s2d+"\r\n"+s3d+"\r\n"+s4d);
//		
		TestGame game = new TestGame();
		CoreEngine engine = new CoreEngine(800, 600, 60, game);
		engine.createWindow("3D Game Engine");
		engine.start();
		
		
	}
}
