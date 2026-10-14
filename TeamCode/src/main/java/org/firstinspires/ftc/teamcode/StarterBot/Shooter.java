package org.firstinspires.ftc.teamcode.StarterBot;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {
    private DcMotorEx shooter;

    public void init(HardwareMap hardwareMap) {
        shooter = hardwareMap.get(DcMotorEx.class, "Shooter");
    }

    public void setShooterVelocity (double velocity) {
        shooter.setVelocity(velocity);
    }

    public double getShooterVelocity () {
        return shooter.getVelocity();
    }
}
