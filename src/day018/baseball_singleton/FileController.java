package day018.baseball_singleton;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileController {
    private static class LazyLoader {
        private static final FileController fileController = new FileController("singleton");
    }
    File f;

    public static FileController getInstance() {
        return LazyLoader.fileController;
    }

    private FileController(String filename) {
        f = new File("D:/tmp/" + filename + ".txt");
    }

    public void createFile() {
        try {
            if(f.createNewFile()) {
                System.out.println("파일을 생성했습니다.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveData() {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));

            Repository.getInstance()
                    .findAll()
                    .forEach(pw::println);

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData() {
        try {
            createFile();

            BufferedReader br = new BufferedReader(new FileReader(f));
            br.lines().forEach(string -> {
                String[] array = string.split(",");

                for(int i = 0 ; i < array.length; i++ ){
                    array[i] = array[i].substring(array[i].indexOf('=') + 1);
                }

                int id = Integer.parseInt(array[0]);
                String name = array[1];
                int age = Integer.parseInt(array[2]);
                double height = Double.parseDouble(array[3]);

                Repository.getInstance().add(new Member(id, name, age, height));
                });

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
