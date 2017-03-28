package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by union on 3/24/17.
 */
@Autonomous(group = "Autonomous", name = "TwoCDIMTest")
public class twinColorTest extends OpMode {

    public static ColorSensor colorMid;
    public static ColorSensor colorBeacon;


    public void init(){
        colorMid = hardwareMap.colorSensor.get("colorMid");
        colorBeacon = hardwareMap.colorSensor.get("colorBeacon");
    }
    public void loop(){
        telemetry.addData("RedFront",colorMid.red());
        telemetry.addData("GreenFront",colorMid.green());
        telemetry.addData("BlueFront",colorMid.blue());
        telemetry.addData("AlphaFront",colorMid.alpha());
        telemetry.addData("ArgbFront", colorMid.argb());
        telemetry.addData("RedBeacon",colorBeacon.red());
        telemetry.addData("GreenBeacon",colorBeacon.green());
        telemetry.addData("BlueBeacon",colorBeacon.blue());
        telemetry.addData("AlphaBeacon",colorBeacon.alpha());
        telemetry.addData("ArgbBeacon", colorBeacon.argb());
    }
}
