package com.ptm.example;

public class NakedObjectDisplayer {
	public void display(NakedObject obj) {
		for (String fieldName: obj.fieldNames()) {
			String fieldValue = obj.getFieldValue(fieldName);
			createDisplayForField(fieldName, fieldValue);
		}
	}
	
	private void createDisplayForField(String fieldName, String fieldValue) {
		//create UI element and bind to it using the NakedObject methods - this I'm leaving to you :)
		//This should obviously involve JavaFX code.
	}
}
