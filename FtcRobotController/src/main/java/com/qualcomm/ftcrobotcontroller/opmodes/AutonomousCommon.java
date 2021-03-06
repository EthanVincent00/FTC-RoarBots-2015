package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

import static java.lang.Thread.sleep;

/**
 * Created by Roarbots on 11/20/2015.
 */
public class AutonomousCommon extends AutonomousRoarbotsCommon {

    @Override
    public void runOpMode() {
        super.runOpMode();

    }

    private double myWheelSize;
    private double driveTrainRatio;
    private static final double encoderClicksPerRev = 280;
    private static final double motorRatio = 40;
    private static final double driveRatio = 1;
    private static final double wheelSize = 6;
    private static final double clicksPerInch = (encoderClicksPerRev * motorRatio * driveRatio) / (Math.PI * wheelSize);

    /*
     * Sets up the parameters of the robot to use in our functions
     *
     * wheelSize = Diameter of the wheel in inches
     */
    public void setupRobotParameters(double myWheelSize, double myDriveTrainRatio) {
        myWheelSize = this.myWheelSize;
        driveTrainRatio = myDriveTrainRatio;
    }

    /*
     * Drive the robot forward or backward for a distance.
     *
     * speed    = 1.0 through -1.0 sets the motor power
     * distance = The distance in inches to travel
     */

    // 280 - clicks per encoder revolution
    //  clicks per inch
    public void drive(double speed, double distance) throws InterruptedException {
        int clicksForDistance = (int)(distance * clicksPerInch);
        for (DcMotor singleMotor : rightMotors) {
            singleMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        }
        for (DcMotor singleMotor : leftMotors) {
            singleMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        }
        /*while (leftMotors.get(0).getCurrentPosition() != 0) {
            sleep(200);
        }*/
        leftMotors.get(0).setTargetPosition(clicksForDistance);
        for (DcMotor singleMotor : rightMotors) {
            singleMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        }
        for (DcMotor singleMotor : leftMotors) {
            singleMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        }
        int position = leftMotors.get(0).getCurrentPosition();

        do {
            for (DcMotor singleMotor : leftMotors) {
                singleMotor.setPower(speed);
            }
            for (DcMotor singleMotor : rightMotors) {
                singleMotor.setPower(speed);
            }
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            position = leftMotors.get(0).getCurrentPosition();
        } while (position < clicksForDistance);
    }

    /*  Creates a function to define a One Point Turn.
        speed = speed of motors
        angle = angle of turn in degrees
        left = direction: left or right
     */
    public void onePointTurn(double speed, double angle, boolean left) {
        if (left == true) {
            for (DcMotor singleMotor : leftMotors) {
                singleMotor.setPower(speed);
            }
        } else {
            for (DcMotor singleMotor : rightMotors) {
                singleMotor.setPower(speed);
            }
        }
    }

    /*  Creates a function that defines a Two Point Turn.
        speed = speed of motors
        angle = angle of turn in degrees
        left = direction: left or right
     */
    public void twoPointTurn(double speed, double angle, boolean left) {
        if (left == true) {
            for (DcMotor singleMotor : leftMotors) {
                singleMotor.setPower(speed);
            }
            for (DcMotor singleMotor : rightMotors) {
                singleMotor.setPower(speed * .5);
            }
        } else {
            for (DcMotor singleMotor : leftMotors) {
                singleMotor.setPower(speed * .5);
            }
            for (DcMotor singleMotor : rightMotors) {
                singleMotor.setPower(speed);
            }
        }
    }
}
