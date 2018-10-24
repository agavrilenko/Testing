package org.my.hrank;

import java.io.File;

public abstract class AbstractPackageTest extends AbstractTest {
    protected File[] getTestFiles() {
        String inFolder = "src/test/resources/" + this.getClass().getPackage().getName().replace(".", "/")
                + "/" + this.getClass().getSimpleName() + "/in";

        return new File(inFolder).listFiles();
    }
}
