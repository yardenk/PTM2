package com.ptm.example;

import javax.ejb.Remote;

@Remote
public interface ExampleStatefulBeanRemote {
	public int count();
	public SolvedGame solve(GameRequest request);
}
