package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Roarbots on 10/18/2015.
 */
public class AutonomousTest extends AutonomousResQCommon {

    @Override
    public void runOpMode(){
        super.runOpMode();
        //REMINDER: drive(motor power, distance(inches));

        try {
            drive(.75, 12);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}