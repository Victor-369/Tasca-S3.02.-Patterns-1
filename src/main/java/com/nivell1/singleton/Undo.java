package com.nivell1.singleton;

import java.util.ArrayList;
import java.util.List;

public class Undo {
    private static final Undo INSTANCE = new Undo();
    private final List<String> commandList;

    private Undo() {
        this.commandList = new ArrayList<>();
    }

    public void addCommand(String command) {
        checkCommand(command);
        this.commandList.add(command);
    }

    public String undoCommand() {
        String lastCommand;

        if (!this.commandList.isEmpty()) {
            lastCommand = this.commandList.removeLast();
        } else {
            lastCommand = "";
        }

        return lastCommand;
    }

    public void showHistory() {
        for (String command : this.commandList) System.out.println(command);
    }

    public static Undo getInstance() {
        return INSTANCE;
    }

    private void checkCommand(String command) {
        if (command == null || command.isBlank()) throw new IllegalArgumentException("Command must be filled");
    }
}
