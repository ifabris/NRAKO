package hr.algebra.dal.sql;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import io.prometheus.client.exporter.HTTPServer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author ivan
 */
public final class DataSourceSingleton {
    
    private static final String SERVER_NAME = "localhost";
    private static final String DATABASE_NAME = "NRAKO";
    private static final String USER = "sas"; 
    private static final String PASSWORD = "SQL"; 

    private static void addMetrics() throws IOException {
        
//        MeterRegistry registry = new SimpleMeterRegistry();
//
//        // Create a counter metric
//        Counter requestCounter = Counter.builder("app.requests")
//                .description("Total number of requests")
//                .register(registry);
//
//        // Start an HTTP server to expose metrics (optional)
//        HTTPServer server = new HTTPServer(8082);
//
//        // Simulate incoming requests and keep the application running
//        for (int i = 0; i < 10; i++) {
//            requestCounter.increment();
//            try {
//                Thread.sleep(1000); // Sleep for 1 second
//            } catch (InterruptedException e) {
//                // Handle the interruption
//            }
//        }
//
//        // Sleep to keep the application running (or any other method)
//        try {
//            Thread.sleep(30000); // Sleep for 30 seconds (adjust as needed)
//        } catch (InterruptedException e) {
//            // Handle the interruption
//        }

    }

    private DataSourceSingleton() {}

    private static DataSource instance;

    public static DataSource getInstance() {
        if (instance == null) {
            instance = createInstance();
        }
        return instance;
    }
    private static DataSource createInstance() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setServerName(SERVER_NAME);
        dataSource.setDatabaseName(DATABASE_NAME);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
//        try {
//            addMetrics();
//        } catch (IOException ex) {
//            Logger.getLogger(DataSourceSingleton.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return dataSource;
    }    
}
