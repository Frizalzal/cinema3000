package de.lmu.dao.impl;

import de.lmu.dao.api.FileDecorator;
import de.lmu.dao.exception.ProcessingException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOFileDecorator implements FileDecorator {

    private final String filePath;

    public IOFileDecorator(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void saveTextToFile(String content) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            throw new ProcessingException("Error saving content to file: " + e.getMessage());
        }
    }

    @Override
    public String readTextFromFile() {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            reader.close();
        } catch (IOException e) {
            throw new ProcessingException("Error reading content from file: " + e.getMessage());
        }
        return sb.toString().trim();
    }
}
