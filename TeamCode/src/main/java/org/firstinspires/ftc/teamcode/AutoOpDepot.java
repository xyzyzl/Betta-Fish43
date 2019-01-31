package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;

/*
 * Created by Tej Bade on 10/6/18.
 */

@Autonomous(name="Depot")
public class AutoOpDepot extends AutoOpBase {

    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStart();

        startRobot(); //views the minerals, drops down, and drives forward

        //SAMPLING CODE
        switch (r.sampling) {
            case 0: //gold mineral is left from robot's point of view
                turnLeftToAngle(-55);
                driveForwardDistance(r.getCurrentAngle(), 25, 0.3);
                turnRightToAngle(45);
                driveForwardDistance(r.getCurrentAngle(), 5, 0.3);
                r.rotatingArm.setPower(-1);
                sleep(1000);
                r.rotatingArm.setPower(0);
                r.intake.setPower(-0.7);
                sleep(3000); //spin outward for 3 secs.
                r.intake.setPower(0);
                driveBackwardDistance(r.getCurrentAngle(), 60, 0.3); //drive to crater
                break;
            case 1: //gold mineral is center from robot's point of view
                driveForwardDistance(r.getCurrentAngle(),25, 0.3);
                r.intake.setPower(-0.7);
                sleep(3000); //spin outward for 3 secs.
                r.intake.setPower(0);
                driveBackwardDistance(r.getCurrentAngle(),25, 0.3);
                turnRightToAngle(90);
                driveBackwardDistance(r.getCurrentAngle(),15, 0.3);
                break;
            case 2: //gold mineral is right from robot's point of view
                mecanumStrafeRightTime(0.3, 1500);
                driveForwardDistance(r.getCurrentAngle(),4, 0.3);
                driveBackwardDistance(r.getCurrentAngle(),4, 0.3);
                turnRightToAngle(90);
                driveBackwardDistance(r.getCurrentAngle(),20, 0.3);
                break;
        }


        while (opModeIsActive()) {
            idle();
        }

        r.stop();

    }

}