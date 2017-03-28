package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by union on 2/10/17.
 */

public class PracticeTank extends OpMode{
    public static DcMotor MotorFR, MotorFL, MotorBL, MotorBR;
    public static Servo thing;
    public boolean flaggyFlag, onOff;

    public void init(){
        MotorFR = hardwareMap.dcMotor.get("FrontRight");
        MotorFL = hardwareMap.dcMotor.get("FrontLeft");
        MotorBR = hardwareMap.dcMotor.get("BackRight");
        MotorBL = hardwareMap.dcMotor.get("BackLeft");
        thing = hardwareMap.servo.get("servo");
    }

    public void loop(){

    }
}
