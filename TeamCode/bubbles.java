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

@TeleOp(name = "bubbles")
public class bubbles extends OpMode {

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
  public void runOpMode() {
    double leftY;
    double rightX;
    double ledc = 0;
    int lucas = 0;
    boolean trigger = true;

    motor0 = hardwareMap.get(DcMotor.class, "motor0");
    motor1 = hardwareMap.get(DcMotor.class, "motor1");
    motor2 = hardwareMap.get(DcMotor.class, "motor2");
    motor3 = hardwareMap.get(DcMotor.class, "motor3");
    servo0 = hardwareMap.get(Servo.class, "servo0");
    servo1 = hardwareMap.get(Servo.class, "servo1");
    rgb = hardwareMap.get(RevBlinkinLedDriver.class, "rgb");
    core0 = hardwareMap.get(DcMotor.class, "core0");
    core1 = hardwareMap.get(DcMotor.class, "core1");

    // Put initialization blocks here.
    core0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    core0.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
    core1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    core1.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
    rgb.setPattern(RevBlinkinLedDriver.BlinkinPattern.RAINBOW_PARTY_PALETTE);
    motor0.setDirection(DcMotorSimple.Direction.FORWARD);
    motor1.setDirection(DcMotorSimple.Direction.FORWARD);
    motor2.setDirection(DcMotorSimple.Direction.FORWARD);
    motor3.setDirection(DcMotorSimple.Direction.FORWARD);
    core0.setDirection(DcMotorSimple.Direction.REVERSE);
    core1.setDirection(DcMotorSimple.Direction.FORWARD);
    //servo0.setPosition(0);
    //servo1.setPosition(0);
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        leftY = gamepad1.right_stick_x * -1;
        rightX = gamepad1.left_stick_y * -0.5;
        if ((gamepad1.right_stick_x < 0.2) && (gamepad1.right_stick_x > -0.2)) {
          motor0.setPower(gamepad1.left_stick_y);
          motor1.setPower(gamepad1.left_stick_y * -1);
          motor2.setPower(gamepad1.left_stick_y);
          motor3.setPower(gamepad1.left_stick_y * -1);
        }
        else {
          
        
        motor0.setPower(Math.min(Math.max(leftY - rightX, -1), 1));
        motor1.setPower(Math.min(Math.max(leftY + rightX, -1), 1));
        motor2.setPower(Math.min(Math.max(leftY - rightX, -1), 1));
        motor3.setPower(Math.min(Math.max(leftY + rightX, -1), 1));
        }
        if (gamepad2.dpad_up) {
          lucas++;
        }
        else if (gamepad2.dpad_down) {
          lucas--;
        }
        core0.setTargetPosition(lucas);
        if (gamepad2.a){
          
          core0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
          core0.setPower(1);
        }
        if (gamepad2.dpad_left) {
            lucas = 0;
            core0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            
        }
        if (gamepad2.dpad_right) {
            lucas = lucas + 1;
        }
        
        
        /*if (core0.getCurrentPosition() < core0.getTargetPosition()) {
          core0.setPower(-1);
        }
        else if (core0.getCurrentPosition() > core0.getTargetPosition()) {
          core0.setPower(1);
        }
        else {
          core0.setPower(0);
        }*/


        if (gamepad2.left_bumper) {
          servo0.setPosition(0);
          servo1.setPosition(1);
        }
        if (gamepad2.right_bumper) {
          servo0.setPosition(1);
          servo1.setPosition(0);
        }
        else {
          telemetry.addData("Arm Status", "nope");
        }
        
        if (gamepad1.right_stick_button) {
          motor0.setPower(1);
          motor1.setPower(1);
          motor2.setPower(1);
          motor3.setPower(1);
        }
        if (gamepad2.a) {
          ledc++;
        }
        else if (gamepad2.b) {
          ledc--;
        }

        telemetry.addData("CCore 0+1", core0.getCurrentPosition());
        telemetry.addData("lucas", lucas);
        telemetry.addData("Motor 0 & 1 Power", motor0.getPower());
        telemetry.addData("Motor 2 & 3 Power", motor2.getPower());
        telemetry.addData("Servo Position 0", servo0.getPosition());
        telemetry.addData("Servo Position 1", servo1.getPosition());
        telemetry.addData("Belt Speed", core0.getPower());
        telemetry.addData("test1", core0.getPower()); 
        telemetry.update();
        
      }
      
      
    }
  }
  

  
}
