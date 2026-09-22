package com;

import com.oop.Probe;

public class Auditor {
    public void inspect() {
        Probe p = new Probe();
        System.out.println("Auditor (package com) accessing public field: " + p.fieldPublic);
        // From outside com.oop, default and protected fields fail to compile:
        // System.out.println(p.fieldDefault);   // Predict: fails (not visible)
        // System.out.println(p.fieldProtected); // Predict: fails (protected access)
    }
}
