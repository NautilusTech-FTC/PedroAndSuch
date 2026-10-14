package org.firstinspires.ftc.teamcode.StarterBot;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class LED {
    private Servo led;

    public void init (HardwareMap hardwareMap) {
        led = hardwareMap.get(Servo.class, "LED");
    }

    public void shooterReadiness(double shooterVelocity) {
        if (shooterVelocity < 1320) {
            led.setPosition(0.315); //orange
        } else if (shooterVelocity >= 1320 && shooterVelocity <= 1340) {
            led.setPosition(0.611); //royal
        } else if (shooterVelocity == 0) {
            led.setPosition(0); //off
        } else {
            led.setPosition(1); //white
        }
    }
}
