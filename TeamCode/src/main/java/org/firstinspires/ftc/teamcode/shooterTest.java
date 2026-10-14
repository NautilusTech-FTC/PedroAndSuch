package org.firstinspires.ftc.teamcode;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

@TeleOp
@Configurable
public class shooterTest extends OpMode {
    DcMotorEx motor;
    @Override
    public void init() {
        motor = hardwareMap.get(DcMotorEx.class, "Shooter");
        motor.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public static double power = 0.5;
    public void start() {
        motor.setVelocity(1500);
    }
    @Override
    public void loop() {


        if (gamepad1.a) {
            motor.setVelocity(1600);
        } else if (gamepad1.b) {
            motor.setVelocity(1700);
        } else if (gamepad1.y) {
            motor.setVelocity(1400);
        } else if (gamepad1.x) {
            motor.setPower(1);
        }
        telemetry.addData("Motor velocity", motor.getCurrent(CurrentUnit.AMPS));

        telemetry.addData("Motor velocity", motor.getVelocity());

    }
}
