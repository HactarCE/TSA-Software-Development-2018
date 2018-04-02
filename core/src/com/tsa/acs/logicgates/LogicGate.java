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
	public boolean isHeld;

	String path;


	public LogicGate() {
		position = new Vector2(0, 0);
	}

	public void create() {
		icon = new Texture(path);
		rect = new Rectangle(1000, 1000, 64, 64);
	}

	public void render(SpriteBatch batch, Rectangle mouse) {
		if (isHeld) {
			if (mouse.x > 74)
				position = new Vector2(mouse.x, mouse.y);
			else
				isHeld = false;

			if (!Gdx.input.isButtonPressed(Buttons.LEFT))
				isHeld = false;
		}
		rect.setPosition(position);
		batch.draw(icon, position.x, position.y);
	}
}
