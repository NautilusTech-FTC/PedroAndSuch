package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class swervePod extends OpMode {
    private DcMotorEx driveMotor, rotationMotor;

    public static double encoderCPR = 580.4;
    private final double tickToRadiansConst = (2*Math.PI / encoderCPR);

    public static double drivePower = 0.8;


    public void init() {
        driveMotor = hardwareMap.get(DcMotorEx.class, "driveMotor");
        rotationMotor = hardwareMap.get(DcMotorEx.class, "rotationMotor");

        rotationMotor.setTargetPosition(rotationMotor.getCurrentPosition());
        rotationMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void loop() {
        float gamePadX = gamepad1.left_stick_x;
        float gamePadY = gamepad1.left_stick_y;
        float gamePadTrigger = gamepad1.right_trigger;
        int rotTicks = rotationMotor.getCurrentPosition();

        double targetTicks = dirMotor(gamePadX, gamePadY, rotTicks);
        rotationMotor.setTargetPosition((int)targetTicks);

        driveMotor.setPower(gamePadTrigger *drivePower);
    }

    private double dirMotor(float gamePadX, float gamePadY, float rotTicks) {
        double gamePadTheta = Math.atan2(gamePadY,gamePadX);
        double controllerTicks = gamePadTheta/tickToRadiansConst;
        //double angle = rotTicks*tickToRadiansConst;
        double tickDifference = controllerTicks - (rotTicks % encoderCPR);
        return rotTicks + tickDifference + ((tickDifference<-encoderCPR/2) ? encoderCPR : 0);
    }
}
