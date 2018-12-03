package com.github.freesk.pja_2018_utp_homework_5;

public class Mixin {

	public static int getRandomInt(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}

}
