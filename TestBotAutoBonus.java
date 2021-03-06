/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file illustrates the concept of driving a path based on time.
 * It uses the common Pushbot hardware class to define the drive on the robot.
 * The code is structured as a LinearOpMode
 *
 * The code assumes that you do NOT have encoders on the wheels,
 *   otherwise you would use: PushbotAutoDriveByEncoder;
 *
 *   The desired path in this example is:
 *   - Drive forward for 3 seconds
 *   - Spin right for 1.3 seconds
 *   - Drive Backwards for 1 Second
 *   - Stop and close the claw.
 *
 *  The code is written in a simple form with no optimizations.
 *  However, there are several ways that this type of sequence could be streamlined,
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="TestBot: AutoBonus", group="TestBot")
//@Disabled
public class TestBotAutoBonus extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareTestBot robot   = new HardwareTestBot();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        //Drive the Robot forward
        robot.leftDriveFront.setPower(1); //motor values can go from -1 to 1 with 0 being stopped
        robot.leftDriveBack.setPower(1);
        robot.rightDriveFront.setPower(1);
        robot.rightDriveBack.setPower(1);
        sleep(1100); //stay here in the code for 1 second, don't move on to the next instructions

        //Turn the robot left
        robot.leftDriveFront.setPower(-.5); //motor values can go from -1 to 1 with 0 being stopped
        robot.leftDriveBack.setPower(-.5);
        robot.rightDriveFront.setPower(.5);
        robot.rightDriveBack.setPower(.5);
        sleep(750);

        //Drive the robot forward
        robot.leftDriveFront.setPower(1); //motor values can go from -1 to 1 with 0 being stopped
        robot.leftDriveBack.setPower(1);
        robot.rightDriveFront.setPower(1);
        robot.rightDriveBack.setPower(1);
        sleep(1000);

        //Turn the robot right
        robot.leftDriveFront.setPower(.5); //motor values can go from -1 to 1 with 0 being stopped
        robot.leftDriveBack.setPower(.5);
        robot.rightDriveFront.setPower(-.5);
        robot.rightDriveBack.setPower(-.5);
        sleep(750);

        //Drive the Robot forward
        robot.leftDriveFront.setPower(1); //motor values can go from -1 to 1 with 0 being stopped
        robot.leftDriveBack.setPower(1);
        robot.rightDriveFront.setPower(1);
        robot.rightDriveBack.setPower(1);
        sleep(1000);

        //Park, stop the motors
        robot.leftDriveFront.setPower(0); //motor values can go from -1 to 1 with 0 being stopped
        robot.leftDriveBack.setPower(0);
        robot.rightDriveFront.setPower(0);
        robot.rightDriveBack.setPower(0);


        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}