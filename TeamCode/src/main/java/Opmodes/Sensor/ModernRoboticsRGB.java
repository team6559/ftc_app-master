package Opmodes.Sensor;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by admin on 4/10/2017.
 */
@TeleOp (name = "Modern Robotics RGB", group = "Sensors")
public class ModernRoboticsRGB extends OpMode {

    ColorSensor c;

    public void init()
    {
        c = hardwareMap.colorSensor.get("MRCS");
    }
    public void loop()
    {
        telemetry.addData("Red", c.red());
        telemetry.addData("Green", c.green());
        telemetry.addData("Blue", c.blue());
        telemetry.addData("Alpha", c.alpha());
    }
}
