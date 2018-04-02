package com.tsa.acs;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.math.*;

public class Wire {

	Vector2 Start;
	Vector2 End;

	public Wire(Vector2 start, Vector2 end) {
		if (start.y > end.y) {
			Start = end;
			End = start;
		} else {
			Start = start;
			End = end;
		}

	}

	public void render(ShapeRenderer sr) {
		float xDistance = Math.abs(Start.x - End.x);
		float yDistance = Math.abs(Start.y - End.y);

		sr.setColor(Color.RED);
		sr.line(Start, new Vector2(Start.x + (xDistance / 2), Start.y));
		sr.line(new Vector2(Start.x + (xDistance / 2), Start.y),
				new Vector2(Start.x + (xDistance / 2), Start.y + yDistance));
		sr.line(new Vector2(Start.x + (xDistance / 2), Start.y + yDistance), End);
	}

	public void setPoints(Vector2 start, Vector2 end) {
		if (start.y > end.y) {
			Start = end;
			End = start;
		} else {
			Start = start;
			End = end;
		}
	}
}
