package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/*
 * Created by Tej Bade on 11/14/18.
 */

@TeleOp(name="Test Encoders")
public class TestEncoders extends AutoOpBase {

    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("LF", r.leftFront.getPower());
            telemetry.addData("RF", r.rightFront.getPower());
            telemetry.addData("LB", r.leftBack.getPower());
            telemetry.addData("RB", r.leftBack.getPower());
            telemetry.update();

            if(gamepad1.right_bumper) {
                driveForwardDistance(r.getCurrentAngle(), 10, 1);
                while(gamepad1.right_bumper) {
                    //DO NOTHING
                }
            } else if(gamepad1.left_bumper) {
                r.driveForward(0.05);
            } else
                r.stopDriving();

            idle();
        }

        r.stop();

    }

}