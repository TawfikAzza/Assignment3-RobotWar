package com.tazza;

import java.io.IOException;

public class Robot extends GameObject {


    public Robot() throws IOException {
    }

    public void say(String whatToSay){}
    public void move(int steps){

        super.move(steps);
        System.out.println("(" + getX() + "," + getY() + " Robot moved");
    }
    public void die(){

        System.out.println("I die !!!!");

    }

}
