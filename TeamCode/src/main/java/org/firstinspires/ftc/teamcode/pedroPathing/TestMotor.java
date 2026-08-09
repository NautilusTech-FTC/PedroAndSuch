package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class TestMotor extends OpMode {
    DcMotor motor;
    public void init() {
        motor = hardwareMap.get(DcMotor.class, "Motor0");
    }
    public void start() {
        motor.setPower(1);
    }
    public void loop() {}
}
