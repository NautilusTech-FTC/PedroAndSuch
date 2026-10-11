package org.firstinspires.ftc.teamcode.StarterBot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class teleOp extends OpMode {
    Drive drive = new Drive();
    Intake intake = new Intake();
    Transfer transfer = new Transfer();
    Shooter shooter = new Shooter();

    public void init() {
        drive.init(hardwareMap);
        intake.init(hardwareMap);
        transfer.init(hardwareMap);
        shooter.init(hardwareMap);
    }

    public void loop() {
        drive.robotCentric(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

        if (gamepad2.left_bumper) {
            intake.setPowerIntake(1);
            intake.setPowerWheels(-1);
        } else if (gamepad2.right_bumper) {
            intake.setPowerIntake(-1);
            intake.setPowerWheels(1);
        } else {
            intake.setPowerIntake(0);
            intake.setPowerWheels(0);
        }

        if (gamepad2.y) {
            transfer.setPowerTransfer(1);
        } else if (gamepad2.a) {
            transfer.setPowerTransfer(-1);
        } else {
            transfer.setPowerTransfer(0);
        }

        if (gamepad2.x) {
            shooter.setShooterVelocity(1320);
        }
        if (gamepad2.b) {
            shooter.setShooterVelocity(0);
        }

        double shooterVelocity = shooter.getShooterVelocity();
        telemetry.addData("Shooter Velocity: ", shooterVelocity);
    }
}
