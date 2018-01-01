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
