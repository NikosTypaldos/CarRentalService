package ApalakthkhErgasiaJava.src.gui;

import javafx.scene.Scene;

	
public abstract class SceneCreator {
	double width,height;
	
	public SceneCreator(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	abstract Scene createScene();
	public SceneCreator(){}

}
