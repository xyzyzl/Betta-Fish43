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

        TensorFlowSampling tf = new TensorFlowSampling(hardwareMap, telemetry);
        telemetry.addData("Location: ", tf.location);
        telemetry.update();

        while (opModeIsActive()) {
            idle();
        }

    }

}