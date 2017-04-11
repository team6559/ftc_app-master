package Opmodes.Competition.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.util.Timer;
import java.util.TimerTask;

import General.Utility.OpModeGeneral;

/**
 * Created by bryanperkins on 12/10/16.
 */
@Autonomous (name = "Launch Twice Drive Center", group = "Competition")
public class LaunchTwoBallsDriveCenter extends OpMode {
    public static TimerTask shoot, shootPause, shootAgain, stopAll, ramBall, stopAllAgain, flip;
    public static Timer time;

    public void init() {
        OpModeGeneral.allInit(hardwareMap);

        time = new Timer();
        shoot = new TimerTask() {
            public void run() {
                OpModeGeneral.mecanumMove(0, 0, 0, false);
                OpModeGeneral.catapult.setPower(1);
            }
        };
        shootPause = new TimerTask() {
            @Override
            public void run() {
                OpModeGeneral.mecanumMove(0, 0, 0, false);
                OpModeGeneral.combine.setPower(1);
                OpModeGeneral.catapult.setPower(0);;
            }
        };
        shootAgain = new TimerTask() {
            @Override
            public void run() {
                OpModeGeneral.combine.setPower(0);
                OpModeGeneral.mecanumMove(0, 0, 0, false);
                OpModeGeneral.catapult.setPower(1);
            }
        };
        stopAll = new TimerTask() {
            @Override
            public void run() {
                OpModeGeneral.catapult.setPower(0);
                OpModeGeneral.mecanumMove(0, 0, 0, false);
            }
        };
        ramBall = new TimerTask() {
            @Override
            public void run() {
                OpModeGeneral.mecanumMove(-1, 0, 0, false);
            }
        };
        stopAllAgain = new TimerTask() {
            public void run() {
                OpModeGeneral.catapult.setPower(0);
                OpModeGeneral.mecanumMove(0, 0, 0, false);
            }
        };
        flip = new TimerTask() {
            @Override
            public void run() {
//                flipper.setPosition(1);
            }
        };
    }
    public void start()
    {
        OpModeGeneral.mecanumMove(-1,0,0,false);
        time.schedule(shoot, 1000);
        time.schedule(shootPause, 2000);
        time.schedule(flip, 2250);
        time.schedule(shootAgain,3000);
        time.schedule(stopAll,4000);
        time.schedule(ramBall, 5000);
        time.schedule(stopAllAgain, 9000);
    }
    public void loop()
    {

    }

}