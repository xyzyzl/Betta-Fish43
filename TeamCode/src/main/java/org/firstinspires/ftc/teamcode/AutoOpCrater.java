package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

@Autonomous(name = "Crater")
public class AutoOpCrater extends AutoOpBase {

    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStart();

        startRobot(); //drop down, sample and strafe out of hook

        //SAMPLING CODE
        switch (r.sampling) {
            case 2: //gold mineral is left from robot's point of view
                mecanumStrafeLeftTime(0.3, 1500);
                driveForwardDistance(r.getCurrentAngle(), 5, 0.3);
                driveBackwardDistance(r.getCurrentAngle(), 5, 0.3);
                turnLeftToAngle(90);
                driveForwardDistance(r.getCurrentAngle(), 10, 0.3);
                break;
            case 1: //gold mineral is center from robot's point of view
                driveForwardDistance(10, 0.3);
                driveBackwardDistance(5, 0.3);
                turnLeftTime(0.3, 950);
                driveForwardDistance(20, 0.7);
                turnLeftTime(0.3, 100);
                driveForwardDistance(r.getCurrentAngle(),15, 0.3);
                dropMarker();
                driveBackwardDistance(r.getCurrentAngle(),65, 1);
                break;
            case 0: //gold mineral is right from robot's point of view
                mecanumStrafeRightTime(0.3, 1500);
                driveForwardDistance(r.getCurrentAngle(),5, 0.3);
                driveBackwardDistance(r.getCurrentAngle(),5, 0.3);
                turnLeftToAngle(90);
                driveForwardDistance(r.getCurrentAngle(),20, 0.3);
                break;
            default: //case 1
                driveForwardDistance(10, 0.3);
                driveBackwardDistance(5, 0.3);
                turnLeftTime(0.3, 950);
                driveForwardDistance(20, 0.7);
                turnLeftTime(0.3, 100);
                driveForwardDistance(r.getCurrentAngle(),15, 0.3);
                dropMarker();
                driveBackwardDistance(r.getCurrentAngle(),65, 1);
        }


        driveForwardDistance(25, 0.3);

        while (opModeIsActive()) {
            idle();
        }

        r.stop();
    }
}