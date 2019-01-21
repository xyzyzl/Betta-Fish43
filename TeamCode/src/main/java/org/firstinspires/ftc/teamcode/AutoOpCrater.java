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
            case 0: //gold mineral is left from robot's point of view
                mecanumStrafeLeftTime(0.3, 1500);
                driveForwardDistance(r.getCurrentAngle(), 5, 0.3);
                driveBackwardDistance(r.getCurrentAngle(), 5, 0.3);
                turnLeftToAngle(90);
                driveForwardDistance(r.getCurrentAngle(), 10, 0.3);
                break;
            case 1: //gold mineral is center from robot's point of view
                driveForwardDistance(r.getCurrentAngle(),5, 0.3);
                driveBackwardDistance(r.getCurrentAngle(),5, 0.3);
                turnLeftToAngle(90);
                driveForwardDistance(r.getCurrentAngle(),15, 0.3);
                break;
            case 2: //gold mineral is right from robot's point of view
                mecanumStrafeRightTime(0.3, 1500);
                driveForwardDistance(r.getCurrentAngle(),5, 0.3);
                driveBackwardDistance(r.getCurrentAngle(),5, 0.3);
                turnLeftToAngle(90);
                driveForwardDistance(r.getCurrentAngle(),20, 0.3);
                break;
            default: //case 1
                driveForwardDistance(r.getCurrentAngle(),5, 0.3);
                driveBackwardDistance(r.getCurrentAngle(),5, 0.3);
                turnLeftToAngle(90);
                driveForwardDistance(r.getCurrentAngle(),15, 0.3);
        }

        turnLeftToAngle(135);

        mecanumStrafeRightTime(0.5, 3000); //align with wall

        mecanumStrafeLeftTime(0.5, 500);

        driveForwardDistance(r.getCurrentAngle(), 20, 0.3); //drive to depot

        r.intake.setPower(-0.7);
        sleep(3000); //spin outward for 3 secs.
        r.intake.setPower(0);

        driveBackwardDistance(r.getCurrentAngle(), 60, 0.3); //drive to crater

        r.stopDriving();

        while (opModeIsActive()) {
            idle();
        }

        r.stop();
    }
}