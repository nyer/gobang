package org.asky.gobang.core;

public class CommandParser {

    public static final Map<String, Command> commands = new HashMap<String, Command>();
    static {
        Command cmd = new StepChessCommand();
        commands.put(cmd.getUrl(), cmd);
    }

    public static Command parse(String str) throws Exception {
        JSONObject json = JSONObject.fromString(str);
        String url = (String)json.get("url");
        Command cmd = commands.get(url);
        return cmd;
    }
}
