package com.tazza;


import java.io.IOException;

public class RobotGameMain {
    public static void main(String[] args) throws IOException {
        Robot r = new Robot();
        RobotEater rEat = new RobotEater();
        GameArea gameArea = new GameArea();

        //gameArea.setRobot(10,10,r);
        //gameArea.setRobotEater(25,25,rEat);
        gameArea.setRobot(25,25,r);
        gameArea.setRobotEater(10,10,rEat);

        System.out.println("Starting game.....");
        gameArea.startGame();

        System.out.println("Game as stopped thank you for playing.....");
        System.out.println("Steps needed "+gameArea.getTimeElapsed());
    }
}
