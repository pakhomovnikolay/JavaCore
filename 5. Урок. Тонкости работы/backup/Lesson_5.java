package backup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lesson_5 {

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] array = new int[9];
        String filePathOriginal = "5. Урок. Тонкости работы/testOriginal.txt";
        String filePath = "5. Урок. Тонкости работы/testWithZero.txt";
        String filePathToByte = "5. Урок. Тонкости работы/testToByte.bin";
        String sourcePathDirectory = "5. Урок. Тонкости работы/";
        String sourceBackupDirectory = "5. Урок. Тонкости работы/backup";

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(0, 9);
        }
        writeToFile(array, filePathOriginal);
        writeToFileWithCommasReplacedByZero(array, filePath);
        System.out.println(Arrays.toString(ReadFromFile(filePath)));

        saveArrayToByte(array, filePathToByte);
        try {
            createBackup(sourcePathDirectory, sourceBackupDirectory);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
    }

    public static void writeToFile(int[] array, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(Arrays.toString(array));
        } catch (Exception e) {
            System.out.println("Не удалось записать данные в файл - " + filePath);
        }
    }

    public static void writeToFileWithCommasReplacedByZero(int[] array, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            StringBuilder sb = new StringBuilder(Arrays.toString(array));
            fileWriter.write(sb.toString().replaceAll(",\\s", "0"));
        } catch (Exception e) {
            System.out.println("Не удалось записать данные в файл - " + filePath);
        }
    }

    public static int[] ReadFromFile(String filePath) {
        try (FileReader fileReader = new FileReader(filePath)) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int simbol;
            int countZero = 0;
            while ((simbol = fileReader.read()) >= 0) {
                char value = (char)simbol;
                if (value != '[' && value != ']') {
                    if (value == '0') {
                        if (countZero % 2 != 0) {
                            arrayList.add(Integer.parseInt(String.valueOf(value)));
                        }
                        countZero++;
                    }
                    else {
                        countZero = 0;
                        arrayList.add(Integer.parseInt(String.valueOf(value)));
                    }
                }
            }

            int[] result = new int[arrayList.size()];
            int index = 0;
            for (Integer value : arrayList) {
                result[index++] = value.intValue();
            }
            return result;

        } catch (Exception e) {
            System.out.println("Не удалось прочитать данные из файла - " + filePath);
            return null;
        }
    }

    public static void saveArrayToByte(int[] array, String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            byte[] bytes = new byte[3];
            for (int i = 0; i < array.length; i++) {
                int shift = i % 4 * 2;
                bytes[i / 4] |= (array[i] << shift);
            }
            fos.write(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createBackup(String sourceDirectory, String backupDirectory) throws IOException {
        // Создаем папку для резервных копий, если ее нет
        File backupDir = new File(backupDirectory);
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        // Получаем список файлов в директории
        File sourceDir = new File(sourceDirectory);
        File[] filesToBackup = sourceDir.listFiles();

        // Копируем каждый файл в папку с резервными копиями
        for (File file : filesToBackup) {
            if (file.isFile()) {
                Path copyPath = file.toPath();
                Path pastePath = new File(backupDir.getPath() + "/" + file.getName()).toPath();

                Files.copy(copyPath, pastePath, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}
