package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/*
 * Created by Tej Bade on 11/14/18.
 */

@Autonomous(name = "Test Encoders")
public class TestEncoders extends AutoOpBase {

    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStart();

        driveForwardDistance(r.getCurrentAngle(), 20, 0.5);

        while(opModeIsActive()) {
            idle();
        }

        r.stopDriving();

    }

}