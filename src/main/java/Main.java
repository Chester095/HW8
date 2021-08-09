import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {

        File directoryName = new File("C:\\test");
        String fileName1 = "test1.txt";
        String fileName2 = "test2.txt";
        String dataText1 = "Well, Prince, so Genoa and Lucca are now just family estates of the Buonapartes. But I warn you, if you don't tell me that this means war, if you still try to defend the infamies and horrors perpetrated by that Antichrist--I really believe he is Antichrist--I will have nothing more to do with you and you are no longer my friend, no longer my 'faithful slave,' as you call yourself! But how do you do? I see I have frightened you--sit down and tell me all the news.";
        String dataText2 = "It was in July, 1805, and the speaker was the well-known Anna Pavlovna Scherer, maid of honor and favorite of the Empress Marya Fedorovna. With these words she greeted Prince Vasili Kuragin, a man of high rank and importance, who was the first to arrive at her reception. Anna Pavlovna had had a cough for some days. She was, as she said, suffering from la grippe; grippe being then a new word in St. Petersburg, used only by the elite.";
//        newFile(directoryName, fileName1);
//        dataToFile(directoryName, fileName1, dataText1);
//        newFile(directoryName, fileName2);
//        dataToFile(directoryName, fileName2, dataText2);
        String newFileName = "test3.txt";
//        mergeFiles(directoryName, fileName1, fileName2, newFileName);
        String searchWord = "and";
//        findWordInFile(directoryName, newFileName, searchWord);
        findWordInDirectory(directoryName,searchWord);
//        printDir(directoryName,"",false);



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
                    System.out.println("В директории " + ANSI_GREEN + directoryName + ANSI_RESET + " создан файл " + ANSI_GREEN + fileName + ANSI_RESET);
                } else
                    System.out.println("В директории " + ANSI_GREEN + directoryName + ANSI_RESET + " файл " + ANSI_RED + fileName + ANSI_RESET + " уже существует.");
            } else System.out.println("Неверно указана директория" + ANSI_RED + directoryName + ANSI_RESET);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /*** Запись данных в файл
     *
     * @param directoryName - путь к директории в которой нужно создать файл в формате File "C:\\directory\\subdirectory"
     * @param fileName - имя файла с указанием типа файла "name.***"
     * @param dataText - текст для записи
     */
    public static void dataToFile(File directoryName, String fileName, String dataText){
        try {
            if (directoryName.isDirectory()) {
                File fullFileName = new File(directoryName + "\\" + fileName);
                if (fullFileName.exists()) {
                    FileWriter writer = new FileWriter(fullFileName, true);
                    writer.append(dataText);
                    writer.flush();
                    writer.close();
                    System.out.println("Данные успешно записаны в файл "+ ANSI_GREEN + fileName + ANSI_RESET);
                } else
                    System.out.println("В директории " + ANSI_GREEN + directoryName + ANSI_RESET + " файл " + ANSI_RED + fileName + ANSI_RESET + " не существует.");
            } else System.out.println("Неверно указана директория"+ ANSI_RED + directoryName + ANSI_RESET);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /*** Чтение данных из файла
     *
     * @param directoryName - путь к директории в которой нужно создать файл в формате File "C:\\directory\\subdirectory"
     * @param fileName - имя файла с указанием типа файла "name.***"
     * @return
     */
    public static String dataFromFile(File directoryName, String fileName){
        try {
            if (directoryName.isDirectory()) {
                File fullFileName = new File(directoryName + "\\" + fileName);
                if (fullFileName.exists()) {
                    FileReader reader = new FileReader(fullFileName);
                    int i = -1;
                    char[] buf = new char[200];
                    String dataFromFile = "";
                    while ((i = reader.read(buf)) != -1){
                        for (int j=0; j<i;j++){
                            dataFromFile +=buf[j];
                        }
                    }
                    reader.close();
                    return dataFromFile;
                } else
                    System.out.println("В директории " + ANSI_GREEN + directoryName + ANSI_RESET + " файл " + ANSI_RED + fileName + ANSI_RESET + " не существует.");
            } else System.out.println("Неверно указана директория"+ ANSI_RED + directoryName + ANSI_RESET);
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    /*** Склеивание двух файлов в третий
     *
     * @param directoryName - путь к директории в которой нужно создать файл в формате File "C:\\directory\\subdirectory"
     * @param fileName1 - имя Первого файла для извлечения данных с указанием типа файла "name.***"
     * @param fileName2 - имя Второго файла для извлечения данных с указанием типа файла "name.***"
     * @param newFileName - имя Третьего файла в который будут перенесены данные
     */
    public static void mergeFiles(File directoryName, String fileName1, String fileName2, String newFileName){
        try {
            if (directoryName.isDirectory()) {
                File fullFileName1 = new File(directoryName + "\\" + fileName1);
                File fullFileName2 = new File(directoryName + "\\" + fileName2);
                if (fullFileName1.exists()) {
                    if (fullFileName2.exists()) {
                        newFile(directoryName, newFileName);
                        dataToFile(directoryName, newFileName, dataFromFile(directoryName, fileName1) + dataFromFile(directoryName, fileName2));
                    } else System.out.println("В директории 2" + ANSI_GREEN + directoryName + ANSI_RESET + " файл " + ANSI_RED + fileName2 + ANSI_RESET + " не существует.");
                } else System.out.println("В директории 1" + ANSI_GREEN + directoryName + ANSI_RESET + " файл " + ANSI_RED + fileName1 + ANSI_RESET + " не существует.");
            } else System.out.println("Неверно указана директория"+ ANSI_RED + directoryName + ANSI_RESET);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /*** Поиск слова в файле
     *
     * @param directoryName - путь к директории в которой нужно создать файл в формате File "C:\\directory\\subdirectory"
     * @param fileName - имя файла для поиска слова с указанием типа файла "name.***"
     * @param searchWord - искомое слово
     */
    public static void findWordInFile(File directoryName, String fileName, String searchWord){
        try {
            if (directoryName.isDirectory()) {
                File fullFileName = new File(directoryName + "\\" + fileName);
                if (fullFileName.exists()) {
                    FileReader reader = new FileReader(fullFileName);
                    int i = -1;
                    char[] buf = new char[2000];
                    String dataFromFile = "";
                    while ((i = reader.read(buf)) != -1){
                        for (int j=0; j<i;j++){ dataFromFile +=buf[j];}
                    }
                    reader.close();
                    if (dataFromFile.contains(searchWord)) System.out.println("В файле " + ANSI_GREEN + fileName + ANSI_RESET + " есть слово " + ANSI_GREEN + searchWord + ANSI_RESET);
                    else System.out.println("В файле " + ANSI_GREEN + fileName + ANSI_RESET + " нет слова " + ANSI_RED + searchWord + ANSI_RESET);
                } else
                    System.out.println("В директории " + ANSI_GREEN + directoryName + ANSI_RESET + " файл " + ANSI_RED + fileName + ANSI_RESET + " не существует.");
            } else System.out.println("Неверно указана директория"+ ANSI_RED + directoryName + ANSI_RESET);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /*** Поиск слова в директории
     *
     * @param directoryName - путь к директории в которой нужно создать файл в формате File "C:\\directory\\subdirectory"
     * @param searchWord - искомое слово
     */
    public static void findWordInDirectory(File directoryName, String searchWord){
        try {
            if (directoryName.isDirectory()) {
                File[] files = directoryName.listFiles();
                for (File file : files) {
                    if (file.isFile()) findWordInFile(directoryName,file.toString().substring(directoryName.toString().length()+1), searchWord);
                }
            } else System.out.println("Неверно указана директория"+ ANSI_RED + directoryName + ANSI_RESET);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /*** Построение дерева
     *
     * @param directoryName - путь к первой директории построения дерева в формате File "C:\\directory\\subdirectory"
     * @param indent - символ дерева. По умолчанию ""
     * @param lastDirectory - Промежуточная или закрывающая для отрисовки
     */
    static void printDir(File directoryName, String indent, boolean lastDirectory){
        System.out.print(indent);
        if (lastDirectory){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(directoryName.getName());
        File[] files = directoryName.listFiles();
        int subDirTotal = 0;
        for (File file : files) {
            if (file.isDirectory()){
                subDirTotal++;
            }
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory()){
                subDirCounter++;
                printDir(files[i], indent, subDirTotal == subDirCounter);
            }
        }
    }

}
