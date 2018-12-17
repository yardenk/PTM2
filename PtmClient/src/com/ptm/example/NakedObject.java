package com.ptm.example;

import java.util.List;

public interface NakedObject {
	public List<String> fieldNames();
	public void fieldChanged(String fieldName, String newValue);
	public String getFieldValue(String fieldName);
}
