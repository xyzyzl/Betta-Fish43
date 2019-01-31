package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/*
 * Created by Tej Bade on 11/14/18.
 */

@TeleOp(name = "Test Encoders")
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

            double maintain = r.getCurrentAngle();
            driveForwardDistance(maintain,10, 1);

/*
            if (Math.abs(gamepad2.left_stick_y) > Math.abs(gamepad2.left_stick_x) && gamepad2.left_stick_y < -0.2) {
                driveForwardDistance(r.getCurrentAngle(), 10, 1);
            } else if (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x) && gamepad1.left_stick_y < -0.2) {
                r.driveForward(1);
            } else
                r.stopDriving();
*/
            idle();
        }

        r.stopDriving();
        r.stop();

    }

}