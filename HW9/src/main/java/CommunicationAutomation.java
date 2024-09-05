import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CommunicationAutomation {

  public static void main(String[] args) {
    // 打印当前工作目录
    System.out.println("Current working directory: " + System.getProperty("user.dir"));

    // 模拟命令行参数
    String[] arguments = {
        "--email",
        "--email-template", "java/email-template.txt",
        "--letter",
        "--letter-template", "java/letter-template.txt",
        "--output-dir", "java/output",
        "--csv-file", "java/insurance-company-members.csv"
    };

    Map<String, String> options = parseArgs(arguments);

    try {
      validateArgs(options);

      List<Map<String, String>> csvData = readCSV(options.get("csv_file"));
      String emailTemplate = options.containsKey("email_template") ? readTemplate(options.get("email_template")) : null;
      String letterTemplate = options.containsKey("letter_template") ? readTemplate(options.get("letter_template")) : null;

      generateMessages(csvData, emailTemplate, letterTemplate, options.get("output_dir"));
      System.out.println("Messages generated successfully.");

    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
      printUsage();
    }
  }

  private static Map<String, String> parseArgs(String[] args) {
    Map<String, String> options = new HashMap<>();
    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case "--email" -> options.put("email", "true");
        case "--email-template" -> {
          if (i + 1 < args.length) {
            options.put("email_template", args[++i]);
          } else {
            throw new IllegalArgumentException("Missing value for --email-template");
          }
        }
        case "--letter" -> options.put("letter", "true");
        case "--letter-template" -> {
          if (i + 1 < args.length) {
            options.put("letter_template", args[++i]);
          } else {
            throw new IllegalArgumentException("Missing value for --letter-template");
          }
        }
        case "--output-dir" -> {
          if (i + 1 < args.length) {
            options.put("output_dir", args[++i]);
          } else {
            throw new IllegalArgumentException("Missing value for --output-dir");
          }
        }
        case "--csv-file" -> {
          if (i + 1 < args.length) {
            options.put("csv_file", args[++i]);
          } else {
            throw new IllegalArgumentException("Missing value for --csv-file");
          }
        }
        default -> throw new IllegalArgumentException("Unknown argument: " + args[i]);
      }
    }
    return options;
  }

  private static void validateArgs(Map<String, String> options) {
    if (!options.containsKey("csv_file")) {
      throw new IllegalArgumentException("Missing --csv-file");
    }
    if (!options.containsKey("output_dir")) {
      throw new IllegalArgumentException("Missing --output-dir");
    }
    if (options.containsKey("email") && !options.containsKey("email_template")) {
      throw new IllegalArgumentException("--email provided but no --email-template was given");
    }
    if (options.containsKey("letter") && !options.containsKey("letter_template")) {
      throw new IllegalArgumentException("--letter provided but no --letter-template was given");
    }
  }

  private static List<Map<String, String>> readCSV(String filePath) throws IOException {
    File csvFile = new File(filePath);
    if (!csvFile.exists()) {
      throw new FileNotFoundException("CSV file not found: " + filePath);
    }

    List<Map<String, String>> data = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
      String headerLine = reader.readLine();
      if (headerLine == null) {
        throw new IOException("CSV file is empty");
      }
      String[] headers = parseCSVLine(headerLine);
      String line;
      while ((line = reader.readLine()) != null) {
        String[] values = parseCSVLine(line);
        Map<String, String> row = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
          row.put(headers[i], values[i]);
        }
        data.add(row);
      }
    }
    return data;
  }

  private static String[] parseCSVLine(String line) {
    List<String> values = new ArrayList<>();
    StringBuilder current = new StringBuilder();
    boolean inQuotes = false;
    for (char c : line.toCharArray()) {
      if (c == '"') {
        inQuotes = !inQuotes;
      } else if (c == ',' && !inQuotes) {
        values.add(current.toString().trim());
        current.setLength(0);
      } else {
        current.append(c);
      }
    }
    values.add(current.toString().trim());
    return values.toArray(new String[0]);
  }

  private static String readTemplate(String filePath) throws IOException {
    return new String(Files.readAllBytes(Paths.get(filePath)));
  }

  private static void generateMessages(List<Map<String, String>> csvData, String emailTemplate, String letterTemplate, String outputDir) throws IOException {
    Files.createDirectories(Paths.get(outputDir));

    for (Map<String, String> row : csvData) {
      if (emailTemplate != null) {
        String emailContent = generateMessage(emailTemplate, row);
        writeOutput(outputDir, row.get("first_name") + "_" + row.get("last_name") + "_email.txt", emailContent);
      }
      if (letterTemplate != null) {
        String letterContent = generateMessage(letterTemplate, row);
        writeOutput(outputDir, row.get("first_name") + "_" + row.get("last_name") + "_letter.txt", letterContent);
      }
    }
  }

  private static String generateMessage(String template, Map<String, String> data) {
    String message = template;
    for (Map.Entry<String, String> entry : data.entrySet()) {
      message = message.replace("[[" + entry.getKey() + "]]", entry.getValue());
    }
    return message;
  }

  private static void writeOutput(String outputDir, String fileName, String content) throws IOException {
    Files.write(Paths.get(outputDir, fileName), content.getBytes());
  }

  private static void printUsage() {
    System.out.println("Usage:");
    System.out.println("--email Generate email messages. If this option is provided, then --email-template must also be provided.");
    System.out.println("--email-template <path/to/file> A filename for the email template.");
    System.out.println("--letter Generate letters. If this option is provided, then --letter-template must also be provided.");
    System.out.println("--letter-template <path/to/file> A filename for the letter template.");
    System.out.println("--output-dir <path/to/folder> The folder to store all generated files. This option is required.");
    System.out.println("--csv-file <path/to/file> The CSV file to process. This option is required.");
    System.out.println("Examples:");
    System.out.println("--email --email-template email-template.txt --output-dir emails --csv-file customer.csv");
    System.out.println("--letter --letter-template letter-template.txt --output-dir letters --csv-file customer.csv");
  }
}
