package Opmodes.Competition.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.util.Timer;
import java.util.TimerTask;

import Devices.Drivers.FieldColor;
import General.Utility.OpModeGeneral;

/**
 * Created by bryanperkins on 12/10/16.
 */
@Autonomous (name = "First Match Auto", group = "Competition")
public class LaunchTwoBallsDriveCenter extends OpMode {
    public static TimerTask shoot, stopAllLast, shootPause, shootAgain, stopAll, stopAllAgain, flip, park;
    public static Timer time;
    public boolean stage1Complete = false;
    public float currentTime = 0;
    public boolean isP2Enabled = false;

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
//                OpModeGeneral.combine.setPower(-1);
                OpModeGeneral.catapult.setPower(0);
            }
        };
        shootAgain = new TimerTask() {
            @Override
            public void run() {
//                OpModeGeneral.combine.setPower(0);
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
        stopAllAgain = new TimerTask() {
            public void run() {
                OpModeGeneral.catapult.setPower(0);
                OpModeGeneral.mecanumMove(0, 0, 0, false);
                stage1Complete = true;
            }
        };
        stopAllLast = new TimerTask() {
            public void run() {
                OpModeGeneral.catapult.setPower(0);
                OpModeGeneral.mecanumMove(0, 0, 0, false);
                stage1Complete = true;
            }
        };
        flip = new TimerTask() {
            @Override
            public void run() {
                OpModeGeneral.combine.setPower(-1);
            }
        };



        park = new TimerTask() {
        @Override
        public void run() {
            OpModeGeneral.mecanumMove(-1,0,0,false);        }
    };
}
    public void start()
    {
        OpModeGeneral.mecanumMove(-1,0,0,false);
        time.schedule(stopAll, 1400);
        time.schedule(shoot, 2000);
        time.schedule(shootPause, 3000);
        time.schedule(flip, 3500);
        time.schedule(shootAgain,5000);
        time.schedule(stopAllAgain,6000);
        time.schedule(park, 7000);
        time.schedule(stopAllLast, 7500);
    }

    public int stage = 0;
    public void loop()
    {
        if (isP2Enabled)
        switch (stage) {
            case 0:
                if (stage1Complete) {
                    if (OpModeGeneral.colorMid.getColorEnum().equals(FieldColor.WHITETAPE)) {
                        stage++;
                        currentTime = System.currentTimeMillis();
                        OpModeGeneral.mecanumMove(0, 0, 0, false);
                    } else {
                        OpModeGeneral.mecanumMove(1, 0, 0, false, 0.1f);
                    }
                }
            case 1:
                OpModeGeneral.gyro.getHeadingData();
        }

    }

}