package com.connect.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Connect extends Game
{
	/*
	label for whos turn
	7 columns
		hold variable for top spot
	check if win
		hold array for placed chips
		check for familiar colors around
	 */
	public final int WIDTH=1024;
	public final int HEIGHT=600;
	public SpriteBatch batch;

	@Override
	public void create ()
	{
		batch = new SpriteBatch();
	}
	
	@Override
	public void dispose ()
	{
		batch.dispose();
	}
}
