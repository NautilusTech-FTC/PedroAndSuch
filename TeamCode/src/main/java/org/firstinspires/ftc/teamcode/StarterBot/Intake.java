package org.firstinspires.ftc.teamcode.StarterBot;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private DcMotor intake;
    private CRServo CRServo1;
    private CRServo CRServo2;

    public void init(HardwareMap hardwareMap)  {
        intake = hardwareMap.get(DcMotor.class, "IntakeMotor");
        CRServo1 = hardwareMap.get(CRServo.class, "Servo1");
        CRServo2 = hardwareMap.get(CRServo.class, "Servo2");
        CRServo1.setDirection(DcMotorSimple.Direction.FORWARD);
        CRServo2.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setPowerIntake (double power) {
        intake.setPower(power);
    }
    public void setPowerWheels(double power) {
        CRServo1.setPower(power);
        CRServo2.setPower(power);
    }
}

