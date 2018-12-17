package com.ptm.example;

import java.io.Serializable;

public class SolvedGame implements Serializable {

	private static final long serialVersionUID = 7133557209904168507L;
	
	private final int numSteps;
	private final String userName;
	
	public SolvedGame(int numSteps, String userName) {
		this.numSteps = numSteps;
		this.userName = userName;
	}

	public int getNumSteps() {
		return numSteps;
	}

	public String getUserName() {
		return userName;
	}
	
	@Override public String toString() {
		return "SolvedGame(numSteps = " + this.numSteps + ", userName = " + this.userName+")";
	}
	
	

}
