package com.tazza;

public class GameArea {

    private Robot robot;
    private RobotEater robotEater;
    private int timeElapsed=0;
    private boolean gameIsRunning=true;
    private void passTime() {
        timeElapsed++;
    }
    public void stopGame() {
        System.out.println("Robot died");
        gameIsRunning=false;
    }

    public void startGame() {
        //System.out.println("In GameArea :"+this);
        robot.setGameArea(this);
        robotEater.setGameArea(this);
        while(gameIsRunning){
            passTime();
            robot.move(1);
            robotEater.move(2);
            //System.out.println("In while TimeElapsed :"+timeElapsed);
            if(robot==null)
                stopGame();
        }
    }
    public boolean doesCollide(GameObject aGameObject1, GameObject aGameObject2){
        if(aGameObject1.getX()==aGameObject2.getX() && aGameObject1.getY()==aGameObject2.getY()) {
            return true;
        } else {
            return false;
        }
    }
    public int calculateDistance(GameObject aGameObject1, GameObject aGameObject2){
       return (int) Math.sqrt(Math.pow((aGameObject2.getY()-aGameObject1.getY()),2)+Math.pow((aGameObject2.getX()-aGameObject1.getX()),2));
    }
    public void removeRobot(Robot r){
        robot=null;
        //r.die();
    }
    public void setRobot(int x, int y, Robot r) {
        robot=r;
        robot.setX(x);
        robot.setY(y);
    }
    public void setRobotEater(int x, int y, RobotEater re){
        robotEater=re;
        robotEater.setX(x);
        robotEater.setY(y);
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }
    public Robot getRobot() {
        return robot;
    }


}
