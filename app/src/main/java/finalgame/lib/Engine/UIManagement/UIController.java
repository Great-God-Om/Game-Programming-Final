package finalgame.lib.Engine.UIManagement;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

public class UIController {
	public static ArrayList<UIElement> uiElementsToRender = new ArrayList<UIElement>();
	
	/** 
	 * @param gl
	 */
	public static void render(GL2 gl){
		for(UIElement elem : uiElementsToRender){
			elem.render(gl);
		}
	}
}
