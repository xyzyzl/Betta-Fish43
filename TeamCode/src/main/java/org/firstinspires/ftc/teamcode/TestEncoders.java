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

            telemetry.addData("Angle", r.getCurrentAngle());
            telemetry.update();

            if(gamepad1.left_bumper)
                r.turnLeft(0.1);
            else if(gamepad1.right_bumper)
                r.turnRight(0.1);
            else
                r.stopDriving();


            idle();
        }

        r.stop();

    }

}