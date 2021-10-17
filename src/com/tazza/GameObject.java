package com.tazza;

import java.io.IOException;
import java.util.Random;

public class GameObject {
    int x;
    int y;
    int direction=1;
    Random randMove = new Random();
    public int getX(){
        return x;
    }
    public void setX(int aX){
        x=x+aX;
    }
    public int getY() {
        return y;
    }
    public void setY(int aY){
        y=y+aY;
    }
    public void move(int aSteps){
        switch (direction) {
            case 1 -> setX(getX() + aSteps);
            case 2 -> setY(getY() + aSteps);
            case 3 -> setX(getX() - aSteps);
            case 4 -> setY(getY() - aSteps);
            default -> {
            }
        }



    }
    public void turn(int turns){
        direction = randMove.nextInt(4);
        System.out.println(" Random direction :"+direction);
        //System.out.println("direction : "+direction+" X Coord : "+(Math.cos(direction))+" Y Coord :"+Math.sin(direction));
    }
    private GameArea gameArea;

    public GameArea getGameArea() {
        return gameArea;
    }

    public void setGameArea(GameArea ga) {
        gameArea=ga;
        //System.out.println("In GameObject :"+gameArea);
    }
    public GameObject() throws IOException {}
    public GameObject(int x, int y, int direction){}


}
