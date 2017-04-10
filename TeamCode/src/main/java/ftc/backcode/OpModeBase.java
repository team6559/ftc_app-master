package ftc.backcode;

import android.support.annotation.ColorRes;

import com.qualcomm.hardware.ams.AMSColorSensor;
import com.qualcomm.hardware.ams.AMSColorSensorImpl;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DigitalChannelController;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * Created by union on 11/8/16.
 */

public abstract class OpModeBase extends OpMode {

    public static DcMotor left1;
    public static DcMotor right1;
    public static DcMotor combine;
    public static DcMotor left2;
    public static DcMotor right2;
    public static DcMotor catapult;
    public static I2cDevice colorMid;
    public static ColorSensor colorBeacon;
    public static Servo flipper;

    public void init()
    {
        //Motors
        right1 = hardwareMap.dcMotor.get("frontRight");
        left1 = hardwareMap.dcMotor.get("frontLeft");
        right2 = hardwareMap.dcMotor.get("backRight");
        left2 = hardwareMap.dcMotor.get("backLeft");
        combine = hardwareMap.dcMotor.get("combine");
        catapult = hardwareMap.dcMotor.get("Catapult");

        //Color Sensors
        colorBeacon = hardwareMap.colorSensor.get("colorBeacon");
        flipper = hardwareMap.servo.get("flipper");

        flipper.setPosition(0);
    }

    public void loop()
    {

    }

    public void start()
    {

    }

    private static double _topLeft, _topRight, _bottomLeft, _bottomRight, _maxVector;

    public static void move(double leftX, double leftY, double rightX, boolean negated){
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

    public static void turn(double turnSpeed){
        move(0,0,turnSpeed,false);
    }

    public static void driveAngle(float angle, float power)
    {
        float b = (float) Math.sin(90-angle);
        float a = (float) (Math.pow(power,2) - Math.pow(b,2));
        move(a, b, 0,false);
    }

    public static void resetEncoders(boolean useEncoders)
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