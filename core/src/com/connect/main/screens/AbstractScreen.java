package com.connect.main.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.connect.main.Connect;

import javax.swing.event.HyperlinkEvent;

/**
 * Created by pete456 on 12/21/17.
 */

public abstract class AbstractScreen implements Screen{
    final Connect connect;

    OrthographicCamera camera;
    Stage stage;
    FillViewport fillviewport;

    public AbstractScreen(final Connect connect)
    {
        this.connect=connect;
        stage=new Stage();
        camera=new OrthographicCamera(connect.WIDTH,connect.HEIGHT);
        camera.position.set(camera.viewportWidth/2f,camera.viewportHeight/2f,0);
        stage.getViewport().setCamera(camera);
        camera.update();
    }

    public abstract void update(float delta);

    @Override
    public void render(float delta) {
        update(delta);
        camera.update();
        connect.batch.setProjectionMatrix(camera.combined);
        Gdx.gl.glClearColor(0f,0f,.5f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void dispose()
    {
        stage.dispose();
    }

    public Stage getStage() {return stage;}
}
