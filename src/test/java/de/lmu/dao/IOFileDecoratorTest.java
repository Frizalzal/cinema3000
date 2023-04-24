package de.lmu.dao;

import de.lmu.dao.impl.IOFileDecorator;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class IOFileDecoratorTest {

    @Test
    public void shouldWriteAndReadText() {
        try {
            // given
            File tempFile = File.createTempFile("shouldSaveTextToFile", ".txt");
            tempFile.deleteOnExit();
            var decorator = new IOFileDecorator(tempFile.getPath());

            // when
            decorator.saveTextToFile("shouldSaveTextToFile");
            var text = decorator.readTextFromFile();

            // then
            assertEquals("shouldSaveTextToFile", text);
        } catch (IOException e) {
            fail(e);
        }
    }
}
