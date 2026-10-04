package org.firstinspires.ftc.teamcode.StarterBot;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Transfer {
    private CRServo CRServo1;

    public void init(HardwareMap hardwareMap) {
        CRServo1 = hardwareMap.get(CRServo.class, "Transfer");
        CRServo1.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void setPowerTransfer (double power) {
        CRServo1.setPower(power);
    }
}
