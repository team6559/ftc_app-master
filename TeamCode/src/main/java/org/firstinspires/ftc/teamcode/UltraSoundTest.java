package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * Created by admin on 4/1/2017.
 */

@Autonomous(group = "Autonomous", name = "LeftRightUltraSensor")

public class UltraSoundTest extends OpMode {
    UltrasonicSensor left, right;

    public void init(){
        left = hardwareMap.ultrasonicSensor.get("leftUltra");
        right = hardwareMap.ultrasonicSensor.get("rightUltra");
    }
    public void loop(){
        telemetry.addData("Left Reading:", left.getUltrasonicLevel());
        telemetry.addData("Right Reading:", right.getUltrasonicLevel());
    }
}
