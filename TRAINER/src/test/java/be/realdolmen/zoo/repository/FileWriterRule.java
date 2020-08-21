package be.realdolmen.zoo.repository;

import be.realdolmen.zoo.services.FileWriterService;
import org.junit.rules.ExternalResource;

public class FileWriterRule extends ExternalResource {
    private FileWriterService fileWriterService;

    @Override
    public void before() throws Throwable {
        fileWriterService = new FileWriterService("./test.txt");
    }

    public FileWriterService getFileWriterService() {
        return fileWriterService;
    }
}
