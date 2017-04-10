package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.teamcode.I2CColorSensor6559;

/**
 * Created by union on 3/24/17.
 */
@TeleOp(name = "TwoTypeColorSensorTest", group = "UserOP")
public class twinColorTest extends OpMode {

    public static ColorSensor colorMid;
    public static I2CColorSensor6559 colorBeacon;


    public void init(){
        colorMid = hardwareMap.colorSensor.get("colorMid");
        colorBeacon = (I2CColorSensor6559) hardwareMap.colorSensor.get("colorBeacon");
    }
    public void loop(){
        telemetry.addData("RedFront",colorMid.red());
        telemetry.addData("GreenFront",colorMid.green());
        telemetry.addData("BlueFront",colorMid.blue());
        telemetry.addData("AlphaFront",colorMid.alpha());
        telemetry.addData("ArgbFront", colorMid.argb());
        telemetry.addData("ArgbFront", colorMid.argb());
        telemetry.addData("RedBeacon",colorBeacon.red());
        telemetry.addData("GreenBeacon",colorBeacon.green());
        telemetry.addData("BlueBeacon",colorBeacon.blue());
        telemetry.addData("AlphaBeacon",colorBeacon.alpha());
        telemetry.addData("ArgbBeacon", colorBeacon.argb());
    }
}
