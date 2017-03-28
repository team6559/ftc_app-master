package org.firstinspires.ftc.teamcode;

import android.os.Environment;
import android.provider.ContactsContract;
import android.text.method.DateTimeKeyListener;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import android.content.*;
import java.io.*;

import java.util.Date;
import ftc.backcode.*;
import org.firstinspires.ftc.robotcontroller.internal.FtcRobotControllerActivity;

/**
 * Created by bryanperkins on 1/1/01.
 */
@TeleOp (name = "On The Fly Autonomous")
public class OnTheFlyCreator extends OpModeBase {

    public static final int RES = 5;
    private long milliseconds;
    private long startTimeSinceEpoch;
    List<MotionPoint> points = new ArrayList<MotionPoint>();
    public void start()
    {
        startTimeSinceEpoch = System.currentTimeMillis();
        milliseconds = 0;
    }
    int i = 0;
    public void loop()
    {
        if (i < RES) {
            if (milliseconds >= (i + 1) * 30000 / RES) {
                points.add(new MotionPoint(new Vector2(-gamepad1.left_stick_x, -gamepad1.left_stick_y, -gamepad1.right_stick_x), (int) milliseconds));
                i++;
            }
        }
        move(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x,false);
        //Save inputs based on resolution
        milliseconds = System.currentTimeMillis() - startTimeSinceEpoch;
        telemetry.addData("Time:", milliseconds);

    }
    public void stop()
    {
        //Save to file
        ObjectOutputStream obj = null;
        try {
            File dir = new File(Environment.getExternalStorageDirectory()+"/robotSaves");
            if (!(dir.exists() && dir.isDirectory()))
            {
                dir.mkdirs();
            }
            obj =  new ObjectOutputStream(new FileOutputStream(Environment.getExternalStorageDirectory() + "/robotSaves/" +"current.mtmp"));
            obj.writeObject(points);
        }
        catch (FileNotFoundException fl)
        {
            telemetry.addData("FIILE IS NOT FOUND", 1);
            System.out.println(fl.getStackTrace());
        }
        catch (IOException io)
        {
            telemetry.addData("IO EXCEPTION", 2);
            System.out.println(io.getStackTrace());
        }
        finally
        {
            try {
                if (obj != null) {
                    obj.flush();
                    obj.close();
                }
            }
            catch (IOException io)
            {
                telemetry.addData("IO EXCEPTION", 2);
                System.out.println(io.getStackTrace());
            }
        }
    }


}