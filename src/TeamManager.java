import java.util.ArrayList;
import java.util.List;

public class TeamManager {
    private List<Team> temList = new ArrayList<>();

    public TeamManager(List<Team> temList) {
        this.temList = temList;
    }

    public List<Team> getTemList() {
        return temList;
    }
    public void addMember(Member mem, Team tem){

    }

    public void setTemList(List<Team> temList) {
        this.temList = temList;
    }

}
