package org.asky.gobang.core.cmd;

import org.asky.gobang.core.Context;
public class StepChessCommand extends AbstractCommand {
    public StepChessCommand() {
        super("/gobang/stepchess");
    }

    @Overried
    public void doCommand(Context context, Map<String, Object> parameters) {

    }
}
