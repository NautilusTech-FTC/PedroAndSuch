package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous
public class JankyUI extends OpMode {
    String[] allianceSelection = {"Red Alliance", "Blue Alliance"};
    int currentAlliance = 0;

    @Override
    public void init() {

    }

    @Override
    public void init_loop() {
        telemetry.addData("Team Select", changeSelection(allianceSelection));
        telemetry.update();
    }

    @Override
    public void loop() {

    }

    String changeSelection (String[] array) {
        if (gamepad1.dpad_right) {
            currentAlliance++;
        } else if (gamepad1.dpad_left) {
            currentAlliance--;
        }

        if (currentAlliance > (allianceSelection.length-1)) {
            currentAlliance = 0;
        }

        return array[currentAlliance];
    }
}
