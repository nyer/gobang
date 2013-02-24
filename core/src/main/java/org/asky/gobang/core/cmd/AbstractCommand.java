package org.asky.gobang.core.cmd;

import org.asky.gobang.core.Command;

public abstract class AbstractCommand implements Command {
    private String cmdUrl;

    public AbstractCommand(String url) {
        this.cmdUrl = url;
    }

    public String getUrl() {
        return this.cmdUrl;
    }
}

