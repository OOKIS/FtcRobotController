package org.firstinspires.ftc.teamcode;
//Import Devices
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver.BlinkinPattern;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "BlueSideAuto", group = "")
public class BlueSideAuto extends LinearOpMode {

  private DcMotor motor0;
  private DcMotor motor1;
  private DcMotor motor2;
  private DcMotor motor3;
  private Servo servo0;
  private Servo servo1;
  private DcMotor core0;
  private DcMotor core1;
  private RevBlinkinLedDriver rgb;
  @Override
  public void runOpMode() throws InterruptedException {
    motor0 = hardwareMap.get(DcMotor.class, "motor0");
    motor1 = hardwareMap.get(DcMotor.class, "motor1");
    motor2 = hardwareMap.get(DcMotor.class, "motor2");
    motor3 = hardwareMap.get(DcMotor.class, "motor3");
    //Start Driving
    telemetry.addData("Auto Status: ", "Driving Forward...");
    telemetry.update();
    motor0.setPower(-1);
    motor1.setPower(1);
    motor2.setPower(-1);
    motor3.setPower(1);
    sleep(400);
    telemetry.addData("Auto Status: ", "Turning...");
    telemetry.update();
    motor0.setPower(1);
    motor1.setPower(1);
    motor2.setPower(1);
    motor3.setPower(1);
    sleep(430);
    telemetry.addData("Auto Status: ", "Driving Forward...");
    telemetry.update();
    motor0.setPower(-1);
    motor1.setPower(1);
    motor2.setPower(-1);
    motor3.setPower(1);
    sleep(1700);
    telemetry.addData("Auto Status: ", "Stopping...");
    telemetry.update();
    motor0.setPower(0);
    motor1.setPower(0);
    motor2.setPower(0);
    motor3.setPower(0);
    telemetry.addData("Auto Status: ", "Stopped.");
    telemetry.update();
    
    
    
  }




}
