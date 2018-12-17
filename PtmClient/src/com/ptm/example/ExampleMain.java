package com.ptm.example;

import javax.naming.NamingException;

public class ExampleMain {
	
	public static void main(String... args) throws NamingException {
		ClientSideExample example = new ClientSideExample();
		
		example.count();
		example.count();
		int count = example.count();
		
		System.out.println("count is " + count); //if the stateful bean were stateless, what would this print?
		
		example.foo();
		SolvedGame result = example.solve(new GameRequest(System.nanoTime()));
		System.out.println("result is: " + result);
	}

}
