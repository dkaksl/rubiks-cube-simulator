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
public class Side {
	private static String[][] topFace;
	private static String[][] leftFace;
	private static String[][] centerFace;
	private static String[][] rightFace;
	private static String[][] bottomFace;

	// TODO: rotate sides on initialization as necessary
	// TODO: check dimensions?
	public Side(String[][][] faces) {
		topFace = faces[0];
		leftFace = faces[1];
		centerFace = faces[2];
		rightFace = faces[3];
		bottomFace = faces[4];
	}

	public String[][] getSideRotatedClockwise() {
		String[][] side = getSideArray();

		side = rotateCenterArray(side);

		return side;
	}

	public static String[][] getSideRotatedCounterClockwise() {
		String[][] side = getSideArray();

		// TODO

		return side;
	}

	private static String[][] getSideArray() {
		String[][] side = new String[9][9];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				side[i][j + 3] = topFace[i][j];
				side[i + 3][j] = leftFace[i][j];
				side[i + 3][j + 3] = centerFace[i][j];
				side[i + 3][j + 6] = rightFace[i][j];
				side[i + 6][j + 3] = bottomFace[i][j];
			}
		}

		return side;
	}

	private static String[][] rotateCenterArray(String[][] side) {
		String[][] centerArray = getCenterArray(side);

		centerArray = rotateArrayClockwise(centerArray);

		return applyCenterArrayToSide(centerArray, side);
	}

	private static String[][] getCenterArray(String[][] side) {
		String[][] centerArray = new String[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				centerArray[i][j] = side[i + 2][j + 2];
			}
		}

		return centerArray;
	}

	private static String[][] applyCenterArrayToSide(String[][] centerArray, String[][] side) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				side[i + 2][j + 2] = centerArray[i][j];
			}
		}
		return side;
	}

	private static String[][] rotateArrayClockwise(String[][] array) {
		int rowCount = array.length;
		int columnCount = array[0].length;

		String[][] rotatedArray = new String[rowCount][columnCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				rotatedArray[j][rowCount - 1 - i] = array[i][j];
			}

		}
		return rotatedArray;
	}
}