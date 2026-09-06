package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TestJankyUI extends OpMode {
    @Override
    public void init() {
        telemetry.addData("alliance: ", Robot.Infoz.alliance);
        telemetry.addData("drive: ", Robot.Infoz.drive);
        telemetry.addData("start position: ", Robot.Infoz.startPosition);
        telemetry.addData("auto: ", Robot.Infoz.auto);
    }

    @Override
    public void loop() {

    }
}
