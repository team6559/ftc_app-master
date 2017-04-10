package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.robotcore.hardware.I2cController;
import com.qualcomm.robotcore.util.TypeConversion;

import java.util.concurrent.locks.Lock;

/**
 * Created by admin on 4/6/2017.
 */

public class I2CColorSensor6559 extends ModernRoboticsI2cColorSensor {
    public final static int ADDRESS_COLOR_INDEX_NUMBER = 0x09;
    private Lock readLock;
    private byte[] readBuffer;
    public I2CColorSensor6559(I2cController module, int physicalPort) {
        super(module, physicalPort);
        finishConstruction();
    }

    public int getColorNumber()
    {
        byte color;
        try {
            readLock.lock();
            color = readBuffer[ADDRESS_COLOR_INDEX_NUMBER];
        }
        finally {
            readLock.unlock();
        }
        return TypeConversion.unsignedByteToInt(color);

    }
}
