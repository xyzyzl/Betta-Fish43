package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor;

/*
 * Created by Tej Bade on 10/6/18.
 */

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp")
public class TeleOp extends LinearOpMode {
    Robot r = new Robot();
    int direction = 1;
    int extendingLimit = 0;
    int farRotationLimit = 0;
    int closeRotationLimit = 0;
    int rotStop = 1;
    int mode = 1;


    public void runOpMode() throws InterruptedException {
        // Initialize the drive system variables.
        // The init() method of the hardware class does all the work here
        r.init(hardwareMap, telemetry);
        r.resetEncoders();
        r.setUseEncoderMode();
        telemetry.addData("Initialization", "Success");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            // Display Modes
            if (direction == 1)
                telemetry.addData("Direction", "Forward");
            else if (direction == -1)
                telemetry.addData("Direction", "Reverse");

            if (mode == 1)
                telemetry.addData("Mode", "Crater");
            else if (mode == -1)
                telemetry.addData("Mode", "Lander");

            if (rotStop == 1)
                telemetry.addData("Rotation Stop", "1");
            else if (rotStop == -1)
                telemetry.addData("Rotation Stop", "2");

            telemetry.update();

            //Gamepad 1

            if (gamepad1.left_stick_button) {
                direction = -direction;
                while (gamepad1.left_stick_button) {
                    //DO NOTHING UNTIL RELEASED
                }
            }

            if (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x) && gamepad1.left_stick_y < -0.2)
                r.driveForward(Math.abs(gamepad1.left_stick_y) * direction);
            else if (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x) && gamepad1.left_stick_y > 0.2)
                r.driveBackward(Math.abs(gamepad1.left_stick_y) * direction);
            else if (gamepad1.right_stick_x > 0.2)
                r.turnRight(Math.abs(gamepad1.right_stick_x));
            else if (gamepad1.right_stick_x < -0.2)
                r.turnLeft(Math.abs(gamepad1.right_stick_x));
            else if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y) && gamepad1.left_stick_x > 0.2)
                r.mecanumStrafeRight(Math.abs(gamepad1.left_stick_x) * direction);
            else if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y) && gamepad1.left_stick_x < -0.2)
                r.mecanumStrafeLeft(Math.abs(gamepad1.left_stick_x) * direction);
            else
                r.stopDriving();

            //Gamepad 2

            if (gamepad2.left_stick_button) {
                rotStop = -rotStop;
                if (rotStop == -1) { //lander
                    r.rotatingArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    r.extendingArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    r.rotatingArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    r.extendingArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    extendingLimit = r.extendingArm.getCurrentPosition() + 1850;
                    farRotationLimit = r.rotatingArm.getCurrentPosition() + 3800;
                    closeRotationLimit = r.rotatingArm.getCurrentPosition() + 2100;
                }

                while (gamepad2.left_stick_button) {
                    //DO NOTHING UNTIL RELEASED
                }
            }

            if (gamepad2.right_stick_button) {
                mode = -mode;
                while (gamepad2.right_stick_button) {
                    //DO NOTHING UNTIL RELEASED
                }
            }

            if (mode == 1) { //crater
                if (gamepad2.y)
                    r.rotatingArm.setPower(0.5);
                else if (gamepad2.a)
                    r.rotatingArm.setPower(-0.5);
                else
                    r.rotatingArm.setPower(0);

                if (gamepad2.b) {
                    r.extendingArm.setPower(1);
                } else if (gamepad2.x) {
                    r.extendingArm.setPower(-1);
                } else
                    r.extendingArm.setPower(0);

            } else if (mode == -1) { //lander

                if (rotStop == 1) {
                    if (gamepad2.y && r.rotatingArm.getCurrentPosition() < closeRotationLimit)
                        r.rotatingArm.setPower(0.5);
                    else if (gamepad2.a)
                        r.rotatingArm.setPower(-0.5);
                    else
                        r.rotatingArm.setPower(0);

                } else if (rotStop == -1) {
                    if (gamepad2.y && r.rotatingArm.getCurrentPosition() < farRotationLimit) {
                        r.rotatingArm.setPower(0.8);
                    } else if (gamepad2.a) {
                        r.rotatingArm.setPower(-0.8);
                    } else
                        r.rotatingArm.setPower(0);
                }

                if (gamepad2.b && r.extendingArm.getCurrentPosition() < extendingLimit) {
                    r.extendingArm.setPower(0.7);
                } else if (gamepad2.x) {
                    r.extendingArm.setPower(-0.7);
                } else
                    r.extendingArm.setPower(0);

            }

            if (gamepad2.left_bumper) {
                r.intake.setPower(-1); //outtake
            } else if (gamepad2.right_bumper) {
                r.intake.setPower(1); //intake
            } else {
                r.intake.setPower(0);
            }

            if (gamepad2.dpad_up)
                r.winch.setPower(-1);
            else if (gamepad2.dpad_down)
                r.winch.setPower(1);
            else
                r.winch.setPower(0);

            idle();
        }

        r.stop();

    }

}
