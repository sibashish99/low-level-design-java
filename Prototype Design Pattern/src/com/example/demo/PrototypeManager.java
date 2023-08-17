package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class PrototypeManager {
	 private Map<String, CloneablePrototype> prototypes = new HashMap<>();

	    public void registerPrototype(String key, CloneablePrototype prototype) {
	        prototypes.put(key, prototype);
	    }

	    public CloneablePrototype createPrototype(String key) {
	        return prototypes.get(key).clone();
	    }
}
