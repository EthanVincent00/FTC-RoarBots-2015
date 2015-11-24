package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Roarbots on 11/1/2015.
 */
public class OppositeMLBlue extends ResQCommon {
    @Override
    public void loop(){

        super.drive(.5, 7);
        super.onePointTurn(.5, 90, true);
        super.drive(.5, 7);
    }
}
