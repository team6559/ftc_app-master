package org.firstinspires.ftc.teamcode;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import ftc.backcode.MotionPoint;
import ftc.backcode.OpModeBase;
import ftc.backcode.Vector2;

/**
 * Created by union on 2/7/17.
 */

public class OnTheFlyReader extends OpModeBase {

    List<MotionPoint> points = new ArrayList<MotionPoint>();
    List<MotionPoint> in;
    float x;
    float y;
    float rot;
    public static final int RES = 5;
    private long milliseconds;
    private long startTimeSinceEpoch;

    public void start() {
        try {
            in = (List<MotionPoint>) new ObjectInputStream(new FileInputStream(Environment.getExternalStorageDirectory() + "/robotSaves/" + "current.mtmp"));
        } catch (FileNotFoundException FNFE) {
            telemetry.addData("FILE IS NOT FOUND", 1);
            System.out.println(FNFE.getStackTrace());
        } catch (IOException IOE) {
            telemetry.addData("IO EXCEPTION", 2);
            System.out.println(IOE.getStackTrace());
        }

    }
    int i = 0;
    public void loop()
    {
        if (i < RES) {
            if (milliseconds >= (i + 1) * 30000 / RES) {
                i++;
            }
        }
        MotionPoint currentPoint = points.get(i);
        Vector2 vec = currentPoint.vec;
        move(vec.x,vec.y,vec.rot,false);
        milliseconds = System.currentTimeMillis() - startTimeSinceEpoch;
        telemetry.addData("Time:", milliseconds);

    }
}
