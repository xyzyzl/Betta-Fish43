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
        double maintain;

        if (r.location == 0) { // left from robot's point of view
            mecanumStrafeLeftTime(0.5, 2000);
            driveForwardDistance(20, 0.5);
            driveBackwardDistance(10, 0.5);
            turnRightToAngle(r.getCurrentAngle() - 90);
            driveForwardDistance(50, 1);
        } else if (r.location == 2) { // right from robot's point of view
            mecanumStrafeLeftTime(0.5, 1000);
            driveForwardDistance(20, 0.5);
            sleep(100);
            driveBackwardDistance(10, 0.5);
            turnRightToAngle(r.getCurrentAngle() - 90);
            driveForwardDistance(25, 1);
        } else { // center from robot's point of view
            mecanumStrafeRightTime(0.5, 1000);
            driveForwardDistance(20, 0.5);
            sleep(100);
            driveBackwardDistance(10, 0.5);
            turnRightToAngle(r.getCurrentAngle() - 90);
            driveForwardDistance(30, 1);
        }

        double angle = r.getCurrentAngle() + 1;
        turnLeftToAngle(angle); //turn to depot
        sleep(500);

        maintain = r.getCurrentAngle();
        driveForwardDistance(maintain, 36, 1);
        angle = r.getCurrentAngle() + 0.5;
        turnLeftToAngle(angle);
        maintain = r.getCurrentAngle();
        driveForwardDistance(maintain, 30, 0.8);
        angle = r.getCurrentAngle() + 2;
        turnRightToAngle(angle);
        maintain = r.getCurrentAngle();
        driveForwardDistance(maintain, 75, 1);
        r.stop();
    }
}