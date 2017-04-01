package ftc.backcode;

/**
 * Created by bryan on 3/29/17.
 */

public interface IMotionBase {

    PolarCoordinate getCoords();
    PolarCoordinate getCurrentFirePoint();

    void init();

    void loop();

    void moveToPoint(PolarCoordinate point);

    void fire();

    void rotate();

    Vector2 getCartesian ();



}
