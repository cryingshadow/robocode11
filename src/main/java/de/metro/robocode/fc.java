package de.metro.robocode;

import robocode.*;

public class fc extends AdvancedRobot {
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
			setAhead(1000);
			turnGunLeft(180);
			turnGunRight(180);
		}
	}
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(1);
	}
	public void onHitByBullet(HitByBulletEvent e) {
		back(25);
	}
	public void onHitWall(HitWallEvent e) {
		turnLeft(90);
	}
}
