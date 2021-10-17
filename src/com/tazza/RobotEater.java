package com.tazza;

import java.io.IOException;
import java.util.Random;

public class RobotEater extends GameObject{
    private int lastDistance=Integer.MAX_VALUE;
    Random rand = new Random();

    private double direction;
    private int lastDirection = Integer.MAX_VALUE;

    public RobotEater() throws IOException {
    }

    public void eatRobot(Robot aRobot){
        aRobot.die();
        getGameArea().removeRobot(aRobot);


    }
    public void move(int steps){
        int currentDistance = getGameArea().calculateDistance(this, getGameArea().getRobot());
        for (int i = 0; i < steps; i++) {

            if (getGameArea().getRobot() != null) {


                // System.out.println(" Last Distance : "+lastDistance+" Current distance : "+currentDistance);
                if (currentDistance < lastDistance) {
                    super.move(steps);
                } else {
                    turn(rand.nextInt(4) + 1);
                    super.move(steps);
                }
            }
            System.out.println("(" + getX() + "," + getY() + " RobotEater moved, Distance : " + currentDistance);
            lastDistance = currentDistance;

            if (getGameArea().doesCollide(this, getGameArea().getRobot())) {
                eatRobot(getGameArea().getRobot());
            }
        }
        }

    public void turn(int direction) {
        /*System.out.println("changing direction");
        int currentDistance = getGameArea().calculateDistance(this,getGameArea().getRobot());
        double xDiff = ((double)getX()-(double)getGameArea().getRobot().getX())/(double)getGameArea().calculateDistance(this,getGameArea().getRobot());
        double yDiff= ((double)getX()-(double)getGameArea().getRobot().getY())/(double)getGameArea().calculateDistance(this,getGameArea().getRobot());
        System.out.println("Value of the cos of the angle = "+xDiff+" Value of the angle I hope = "+(Math.toDegrees(Math.acos(xDiff))));
        double angleInDegrees = Math.toDegrees(Math.acos(xDiff));

        double testXcoordModifier= Math.cos(angleInDegrees);
        double testYcoordModifier= Math.sin(angleInDegrees);
        System.out.println("XMODIF = "+testXcoordModifier+" YMODIF = "+testYcoordModifier);
        double res = Math.sqrt(Math.pow(1-xDiff,2));
        System.out.println("sin= "+Math.asin(yDiff));*/
//        if(this.getX()==getGameArea().getRobot().getX()) {
//            direction = rand.nextInt(2)+3;
//        }
//        if(this.getY()==getGameArea().getRobot().getY()) {
//            direction = rand.nextInt(2)+1;
//        }
        if(this.getX()>getGameArea().getRobot().getX()) {
            direction = 3;
        }
        if(this.getX()<getGameArea().getRobot().getX()) {
            direction = 1;
        }
        if(this.getY()<getGameArea().getRobot().getY()) {
            direction = 2;
        }
        if(this.getY()>getGameArea().getRobot().getY()){
            direction=4;
        }
        switch (direction) {
            case 1:
                setX(1);
                break;
            case 2:
                setY(1);
                break;
            case 3:
                setX(-1);
                break;

            case 4:
                setY(-1);
                break;

            default:
                break;
        }
        /*if(testXcoordModifier>0) {
            testXcoordModifier=-(1/(1-testXcoordModifier));
            currentDistance=currentDistance;
        }
        if(testYcoordModifier>0) {
            testYcoordModifier=-1/(testYcoordModifier-1);
            currentDistance=currentDistance;
        }*/
   //     int step;


//                case 1:
//                    step=(int)Math.round((testXcoordModifier+currentDistance+10)/currentDistance);
//                    if(testXcoordModifier<0) {
//                        if (Math.abs(step) > 1 && step < 0) {
//                            step = -1;
//                        }
//                       /* if (Math.abs(step) > 1 && step > 0) {
//                            step = 1;
//                        }*/
//                        setX(step);
//                    }
//                    if (testXcoordModifier>=0) {
//                            if (Math.abs(step) > 1 && step < 0) {
//                                step = 1;
//                            }
//                            /*if (Math.abs(step) > 1 && step > 0) {
//                                step = -1;
//                            }*/
//                        setX(step);
//                    }
//
//                    //setX((int)Math.round((testXcoordModifier+currentDistance)/currentDistance));
//                    System.out.println("Step length = "+((int)Math.round((testXcoordModifier+currentDistance+10)/currentDistance)));
//                    break;
//                case 2:
//                    step=(int)Math.round((testXcoordModifier+currentDistance+10)/currentDistance);
//                    if(testXcoordModifier<0) {
//                        if (Math.abs(step) > 1 && step < 0) {
//                            step = -1;
//                        }
//                        if (Math.abs(step) > 1 && step > 0) {
//                            step = 1;
//                        }
//
//                    } else {
//                        if (Math.abs(step) > 1 && step < 0) {
//                            step = 1;
//                        }
//                        if (Math.abs(step) > 1 && step > 0) {
//                            step = -1;
//                        }
//                    }
//                    setX(step);
//                    //setX((int)Math.round((testXcoordModifier+currentDistance)/currentDistance));
//                    System.out.println("Step length = "+((int)Math.round((testXcoordModifier+currentDistance+10)/currentDistance)));
//                    break;
//
//                case 3:
//                    step=(int)Math.round((testYcoordModifier+currentDistance)/currentDistance);
//                    if(testYcoordModifier<0) {
//                        if(Math.abs(step)>1 && step<0) {
//                            step=-1;
//                        }
//                        if(Math.abs(step)>1 && step>0){
//                            step=1;
//                        }
//
//                    } else {
//                        if(Math.abs(step)>1 && step<0) {
//                            step=1;
//                        }
//                        if(Math.abs(step)>1 && step>0){
//                            step=-1;
//                        }
//                    }
//                    setY(step);
//                    System.out.println("Step length = "+step);
//                   break;
//
//                case 4:
//                    step=(int)Math.round((testYcoordModifier+currentDistance)/currentDistance);
//                    if(testYcoordModifier<0) {
//                        if(Math.abs(step)>1 && step<0) {
//                            step=-1;
//                        }
//                        if(Math.abs(step)>1 &&step>0){
//                            step=1;
//                        }
//                        setY(step);
//                    } else {
//                        if(Math.abs(step)>1 && step<0) {
//                            step=1;
//                        }
//                        if(Math.abs(step)>1 && step>0){
//                            step=-1;
//                        }
//                    }
//                    //setY((int)Math.round((testYcoordModifier+currentDistance)/currentDistance));
//                    System.out.println("Step length = "+((int)Math.round((testYcoordModifier+currentDistance)/currentDistance)));
//                    break;


    }



}
