/** 
 * 
 * Copyright (C) 2016 Amani Kilumanga
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package io.github.dkaksl.rubiks_cube_simulator;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Amani Kilumanga
 *
 */
public class Cube {

	private static String[][] upFace;
	private static String[][] backFace;
	private static String[][] rightFace;
	private static String[][] frontFace;
	private static String[][] leftFace;
	private static String[][] downFace;

	public Cube() {
		upFace = initializeFace("Ｗ");
		backFace = initializeFace("Ｒ");
		rightFace = initializeFace("Ｇ");
		frontFace = initializeFace("Ｂ");
		leftFace = initializeFace("Ｙ");
		downFace = initializeFace("Ｏ");
	}

	private String[][] initializeFace(String color) {
		String[][] side = new String[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				side[i][j] = color;
			}
		}
		return side;
	}

	public void turnUp() {
		upFace = rotateArrayClockwise(upFace);

		String[][] tmpLeft = applyFace(leftFace);
		String[][] tmpFront = applyFace(frontFace);
		String[][] tmpRight = applyFace(rightFace);
		String[][] tmpBack = applyFace(backFace);

		for (int i = 0; i < 3; i++) {
			tmpLeft[0][i] = frontFace[0][i];
			tmpFront[0][i] = rightFace[0][i];
			tmpRight[0][i] = backFace[0][i];
			tmpBack[0][i] = leftFace[0][i];
		}

		reapplyFaces(new String[][][] { null, tmpLeft, tmpFront, tmpRight, null, tmpBack });
	}

	public void turnLeft() {
		leftFace = rotateArrayClockwise(leftFace);

		String[][] tmpUp = applyFace(upFace);
		String[][] tmpFront = applyFace(frontFace);
		String[][] tmpDown = applyFace(downFace);
		String[][] tmpBack = applyFace(backFace);

		for (int i = 0; i < 3; i++) {
			tmpUp[i][0] = backFace[2 - i][2];
			tmpFront[i][0] = upFace[i][0];
			tmpDown[i][0] = frontFace[i][0];
			tmpBack[2 - i][2] = downFace[i][0];
		}

		reapplyFaces(new String[][][] { tmpUp, null, tmpFront, null, tmpDown, tmpBack });
	}

	public void turnFront() {
		frontFace = rotateArrayClockwise(frontFace);

		String[][] tmpUp = applyFace(upFace);
		String[][] tmpLeft = applyFace(leftFace);
		String[][] tmpRight = applyFace(rightFace);
		String[][] tmpDown = applyFace(downFace);

		for (int i = 0; i < 3; i++) {
			tmpUp[2][i] = leftFace[2 - i][2];
			tmpLeft[i][2] = downFace[0][i];
			tmpRight[i][0] = upFace[2][i];
			tmpDown[0][i] = rightFace[2 - i][0];
		}

		reapplyFaces(new String[][][] { tmpUp, tmpLeft, null, tmpRight, tmpDown, null });
	}

	public void turnRight() {
		rightFace = rotateArrayClockwise(rightFace);

		String[][] tmpUp = applyFace(upFace);
		String[][] tmpFront = applyFace(frontFace);
		String[][] tmpBack = applyFace(backFace);
		String[][] tmpDown = applyFace(downFace);

		for (int i = 0; i < 3; i++) {
			tmpUp[i][2] = frontFace[i][2];
			tmpFront[i][2] = downFace[i][2];
			tmpBack[i][0] = upFace[2 - i][2];
			tmpDown[i][2] = backFace[2 - i][0];
		}

		reapplyFaces(new String[][][] { tmpUp, null, tmpFront, null, tmpDown, tmpBack });
	}

	public void turnDown() {
		downFace = rotateArrayClockwise(downFace);

		String[][] tmpFront = applyFace(frontFace);
		String[][] tmpLeft = applyFace(leftFace);
		String[][] tmpRight = applyFace(rightFace);
		String[][] tmpBack = applyFace(backFace);

		for (int i = 0; i < 3; i++) {
			tmpFront[2][i] = leftFace[2][i];
			tmpLeft[2][i] = backFace[2][i];
			tmpRight[2][i] = frontFace[2][i];
			tmpBack[2][i] = rightFace[2][i];
		}

		reapplyFaces(new String[][][] { null, tmpLeft, tmpFront, tmpRight, null, tmpBack });
	}

	public void turnBack() {
		backFace = rotateArrayClockwise(backFace);

		String[][] tmpUp = applyFace(upFace);
		String[][] tmpRight = applyFace(rightFace);
		String[][] tmpLeft = applyFace(leftFace);
		String[][] tmpDown = applyFace(downFace);

		for (int i = 0; i < 3; i++) {
			tmpUp[0][i] = rightFace[i][2];
			tmpRight[i][2] = downFace[2][2 - i];
			tmpLeft[i][0] = upFace[0][2 - i];
			tmpDown[2][i] = leftFace[i][0];
		}

		reapplyFaces(new String[][][] { tmpUp, tmpLeft, null, tmpRight, tmpDown, null });
	}

	public void returnUp() {
		turnUp();
		turnUp();
		turnUp();
	}

	public void returnLeft() {
		turnLeft();
		turnLeft();
		turnLeft();
	}

	public void returnFront() {
		turnFront();
		turnFront();
		turnFront();
	}

	public void returnRight() {
		turnRight();
		turnRight();
		turnRight();
	}

	public void returnDown() {
		turnDown();
		turnDown();
		turnDown();
	}

	public void returnBack() {
		turnBack();
		turnBack();
		turnBack();
	}

	public void randomMove() {
		int random = ThreadLocalRandom.current().nextInt(0, 12);

		switch (random) {
		case 0:
			this.turnUp();
			break;
		case 1:
			this.turnLeft();
			break;
		case 2:
			this.turnFront();
			break;
		case 3:
			this.turnRight();
			break;
		case 4:
			this.turnDown();
			break;
		case 5:
			this.turnBack();
			break;
		case 6:
			this.returnUp();
			break;
		case 7:
			this.returnLeft();
			break;
		case 8:
			this.returnFront();
			break;
		case 9:
			this.returnRight();
			break;
		case 10:
			this.returnDown();
			break;
		case 11:
			this.returnBack();
			break;
		}
	}

	public void shuffleCube() {
		for (int i = 0; i < 100; i++) {
			this.randomMove();
		}
	}

	/**
	 * Order: up, left, front, right, down, back
	 * 
	 * @param faces
	 */
	private static void reapplyFaces(String[][][] faces) {
		if (faces.length != 6) {
			// TODO: throw exception
		}

		upFace = (faces[0] == null) ? upFace : applyFace(faces[0]);
		leftFace = (faces[1] == null) ? leftFace : applyFace(faces[1]);
		frontFace = (faces[2] == null) ? frontFace : applyFace(faces[2]);
		rightFace = (faces[3] == null) ? rightFace : applyFace(faces[3]);
		downFace = (faces[4] == null) ? downFace : applyFace(faces[4]);
		backFace = (faces[5] == null) ? backFace : applyFace(faces[5]);
	}

	private static String[][] applyFace(String[][] source) {
		String[][] target = new String[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				target[i][j] = source[i][j];
			}
		}

		return target;
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

	public String[][] getFlatCube() {
		String[][] cube = new String[9][12];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 12; j++) {
				cube[i][j] = "□";
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i][j + 3] = upFace[i][j];
				cube[i + 3][j] = leftFace[i][j];
				cube[i + 3][j + 3] = frontFace[i][j];
				cube[i + 3][j + 6] = rightFace[i][j];
				cube[i + 3][j + 9] = backFace[i][j];
				cube[i + 6][j + 3] = downFace[i][j];
			}
		}

		return cube;
	}

	public boolean isSolved() {
		if (!isFaceSolved(upFace)) {
			return false;
		}
		if (!isFaceSolved(leftFace)) {
			return false;
		}
		if (!isFaceSolved(frontFace)) {
			return false;
		}
		if (!isFaceSolved(rightFace)) {
			return false;
		}
		if (!isFaceSolved(backFace)) {
			return false;
		}
		if (!isFaceSolved(downFace)) {
			return false;
		}
		return true;
	}

	private static boolean isFaceSolved(String[][] face) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!face[i][j].equals(face[0][0])) {
					return false;
				}
			}
		}

		return true;
	}

	public static String[][] getUpFace() {
		return applyFace(upFace);
	}

	public static String[][] getBackFace() {
		return applyFace(backFace);
	}

	public static String[][] getRightFace() {
		return applyFace(rightFace);
	}

	public static String[][] getFrontFace() {
		return applyFace(frontFace);
	}

	public static String[][] getLeftFace() {
		return applyFace(leftFace);
	}

	public static String[][] getDownFace() {
		return applyFace(downFace);
	}
}
