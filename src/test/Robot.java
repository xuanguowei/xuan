package test;

/**
 * ClassName:Robot
 * Package:test
 * Description:
 *
 * @Date:2020/8/2 9:05
 * @Author:xuan
 */
public class Robot extends People {

    private class MachineHeart implements Machine

    {

        public void run(){System.out.println("heart run");}

    }

    public void run(){System.out.println("Robot run");}

    Machine getMachine(){return new MachineHeart();}

    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.run();
        Machine m = robot.getMachine();
        m.run();
    }
}
