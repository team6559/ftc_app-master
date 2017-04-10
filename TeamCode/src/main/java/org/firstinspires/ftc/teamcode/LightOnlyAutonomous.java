package org.firstinspires.ftc.teamcode;

import android.provider.Telephony;
import android.util.TimeUtils;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import ftc.backcode.OpModeBase;
import ftc.backcode.SecondThread;
import java.lang.Object;
import java.lang.Thread;
import java.util.Calendar;

/**
 * Created by union on 11/15/16.
 */

//@Autonomous (name = "LightOnlyAutonomous", group = "UserOP")
public class LightOnlyAutonomous extends OpModeBase {

    public static boolean isBlue = true;
    public static boolean breakThread = false;

    public static long timeSinceEpoch;
    Thread thr;
    public void start() {
        thr = new Thread(new SecondThread());
        thr.start();
    }
    public void stop()
    {
        breakThread = true;
    }

    public static void press(int blue, int red) {
        //Assuming sensor is on the left
        long time = System.currentTimeMillis();
        if (blue > 2000) {
            if (isBlue) {


                //Left
                while (System.currentTimeMillis() - time < 100) {move(1,0,0, false);}
                while (System.currentTimeMillis() - time < 500){move(0,1,0,false);}
                while (System.currentTimeMillis() - time < 900){move(0,-1,0,false);}

            } else {
                //Right
                while (System.currentTimeMillis() - time < 100) {move(-1,0,0, false);}
                while (System.currentTimeMillis() - time < 500){move(0,1,0,false);}
                while (System.currentTimeMillis() - time < 900){move(0,-1,0,false);}
            }
        }
        if (red > 700) {
            if (isBlue) {
                //Right
                while (System.currentTimeMillis() - time < 100) {move(-1,0,0, false);}
                while (System.currentTimeMillis() - time < 500){move(0,1,0,false);}
                while (System.currentTimeMillis() - time < 900){move(0,-1,0,false);}
            } else {
                //Left
                while (System.currentTimeMillis() - time < 100) {move(1,0,0, false);}
                while (System.currentTimeMillis() - time < 500){move(0,1,0,false);}
                while (System.currentTimeMillis() - time < 900){move(0,-1,0,false);}
            }
        }
    }
}



