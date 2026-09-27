package org.firstinspires.ftc.teamcode.StarterBot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive {
    private DcMotor fL, fR, bR, bL;
    public void init(HardwareMap hardwareMap) {
        fL = hardwareMap.get(DcMotor.class, "Motor0");
        fR = hardwareMap.get(DcMotor.class, "Motor1");
        bR = hardwareMap.get(DcMotor.class, "Motor2");
        bL = hardwareMap.get(DcMotor.class, "Motor3");

        fL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        fL.setDirection(DcMotorSimple.Direction.REVERSE);
        fR.setDirection(DcMotorSimple.Direction.FORWARD);
        bR.setDirection(DcMotorSimple.Direction.FORWARD);
        bL.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void robotCentric (double lSY, double lSX, double rSX) {
        double denom = Math.max(Math.abs(lSY) + Math.abs(lSX) + Math.abs(rSX), 1);
        fL.setPower((-lSY + lSX + rSX) / denom);
        fR.setPower((-lSY - lSX - rSX) / denom);
        bR.setPower((-lSY + lSX - rSX) / denom);
        bL.setPower((-lSY - lSX + rSX) / denom);
    }
}
