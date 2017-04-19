package Opmodes.Competition.Autonomous;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.configuration.Utility;

import Devices.Drivers.FieldColor;
import General.Utility.OpModeGeneral;

/**
 * Created by ironOwlKing on 2/4/2017.
 */
@Autonomous(name = "Color Sensor Only Launch Twice Hit Two Beacon Drive Sensor", group = "Competition")

public class ColorSensorOnlyLaunchTwoBallHitBeaconHitCenterBall extends OpMode {

    int stage = 1;
    boolean isBlue = true;

    public void init()
    {
        OpModeGeneral.allInit(hardwareMap);
        OpModeGeneral.colorBeacon.togglePassive();
        OpModeGeneral.colorMid.toggleActive();
    }

    public void loop() {
        telemetry.addData("ValueMid", OpModeGeneral.colorMid.getColorValue());
        telemetry.addData("EnumMid", OpModeGeneral.colorMid.getColorEnum());
        telemetry.addData("ValueBack", OpModeGeneral.colorBack.getColorValue());
        telemetry.addData("EnumBack", OpModeGeneral.colorBack.getColorEnum());


        telemetry.addData("stage", stage);
        switch (stage) {
            case 1:
                OpModeGeneral.mecanumMove(0, 1, 0, false, 0.1f);
                if (OpModeGeneral.colorMid.getColorEnum().equals(FieldColor.WHITETAPE)) {
                    stage++;
                }
            case 2:
                time = System.currentTimeMillis();
                if (OpModeGeneral.colorBeacon.getColorEnum().equals(FieldColor.BEACONRED)) {
                    if (isBlue) {
                        //Right
                        if (System.currentTimeMillis() - time < 100) {
                            OpModeGeneral.mecanumMove(-1, 0, 0, false);
                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
                            OpModeGeneral.mecanumMove(0, 1, 0, false);
                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
                            OpModeGeneral.mecanumMove(0, -1, 0, false);
                        } else {
                            stage++;
                        }
                    }
                    else {
                        //Left
                        if (System.currentTimeMillis() - time < 100) {
                            OpModeGeneral.mecanumMove(1, 0, 0, false);
                        } else if (System.currentTimeMillis() > 100 && System.currentTimeMillis() < 500) {
                            OpModeGeneral.mecanumMove(0, 1, 0, false);
                        } else if (System.currentTimeMillis() > 500 && System.currentTimeMillis() < 900) {
                            OpModeGeneral.mecanumMove(0, -1, 0, false);
                        } else {
                            stage++;
                        }
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
