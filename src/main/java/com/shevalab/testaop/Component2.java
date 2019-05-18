
package com.shevalab.testaop;

import org.springframework.stereotype.Component;

@Component
public class Component2 {
    private String name;

    public String getName() {
        return name;
    }

    public Component2 setName(String name) {
        this.name = name;
        return this;
    }
    
    
    
}
