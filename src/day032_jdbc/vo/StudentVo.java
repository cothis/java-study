package day032_jdbc.vo;

/*
    자바빈(Java Bean)
        - 멤버변수(property)의 접근제한자는 private
        - 멤버변수(property) 마다 get/set 메소드 제공(선택적으로 get만 제공)
        - getter/setter 메소드는 public
        - get 메소드는 파라미터 없고, set 메소드는 하나 이상의 파라미터 존재
        - 멤버변수(property)가 boolean 타입이면 get 대신 is 메소드 사용가능
*/

// VO(Value Object) : *값 또는 데이터를 저장*하기 위한 클래스(객체)
// DTO(Data Transfer Object) : *값 또는 데이터를 저장*해서 값을 전달하기 위한 목적 클래스(객체)
// VO를 많이 사용
public class StudentVo {
    private String id;   //필드, 멤버변수, 인스턴스 변수, 속성
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int tot;
    private double avg;

    public StudentVo() {
    }

    public StudentVo(String id, String name, int kor, int eng, int math) {
        this.id = id;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        computeTotAvg();
    }

    public StudentVo(String id, String name, int kor, int eng, int math, int tot, double avg) {
        this.id = id;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.tot = tot;
        this.avg = avg;
        computeTotAvg();
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
        computeTotAvg();
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
        computeTotAvg();
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
        computeTotAvg();
    }

    private void computeTot() {
        tot = kor + eng + math;
    }

    private void computeAvg() {
        // 소수점 2자리까지 표시됨.
        avg = (int)(tot * 100 / 3.0) / 100.0;
    }

    private void computeTotAvg() {
        computeTot();
        computeAvg();
    }

    @Override
    public String toString() {
        return "StudentVo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                ", tot=" + tot +
                ", avg=" + avg +
                '}';
    }
}
