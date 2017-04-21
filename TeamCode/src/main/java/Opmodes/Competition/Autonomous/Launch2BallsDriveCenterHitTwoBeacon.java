package Opmodes.Competition.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.util.Timer;
import java.util.TimerTask;

import Devices.Drivers.FieldColor;
import General.Utility.OpModeGeneral;

/**
 * Created by admin on 4/19/2017.
 */
@Autonomous (name = "Launch 2 Balls Drive Center Hit Two Beacon", group = "Competition")

public class Launch2BallsDriveCenterHitTwoBeacon extends OpMode {

    public static TimerTask shoot, shootPause, shootAgain, stopAll, stopAllAgain, flip,
            stopAllLast, park;
    public static Timer time;
    public boolean stage1Complete = false;
    public float currentTime = 0;
    public int stage = 0;

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


    public void loop()
    {
        telemetry.addData("Current Stage", stage);
        telemetry.addData("Gyro",OpModeGeneral.gyro.getHeadingData());
        telemetry.addData("Enum", OpModeGeneral.colorMid.getColorEnum());
        if (stage1Complete) {
            switch (stage) {
                case 0:
                    if (stage1Complete) {
                        if (OpModeGeneral.colorMid.getColorEnum().equals(FieldColor.WHITETAPE)) {
                            stage++;
                            currentTime = System.currentTimeMillis();
                            OpModeGeneral.mecanumDriveAngle(-45,1);
                        } else {
                            OpModeGeneral.mecanumMove(1, 0, 0, false, 0.1f);
                        }
                    }
                case 1:
//                    int gyroData = OpModeGeneral.gyro.getHeadingData();
//                    if (gyroData < -47) {
//                        OpModeGeneral.mecanumMove(0, 0, -1, false, 0.2f);
//                    } else if (gyroData > -43) {
//                        OpModeGeneral.mecanumMove(0, 0, 1, false, 0.2f);
//                    } else {
//                        OpModeGeneral.mecanumMove(0, 0, 0, false);
//                        stage++;
//                    }
                    if (System.currentTimeMillis() > currentTime + 3000){
                        stage++;
                    }
                case 2:
                    OpModeGeneral.colorBeacon.togglePassive();
                    if (OpModeGeneral.colorBeacon.getColorEnum() != FieldColor.CLEAR) {
                        OpModeGeneral.mecanumMove(0, 0, 0, false);
                        stage++;
                    } else {
                        OpModeGeneral.mecanumMove(1, 0, 0, false, 0.1f);
                    }
                case 3:
                    //ColorBeacon is on the left
                    if (OpModeGeneral.colorBeacon.red() > OpModeGeneral.colorBeacon.blue()) {
                        telemetry.addData("ColorBeacon shows that red is on the left, triggering left", 0);
                        //Triggering Left Button
                    }
                    if (OpModeGeneral.colorBeacon.red() <= OpModeGeneral.colorBeacon.blue()) {
                        telemetry.addData("ColorBeacon shows that blue is on the left, triggering right", 0);
                        //Trigger Right Button
                    }
                case 4:
                    return;

            }
        }

    }

}
