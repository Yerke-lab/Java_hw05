import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BackupUtility {
    public static void createBackup(String directoryPath) {
        // Создаем папку ./backup
        File backupDir = new File(directoryPath, "backup");
        backupDir.mkdir();

        // Получаем список файлов в директории (без поддиректорий)
        File directory = new File(directoryPath);
        File[] files = directory.listFiles(File::isFile);

        // Копируем файлы в папку ./backup
        for (File file : files) {
            File destFile = new File(backupDir, file.getName());
            try {
                Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // использование функции
    public static void main(String[] args) {
        createBackup("./my_directory");
    }
}

