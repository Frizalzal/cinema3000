package de.lmu.dao.api;

/**
 * Wrapper class on some file
 */
public interface FileDecorator {
    void saveTextToFile(String content);

    String readTextFromFile();
}
