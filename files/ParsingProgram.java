package files;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Parsing different computer programming language's program
 * @author Manjunath Asundi
 */
public class ParsingProgram {

    static int blankCount = 0, commentsCount = 0, codeCount = 0, totalLinesCount = 0, importCount = 0, variableDeclarationCount = 0;

    public static void readFile(String fileContent) {
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

    public static void main(String[] args) {
        try {
            File file = new File("/Users/m0a07xh/Projects/Data-structure-And-Algorithms-using-Java/");
            String[] filesList = file.list();
            for (int i = 0; i < filesList.length; i++) {
                if (filesList[i].endsWith(".java")) {
                    System.out.println(filesList[i]);
                    String data = Files
                            .lines(Paths.get(
                                    "/Users/m0a07xh/Projects/Data-structure-And-Algorithms-using-Java/" + filesList[i]))
                            .collect(Collectors.joining(System.lineSeparator()));
                    // System.out.println(data);
                    readFile(data);
                }
            }
            System.out.println("blankCount:" + blankCount + " commentsCount:" + commentsCount + " codeCount:"
                    + codeCount + " totalLinesCount:" + totalLinesCount);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}