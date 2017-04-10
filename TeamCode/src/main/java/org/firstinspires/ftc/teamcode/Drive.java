package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import ftc.backcode.OpModeBase;



@TeleOp(name = "Drive", group = "UserOP")
public class Drive extends OpModeBase {

    //Values used to calculate power

    private boolean _lastAButton = false;

    public void loop()
    {

        move(-gamepad1.left_stick_x, -gamepad1.left_stick_y, -gamepad1.right_stick_x,negated);
        //Trigger
        if (gamepad1.a & !_lastAButton) { triggerReverse(); }
        if (gamepad1.a) { _lastAButton = true; }
        else { _lastAButton = false; }
        catapult.setPower(-gamepad2.left_stick_y > 0 ? -gamepad2.left_stick_y : 0);
        combine.setPower(-gamepad2.right_stick_y);
        if (gamepad2.dpad_right){
            flipper.setPosition(120);
        }
        else if (gamepad2.dpad_left){
            flipper.setPosition(-120);
        }
        else {
            flipper.setPosition(0);
        }

    }

    private boolean negated;
    public void triggerReverse ()
    {
        negated = !negated;
    }
}