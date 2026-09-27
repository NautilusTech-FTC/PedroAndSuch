package org.firstinspires.ftc.teamcode.StarterBot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {

    private DcMotor shooter;

    public void init(HardwareMap hardwareMap) {
        shooter = hardwareMap.get(DcMotor.class, "Shooter");
    }

    public void setPowerShooter (double power) {
        shooter.setPower(power);
    }
}
