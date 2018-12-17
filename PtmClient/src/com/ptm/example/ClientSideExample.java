package com.ptm.example;

import javax.naming.NamingException;

public class ClientSideExample implements ExampleStatefulBeanRemote, ExampleStatelessBeanRemote {

	private final ExampleStatefulBeanRemote stateful;
	private final ExampleStatelessBeanRemote stateless;
	
	public ClientSideExample() throws NamingException {
		stateful = BeanLocator.lookupStatefulBean(ExampleStatefulBeanRemote.class, "ExampleStatefulBean");
		stateless = BeanLocator.lookupStatelessBean(ExampleStatelessBeanRemote.class, "ExampleStatelessBean");
	}
	
	@Override
	public int count() {
		return stateful.count();
	}

	@Override
	public void foo() {
		stateless.foo();
	}

	@Override
	public SolvedGame solve(GameRequest request) {
		return stateful.solve(request);
	}

}
