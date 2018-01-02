package com.connect.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.connect.main.entities.Column;
import com.connect.main.screens.ScreenManager;

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
	public BitmapFont font;

	public ScreenManager sm;
	public Column[] column;

	@Override
	public void create ()
	{
		batch = new SpriteBatch();
		font=new BitmapFont();
		column=new Column[7];
		for(int i=0; i<7; i++)
		{
			column[i]=new Column(this,i,300/4*(i+1));
		}
		sm=new ScreenManager(this);
	}
	
	@Override
	public void dispose ()
	{
		batch.dispose();
	}
}
