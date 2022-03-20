/**
 * Created on 2008/8/24 9:07:19
 * @author Chien-Tsun Chen
 */
package tw.teddysoft.gof.Adapter.ans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 * 
 */
public class ConfigContext {
	private Map<String, ConfigObject> lookup;

	public ConfigContext() {
		lookup = new HashMap<>();
	}
	public List<ConfigObject> getAllObjects() {
		return new ArrayList<ConfigObject>(lookup.values());
	}
	public void add(ConfigObject obj) {
		if (!lookup.containsKey(obj.getKey())) {
			lookup.put(obj.getKey(), obj);
		}
	}
	public ConfigObject get(String aKey) {
		return  lookup.get(aKey);
	}
	public void remove(ConfigObject obj) {
		lookup.remove(obj);
	}
	public void clear() {
		lookup.clear();
	}
	//....
}
