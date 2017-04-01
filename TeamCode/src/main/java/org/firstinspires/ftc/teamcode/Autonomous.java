package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import ftc.backcode.IMotionBase;
import ftc.backcode.OpModeDefaults;
import ftc.backcode.PolarCoordinate;
import ftc.backcode.Vector2;

public class Autonomous extends OpMode implements IMotionBase {

    private PolarCoordinate startPosition;
    private PolarCoordinate coordinate;
    //This is your rotation relative to the x axis of the field
    private float globalRotation;
    //This is your rotation relative to the center vortex
    private float rotationVortexRelative;
    private float currentFireRange;



    public PolarCoordinate getCoords()
    {
        return coordinate;
    }

    public void init()
    {
        OpModeDefaults.basicInit(hardwareMap);
        startPosition = OpModeDefaults.getPosition();

    }

    public void moveToPoint(PolarCoordinate point)
    {
        coordinate = OpModeDefaults.getPosition();



    }
    public void fire()
    {

    }
    public void rotate()
    {

    }

    public Vector2 getCartesian()
    {
        float x = (float) (coordinate.radius * Math.cos(coordinate.theta));
        float y = (float) (coordinate.radius * Math.sin(coordinate.theta));
        return new Vector2(x,y,0);
    }

    public PolarCoordinate getCurrentFirePoint()
    {
        Vector2 pos = getCartesian();
        

        return new PolarCoordinate(0,0);
    }



    public void loop() { }

}
