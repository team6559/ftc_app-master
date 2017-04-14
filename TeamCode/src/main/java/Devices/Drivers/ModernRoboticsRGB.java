package Devices.Drivers;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchImpl;

/**
 * Created by admin on 4/13/2017.
 */

public class ModernRoboticsRGB {

    byte[] colorAcache;
    byte[] colorCcache;

    I2cDevice colorA;
    I2cDevice colorC;
    I2cDeviceSynch colorAreader;
    I2cDeviceSynch colorCreader;

    boolean touchState = false;  //Tracks the last known state of the touch sensor
    boolean LEDState = true;


    public ModernRoboticsRGB (HardwareMap hardwareMap, String name)
    {
        colorA = hardwareMap.i2cDevice.get(name);
        colorAreader = new I2cDeviceSynchImpl(colorA, I2cAddr.create8bit(0x3c), false);
        colorAreader.engage();
    }

    public int getColorNum()
    {
        colorAcache = colorAreader.read(0x09, 1);
        return colorAcache[0] & 0xFF;
    }
    public FieldColor getColorEnum()
    {
        int a = getColorNum();
        if (a == 58) return FieldColor.TILEGRAY;
        if (a == 62) return FieldColor.WHITETAPE;
        if (a == 7) return FieldColor.BLUEPARTICLE;
        if (a == 7) return FieldColor.BLUECAPBALL;
        if (a == 48) return FieldColor.REDCENTERVORTEX;
        if (a == 56) return FieldColor.YELLOWCENTERVORTEX;
        if (a == 3) return FieldColor.BLUECENTERVORTEX;
        return FieldColor.CLEAR;
    }

    public int getColorValue()
    {
        colorAcache = colorAreader.read(0x04, 1);
        return colorAcache[0] & 0xFF;
    }


    public void togglePassiveActive()
    {
        colorAcache = colorAreader.read(0x04, 1);
        if (LEDState) {
            command(0x01);
        }
        else {
            command(0x00);
        }
    }

    private void command(int cmdValue)
    {
        colorAreader.write8(0x03, cmdValue);
    }


}
