package Opmodes.Competition.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import General.Utility.OpModeGeneral;


@TeleOp(name = "Drive", group = "Competition")
public class Drive extends OpMode {

    //Values used to calculate power

    private boolean _lastAButton = false;

    public void init()
    {
        OpModeGeneral.allInit(hardwareMap);
    }

    public void loop()
    {

        OpModeGeneral.mecanumMove(-gamepad1.left_stick_x, -gamepad1.left_stick_y, -gamepad1.right_stick_x, negated);
        //Trigger
        if (gamepad1.a & !_lastAButton) { triggerReverse(); }
        if (gamepad1.a) { _lastAButton = true; }
        else { _lastAButton = false; }
        OpModeGeneral.catapult.setPower(-gamepad2.left_stick_y > 0 ? -gamepad2.left_stick_y : 0);
        OpModeGeneral.combine.setPower(-gamepad2.right_stick_y);
        if (gamepad2.dpad_right){
            OpModeGeneral.flipper.setPosition(120);
        }
        else if (gamepad2.dpad_left){
            OpModeGeneral.flipper.setPosition(-120);
        }
        else {
            OpModeGeneral.flipper.setPosition(0);
        }

    }

    private boolean negated;
    public void triggerReverse ()
    {
        negated = !negated;
    }
}