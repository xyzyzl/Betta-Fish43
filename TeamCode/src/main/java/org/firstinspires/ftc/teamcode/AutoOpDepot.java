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

        startRobot(); //drops down, views the minerals, and drives forward

        //SAMPLING CODE
        if(r.location == 0) { //left from robot's point of view
            mecanumStrafeLeftTime(0.5, 1000);
            driveForwardDistance(r.getCurrentAngle(),10, 0.5);
            driveBackwardDistance(r.getCurrentAngle(),5, 0.5);
            turnRightToAngle(r.getCurrentAngle() - 90);
            driveForwardDistance(r.getCurrentAngle(),20, 1);
        } else if (r.location == 2) { //right from robot's point of view
            driveForwardDistance(r.getCurrentAngle(),10, 0.5);
            driveBackwardDistance(r.getCurrentAngle(),5, 0.5);
            turnRightToAngle(r.getCurrentAngle() - 90);
            driveForwardDistance(r.getCurrentAngle(),37, 1);
        } else { //center from robot's point of view
            mecanumStrafeRightTime(0.5, 1000);
            driveForwardDistance(r.getCurrentAngle(),10, 0.5);
            driveBackwardDistance(r.getCurrentAngle(),5, 0.5);
            turnRightToAngle(r.getCurrentAngle() - 90);
            driveForwardDistance(r.getCurrentAngle(),54, 1);
        }

        turnLeftToAngle(r.getCurrentAngle() + 7);
        sleep(200);

        mecanumStrafeLeftTime(0.5, 600);

        mecanumStrafeRightTime(0.5, 500);

        driveForwardDistance(r.getCurrentAngle(), 20, 0.7);

        dropMarker();

        driveBackwardDistance(r.getCurrentAngle(), 60, 0.7);

        r.stopDriving();

        while (opModeIsActive()) {
            idle();
        }

        r.stop();
    }

}