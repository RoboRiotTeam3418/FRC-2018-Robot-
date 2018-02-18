package com.team3418.frc2018.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.team3418.frc2018.Constants;
import com.team3418.frc2018.HardwareMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem {

	
	static Shooter mInstance = new Shooter();
	
    public static Shooter getInstance() {
        return mInstance;
    }
    
    CANTalon mLeftFrontShooterTalon;
	CANTalon mLeftRearShooterTalon;
	CANTalon mRightFrontShooterTalon;
	CANTalon mRightRearShooterTalon;
    
    public Shooter() {
		
		//Left Front Talon Motor Controller
		mLeftFrontShooterTalon = new CANTalon(Constants.kLeftFrontShooterMotorId);		
//		mLeftFrontShooterTalon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		mLeftFrontShooterTalon.changeControlMode(TalonControlMode.PercentVbus);
		mLeftFrontShooterTalon.set(0);
//		mLeftFrontShooterTalon.setPID(Constants.kFlywheelKp, Constants.kFlywheelKi, Constants.kFlywheelKd, Constants.kFlywheelKf,
//                Constants.kFlywheelIZone, Constants.kFlywheelRampRate, 0);
//		mLeftFrontShooterTalon.setProfile(0);
		mLeftFrontShooterTalon.reverseSensor(false);
		mLeftFrontShooterTalon.reverseOutput(false);
		
		mLeftFrontShooterTalon.setVoltageRampRate(0);
		mLeftFrontShooterTalon.enableBrakeMode(false);
		mLeftFrontShooterTalon.clearStickyFaults();
		
		mLeftFrontShooterTalon.configNominalOutputVoltage(+0.0f, -0.0f);
		mLeftFrontShooterTalon.configPeakOutputVoltage(+12.0f, -0.0f);
//		mLeftFrontShooterTalon.setAllowableClosedLoopErr(Constants.kFlywheelAllowableError);	
		//
		System.out.println("Left Front Shooter Done Initializing.");
		
		//Left Rear Talon Motor Controller
		mLeftRearShooterTalon = new CANTalon(Constants.kLeftRearShooterMotorId);
//		mLeftRearShooterTalon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		mLeftRearShooterTalon.changeControlMode(TalonControlMode.PercentVbus);
		mLeftRearShooterTalon.set(0);
//		mLeftRearShooterTalon.setPID(Constants.kFlywheelKp, Constants.kFlywheelKi, Constants.kFlywheelKd, Constants.kFlywheelKf,
//                Constants.kFlywheelIZone, Constants.kFlywheelRampRate, 0);
//		mLeftRearShooterTalon.setProfile(0);
		mLeftRearShooterTalon.reverseSensor(false);
		mLeftRearShooterTalon.reverseOutput(false);
		
		mLeftRearShooterTalon.setVoltageRampRate(0);
		mLeftRearShooterTalon.enableBrakeMode(false);
		mLeftRearShooterTalon.clearStickyFaults();
		
		mLeftRearShooterTalon.configNominalOutputVoltage(+0.0f, -0.0f);
		mLeftRearShooterTalon.configPeakOutputVoltage(+12.0f, -0.0f);
//		mLeftRearShooterTalon.setAllowableClosedLoopErr(Constants.kFlywheelAllowableError);
		System.out.println("Left Rear Shooter Done Initializing.");
		
		//Right Front Talon Motor Controller
		mRightFrontShooterTalon = new CANTalon(Constants.kRightFrontShooterMotorId);
//		mRightFrontShooterTalon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		mRightFrontShooterTalon.changeControlMode(TalonControlMode.PercentVbus);
		mRightFrontShooterTalon.set(0);
//		mRightFrontShooterTalon.setPID(Constants.kFlywheelKp, Constants.kFlywheelKi, Constants.kFlywheelKd, Constants.kFlywheelKf,
//                Constants.kFlywheelIZone, Constants.kFlywheelRampRate, 0);
//		mRightFrontShooterTalon.setProfile(0);
		mRightFrontShooterTalon.reverseSensor(true);
		mRightFrontShooterTalon.reverseOutput(true);
		
		mRightFrontShooterTalon.setVoltageRampRate(0);
		mRightFrontShooterTalon.enableBrakeMode(false);
		mRightFrontShooterTalon.clearStickyFaults();
		
		mRightFrontShooterTalon.configNominalOutputVoltage(+0.0f, -0.0f);
		mRightFrontShooterTalon.configPeakOutputVoltage(+.0f, -12.0f);
//		mRightFrontShooterTalon.setAllowableClosedLoopErr(Constants.kFlywheelAllowableError);		
		
		mTargetShooterRpm = Constants.kTargetShooterRpm;
		
		System.out.println("Right Front Shooter Done Initializing.");
		
		//Right Rear Talon Motor Controller
		mRightRearShooterTalon = new CANTalon(Constants.kRightRearShooterMotorId);
//		mRightRearShooterTalon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		mRightRearShooterTalon.changeControlMode(TalonControlMode.PercentVbus);
		mRightRearShooterTalon.set(0);
//		mRightRearShooterTalon.setPID(Constants.kFlywheelKp, Constants.kFlywheelKi, Constants.kFlywheelKd, Constants.kFlywheelKf,
//                Constants.kFlywheelIZone, Constants.kFlywheelRampRate, 0);
//		mRightRearShooterTalon.setProfile(0);
		mRightRearShooterTalon.reverseSensor(true);
		mRightRearShooterTalon.reverseOutput(true);
		
		mRightRearShooterTalon.setVoltageRampRate(0);
		mRightRearShooterTalon.enableBrakeMode(false);
		mRightRearShooterTalon.clearStickyFaults();
		
		mRightRearShooterTalon.configNominalOutputVoltage(+0.0f, -0.0f);
		mRightRearShooterTalon.configPeakOutputVoltage(+.0f, -12.0f);
//		mRightRearShooterTalon.setAllowableClosedLoopErr(Constants.kFlywheelAllowableError);
		System.out.println("Right Rear Shooter Done Initializing.");
		System.out.println("Shooter Done Initializing.");
	}
    
    public enum ShooterReadyState {
    	READY, NOT_READY
    }
    
    public enum ShooterState {
    	SHOOT, STOP
    }
    
    private double mTargetShooterRpm;
    
    public void setTargetShooterRpm(double rpm){
    	mTargetShooterRpm = rpm;
    }
    
    public double getTargetShooterRpm(){
    	return mTargetShooterRpm;
    }
    
    private ShooterReadyState mShooterReadyState;
    private ShooterState mShooterState;
    
    public ShooterState getShooterState(){
    	return mShooterState;
    }
    
    public ShooterReadyState getShooterReadyState(){
    	return mShooterReadyState;
    }
    
	@Override
	public void updateSubsystem() {
		
		switch(mShooterState){
		case SHOOT:
			setShooterRpm(mTargetShooterRpm);
			break;
		case STOP:
			setShooterOpenLoop(0);
			break;
		default:
			stop();
			break;
		}
		
		if (bothIsOnTarget()){
			mShooterReadyState = ShooterReadyState.READY;
		} else {
			mShooterReadyState = ShooterReadyState.NOT_READY;
		}
		
		outputToSmartDashboard();
		
	}
	
	public void shoot(){
		mShooterState = ShooterState.SHOOT;
	}
	
	@Override
	public void stop(){
		mShooterState = ShooterState.STOP;
	}
	
	//get shooter speed info
	private double getLeftFrontRpm(){
		return mLeftFrontShooterTalon.getSpeed();
	}
	
	private double getLeftRearRpm(){
		return mLeftRearShooterTalon.getSpeed();
	}
	
	private double getRightFrontRpm(){
		return mRightFrontShooterTalon.getSpeed();
	}
	
	private double getRightRearRpm(){
		return mRightRearShooterTalon.getSpeed();
	}
	
	private double getLeftFrontSetpoint(){
		return mLeftFrontShooterTalon.getSetpoint();
	}
	
	private double getLeftRearSetpoint(){
		return mLeftRearShooterTalon.getSetpoint();
	}
	
	private double getRightFrontSetpoint(){
		return mRightFrontShooterTalon.getSetpoint();
	}
	
	private double getRightRearSetpoint(){
		return mRightRearShooterTalon.getSetpoint();
	}
	//
	
	//set shooter speed
	public void setShooterRpm(double rpm){
		mLeftFrontShooterTalon.changeControlMode(TalonControlMode.Speed);
		mLeftFrontShooterTalon.set(rpm);
		mRightFrontShooterTalon.changeControlMode(TalonControlMode.Speed);
		mRightFrontShooterTalon.set(rpm);
		mLeftRearShooterTalon.changeControlMode(TalonControlMode.Speed);
		mLeftRearShooterTalon.set(rpm);
		mRightRearShooterTalon.changeControlMode(TalonControlMode.Speed);
		mRightRearShooterTalon.set(rpm);
	}
	
	public void setShooterOpenLoop(double speed){
		mLeftFrontShooterTalon.changeControlMode(TalonControlMode.PercentVbus);
		mLeftFrontShooterTalon.set(speed);
		mRightFrontShooterTalon.changeControlMode(TalonControlMode.PercentVbus);
		mRightFrontShooterTalon.set(speed);
		mLeftRearShooterTalon.changeControlMode(TalonControlMode.PercentVbus);
		mLeftRearShooterTalon.set(speed);
		mRightRearShooterTalon.changeControlMode(TalonControlMode.PercentVbus);
		mRightRearShooterTalon.set(speed);
	}
	
	//set shooter ready state
	private boolean leftIsOnTarget(){
		return (mLeftFrontShooterTalon.getControlMode() == CANTalon.TalonControlMode.Speed
                && Math.abs(getLeftFrontRpm() - getLeftFrontSetpoint()) < Constants.kFlywheelOnTargetTolerance);
	}
	
	private boolean RightIsOnTarget(){
		return (mRightFrontShooterTalon.getControlMode() == CANTalon.TalonControlMode.Speed
                && Math.abs(getRightFrontRpm() - getRightFrontSetpoint()) < Constants.kFlywheelOnTargetTolerance);
	}
	
	private boolean bothIsOnTarget(){
		return (leftIsOnTarget() && RightIsOnTarget());
	}
	
    public boolean isShooterReady(){
    	return bothIsOnTarget();
    }
	
	@Override
	public void outputToSmartDashboard() {
        SmartDashboard.putBoolean("Flywheel_On_Target", bothIsOnTarget());
        SmartDashboard.putBoolean("Flywheel_On_Target_Left", leftIsOnTarget());
        SmartDashboard.putBoolean("Flywheel_On_Target_Right", RightIsOnTarget());
        
		SmartDashboard.putNumber("LeftFront_Flywheel_rpm", getLeftFrontRpm());
		SmartDashboard.putNumber("LeftRear_Flywheel_rpm", getLeftRearRpm());
		SmartDashboard.putNumber("RightFront_Flywheel_rpm", getRightFrontRpm());
		SmartDashboard.putNumber("RightRear_Flywheel_rpm", getRightRearRpm());
		
		SmartDashboard.putNumber("Target_Shooter_rpm", getTargetShooterRpm());
        
        SmartDashboard.putNumber("LeftFront_Flywheel_Closed_Loop_error", mLeftFrontShooterTalon.getClosedLoopError());
        SmartDashboard.putNumber("LeftFront_Flywheel_Closed_Loop_error_Number", mLeftFrontShooterTalon.getClosedLoopError());
        SmartDashboard.putNumber("LeftRear_Flywheel_Closed_Loop_error", mLeftRearShooterTalon.getClosedLoopError());
        SmartDashboard.putNumber("LeftRear_Flywheel_Closed_Loop_error_Number", mLeftRearShooterTalon.getClosedLoopError());
        SmartDashboard.putNumber("RightFront_Flywheel_Closed_Loop_error", mRightFrontShooterTalon.getClosedLoopError());
        SmartDashboard.putNumber("RightFront_Flywheel_Closed_Loop_error_Number", mRightFrontShooterTalon.getClosedLoopError());
        SmartDashboard.putNumber("RightRear_Flywheel_Closed_Loop_error", mRightRearShooterTalon.getClosedLoopError());
        SmartDashboard.putNumber("RightRear_Flywheel_Closed_Loop_error_Number", mRightRearShooterTalon.getClosedLoopError());
        
        SmartDashboard.putString("Shooter_State", mShooterState.toString());
        SmartDashboard.putString("ShooterReady_State", mShooterReadyState.toString());
	}
}