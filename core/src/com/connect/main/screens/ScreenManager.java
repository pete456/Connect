package com.connect.main.screens;

import com.connect.main.Connect;

import java.util.HashMap;

/**
 * Created by pete456 on 12/21/17.
 */

public class ScreenManager {
    final Connect connect;
    public enum STATE{LOAD,PLAY}
    public HashMap<STATE,AbstractScreen> gamestates;

    public ScreenManager(final Connect connect){
        this.connect=connect;
        initScreen();
        setScreen(STATE.PLAY);
    }

    private void initScreen(){
        this.gamestates=new HashMap<STATE, AbstractScreen>();
        this.gamestates.put(STATE.LOAD,new LoadScreen(connect));
        this.gamestates.put(STATE.PLAY, new PlayScreen(connect));
    }

    public void setScreen(STATE setto){
        connect.setScreen(gamestates.get(setto));
    }

    public void dispose(){
        for(AbstractScreen screen : gamestates.values()){
            if(screen!=null){
                screen.dispose();
            }
        }
    }
}
