package com.connect.main.screens;

import com.connect.main.Connect;

/**
 * Created by pete456 on 12/21/17.
 */

public class LoadScreen extends AbstractScreen{
    final Connect connect;

    public LoadScreen(final Connect connect)
    {
        super(connect);
        this.connect=connect;
    }

    @Override
    public void show(){}

    @Override
    public void update(float delta){}

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
