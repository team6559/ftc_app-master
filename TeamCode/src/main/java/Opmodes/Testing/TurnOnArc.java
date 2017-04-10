package Opmodes.Testing;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import General.Utility.OpModeBase;
/**
 * Created by admin on 3/30/2017.
 */
@TeleOp(name = "Circle", group = "Testing")
public class TurnOnArc extends OpModeBase{

    //Radius from pole to the edge of the robot
    //Measurement in Inches
    int turningRadius = 39;
    public void loop(){
        if (gamepad1.dpad_up){
            turningRadius++;
        }
        else if (gamepad1.dpad_down){
            turningRadius--;
        }
        left1.setPower(turningRadius/(turningRadius-13));
        left2.setPower(turningRadius/(turningRadius-13));
        right1.setPower(-1);
        right2.setPower(-1);
        telemetry.addData("Radius:", turningRadius);
    }
}
