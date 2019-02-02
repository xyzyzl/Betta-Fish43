package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;

/*
 * Created by Tej Bade on 10/6/18.
 */

@Autonomous(name = "Depot")
public class AutoOpDepot extends AutoOpBase {

    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStart();

        startRobot(); //views the minerals, drops down, and drives forward

        //SAMPLING CODE
        switch (r.sampling) {
            case 0: //gold mineral is left from robot's point of view
                turnLeftTime(0.3, 400);
                driveForwardDistance(40, 0.7);
                turnRightTime(0.3, 950);
                driveForwardDistance(20, 0.3);
                dropMarker();
                driveBackwardDistance(r.getCurrentAngle(),70, 0.7); //drive to crater
                break;
            case 1: //gold mineral is center from robot's point of view
                driveForwardDistance(37, 0.7);
                dropMarker();
                driveBackwardDistance(24, 0.7);
                turnLeftTime(0.3, 1150);
                driveForwardDistance(45, 0.7);
                turnLeftTime(0.3, 700);
                driveForwardDistance(10, 1);
                break;
            case 2: //gold mineral is right from robot's point of view
                turnRightTime(0.7, 200);
                driveForwardDistance(30, 0.7);
                driveBackwardDistance(23, 0.7);
                turnLeftTime(0.7, 625);
                driveForwardDistance(40, 0.7);
                turnRightTime(0.7,650);
                driveForwardDistance(25, 0.7);
                dropMarker();
                driveBackwardDistance(r.getCurrentAngle(), 70, 1);
                break;
            default:
                driveForwardDistance(37, 0.7);
                dropMarker();
                driveBackwardDistance(24, 0.7);
                turnLeftTime(0.3, 1150);
                driveForwardDistance(45, 0.7);
                turnLeftTime(0.3, 700);
                driveForwardDistance(10, 1);
                break;
        }


        while (opModeIsActive()) {
            idle();
        }

        r.stop();

    }

}