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

        while(opModeIsActive()) {
            sampling();
            telemetry.addData("Sampling", r.sampling);
            telemetry.update();
        }

        r.stop();

    }

}