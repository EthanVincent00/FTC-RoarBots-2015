package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roarbots on 11/20/2015.
 */
public abstract class AutonomousRoarbotsCommon extends LinearOpMode {

    protected List<DcMotor> leftMotors = new ArrayList<DcMotor>();
    protected List<DcMotor> rightMotors = new ArrayList<DcMotor>();

    // Limits constants
    // final static double SERVO_MIN_RANGE  = 0.20;
    // final static double SERVO_MAX_RANGE  = 0.90;
    final static double MOTOR_MIN_RANGE  = -1.0;
    final static double MOTOR_MAX_RANGE  = 1.0;

    @Override
    public void runOpMode(){
    }

    public void setLeftPower(double power) {
        for (DcMotor singleMotor : leftMotors) {
            singleMotor.setPower(power);
        }
    }

    public void setRightPower(double power) {
        for (DcMotor singleMotor : rightMotors) {
            singleMotor.setPower(power);
        }
    }
}
