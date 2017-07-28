package de.metro.robocode;

import robocode.*;

public class fc extends AdvancedRobot {
	double movefactor = 1;
	public void run() {
		//turn heading to 0
		if (getHeading()<=180) {
			turnLeft(getHeading());
		}
		else {
			turnRight(360-getHeading());
		}
		//move to ceiling
		ahead(500);

		// robot main loop
		while(true) {
			setAhead(movefactor*1000);
			turnGunLeft(movefactor*360);
			//turnGunRight(360);
		}
	}
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(1);
	}
	public void onHitByBullet(HitByBulletEvent e) {
		movefactor = movefactor * -1;
	}
	public void onHitWall(HitWallEvent e) {
		turnLeft(movefactor*90);
	}
	public void onHitRobot(HitRobotEvent e) {
		turnGunRight(getHeading()-getGunHeading());
		fire(4);
	}
}
