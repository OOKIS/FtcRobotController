package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver.BlinkinPattern;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "auto_november_scrimmage", group = "")
public class firstdrivetrain extends LinearOpMode {

  private DcMotor motor0;
  private DcMotor motor1;
  private DcMotor motor2;
  private DcMotor motor3;
  private Servo servo0;
  private Servo servo1;
  private DcMotor core0;
  private DcMotor core1;
  private RevBlinkinLedDriver rgb;
  String autoStat = "Not Started";
  while (opModeIsActive()) {
    telemetry.addData("Motor 0 Power", motor0.getPower());
    telemetry.addData("Auto Status: ", autoStat);
    telemetry.update();
  }
  @Override
  public void runOpMode() {
    autoStat = "Driving Forward..."
    motor0.setPower(1);
    motor1.setPower(1);
    motor2.setPower(1);
    motor3.setPower(1);
    sleep(500);
    motor0.setPower(1);
    motor1.setPower(-1);
    motor2.setPower(1);
    motor3.setPower(-1);
    autoStat = "Turning..."
    sleep(100);
    motor0.setPower(0);
    motor1.setPower(0);
    motor2.setPower(0);
    motor3.setPower(0);
    autoStat = "Stopped"
  }




}
