import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Team {
    public int startValue;
    private int num;
    private String name;
    private BigDecimal cost;
    private LocalDate regDate;
    private List<Member> memList = new ArrayList<>();

    public List<Member> getMemList() {
        return memList;
    }

    public void setMemList(List<Member> memList) {
        this.memList = memList;
    }

    public Team(String name, List<Member> memList) {

        Main m = new Main();
        this.num = startValue;
        this.name = name;
        startValue++;

        this.cost = m.getDefaultSum();
        this.regDate = LocalDate.now();
        this.memList = memList;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }
}
