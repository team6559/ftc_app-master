package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import java.util.Timer;
import java.util.TimerTask;

import ftc.backcode.OpModeBase;

/**
 * Created by bryanperkins on 12/10/16.
 */
@Autonomous (name = "LaunchBallTwice", group = "UserOP")
public class HitBallTwice extends OpModeBase {
    public static TimerTask shoot, shootPause, shootAgain, stopAll, ramBall, stopAllAgain, flip;
    public static Timer time;

    public void init() {
        super.init();
        time = new Timer();
        shoot = new TimerTask() {
            public void run() {
                move(0, 0, 0, false);
                catapult.setPower(1);
            }
        };
        shootPause = new TimerTask() {
            @Override
            public void run() {
                move(0, 0, 0, false);
                combine.setPower(1);
                catapult.setPower(0);;
            }
        };
        shootAgain = new TimerTask() {
            @Override
            public void run() {
                combine.setPower(0);
                move(0, 0, 0, false);
                catapult.setPower(1);
            }
        };
        stopAll = new TimerTask() {
            @Override
            public void run() {
                catapult.setPower(0);
                move(0, 0, 0, false);
            }
        };
        ramBall = new TimerTask() {
            @Override
            public void run() {
                move(-1, 0, 0, false);
            }
        };
        stopAllAgain = new TimerTask() {
            public void run() {
                catapult.setPower(0);
                move(0, 0, 0, false);
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
        move(-1,0,0,false);
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