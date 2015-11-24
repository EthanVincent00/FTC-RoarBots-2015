package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

import java.util.ArrayList;

/**
 * Created by Roarbots on 11/20/2015.
 */
public class AutonomousResQCommon extends AutonomousCommon {

    // Servo testServo;

    // double servoPosition = 0;
    String motor1 = "motor1";//left
    String motor3 = "motor2";//left
    String motor2 = "motor3";//right
    String motor4 = "motor4";//right
    String motor5 = "motor5";//tread lifter upper and lower downer
    String motor6 = "motor6";//tread power
    String motor7 = "motor7";//arm extender and shortener

    public DcMotor treadAngleMotor;
    public DcMotor treadPowerMotor;
    //public DcMotor extenderPowerMotor;

    private final double wheelSize = 6.0;
    private final double driveTrainRatio = 40.0 / 1.0;


    @Override
    public void runOpMode(){
        leftMotors = new ArrayList<DcMotor>();
        rightMotors = new ArrayList<DcMotor>();
        super.runOpMode();
        leftMotors.add(hardwareMap.dcMotor.get(motor2));
        leftMotors.add(hardwareMap.dcMotor.get(motor4));
        rightMotors.add(hardwareMap.dcMotor.get(motor1));
        rightMotors.add(hardwareMap.dcMotor.get(motor3));
        treadAngleMotor = hardwareMap.dcMotor.get(motor6);
        treadPowerMotor = hardwareMap.dcMotor.get(motor5);
        //extenderPowerMotor =hardwareMap.dcMotor.get(motor7);

        int position = leftMotors.get(0).getCurrentPosition();
        setupRobotParameters(wheelSize, driveTrainRatio);

        for (DcMotor singleMotor : rightMotors) {
            singleMotor.setDirection(DcMotor.Direction.FORWARD);
            singleMotor.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        }
        for (DcMotor singleMotor : leftMotors) {
            singleMotor.setDirection(DcMotor.Direction.REVERSE);
            singleMotor.setChannelMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        }

        treadAngleMotor.setDirection(DcMotor.Direction.FORWARD);
        treadAngleMotor.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        treadPowerMotor.setDirection(DcMotor.Direction.REVERSE);
        treadPowerMotor.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
    }

    public void setLeftPower(double leftMotorPower) {
        super.setLeftPower(leftMotorPower);
    }

    public void setRightPower(double rightMotorPower) {
        super.setRightPower(rightMotorPower);
    }

    /*public void setExtenderPower (double extenderMotorPower) {
        extenderPowerMotor.setPower(extenderMotorPower);
    }*/

    public void reset () {
        for (int i = 0; i < rightMotors.size(); i++) {
            rightMotors.get(i).setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
            leftMotors.get(i).setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        }
        treadAngleMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        treadPowerMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
    }
}
