package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import java.util.Timer;
import java.util.TimerTask;

import ftc.backcode.OpModeBase;

/**
 * Created by JORDAN AND TAKUMI GOZAIMASU on 2/9/2017.
 */
//@Autonomous(name = "JordanAndTakumi", group = "Autonomous")
public class JandTAutonomous extends OpModeBase {
    public static TimerTask shoot2, shootPause2, shootAgain2, stopAll2, ramBall2, stopAllAgain2, flip2, turnToSide2, stopAllAgain3;
    public static Timer time2;

    public void init() {
        super.init();
        time2 = new Timer();
        shoot2 = new TimerTask() {
            public void run() {
                move(0, 0, 0, false);
                catapult.setPower(1);
            }
        };
        shootPause2 = new TimerTask() {
            @Override
            public void run() {
                move(0, 0, 0, false);
                combine.setPower(1);
                catapult.setPower(0);;
            }
        };
        shootAgain2 = new TimerTask() {
            @Override
            public void run() {
                combine.setPower(0);
                move(0, 0, 0, false);
                catapult.setPower(1);
            }
        };
        stopAll2 = new TimerTask() {
            @Override
            public void run() {
                catapult.setPower(0);
                move(0, 0, 0, false);
            }
        };
        ramBall2 = new TimerTask() {
            @Override
            public void run() {
                move(-1, 0, 0, false);
            }
        };
        stopAllAgain2 = new TimerTask() {
            public void run() {
                catapult.setPower(0);
                move(0, 0, 0, false);
            }
        };
        stopAllAgain3 = new TimerTask() {
            public void run() {
                catapult.setPower(0);
                move(0, 0, 0, false);
            }
        };
        turnToSide2 = new TimerTask() {
            public void run() {
                catapult.setPower(0);
                move(0, 0, 1, false);
            }
        };
        flip2 = new TimerTask() {
            @Override
            public void run() {
//                flipper.setPosition(1);
            }
        };
    }
    public void start()
    {
        move(-1,0,0,false);
        time2.schedule(shoot2, 1000);
        time2.schedule(shootPause2, 2000);
        time2.schedule(flip2, 2250);
        time2.schedule(shootAgain2,3000);
        time2.schedule(stopAll2,4000);
        time2.schedule(ramBall2, 5000);
        time2.schedule(stopAllAgain2, 7000);
        time2.schedule(turnToSide2, 7500);
        time2.schedule(stopAllAgain3, 7750);

    }
    public void loop()
    {

    }
    }