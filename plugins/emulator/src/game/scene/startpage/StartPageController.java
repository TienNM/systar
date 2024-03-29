package game.scene.startpage;

import com.soyostar.app.Color;
import com.soyostar.app.event.TouchEvent;
import com.soyostar.app.event.TouchListener;
import game.AbController;

/**
 * 
 * @author wp_g4
 */
public class StartPageController extends AbController implements TouchListener {

	private StartPageLayer startPageLayer = null;

	public void updateModel() {
	}

	public void onObtain() {
		startPageLayer = new StartPageLayer();
		startPageLayer.setVisible(true);
		startPageLayer.setBackground(Color.BLACK);
		startPageLayer.setSize(ge.getScreenWidth(), ge.getScreenHeight());
		startPageLayer.setTouchListener(this);
		addWidget(startPageLayer);
	}

	public void onLose() {
	}

	public boolean onTouchEvent(Object t, TouchEvent te) {
		if (te.getType() == TouchEvent.TOUCH_DOWN) {
			rpgGame.setCurrentControl("game.scene.menu.MenuController");
			// rpgGame.setCurrentControl("game.scene.test.TestController");

		}
		return true;
	}
}
