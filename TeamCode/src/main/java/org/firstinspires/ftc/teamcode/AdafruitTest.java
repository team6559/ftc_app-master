package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by admin on 4/8/2017.
 */

@TeleOp (name = "AdafruitTest", group = "Sensors")

public class AdafruitTest extends OpMode {

    AdafruitSensor sensor;

    public void init()
    {
        sensor = new AdafruitSensor(hardwareMap,"adacolor");
    }

    public void loop()
    {
        telemetry.addData("Red", sensor.redColor());
        telemetry.addData("Green", sensor.greenrColor());
        telemetry.addData("Blue", sensor.blueColor());

    }
}
