package com.ptm.example;

import java.util.ArrayList;
import java.util.List;

/**
 * A rather naive implementation of the naked object interface. A "better" implementation would hae the NakedObjectDisplayer
 * use reflection to get the class's fields and display them, thus making all the boilerplate here redundant.
 * That does entail some voodoo though, and voodoo for something as simple as this may not be necessary.
 * @author giladber
 *
 */
public class ServerConfiguration implements NakedObject {

	private String serverIp;
	private String serverPort;
	
	private final List<String> fieldNames;
	
	public ServerConfiguration() {
		this.fieldNames = new ArrayList<>();
		this.fieldNames.add("serverIp");
		this.fieldNames.add("serverPort");
	}
	
	@Override
	public List<String> fieldNames() {
		return this.fieldNames;
	}

	@Override
	public void fieldChanged(String fieldName, String newValue) {
		switch (fieldName) {
			case "serverIp":
				this.serverIp = newValue;
			case "serverPort":
				this.serverPort = newValue;
			default:
				throw new IllegalArgumentException("unexpected value " + fieldName);
		}
	}

	@Override
	public String getFieldValue(String fieldName) {
		switch (fieldName) {
		case "serverIp":
			return this.serverIp;
		case "serverPort":
			return this.serverPort;
		default:
			throw new IllegalArgumentException("unexpected value " + fieldName);
	}
	}

}
