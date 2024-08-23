package com.example.testing;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonIntegrationTest {

    @Test
    public void testPythonScriptExecution() throws IOException, InterruptedException {
        String pythonScriptPath = "python_stub/dynamic_stub_services.py";

        ProcessBuilder processBuilder = new ProcessBuilder("python3", pythonScriptPath);
        Process process = processBuilder.start();

        watch(process);

    }

    private static void watch(final Process process) {
        new Thread() {
            public void run() {
                BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = null;
                try {
                    while ((line = input.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
