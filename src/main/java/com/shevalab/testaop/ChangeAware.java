
package com.shevalab.testaop;

import java.util.Set;

public interface ChangeAware {
    ChangeAware setChange(String change);
    Set<String> getChanges();
}
