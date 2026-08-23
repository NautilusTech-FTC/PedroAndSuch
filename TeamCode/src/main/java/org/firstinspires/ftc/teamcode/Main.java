package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class Main extends OpMode {
    private DcMotor fL;
    private DcMotor fR;
    private DcMotor bR;
    private DcMotor bL;
    private Intake intake = new Intake();
    private Shooter shooter = new Shooter();

    double lSY;
    double lSX;
    double rSX;
    double lT;
    double rT;
    boolean lB;
    boolean rB;
    boolean x;
    boolean a;
    boolean b;
    double denom;

    @Override
    public void init() {
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
        intake.init(hardwareMap);
        shooter.init(hardwareMap);
    }

    @Override
    public void loop() {
        setCtrlVars();

        fL.setPower((-lSY + lSX + rSX) / denom);
        fR.setPower((-lSY - lSX - rSX) / denom);
        bR.setPower((-lSY + lSX - rSX) / denom);
        bL.setPower((-lSY - lSX + rSX) / denom);
        intake.setPowerIntake(rT - lT);

        if (lB && !rB) {
            intake.setPowerTransfer(-0.75);
        } else if (rB && !lB) {
            intake.setPowerTransfer(0.75);
        } else {
            intake.setPowerTransfer(0);
        }

        if (x) {
            shooter.startMotor();
        } else if (b) {
            shooter.stopMotor();
        }

        if(a) {
            shooter.setKickerPosition(0.84);
        } else {
            shooter.setKickerPosition(0.97);
        }
    }

    private void setCtrlVars() {
        lSY = gamepad1.left_stick_y;
        lSX = gamepad1.left_stick_x;
        rSX = gamepad1.right_stick_x;
        lT = gamepad1.left_trigger;
        rT = gamepad1.right_trigger;
        lB = gamepad1.left_bumper;
        rB = gamepad1.right_bumper;
        x = gamepad1.x;
        b = gamepad1.b;
        a = gamepad1.a;

        denom = Math.max(Math.abs(lSY) + Math.abs(lSX) + Math.abs(rSX), 1);
    }
}
