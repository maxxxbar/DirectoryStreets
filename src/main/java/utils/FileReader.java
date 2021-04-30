package utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Optional;

public class FileReader {
    private static final String EXTENSION = "xml";
    private final String fileName;

    public FileReader(@Nullable String fileName) {
        this.fileName = fileName;
    }

    public File read() {
        File resultFile;
        if (nullableOrEmptyFileHandler() && fileName != null) {
            boolean extensionChek = findExtension(fileName).equals(EXTENSION);
            if (extensionChek) {
                resultFile = new File(fileName);
            } else {
                System.out.println("���������� �������� �� xml");
                resultFile = null;
            }
        } else {
            System.out.println("Error");
            resultFile = null;
        }
        return resultFile;
    }

    private boolean nullableOrEmptyFileHandler() {
        return fileName != null && !fileName.isEmpty();

    }

    private String findExtension(@NotNull String fileName) {
        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex == -1) {
            return "Empty extension";
        }
        return Optional.of(fileName.substring(lastIndex + 1)).get();
    }
}
