package ftc.backcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by bryan on 3/30/17.
 */

public class OpModeDefaults {

    public static DcMotor left1;
    public static DcMotor right1;
    public static DcMotor combine;
    public static DcMotor left2;
    public static DcMotor right2;
    public static DcMotor catapult;
    public static ColorSensor colorMid;
    //    public static ColorSensor colorBack;
    public static ColorSensor colorBeacon;
    public static I2cAddr midAddr, backAddr, beaconAddr;
    public static Servo flipper;

    public static void basicInit(HardwareMap map)
    {
        //Motors
        right1 = map.dcMotor.get("frontRight");
        left1 = map.dcMotor.get("frontLeft");
        right2 = map.dcMotor.get("backRight");
        left2 = map.dcMotor.get("backLeft");
        combine = map.dcMotor.get("combine");
        catapult = map.dcMotor.get("Catapult");

        //Servos
        flipper.setPosition(0);
    }

    public static PolarCoordinate getPosition()
    {
        //TODO Write your function here TED
        return new PolarCoordinate(0,0);
    }

    public static void Move (float angle, float distance)
    {
        //TODO Write move function here Bryan or TED
        throw new NoSuchMethodError("Write the move function!!!");
    }




}
