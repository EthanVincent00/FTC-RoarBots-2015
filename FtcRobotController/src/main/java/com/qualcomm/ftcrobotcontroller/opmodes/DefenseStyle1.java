package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by Roarbots on 11/1/2015.
 */
public class DefenseStyle1 extends ResQCommon{
    @Override
    public void loop(){
        try {
            wait(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.drive(.5, 8);
    }

}
