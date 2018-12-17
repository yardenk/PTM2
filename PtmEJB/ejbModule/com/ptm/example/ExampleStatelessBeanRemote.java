package com.ptm.example;

import javax.ejb.Remote;

@Remote
public interface ExampleStatelessBeanRemote {
	
	public void foo();

}
