package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import ftc.backcode.OpModeBase;

/**
 * Created by ironOwlKing on 2/4/2017.
 */
@Autonomous(group = "Autonomous", name = "DUI")
public class LightOnlyAutonomousSwitch extends OpModeBase {

    int stage = 0;
    boolean isBlue = true;
    long time;

    public void loop() {
        telemetry.addData("RedFront",colorMid.red());
        telemetry.addData("GreenFront",colorMid.green());
        telemetry.addData("BlueFront",colorMid.blue());
        telemetry.addData("AlphaFront",colorMid.alpha());
        telemetry.addData("ArgbFront", colorMid.argb());
//        telemetry.addData("RedRear",colorBack.red());
//        telemetry.addData("GreenRear",colorBack.green());
//        telemetry.addData("BlueRear",colorBack.blue());
//        telemetry.addData("AlphaRear",colorBack.alpha());
//        telemetry.addData("ArgbRear", colorBack.argb());
        telemetry.addData("RedBeacon",colorBeacon.red());
        telemetry.addData("GreenBeacon",colorBeacon.green());
        telemetry.addData("BlueBeacon",colorBeacon.blue());
        telemetry.addData("AlphaBeacon",colorBeacon.alpha());
        telemetry.addData("ArgbBeacon", colorBeacon.argb());
        telemetry.addData("stage", stage);
        switch (stage) {
            case 0:
                if (stage == 0) {
                    move(-1, 1, 0, false);
                    if (colorMid.red() > 280) {
                        move (0,0,0,false);
                        stage++;
                    }
                }
            case 1:
                if (stage == 1) {
                    move(0, 1, 0, false);
                    if (colorBeacon.red() > 680 || colorBeacon.blue() > 2000) {
                        stage++;
                    }
                }
            case 2:
                time = System.currentTimeMillis();
                if (colorBeacon.red() > 680) {
                    if (isBlue) {
                        //Right
                        if (System.currentTimeMillis() - time < 100) {
                            move(-1, 0, 0, false);
                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
                            move(0, 1, 0, false);
                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
                            move(0, -1, 0, false);
                        } else {
                            stage++;
                        }
                    } else {
                        //Left
                        if (System.currentTimeMillis() - time < 100) {
                            move(1, 0, 0, false);
                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
                            move(0, 1, 0, false);
                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
                            move(0, -1, 0, false);
                        } else {
                            stage++;
                        }
                    }
                }
                if (colorBeacon.blue() > 2000) {
                    if (isBlue) {
                        //Left
                        if (System.currentTimeMillis() - time < 100) {
                            move(1, 0, 0, false);
                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
                            move(0, 1, 0, false);
                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
                            move(0, -1, 0, false);
                        } else {
                            stage++;
                        }
                    } else {
                        //Right
                        if (System.currentTimeMillis() - time < 100) {
                            move(-1, 0, 0, false);
                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
                            move(0, 1, 0, false);
                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
                            move(0, -1, 0, false);
                        } else {
                            stage++;
                        }
                    }
                }

//            case 3:
//                time = System.currentTimeMillis();
//                if (System.currentTimeMillis() - time < 1000) {
//                    move(1, 0, 0, false);
//                } else if (colorMid.red() < 280) {
//                    stage++;
//                }
//            case 4:
//                time = System.currentTimeMillis();
//                if (colorBeacon.red() > 680) {
//                    if (isBlue) {
//                        //Right
//                        if (System.currentTimeMillis() - time < 100) {
//                            move(-1, 0, 0, false);
//                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
//                            move(0, 1, 0, false);
//                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
//                            move(0, -1, 0, false);
//                        } else {
//                            stage++;
//                        }
//                    } else {
//                        //Left
//                        if (System.currentTimeMillis() - time < 100) {
//                            move(1, 0, 0, false);
//                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
//                            move(0, 1, 0, false);
//                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
//                            move(0, -1, 0, false);
//                        } else {
//                            stage++;
//                        }
//                    }
//                }
//                if (colorBeacon.blue() > 2000) {
//                    if (isBlue) {
//                        //Left
//                        if (System.currentTimeMillis() - time < 100) {
//                            move(1, 0, 0, false);
//                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
//                            move(0, 1, 0, false);
//                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
//                            move(0, -1, 0, false);
//                        } else {
//                            stage++;
//                        }
//                    } else {
//                        //Right
//                        if (System.currentTimeMillis() - time < 100) {
//                            move(-1, 0, 0, false);
//                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
//                            move(0, 1, 0, false);
//                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
//                            move(0, -1, 0, false);
//                        } else {
//                            stage++;
//                        }
//                    }
//                }
//
//        }  case 1:
//                move(0, 1, 0, false);
//                if (colorBeacon.red() > 680 || colorBeacon.blue() > 2000) {
//                    stage++;
//                }
//            case 2:
//                time = System.currentTimeMillis();
//                if (colorBeacon.red() > 680) {
//                    if (isBlue) {
//                        //Right
//                        if (System.currentTimeMillis() - time < 100) {
//                            move(-1, 0, 0, false);
//                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
//                            move(0, 1, 0, false);
//                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
//                            move(0, -1, 0, false);
//                        } else {
//                            stage++;
//                        }
//                    } else {
//                        //Left
//                        if (System.currentTimeMillis() - time < 100) {
//                            move(1, 0, 0, false);
//                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
//                            move(0, 1, 0, false);
//                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
//                            move(0, -1, 0, false);
//                        } else {
//                            stage++;
//                        }
//                    }
//                }
//                if (colorBeacon.blue() > 2000) {
//                    if (isBlue) {
//                        //Left
//                        if (System.currentTimeMillis() - time < 100) {
//                            move(1, 0, 0, false);
//                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
//                            move(0, 1, 0, false);
//                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
//                            move(0, -1, 0, false);
//                        } else {
//                            stage++;
//                        }
//                    } else {
//                        //Right
//                        if (System.currentTimeMillis() - time < 100) {
//                            move(-1, 0, 0, false);
//                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
//                            move(0, 1, 0, false);
//                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
//                            move(0, -1, 0, false);
//                        } else {
//                            stage++;
//                        }
//                    }
//                }
//
//            case 3:
//                time = System.currentTimeMillis();
//                if (System.currentTimeMillis() - time < 1000) {
//                    move(1, 0, 0, false);
//                } else if (colorMid.red() < 280) {
//                    stage++;
//                }
//            case 4:
//                time = System.currentTimeMillis();
//                if (colorBeacon.red() > 680) {
//                    if (isBlue) {
//                        //Right
//                        if (System.currentTimeMillis() - time < 100) {
//                            move(-1, 0, 0, false);
//                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
//                            move(0, 1, 0, false);
//                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
//                            move(0, -1, 0, false);
//                        } else {
//                            stage++;
//                        }
//                    } else {
//                        //Left
//                        if (System.currentTimeMillis() - time < 100) {
//                            move(1, 0, 0, false);
//                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
//                            move(0, 1, 0, false);
//                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
//                            move(0, -1, 0, false);
//                        } else {
//                            stage++;
//                        }
//                    }
//                }
//                if (colorBeacon.blue() > 2000) {
//                    if (isBlue) {
//                        //Left
//                        if (System.currentTimeMillis() - time < 100) {
//                            move(1, 0, 0, false);
//                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
//                            move(0, 1, 0, false);
//                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
//                            move(0, -1, 0, false);
//                        } else {
//                            stage++;
//                        }
//                    } else {
//                        //Right
//                        if (System.currentTimeMillis() - time < 100) {
//                            move(-1, 0, 0, false);
//                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
//                            move(0, 1, 0, false);
//                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
//                            move(0, -1, 0, false);
//                        } else {
//                            stage++;
//                        }
//                    }
//                }

        }


    }
}
