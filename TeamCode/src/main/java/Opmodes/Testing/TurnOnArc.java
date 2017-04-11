package Opmodes.Testing;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import General.Utility.OpModeGeneral;

/**
 * Created by admin on 3/30/2017.
 */
@TeleOp(name = "Circle", group = "Testing")
public class TurnOnArc extends OpMode {

    //Radius from pole to the edge of the robot
    //Measurement in Inches

    public void init()
    {
        OpModeGeneral.allInit(hardwareMap);
    }

    int turningRadius = 39;
    public void loop(){
        if (gamepad1.dpad_up){
            turningRadius++;
        }
        else if (gamepad1.dpad_down){
            turningRadius--;
        }
        OpModeGeneral.left1.setPower(turningRadius/(turningRadius-13));
        OpModeGeneral.left2.setPower(turningRadius/(turningRadius-13));
        OpModeGeneral.right1.setPower(-1);
        OpModeGeneral.right2.setPower(-1);
        telemetry.addData("Radius:", turningRadius);
    }
}
