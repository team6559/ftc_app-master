package ftc.backcode;

/**
 * Created by ironOwlKing on 2/4/2017.
 */

public class SecondThread implements Runnable {


    public void run() {
        if (!LightOnlyAutonomous.breakThread) {
            LightOnlyAutonomous.timeSinceEpoch = System.currentTimeMillis();
            //Stage 0 completed in initialization
            long time = LightOnlyAutonomous.timeSinceEpoch;
            boolean firstLight = false, secondLight = false;

            float angle = 45f;
            float angle2 = -45f;
            float givenPos = 10;
            while (OpModeBase.colorMid.red() < 280) {
                OpModeBase.move(-1, 1, 0, false);
                if (LightOnlyAutonomous.breakThread) break;
            }
            OpModeBase.move(0, 0, 0, false);
            while (true) {
                OpModeBase.move(0, 1, 0, false);
                if (OpModeBase.colorBeacon.red() > 700 || OpModeBase.colorBeacon.blue() > 2000)
                    break;
                if (LightOnlyAutonomous.breakThread) break;
            }
            LightOnlyAutonomous.press(OpModeBase.colorBeacon.red(), OpModeBase.colorBeacon.blue());
            time = System.currentTimeMillis();
            while (System.currentTimeMillis() - time < 1000) {
                OpModeBase.move(-1, 0, 0, false);
                if (LightOnlyAutonomous.breakThread) break;
            }
            while (OpModeBase.colorMid.red() < 280) {
                OpModeBase.move(-1, 0, 0, false);
                if (LightOnlyAutonomous.breakThread) break;
            }
            OpModeBase.move(0, 0, 0, false);
            while (true) {
                OpModeBase.move(0, 1, 0, false);
                if (OpModeBase.colorBeacon.red() > 700 || OpModeBase.colorBeacon.blue() > 2000)
                    break;
                if (LightOnlyAutonomous.breakThread) break;
            }
            LightOnlyAutonomous.press(OpModeBase.colorBeacon.red(), OpModeBase.colorBeacon.blue());

        }
        else
        {
            throw new RuntimeException("Extermination of the AI");
        }
    }

}
