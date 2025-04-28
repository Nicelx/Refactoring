package tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import junit.framework.TestCase;  

public class FileReaderTester extends TestCase {
    private FileReader _input;
    public FileReaderTester(String name) {
        super(name);
    }
    protected void setUp() {
        try {
            _input = new FileReader("testData.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Ошибка открытия файла");
        }
    }
    protected void tearDown() {
        try {
            _input.close();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка закрытия файла");
        }

    }
}
