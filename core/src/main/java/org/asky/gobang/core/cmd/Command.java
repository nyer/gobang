package org.asky.gobang.core.cmd;

public interface Command {
    void doCommand(Context context, Map<String, Object> parameters);
}
