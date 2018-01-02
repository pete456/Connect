package com.connect.main.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.connect.main.Connect;

/**
 * Created by pete456 on 12/21/17.
 */

public class PlayScreen extends AbstractScreen {
    final Connect connect;
    private InputMultiplexer im;
    public PlayScreen(final Connect connect)
    {
        super(connect);
        this.connect=connect;
        im=new InputMultiplexer();
        im.addProcessor(stage);
        Gdx.input.setInputProcessor(im);
    }

    @Override
    public void show()
    {
        for(int i=0; i<connect.column.length; i++)
        {
            stage.addActor(connect.column[i]);
        }
    }

    @Override
    public void update(float delta)
    {
        stage.act();
    }

    @Override
    public void render(float delta){
        super.render(delta);
        stage.draw();
        connect.batch.begin();
        if(connect.column[0].getIfOver())
        {
            connect.font.draw(connect.batch,"Game Over!",700,200);
            connect.font.draw(connect.batch,"The winner is player "+connect.column[0].getWinner(),700,210);
        }
        connect.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
