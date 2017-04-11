package Opmodes.Sensor;

import android.provider.ContactsContract;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Devices.Drivers.AdafruitSensor;
import General.Utility.DataLogger;

/**
 * Created by admin on 4/8/2017.
 */

@TeleOp (name = "AdafruitTest", group = "Sensors")

public class AdafruitRGB extends OpMode {

    AdafruitSensor sensor;
    DataLogger logger;

    public void init()
    {
        sensor = new AdafruitSensor(hardwareMap,"adacolor");
        logger.addField("Red");
        logger.addField("Green");
        logger.addField("Blue");
        logger.addField("Alpha");
        logger.newLine();
    }

    public void loop()
    {
        telemetry.addData("Red", sensor.redColor());
        telemetry.addData("Green", sensor.greenrColor());
        telemetry.addData("Blue", sensor.blueColor());
        telemetry.addData("Alpha", sensor.clearColor());
        logger = new DataLogger("colorValues");
        logger.addField(sensor.redColor());
        logger.addField(sensor.greenrColor());
        logger.addField(sensor.blueColor());
        logger.addField(sensor.clearColor());
        logger.newLine();
    }
    public void stop()
    {
        logger.closeDataLogger();
    }
}
