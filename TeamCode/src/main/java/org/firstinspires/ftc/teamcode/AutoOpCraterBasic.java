package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;

/*
 * Created by Tej Bade on 10/6/18.
 */

@Autonomous(name="Crater Basic")
public class AutoOpCraterBasic extends AutoOpBase {

    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStart();

        startRobot(); //drop down and strafe out of hook

        double maintainAngle = r.getCurrentAngle();
        driveForwardDistance(maintainAngle, 25, 0.5); //drive forward away from lander
        sleep(200);

        while (opModeIsActive()) {
            r.intakeArm.setPower(1);
            idle();
        }

        r.stop();
    }

}