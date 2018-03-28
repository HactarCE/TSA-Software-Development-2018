package com.tsa.acs;

import java.util.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;
import com.tsa.acs.logicgates.*;

public class Simulation {
	ArrayList<LogicGate> gates = new ArrayList<LogicGate>();

	public Simulation() {

	}

	public void create() {
		
	}

	public void render(SpriteBatch batch, Rectangle mouse) {
		for (LogicGate gate : gates) {
			gate.render(batch, mouse);
		}
	}
}
