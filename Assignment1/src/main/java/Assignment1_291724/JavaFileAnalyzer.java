package Assignment1_291724;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class JavaFileAnalyzer {

    public static void main(String[] args) {
        // 🔧 Set your directory path here (change it as needed)
        File folder = new File("C:\\Users\\Huawei Mate D15\\Music\\java"); // <-- Replace with your folder path

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".java"));

        int javaFileCount = 0;
        int solvedIssuesCount = 0;

        if (files != null) {
            javaFileCount = files.length;

            for (File file : files) {
                solvedIssuesCount += countSolvedIssuesInFile(file);
            }
        }

        System.out.println("Number of Java Files = " + javaFileCount);
        System.out.println("Number of Issues = " + solvedIssuesCount);
    }

    private static int countSolvedIssuesInFile(File file) {
        int count = 0;
        try (Stream<String> lines = Files.lines(file.toPath())) {
            count = (int) lines.filter(line -> line.contains("// SOLVED")).count();
        } catch (IOException e) {
            System.out.println("Error reading file: " + file.getName());
        }
        return count;
    }
}
