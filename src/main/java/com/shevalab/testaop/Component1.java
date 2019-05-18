
package com.shevalab.testaop;

import java.util.Set;
import java.util.TreeSet;
import org.springframework.stereotype.Component;

@Component
public class Component1 implements ChangeAware {
    private String property;
    private Set<String> changes = new TreeSet();

    public String getProperty() {
        return property;
    }

    public Component1 setProperty(String property) {
        this.property = property;
        return this;
    }

    @Override
    public ChangeAware setChange(String change) {
        changes.add(change);
        return this;
    }

    @Override
    public Set<String> getChanges() {
        return changes;
    }
    
    
}
