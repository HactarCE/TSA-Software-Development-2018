package com.tsa.acs;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;
import com.badlogic.gdx.math.*;

public class ACS extends ApplicationAdapter {
	SpriteBatch batch;
	ShapeRenderer sr;
	
	Sidebar sidebar;
	Simulation sim;
	Rectangle mouse = new Rectangle(0, 0, 4, 4);

	@Override
	public void create() {
		batch = new SpriteBatch();
		sr = new ShapeRenderer();
		sidebar = new Sidebar();
		sidebar.create();
		sim = new Simulation();
		sim.create();
	}

	@Override
	public void render() {
		mouse.setPosition(Gdx.input.getX(), 720 - Gdx.input.getY());
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sr.begin(ShapeType.Line);
		
		sidebar.render(batch, sim, mouse);
		sim.render(batch, mouse, sr);
		
		sr.setColor(Color.BLACK);
		sr.line(80, 0, 80, 720);
		sr.line(81, 0, 81, 720);
		sr.line(82, 0, 82, 720);
		
		batch.end();
		sr.end();
	
		


	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
