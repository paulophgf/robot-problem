package br.com.challenge.test.robot;

import br.com.challenge.test.environment.Environment;

public class Robot {

    protected Environment environment;
    protected Position position;


    public Robot(Environment environment) {
        this.environment = environment;
        this.position = environment.getValidRandomPosition();
    }

    public boolean toUp() {
        boolean canMove = environment.canMoveToUp(this);
        if(canMove) {
            position.decreaseY();
        }
        return canMove;
    }

    public boolean toDown() {
        boolean canMove = environment.canMoveToDown(this);
        if(canMove) {
            position.increaseY();
        }
        return canMove;
    }

    public boolean toLeft() {
        boolean canMove = environment.canMoveToLeft(this);
        if(canMove) {
            position.decreaseX();
        }
        return canMove;
    }

    public boolean toRight() {
        boolean canMove = environment.canMoveToRight(this);
        if(canMove) {
            position.increaseX();
        }
        return canMove;
    }

    public void toClean() {
        environment.clean(position);
    }

    public void printLocation() {
        environment.print(position);
    }

    public Position getPosition() {
        return position;
    }

}
