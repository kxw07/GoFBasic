/**
 * Created on 2008/8/24 9:07:19
 *
 * @author Chien-Tsun Chen
 */
package tw.teddysoft.gof.Adapter.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Copyright 2016 TeddySoft Technology. All rights reserved.
 *
 */
public class ConfigContext {

    private Map<String, ConfigObject> mLookup = new HashMap<>();

    public ConfigContext() {
    }

    public List<ConfigObject> getAllObjects() {
        return new ArrayList<>(mLookup.values());
    }

    public void add(ConfigObject obj) {
        if (!mLookup.containsKey(obj.getKey())) {
            mLookup.put(obj.getKey(), obj);
        }
    }

    public ConfigObject get(String aKey) {
        return mLookup.get(aKey);
    }

    public void remove(String key) {
        mLookup.remove(key);
    }

    public void clear() {
        mLookup.clear();
    }

    public void addTemplate(ConfigObject template) {

    }
    //....
}

