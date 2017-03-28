package ftc.backcode;

import java.io.*;

/**
 * Created by bryanperkins on 1/1/01.
 */
public class MotionPoint implements Serializable{
    //W E L C O M E  T O  M O T I O N P O I N T
    public Vector2 vec;
    public int order;


    public MotionPoint (Vector2 _vec, int _order)
    {
        vec = _vec;
        order = _order;
    }


}