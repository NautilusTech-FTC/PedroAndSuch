package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class limes extends OpMode {
    Limelight3A orangey;

    @Override
    public void init() {
        orangey = hardwareMap.get(Limelight3A.class, "Limelight");
        orangey.setPollRateHz(100);
        orangey.start();
        orangey.pipelineSwitch(0);
    }

    @Override
    public void loop() {
        LLResult result = orangey.getLatestResult();



    }
}
