package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Roarbots on 11/1/2015.
 */
public class MountainLowRed extends ResQCommon {
    @Override
    public void loop(){

        super.drive(.5, 8.5);
        super.onePointTurn(.5, 90, true);
        super.drive(.5, 4);

    }

}
