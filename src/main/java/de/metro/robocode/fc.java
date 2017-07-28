package de.metro.robocode;

import robocode.*;
import java.util.Random;

public class fc extends AdvancedRobot {
{
	double movefactor = 1;
	boolean block = false;
	public void run() {
		//turn heading to 0
		if (getHeading()<=180) {
			turnLeft(getHeading());
		}
		else {
			turnRight(360-getHeading());
		}
		//move to ceiling
		ahead(1000);

		// robot main loop
		while(true) {
		    Random r = new Random(); 
		    double way = 100.0 + r.nextDouble() * 500.0;
			setAhead(movefactor*way);
			turnGunLeft(movefactor*360);
		}
	}
	public void onScannedRobot(ScannedRobotEvent e) {
		if (e.getDistance()<100) {
			block=true;
			double angle = (getHeading()+e.getBearing()-getGunHeading());
			if (angle<180){
				turnGunRight(angle);
			}
			else {
				turnGunRight(angle-360);
			}
			
			fire(5);
			block=false;
		}
		else {
			fire(1);
		}
		
	}
	public void onHitByBullet(HitByBulletEvent e) {
		movefactor = movefactor * -1;
	} 
	public void onHitWall(HitWallEvent e) {
		turnLeft(movefactor*90);
	}
	public void onHitRobot(HitRobotEvent e) {
		turnGunRight(getHeading()-getGunHeading());
		fire(5);
	}
}
