package org.firstinspires.ftc.teamcode.StarterBot;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {

    private DcMotorEx shooter;

    public void init(HardwareMap hardwareMap) {
        shooter = hardwareMap.get(DcMotorEx.class, "Shooter");
    }

    public void setPowerShooter (double power) {
        shooter.setPower(power);
    }

    public double getShooterVelocity () {
        return shooter.getVelocity();
    }
}
