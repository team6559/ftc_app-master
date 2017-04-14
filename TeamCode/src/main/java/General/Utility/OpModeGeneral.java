package General.Utility;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.Servo;

import Devices.Drivers.AdafruitRGB;

/**
 * Created by union on 11/8/16.
 */

public class OpModeGeneral {

    public static DcMotor left1;
    public static DcMotor right1;
    public static DcMotor combine;
    public static DcMotor left2;
    public static DcMotor right2;
    public static DcMotor catapult;
    public static I2cDevice colorMid;
    public static AdafruitRGB colorBeacon;
    public static Servo flipper;


    public static void allInit (HardwareMap hardwareMap)
    {
        motorInit(hardwareMap);
        sensorInit(hardwareMap);
        servoInit(hardwareMap);
    }

    public static void motorInit (HardwareMap hardwareMap)
    {
        //Motors
        right1 = hardwareMap.dcMotor.get("frontRight");
        left1 = hardwareMap.dcMotor.get("frontLeft");
        right2 = hardwareMap.dcMotor.get("backRight");
        left2 = hardwareMap.dcMotor.get("backLeft");
        combine = hardwareMap.dcMotor.get("combine");
        catapult = hardwareMap.dcMotor.get("Catapult");
    }

    public static void servoInit(HardwareMap hardwareMap)
    {
        flipper = hardwareMap.servo.get("flipper");
        flipper.setPosition(0);
    }

    public static void sensorInit (HardwareMap hardwareMap)
    {
        //Color Sensors
        colorBeacon = new AdafruitRGB(hardwareMap, "colorBeacon");

    }

    private static double _topLeft, _topRight, _bottomLeft, _bottomRight, _maxVector;

    public static void mecanumMove (double leftX, double leftY, double rightX, boolean negated){
        //Each joystick alone gives the wheel a unique set of instructions
        //These equations add them all together
        if (negated) {
            _topLeft = leftX - leftY - rightX;
            _topRight = -leftX - leftY - rightX;
            _bottomLeft = leftX + leftY - rightX;
            _bottomRight = -leftX + leftY - rightX;
        }
        else
        {
            _topRight = -(-leftX - leftY + rightX);
            _topLeft = -(leftX - leftY + rightX);
            _bottomRight = -(-leftX + leftY + rightX);
            _bottomLeft = -(leftX + leftY + rightX);
        }

        //Find the largest absolute value
        _maxVector = Math.max(Math.max(Math.abs(_topLeft), Math.abs(_topRight)),
                Math.max(Math.abs(_bottomLeft), Math.abs(_bottomRight)));

        //If the vector is being divided is less than 1, set it to just 1. Allow for micromanagement
        //Also makes sure we don't divide by zero
        _maxVector = _maxVector > 1 ? _maxVector : 1;

        //Set power to values divided by the largest so numbers are in range and proportional
        left1.setPower(_topLeft/_maxVector);
        left2.setPower(_topRight/_maxVector);
        right1.setPower(_bottomLeft/_maxVector);
        right2.setPower(_bottomRight/_maxVector);
    }

    public static void mecanumTurn(double turnSpeed){
        mecanumMove(0,0,turnSpeed,false);
    }

    public static void mecanumDriveAngle(float angle, float power)
    {
        float b = (float) Math.sin(90-angle);
        float a = (float) (Math.pow(power,2) - Math.pow(b,2));
        mecanumMove(a, b, 0,false);
    }

    public static void resetDriveEncoders(boolean useEncoders)
    {
        left1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        if (!useEncoders) {
            left1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            left2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            right1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            right2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        else
        {
            left1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            left2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            right1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            right2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
}