package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo.Direction;

/*
 * Created by Tej Bade on 11/14/18.
 */

@TeleOp(name = "Test Servos")
public class TestServos extends AutoOpBase {

    double position = 1;

    public void runOpMode() throws InterruptedException {

        initRobot();

        r.leftBox.setDirection(Direction.REVERSE);
        r.rightBox.setDirection(Direction.FORWARD);

        telemetry.addData("Test 4", "");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("l position", r.leftBox.getPosition());
            telemetry.addData("r position", r.rightBox.getPosition());
            telemetry.update();

            r.leftBox.setPosition(position);
            r.rightBox.setPosition(position);

            if (gamepad1.a && r.leftBox.getPosition() <= 1 && r.rightBox.getPosition() <= 1) {
                position += 0.005;
            } else if (gamepad1.b && r.leftBox.getPosition() >= 0.35 && r.rightBox.getPosition() >= 0.35) {
                position -= 0.005;
            }

            idle();

        }


        r.stop();

    }

}