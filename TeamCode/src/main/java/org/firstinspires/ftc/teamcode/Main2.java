package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.*;

public class Main2 extends OpMode {
    private DriveTrain drive;

    double lSY;
    double lSX;
    double rSX;

    public void init() {
        drive = new DriveTrain(
                hardwareMap,
                "Motor0", "Motor1", "Motor2", "Motor3",
                REVERSE, FORWARD, FORWARD, REVERSE);
    }

    public void loop() {
        ctrlVars();

        drive.operate(lSY, lSX, rSX);
    }

    private void ctrlVars() {
        lSY = gamepad1.left_stick_y;
        lSX = gamepad1.left_stick_x;
        rSX = gamepad1.right_stick_x;
    }
}
