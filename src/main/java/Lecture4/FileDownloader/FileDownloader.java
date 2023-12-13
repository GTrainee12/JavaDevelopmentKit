package Lecture4.FileDownloader;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileDownloader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите URL файла для загрузки: ");
        String fileUrl = scanner.nextLine();

        System.out.print("Введите количество потоков: ");
        int numThreads = scanner.nextInt();

        // Создание пула потоков с указанным количеством потоков
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        try {
            // Открытие URL-соединения и получение размера файла
            URL url = new URL(fileUrl);
            long fileSize = url.openConnection().getContentLength();

            // Распределение загрузки по потокам
            long chunkSize = fileSize / numThreads;
            long remainingBytes = fileSize % numThreads;
            long startByte = 0;
            long endByte = chunkSize - 1;

            for (int i = 0; i < numThreads; i++) {
                if (i == numThreads - 1) {
                    endByte += remainingBytes;
                }

                // Создание и запуск задачи загрузки файла
                Runnable worker = new DownloadWorker(fileUrl, startByte, endByte, "Part-" + (i + 1));
                executorService.execute(worker);

                // Обновление начального и конечного байтов для следующей задачи загрузки файла
                startByte = endByte + 1;
                endByte += chunkSize;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Завершение работы пула потоков после выполнения всех задач загрузки файлов
        executorService.shutdown();
    }

    private static class DownloadWorker implements Runnable {

        private final String fileUrl;
        private final long startByte;
        private final long endByte;
        private final String outputFile;

        public DownloadWorker(String fileUrl, long startByte, long endByte, String outputFile) {
            this.fileUrl = fileUrl;
            this.startByte = startByte;
            this.endByte = endByte;
            this.outputFile = outputFile;
        }

        @Override
        public void run() {
            try (BufferedInputStream in = new BufferedInputStream(new URL(fileUrl).openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {

                // Установка позиции в потоке для загрузки только определенного диапазона байтов файла
                in.skip(startByte);

                // Чтение и запись байтов файла в выходной поток
                byte[] data = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(data, 0, 1024)) != -1) {
                    fileOutputStream.write(data, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
