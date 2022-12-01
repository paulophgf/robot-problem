package br.com.challenge.test;

import br.com.challenge.test.environment.Environment;
import br.com.challenge.test.environment.EnvironmentMapType;
import br.com.challenge.test.robot.Robot;

import java.util.Scanner;

public class StartChallenge {

    public static void main(String[] args) {
        Environment environment = new Environment(EnvironmentMapType.MAP_1);
        //Uncomment the line below and execute your auto clean code
        manualClean(environment);
        autoClean(environment);
    }

    public static void autoClean(Environment environment) {
        //TODO Implement your code here
    }

    /**
     * This method was created just to show the robot movement
     */
    public static void manualClean(Environment environment) {
        Scanner scanner = new Scanner(System.in);
        Robot teste = new Robot(environment);
        int i = -1;
        while(i != 0) {
            teste.printLocation();
            System.out.println("Current Position: " + teste.getPosition());
            System.out.println("Choose Move (8=UP 2=DOWN 4=LEFT 6=RIGHT 5=CLEAN 0=EXIT): ");
            i = scanner.nextInt();
            switch (i) {
                case 8: teste.toUp(); break;
                case 4: teste.toLeft(); break;
                case 2: teste.toDown(); break;
                case 6: teste.toRight(); break;
                case 5: teste.toClean(); break;
            }
        }
    }

}
