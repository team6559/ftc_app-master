package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import ftc.backcode.OpModeBase;

/**
 * Created by ironOwlKing on 2/4/2017.
 */
@Autonomous(name = "DUI", group = "Autonomous")
public class LightOnlyAutonomousSwitch extends OpModeBase {

    int stage = 0;
    boolean isBlue = true;
    long time;

    public void loop() {

        telemetry.addData("stage", stage);
        switch (stage) {
            case 0:
                if (stage == 0) {
                    move(-1, 1, 0, false);

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
