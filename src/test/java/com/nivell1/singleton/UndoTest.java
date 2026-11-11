package com.nivell1.singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UndoTest {
    private final Undo undo = Undo.getInstance();

    @BeforeEach
    void setUp() {
        while (!undo.undoCommand().isEmpty()) { }

        undo.addCommand("clear");
        undo.addCommand("ls -l");
        undo.addCommand("mkdir codigo");
        undo.addCommand("history");
    }

    @Test
    void getInstance_whenCalledTwice_returnsSameInstance() {
        Undo first = Undo.getInstance();
        Undo second = Undo.getInstance();

        assertThat(first).isSameAs(second);
    }

    @Test
    void addCommand_whenCommandIsNew_addsCommandToList() {
        undo.addCommand("mv a.txt b.txt");

        assertThat(undo.undoCommand()).isEqualTo("mv a.txt b.txt");
        assertThat(undo.undoCommand()).isEqualTo("history");
    }

    @Test
    void undoCommand_whenRemoveACommandFromList_removeLastCommandFromList() {
        assertThat(undo.undoCommand()).isEqualTo("history");
        assertThat(undo.undoCommand()).isEqualTo("mkdir codigo");
    }

    @Test
    void undoCommand_whenHistoryIsEmpty_returnsEmptyString() {
        while (!undo.undoCommand().isEmpty()) { }
        assertThat(undo.undoCommand()).isEmpty();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    void addCommand_whenCommandIsNullOrBlank_throwsIllegalArgumentException(String command) {
        assertThrows(IllegalArgumentException.class, () -> undo.addCommand(command));
    }

    @Test
    void showHistory_whenHasCommands_printsAllCommandsInOrder() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputTmp = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputTmp));

        try {
            undo.showHistory();
        } finally {
            System.setOut(originalOut);
        }

        assertThat(outputTmp.toString().lines())
                .containsExactly("clear", "ls -l", "mkdir codigo", "history");
    }
}
