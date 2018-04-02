package com.tsa.acs;

import java.util.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;
import com.tsa.acs.logicgates.*;

public class Sidebar {

	ArrayList<LogicGate> logicgates = new ArrayList<LogicGate>();
	ArrayList<Rectangle> boundingBoxes = new ArrayList<Rectangle>();
	Texture overlayTexture;

	public Sidebar() {
		logicgates.add(new And());
		logicgates.add(new Not());
	}

	public void create() {
		for (int i = 0; i < logicgates.size(); i++) {
			logicgates.get(i).create();
			boundingBoxes.add(new Rectangle(10, i * 74, 64, 64));
		}
		overlayTexture = new Texture("overlay.png");
	}

	public void render(SpriteBatch batch, Simulation sim, Rectangle mouse) {
		for (int i = 0; i < logicgates.size(); i++) {
			batch.draw(logicgates.get(i).icon, 10, i * 74);
			if (mouse.overlaps(boundingBoxes.get(i))) {
				batch.draw(overlayTexture, 10, i * 74);
				if (Gdx.input.justTouched()) {
					try {
						sim.gates.add(logicgates.get(i).getClass().newInstance());
						sim.gates.get(sim.gates.size() - 1).create();
						sim.gates.get(sim.gates.size() - 1).position = new Vector2(300, 300);
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
