package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Shooter {
    private DcMotorEx shooter;
    private Servo kicker;

    public void init(HardwareMap hardwareMap) {
        shooter = hardwareMap.get(DcMotorEx.class, "shooterMotor");
        kicker = hardwareMap.get(Servo.class, "kickerServo");
    }

    public void startMotor() {
        shooter.setVelocity(1620);
    }

    public void stopMotor() {
        shooter.setVelocity(0);
    }

    public void setKickerPosition(double position) {
        kicker.setPosition(position);
    }
}

