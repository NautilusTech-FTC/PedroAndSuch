package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

@TeleOp
public class colorTest extends OpMode {
    private NormalizedColorSensor colorSensor;
    public void init () {
        colorSensor = hardwareMap.get(NormalizedColorSensor.class, "DistanceSensor");
    }

    public void loop() {
        NormalizedRGBA color = colorSensor.getNormalizedColors();
    }
}
