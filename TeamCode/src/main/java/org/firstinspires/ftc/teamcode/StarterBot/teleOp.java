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

        if(gamepad1.y) {
            intake.setPowerIntake(1);
            intake.setPowerTransfer(1);
        } else {
            intake.setPowerIntake(0);
            intake.setPowerTransfer(0);
        }

        if(gamepad1.b) {
            transfer.setPowerTransfer(1);
        } else {
            transfer.setPowerTransfer(0);
        }

        if(gamepad1.a) {
            shooter.setPowerShooter(0.5);
        }
        if(gamepad1.x) {
            shooter.setPowerShooter(0);
        }
    }
}
