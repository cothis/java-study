package day021.work.membercontrol.file;

import day021.work.membercontrol.dto.Batter;
import day021.work.membercontrol.dto.Member;
import day021.work.membercontrol.dto.Pitcher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileController {

    File f;

    public FileController() {
        f = new File("d:/tmp/awtBaseball.txt");
        if(!f.exists()) {
            try {
                f.createNewFile();
                System.out.println("새 파일이 생성되었습니다.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /* data type
    Batter:1-홍길동-19-192.300-30-20-1.300
    Batter:2-김개똥-23-182.300-20-22-12.300
    Batter:3-강타자-11-172.300-90-26-1.130
    Pitcher:4-강투수-19-162.300-50-89-3.530
    */
    public List<Member> loadDatas() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));

            List<Member> collect = br.lines().map(str -> {
                int typeDividerPosition = str.indexOf(':');
                String typeString = str.substring(0, typeDividerPosition);
                System.out.println("typeString = " + typeString);
                String[] split = str.split("-");
                String idStr = split[0].substring(split[0].lastIndexOf(':') + 1);
                int id = Integer.parseInt(idStr);
                System.out.println("id = " + id);

                String name = split[1];
                int age = Integer.parseInt(split[2]);
                double height = Double.parseDouble(split[3]);
                int var1 = Integer.parseInt(split[4]);
                int var2 = Integer.parseInt(split[5]);
                double var3 = Double.parseDouble(split[6]);

                Member member = null;

                if (typeString.equals("Pitcher")) {
                    member = new Pitcher(name, age, height, var1, var2, var3);
                } else if (typeString.equals("Batter")) {
                    member = new Batter(name, age, height, var1, var2, var3);
                } else {
                    member = null;
                }
                return member;
            }).collect(Collectors.toList());

            return collect;
        } catch (FileNotFoundException ignored) {
            return null;
        }
    }

    public void saveMembers(List<Member> members) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));

            Stream<String> stringStream = members.stream().map(Member::saveData);

            for (String s : members.stream().map(Member::saveData).collect(Collectors.toList())) {
                pw.println(s);
            }
            pw.close();
        } catch (IOException ignored) {}
    }
}
