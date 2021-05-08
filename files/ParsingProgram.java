package files;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * Parsing different computer programming language's program
 * @author Manjunath Asundi
 */
public class ParsingProgram {

    /**
     * ParseData
     */
    static class ParseData implements Runnable {

        static int blankCount = 0, commentsCount = 0, codeCount = 0, totalLinesCount = 0, importCount = 0, variableDeclarationCount = 0;
        static String fileContent = null;
        public ParseData(String data) {
            ParseData.fileContent = data;
        }

        @Override
        public void run() {
            try {
                readFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void readFile() {
            String lines[] = fileContent.split("\n");
            totalLinesCount = totalLinesCount + lines.length;
            for (int i = 0; i < lines.length; i++) {
                String line = lines[i].trim();
                if (line.isEmpty())
                    blankCount++;
                else if (line.startsWith("//") || line.startsWith("/*")) {
                    if (line.startsWith("/*")) {
                        while (i < lines.length) {
                            if (lines[i].endsWith("*/"))
                                break;
                            i++;
                            commentsCount++;
                        }
                    }
                    commentsCount++;
                } else {
                    if(line.startsWith("import")) {
                        importCount++;
                    } else if(line.startsWith("int") || line.startsWith("float") || line.startsWith("char") || line.startsWith("String"))
                        variableDeclarationCount++;
                    codeCount++;
                }
            }
        }

        public ParseData() {
        }
    }


    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);
        try {
            File file = new File("/Users/m0a07xh/Projects/Data-structure-And-Algorithms-using-Java/files");
            String[] filesList = file.list();
            for (int i = 0; i < filesList.length; i++) {
                if (filesList[i].endsWith(".java")) {
                    System.out.println(filesList[i]);
                    String data = Files
                            .lines(Paths.get(
                                    "/Users/m0a07xh/Projects/Data-structure-And-Algorithms-using-Java/files/" + filesList[i]))
                            .collect(Collectors.joining(System.lineSeparator()));
                    // System.out.println(data);
                    executor.execute(new ParseData(data));
                }
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
            System.out.println("blankCount:" + ParseData.blankCount + " commentsCount:" + ParseData.commentsCount + " codeCount:"
                    + ParseData.codeCount + " totalLinesCount:" + ParseData.totalLinesCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}