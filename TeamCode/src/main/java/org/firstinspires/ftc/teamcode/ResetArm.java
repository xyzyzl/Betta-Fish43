package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;

/*
 * Created by Tej Bade on 10/6/18.
 */

@Autonomous(name="Reset Arm")
public class ResetArm extends AutoOpBase {

    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStart();

        r.rotatingArm.setPower(-0.3);

        while (opModeIsActive()) {
            idle();
        }

        r.stop();

    }

}