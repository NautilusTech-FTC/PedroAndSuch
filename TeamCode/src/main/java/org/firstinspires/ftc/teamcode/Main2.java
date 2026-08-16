package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.*;

public class Main2 extends OpMode {
    private DriveTrain drive;
    private Intake2 intake;

    double lSY;
    double lSX;
    double rSX;
    double lT;
    double rT;
    boolean lB;
    boolean rB;

    public void init() {
        drive = new DriveTrain(
                hardwareMap,
                "Motor0", "Motor1", "Motor2", "Motor3",
                REVERSE, FORWARD, FORWARD, REVERSE);

        intake = new Intake2(hardwareMap, "IntakeMotor", "TransferServo");
    }

    public void loop() {
        ctrlVars();

        if (lB && !rB) {
            intake.setIntakePower(-1 + lT);
            intake.setTransferPower(-0.75);
        } else if (rB && !lB) {
            intake.setIntakePower(1 - lT);
            intake.setTransferPower(0.75);
        } else {
            intake.setIntakePower(0);
            intake.setTransferPower(0);
        }

        drive.operate(lSY, lSX, rSX);
    }

    private void ctrlVars() {
        lSY = gamepad1.left_stick_y;
        lSX = gamepad1.left_stick_x;
        rSX = gamepad1.right_stick_x;
        lT = gamepad1.left_trigger;
        rT = gamepad1.right_trigger;
        lB = gamepad1.left_bumper;
        rB = gamepad1.right_bumper;

        if (lT <= 0.1) {lT = 0.1;}
    }
}
