package br.com.challenge.test.environment;

import br.com.challenge.test.robot.Position;
import br.com.challenge.test.robot.Robot;

import java.util.Random;

public final class Environment {

    private EnvironmentMapType mapType;
    private Integer[][] map;


    public Environment(EnvironmentMapType mapType) {
        this.mapType = mapType;
        this.map = EnvironmentGenerator.getInstance(mapType);
    }


    public void print() {
        System.out.println(printMap(new Position(-1, -1)));
    }

    public void print(Position position) {
        System.out.println(printMap(position));
    }


    public boolean canMoveToUp(Robot robot) {
        boolean canMove = (robot.getPosition().getY()-1)>=0;
        if(canMove) {
            canMove = map[robot.getPosition().getY()-1][robot.getPosition().getX()] != 0;
        }
        return canMove;
    }

    public boolean canMoveToDown(Robot robot) {
        boolean canMove = (robot.getPosition().getY()+1)<map.length;
        if(canMove) {
            canMove = map[robot.getPosition().getY()+1][robot.getPosition().getX()] != 0;
        }
        return canMove;
    }

    public boolean canMoveToLeft(Robot robot) {
        boolean canMove = (robot.getPosition().getX()-1)>=0;
        if(canMove) {
            canMove = map[robot.getPosition().getY()][robot.getPosition().getX()-1] != 0;
        }
        return canMove;
    }

    public boolean canMoveToRight(Robot robot) {
        boolean canMove = (robot.getPosition().getX()+1)<map[robot.getPosition().getY()].length;
        if(canMove) {
            canMove = map[robot.getPosition().getY()][robot.getPosition().getX()+1] != 0;
        }
        return canMove;
    }

    public void clean(Position position) {
        map[position.getY()][position.getX()] = 2;
    }



    private String printMap(Position position) {
        StringBuilder print = new StringBuilder();
        print.append("Map " + mapType.name() + ":\n\n");
        for(int y=0; y<map.length; y++) {
            for(int x=0; x<map[y].length; x++) {
                if(x == position.getX() && y == position.getY()) {
                    print.append(5);
                } else {
                    print.append(map[y][x]);
                }
            }
            print.append("\n");
        }
        return print.toString();
    }

    public Position getValidRandomPosition() {
        Position position = null;
        int x, y;
        for (int i=0; i<500; i++){
            x = new Random().nextInt(map[0].length);
            y = new Random().nextInt(map.length);
            if(map[y][x] == 1) {
                position = new Position(x, y);
            }
        }
        if(position == null) {
            throw new RuntimeException("It was not possible to find a valid position on map: " + mapType.name());
        }
        return position;
    }

}
