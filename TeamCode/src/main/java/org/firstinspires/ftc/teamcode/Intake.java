package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private DcMotor intake;
    private CRServo crServo;

    public void init (HardwareMap hardwareMap) {
        intake = hardwareMap.get(DcMotor.class, "IntakeMotor");
        crServo = hardwareMap.get(CRServo.class, "TransferServo");
    }

    public void setPowerIntake (double power) {
        intake.setPower(power);
    }
    public void setPowerTransfer (double power) {
        crServo.setPower(power);
    }
}
