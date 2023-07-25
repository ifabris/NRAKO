package hr.algebra.tests;

import hr.algebra.observer.ActionLogObserver;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class ActionLogObserverTest {
    private static final String LOG_FILE_PATH = "C:\\Users\\Ivan\\Desktop\\NRAKO\\log\\log_test.txt"; // Test log file path
    private ActionLogObserver actionLogObserver;

    @Before
    public void setUp() {
        actionLogObserver = new ActionLogObserver();
        actionLogObserver.logFilePath = LOG_FILE_PATH;
    }

    @After
    public void tearDown() {
        // Clean up the test log file after each test
        deleteLogFile();
    }

@Test
public void testUpdate() {
    String user = "JohnDoe";
    Date timestamp = new Date();
    String operation = "AddPost";

    // Invoke the update method to log the operation
    actionLogObserver.update(user, timestamp, operation);

    // Read the log file and verify the content
    String logEntry = String.format("[%s] User '%s' performed operation: '%s'%s", timestamp, user, operation, "\n");
    String fileContent = readLogFile(); 
    
    assertTrue(fileContent.contains(logEntry));
}

private String readLogFile() {
    StringBuilder content = new StringBuilder();
    File logFile = new File(LOG_FILE_PATH);

    if (!logFile.exists()) {
        System.out.println("Log file does not exist at the specified location.");
        return content.toString(); // Return an empty string or handle the error accordingly
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
        // Handle the exception appropriately (log or throw)
    }

    return content.toString().replaceAll("\r", "");
}

    private void deleteLogFile() {
        // Delete the test log file after each test
        try {
            Files.deleteIfExists(Paths.get(LOG_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
