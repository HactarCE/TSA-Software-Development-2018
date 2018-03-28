package com.tsa.acs.logicgates;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;

public class LogicGate {
	public Texture icon;
	public Rectangle rect;
	public Vector2 position;

	String path;
	boolean isHeld;

	public LogicGate() {
		position = new Vector2(0, 0);
	}

	public void create() {
		icon = new Texture(path);
		rect = new Rectangle(0, 0, 64, 64);
	}

	public void render(SpriteBatch batch, Rectangle mouse) {
		if (mouse.overlaps(rect) && Gdx.input.isButtonPressed(Buttons.LEFT))
			isHeld = true;
		if (isHeld) {
			position = new Vector2(mouse.x, mouse.y);
			if (!Gdx.input.isButtonPressed(Buttons.LEFT))
				isHeld = false;
		}
		rect.setPosition(position);
		batch.draw(icon, position.x, position.y);
	}
}
