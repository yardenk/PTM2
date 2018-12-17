package com.ptm.example;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 * Session Bean implementation class ExampleStatelessBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
@LocalBean
public class ExampleStatelessBean implements ExampleStatelessBeanRemote {

    /**
     * Default constructor. 
     */
    public ExampleStatelessBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void foo() {
		System.out.println("hello world");
	}

}
