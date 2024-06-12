import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private int num;
    private String name;
    private BigDecimal cost;
    private LocalDate regDate;
    private List<Member> memList = new ArrayList<>();
    public Team(int num, String name, BigDecimal cost, LocalDate regDate) {
        Main m = new Main();
        this.num = num;
        this.name = name;
        this.cost = m.getDefaultSum();
        this.regDate = LocalDate.now();
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
