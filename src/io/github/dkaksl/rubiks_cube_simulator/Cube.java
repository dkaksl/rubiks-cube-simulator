/** 
 * 
 * Copyright (C) 2016 Amani Kilumanga
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package io.github.dkaksl.rubiks_cube_simulator;

/**
 * @author Amani Kilumanga
 *
 */
public class Cube {

	// faces
	// should probably separate this into a new class.
	private static String[][] upFace;
	private static String[][] backFace;
	private static String[][] rightFace;
	private static String[][] frontFace;
	private static String[][] leftFace;
	private static String[][] downFace;

	public Cube() {
		// TODO: initialize faces here instead of using a separate method

		upFace = new String[3][3];
		leftFace = new String[3][3];
		frontFace = new String[3][3];
		rightFace = new String[3][3];
		backFace = new String[3][3];
		downFace = new String[3][3];

		initializeFaces();

	}

	private void initializeFaces() {
		initializeFace(upFace, "White");
		initializeFace(backFace, "Red");
		initializeFace(rightFace, "Green");
		initializeFace(frontFace, "Blue");
		initializeFace(leftFace, "Yellow");
		initializeFace(downFace, "Orange");
	}

	private void initializeFace(String[][] side, String color) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				side[i][j] = color;
			}
		}
	}

	public void printCube() {
		printFace(upFace);
		printFace(backFace);
		printFace(rightFace);
		printFace(frontFace);
		printFace(leftFace);
		printFace(downFace);
	}

	private void printFace(String[][] face) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(face[i][j] + " ");
			}
			System.out.print("\r\n");
		}
	}

	public void turnUp() {
		// define 9 x 9 array
		// TODO: rotate center 5 x 5 array
		// TODO: replace Cube faces with 3 x 3 arrays found in new 9 x 9 array

		String[][] side = new String[9][9];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				side[i][j + 3] = backFace[i][j];
				side[i + 3][j] = leftFace[i][j];
				side[i + 3][j + 3] = upFace[i][j];
				side[i + 3][j + 6] = rightFace[i][j];
				side[i + 6][j + 3] = frontFace[i][j];
			}
		}
	}

	public void returnUp() {

	}

	public void turnLeft() {

	}

	public void turnFront() {

	}

	public void turnRight() {

	}

	public void turnBack() {

	}

	public void turnDown() {

	}
}
