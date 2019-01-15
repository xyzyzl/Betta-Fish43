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
        switch (r.sampling) {
            case 0: //gold mineral is left from robot's point of view
                mecanumStrafeLeftTime(0.3, 1500);
                driveForwardDistance(r.getCurrentAngle(), 3, 0.05);
                driveBackwardDistance(r.getCurrentAngle(), 3, 0.05);
                turnRightToAngle(-90);
                driveBackwardDistance(r.getCurrentAngle(), 10, 0.05);
                break;
            case 1: //gold mineral is center from robot's point of view
                driveForwardDistance(r.getCurrentAngle(),3, 0.05);
                driveBackwardDistance(r.getCurrentAngle(),3, 0.05);
                turnRightToAngle(-90);
                driveBackwardDistance(r.getCurrentAngle(),15, 0.05);
                break;
            case 2: //gold mineral is right from robot's point of view
                mecanumStrafeRightTime(0.3, 1500);
                driveForwardDistance(r.getCurrentAngle(),3, 0.05);
                driveBackwardDistance(r.getCurrentAngle(),3, 0.05);
                turnRightToAngle(-90);
                driveBackwardDistance(r.getCurrentAngle(),20, 0.05);
                break;
            default: //case 1
                driveForwardDistance(r.getCurrentAngle(),3, 0.05);
                driveBackwardDistance(r.getCurrentAngle(),3, 0.05);
                turnRightToAngle(-90);
                driveBackwardDistance(r.getCurrentAngle(),15, 0.05);
        }
        telemetry.addData("Location", r.sampling); // checks the current position of the mineral
        telemetry.update(); // since it got deleted :(

        turnLeftToAngle(-45);

        mecanumStrafeLeftTime(0.1, 3000); //align with wall

        mecanumStrafeRightTime(0.1, 500);

        driveForwardDistance(r.getCurrentAngle(), 20, 0.05); //drive to depot

        dropMarker();

        driveBackwardDistance(r.getCurrentAngle(), 60, 0.05); //drive to crater

        r.stopDriving();

        while (opModeIsActive()) {
            idle();
        }

        r.stop();

    }

}