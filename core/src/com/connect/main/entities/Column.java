package com.connect.main.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.connect.main.Connect;

/**
 * Created by pete456 on 1/1/18.
 */

public class Column extends Actor {
    final Connect connect;
    private int columnnum;
    private static int turn=1;
    private static boolean win=false;
    private static int winner;

    private Sprite sprite;

    private Sprite[] chips;
    private Texture blackchip;
    private Texture redchip;
    private Texture currentchiptexture;
    private int chipcount;
    private static int[][] allchips=null;

    public Column(final Connect connect, final int columnnum, float x)
    {
        this.connect=connect;
        this.columnnum=columnnum;

        this.redchip=new Texture("redchip.png");
        this.blackchip=new Texture("blackchip.png");

        this.sprite=new Sprite(new Texture(Gdx.files.internal("column.png")));
        this.sprite.setPosition(x,0);
        this.sprite.setSize(300/4,2200/4);

        chips=new Sprite[6];

        if(allchips==null)
        {
            allchips=new int[6][7];
        }

        setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
        setTouchable(Touchable.enabled);

        addListener(new InputListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                System.out.println("touch down");
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button)
            {
                System.out.println("turn: "+turn);
                System.out.println("adding chip");
                if(chipcount<6)
                {
                    currentchiptexture=turn==1?redchip:blackchip;
                    chips[chipcount]=new Sprite(currentchiptexture);
                    chips[chipcount].setSize(73,73);
                    chips[chipcount].setPosition(sprite.getX()+2, chipcount*75+89);
                    allchips[chipcount][columnnum]=turn;
                    if(checkWin())
                    {
                        win=true;
                        winner=turn;
                    }
                    turn=turn==1?2:1;
                    chipcount++;
                }
                for(int i=0;i<allchips.length;i++)
                {
                    for(int e=0;e<allchips[i].length;e++)
                    {
                        System.out.print(allchips[i][e]);
                    }
                    System.out.print("\n");
                }
            }
        });
    }

    @Override
    public void act(float delta)
    {
        if(win)setTouchable(Touchable.disabled);
    }

    @Override
    public void draw(Batch batch, float delta)
    {

        for(int i=0;i<chipcount;i++)
        {
            chips[i].draw(batch);
        }
        sprite.draw(batch);
    }

    public boolean getIfOver() {return win;}
    public int getWinner(){return winner;}

    private boolean checkWin()
    {
        for(int i=0;i<allchips.length;i++)
        {
            for(int e=0;e<allchips[i].length;e++)
            {
                if(allchips[i][e]!=0)
                {
                    if(checkVert(i,e)) return true;
                    if(checkHor(i,e)) return true;
                    if(checkNegDiag(i,e))return true;
                    if(checkPosDiag(i,e))return true;
                }
            }
        }
        return false;
    }

    private boolean checkVert(int i,int e)
    {
        for(int c=0;c<4;c++)
        {
            if(i+c==allchips.length)return false;
            if(allchips[i+c][e]!=turn) return false;
        }
        return true;
    }

    private boolean checkHor(int i,int e)
    {
        for(int c=0;c<4;c++) {
            System.out.println("loop"+(e+c));
            if (e+c==allchips[i].length) return false;
            if (allchips[i][e + c] != turn) return false;
        }
        return true;
    }
    private boolean checkNegDiag(int i, int e)
    {
        for(int c=0;c<4;c++)
        {
            if(i+c==allchips.length||e+c==allchips[i].length)return false;
            if(allchips[i+c][e+c]!=turn)return false;
        }
        return true;
    }
    private boolean checkPosDiag(int i, int e)
    {
        for(int c=0;c<4;c++)
        {
            if(i-c==-1||e+c==allchips[i].length)return false;
            if(allchips[i-c][e+c]!=turn)return false;
        }
        return true;
    }
}
