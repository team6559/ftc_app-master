//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//
//import java.io.File;
//
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import java.awt.image.BufferedImage;
//import java.awt.image.DataBufferByte;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//
///**
// * Created by Takumi the HEN HAO and Jordan the annoying at union on 3/25/17.
// */
//
//public abstract class imageGrabber extends OpMode {
//    private SampleModel sampleModel;
//
//    public int[][] compute(File file) {
//        try {
//`
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
//
//
//
//    public java.awt.Image getImage(int pixels[][])
//    {
//        int w=pixels.length;
//        int h=pixels[0].length;
//        BufferedImage image=new BufferedImage(w,h,BufferedImage.TYPE_BYTE_GRAY);
//        WritableRaster raster= Raster.createWritableRaster(sampleModel, new Point(0,0));
//        for(int i=0;i<w;i++)
//        {
//            for(int j=0;j<h;j++)
//            {
//                raster.setSample(i,j,0,pixels[i][j]);
//            }
//        }
//
//        BufferedImage image=new BufferedImage(w,h,BufferedImage.TYPE_BYTE_GRAY);
//        image.setData(raster);        File output=new File("check.jpg");
//        try {
//            ImageIO.write(image,"jpg",output);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return image;
//    }
//}
