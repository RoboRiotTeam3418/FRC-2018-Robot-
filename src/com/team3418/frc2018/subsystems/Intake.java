package com.team3418.frc2018.subsystems;

import com.team3418.frc2018.Constants;
import com.team3418.frc2018.HardwareMap;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake extends Subsystem
{
	static Intake mInstance = new Intake();

    public static Intake getInstance() {
        return mInstance;
    }
    
	private CANTalon mIntakeLeftTalon;
	private CANTalon mIntakeRightTalon;
	private Solenoid mIntakeArmSolenoid;
    
	public Intake() {
		mIntakeLeftTalon = new CANTalon(Constants.kIntakeLeftId);
		mIntakeLeftTalon.reverseOutput(false);
		
		mIntakeRightTalon = new CANTalon(Constants.kIntakeRightId);
		mIntakeRightTalon.reverseOutput(true);
		
		mIntakeArmSolenoid = new Solenoid(Constants.kIntakeSolenoidId);
		
		System.out.println("Intake Done Initializing.");
	}
    
    public enum IntakeRollerState {
    	INTAKE,
    	REVERSE,
    	STOP
    }
    
    public enum IntakeArmState {
    	OPEN,
    	CLOSED
    }
	
	private IntakeRollerState mIntakeRollerState;
	private IntakeArmState mIntakeArmState;

	public IntakeRollerState getIntakeRollerState() {
		return mIntakeRollerState;
	}
	
	public IntakeArmState getIntakeArmState() {
		return mIntakeArmState;
	}
	
	@Override
	public void updateSubsystem()
	{
		switch(mIntakeRollerState) {
		case INTAKE:
			setRollerSpeed(Constants.kRollerIntakeSpeed);
			break;
		case REVERSE:
			setRollerSpeed(Constants.kRollerReverseSpeed);
			break;
		case STOP:
			setRollerSpeed(0);
			break;
		default:
			mIntakeRollerState = IntakeRollerState.STOP;
			break;
		}
		
		switch(mIntakeArmState) {
		case OPEN:
			setArmsOpen(true);
			break;
		case CLOSED:
			setArmsOpen(false);
			break;
		default:
			mIntakeArmState = IntakeArmState.OPEN;
			break;
}
		
		outputToSmartDashboard();
	}	
	
	
	
	public void intake(){
		mIntakeRollerState = IntakeRollerState.INTAKE;
	}
	
	public void reverse(){
		mIntakeRollerState = IntakeRollerState.REVERSE;
	}
	
	@Override
	public void stop(){
		mIntakeRollerState = IntakeRollerState.STOP;
	}
	

	public void setRollerSpeed(double speed) {
		mIntakeLeftTalon.set(speed);
		mIntakeRightTalon.set(-1*speed);
	}
	
	private void setArmsOpen(boolean arms) {
		mIntakeArmSolenoid.set(arms);
}

	@Override
	public void outputToSmartDashboard() {
		SmartDashboard.putNumber("Left_Intake_Speed", mIntakeLeftTalon.getSpeed());
		SmartDashboard.putString("Intake_Roller_State", mIntakeRollerState.toString());
		SmartDashboard.putString("Intake_Arm_State", mIntakeArmState.toString());
		//SmartDashboard.putString("Sensor_Value", toString());
	}
}