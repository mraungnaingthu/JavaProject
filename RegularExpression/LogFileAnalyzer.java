package RegularExpression;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class LogFileAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path of the log file: ");
        String logFilePath = scanner.nextLine();

        File logFile = new File(logFilePath);

        if (!logFile.exists()) {
            System.out.println("Log file not found! Please check the path.");
            return;
        }

        // Patterns for extraction
        //192.168.0.1 - - [17/Nov/2024:10:15:32 +0000] "GET /index.html HTTP/1.1" 200 1024
        String ipPattern = "\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b";
        String timestampPattern = "\\[\\d{2}/[A-Za-z]{3}/\\d{4}:\\d{2}:\\d{2}:\\d{2} \\+\\d{4}\\]";
        String methodPattern = "\"(GET|POST|PUT|DELETE|OPTIONS|HEAD)";
        String urlPattern = "\"(?:GET|POST|PUT|DELETE|OPTIONS|HEAD) (.*?) HTTP/";
        String statusPattern = "HTTP/\\d\\.\\d\" (\\d{3})";
        String responseSizePattern = "(\\d+)$";

        // Collections to store extracted data
        Map<String, Integer> ipAddressCount = new HashMap<>();
        Map<String, Integer> statusCodeCount = new HashMap<>();
        List<String> urls = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Extract IP addresses
                extractAndCount(line, ipPattern, ipAddressCount);

                // Extract status codes
                extractAndCount(line, statusPattern, statusCodeCount);

                // Extract URLs
                Matcher urlMatcher = Pattern.compile(urlPattern).matcher(line);
                if (urlMatcher.find()) {
                    urls.add(urlMatcher.group(1));
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the log file: " + e.getMessage());
        }

        // Display results
        System.out.println("\n--- IP Address Frequency ---");
        ipAddressCount.forEach((ip, count) -> System.out.println(ip + ": " + count));

        System.out.println("\n--- Status Code Frequency ---");
        statusCodeCount.forEach((status, count) -> System.out.println(status + ": " + count));

        System.out.println("\n--- URLs Accessed ---");
        urls.forEach(System.out::println);
    }

    /**
     * Extracts matches based on the regex pattern and counts their occurrences.
     */
    private static void extractAndCount(String line, String pattern, Map<String, Integer> map) {
        Matcher matcher = Pattern.compile(pattern).matcher(line);
        if (matcher.find()) {
            String match = matcher.group();
            map.put(match, map.getOrDefault(match, 0) + 1);
        }
    }
}
