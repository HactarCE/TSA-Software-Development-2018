package com.tsa.acs;

import java.util.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.Input.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;
import com.tsa.acs.logicgates.*;

public class Simulation {
	ArrayList<LogicGate> gates = new ArrayList<LogicGate>();
	boolean isHolding;

	public Simulation() {

	}

	public void create() {

	}

	public void render(SpriteBatch batch, Rectangle mouse) {
		for (LogicGate gate : gates) {
			gate.render(batch, mouse);
			if (mouse.overlaps(gate.rect) && Gdx.input.isButtonPressed(Buttons.LEFT)
					&& !isHolding) {
				gate.isHeld = true;
				isHolding = true;
			} else if (!Gdx.input.isButtonPressed(Buttons.LEFT)) {
				isHolding = false;
			}
		}
	}
}
