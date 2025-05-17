package Assignment1_291724;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class JavaFileAnalyzer {

    public static void main(String[] args) {
        // Folder path that I used for this system
        File folder = new File("C:\\Users\\Huawei Mate D15\\Desktop\\Java");
        analyzeJavaFiles(folder);
    }

    // Function to call Java files dan issues
    public static void analyzeJavaFiles(File folder) {
        // Check either the folder valid or not
        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println("Invalid folder. Please check the path.");
            return;
        }

        // Guna array to store total Java files and issues
        int[] totalJavaFiles = {0};
        int[] totalSolvedIssues = {0};

        // Proses folder & subfolder
        traverseFolder(folder, totalJavaFiles, totalSolvedIssues);

        System.out.println("Number of Java Files = " + totalJavaFiles[0]);
        System.out.println("Number of Issues = " + totalSolvedIssues[0]);
    }

    // Function to traverse file dan folder in directory
    private static void traverseFolder(File folder, int[] totalJavaFiles, int[] totalSolvedIssues) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // If we found subfolder, go to recursive
                    traverseFolder(file, totalJavaFiles, totalSolvedIssues);
                } else if (file.getName().endsWith(".java")) {
                    // If found file .java, count the issues as well
                    totalJavaFiles[0]++;
                    totalSolvedIssues[0] += countSolvedIssues(file);
                }
            }
        }
    }

    // Function to count "// solved problems" in files
    private static int countSolvedIssues(File file) {
        try (Stream<String> lines = Files.lines(file.toPath())) {
            // Cari line yang ada "// solved problems" – the keyword we stated
            return (int) lines
                    .filter(line -> line.toLowerCase().contains("// solved problems"))
                    .count();
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getName());
        }
        return 0;
    }
}



//package Assignment1_291724;
//
//import java.io.File;
//import java.util.List;
//import javax.tools.JavaCompiler;
//import javax.tools.ToolProvider;
//import javax.tools.StandardJavaFileManager;
//import javax.tools.JavaFileObject;
//import javax.tools.DiagnosticCollector;
//import javax.tools.Diagnostic;
//
//public class JavaFileAnalyzer {
//
//    public static void main(String[] args) {
//        File folder = new File("C:\\Users\\Huawei Mate D15\\Music\\java");
//        analyzeJavaErrors(folder);
//    }
//
//    public static void analyzeJavaErrors(File folder) {
//        if (!folder.exists() || !folder.isDirectory()) {
//            System.err.println("Invalid folder. Please check the path.");
//            return;
//        }
//
//        File[] files = folder.listFiles((dir, name) -> name.endsWith(".java"));
//        if (files == null || files.length == 0) {
//            System.out.println("No Java files found in the folder.");
//            return;
//        }
//
//        int javaFileCount = files.length;
//        int totalErrorCount = 0;
//
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
//
//        for (File javaFile : files) {
//            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
//            Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjects(javaFile);
//            compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits).call();
//
//            List<Diagnostic<? extends JavaFileObject>> errors = diagnostics.getDiagnostics().stream()
//                    .filter(d -> d.getKind() == Diagnostic.Kind.ERROR)
//                    .toList();
//
//            if (!errors.isEmpty()) {
//                System.out.println("File with errors: " + javaFile.getName());
//                totalErrorCount += errors.size();
//            }
//        }
//
//        System.out.println("Number of Java Files = " + javaFileCount);
//        System.out.println("Number of Issues = " + totalErrorCount);
//    }
//}
//
