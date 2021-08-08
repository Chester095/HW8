import java.io.File;
import java.io.IOException;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        File file = new File("C:\\test");

/*        System.out.println("exists() -> " + file.exists());                     // Возвращает true, если файл с таким именем существует на диске компьютера.
        System.out.println("getAbsolutePath() -> " + file.getAbsolutePath());   // Возвращает полный путь файла со всеми поддиректориями.
        System.out.println("getName() -> " + file.getName());                   // Возвращает только имя файла, без пути.
        System.out.println("isDirectory() -> " + file.isDirectory());           // Является ли «объект файла» директорией
        System.out.println("isFile() -> " + file.isFile());                     // Является ли объект файлом*/

        File directoryName = new File("C:\\test");
        String fileName = "test3.txt";
        newFile(directoryName, fileName);


    }

    /*** Создание файла
     *
     * @param directoryName - путь к директории в которой нужно создать файл в формате File "C:\\directory\\subdirectory"
     * @param fileName - имя файла с указанием типа файла "name.***"
     */
    public static void newFile(File directoryName, String fileName) {
        try {
            if (directoryName.isDirectory()) {
                File fullFileName = new File(directoryName + "\\" + fileName);
                if (fullFileName.createNewFile()) {
                    System.out.println("Создан файл в директории " + ANSI_GREEN + directoryName + ANSI_RESET + " с именем " + ANSI_GREEN + fileName + ANSI_RESET);
                } else
                    System.out.println("Файл в директории " + ANSI_GREEN + directoryName + ANSI_RESET + " с именем " + ANSI_GREEN + fileName + ANSI_RESET + " уже существует.");
            } else System.out.println("Неверно указана директория");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
