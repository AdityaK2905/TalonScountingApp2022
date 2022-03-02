package com.example.talonscoutingapp2022.fileManagement;

import java.io.File;
import java.io.FileWriter;

public class importUtils {
    // Save data to internal storage as a file in the scouting directory
    public static void writeFileToStorage(String fileName, String pathInDir, String data) {
        // Create directory if it does not exist
        File directory = new File(Constants.SCOUTING_DIR + pathInDir);
        if (!directory.exists()) {
            directory.mkdir();
        }
        // Write file and save in directory specified
        try {
            File file = new File(directory, fileName);
            FileWriter writer = new FileWriter(file);
            writer.append(data);
            writer.flush();
            writer.close();
        }
        catch (Exception e) {

        }
    }
}
