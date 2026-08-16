package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake2 {
    private DcMotor intake;
    private CRServo transfer;

    public Intake2(HardwareMap hardwareMap, String intake, String transfer) {
        this.intake = hardwareMap.get(DcMotor.class, intake);
        this.transfer = hardwareMap.get(CRServo.class, transfer);
    }

    public void setIntakePower(double power) {intake.setPower(power);}

    public void setTransferPower (double power) {transfer.setPower(power);}
}
