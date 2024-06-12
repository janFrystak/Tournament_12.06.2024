public class Member {
    private String name;
    private int startNum;
    private Team team;

    public Member(String name, int startNum, Team team) {
        this.name = name;
        this.startNum = startNum;
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }
}
