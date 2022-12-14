package frc.robot.subsystems.climber;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class ClimberIOBRB implements ClimberIO {

    private final WPI_TalonSRX upControl;
    private final WPI_TalonSRX downControl1;
    private final VictorSP downControl2;
    private final MotorControllerGroup downControl;

    public ClimberIOBRB() {
        this.upControl = new WPI_TalonSRX(6);
        this.downControl1 = new WPI_TalonSRX(7);
        this.downControl2 = new VictorSP(8);
        downControl2.setInverted(true);
        downControl = new MotorControllerGroup(downControl1, downControl2);

    }

    @Override
    public void setVelocity(double velocity) {
        if (velocity >= 0) {
            upControl.set(velocity);
            downControl.set(velocity);
        } else if (velocity < 0) {
            downControl.set(velocity);
            upControl.set(velocity);
        }
    }

    @Override
    public void setUpVelocity(double velocity) {
        upControl.set(velocity);
    }

    @Override
    public void setDownVelocity(double velocity) {
        downControl.set(velocity);
    }

    @Override
    public void stop() {
        upControl.set(0);
        downControl.set(0);
    }
}
