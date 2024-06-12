import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TourneForm extends JFrame {
    private JPanel panel;
    private JTable myTable;
    private JLabel formTableLaber;
    private List<Member> memList = new ArrayList<>();
    private JMenuBar mainMenu = new JMenuBar();
    private JMenu openMenu = new JMenu("Options");
    private JMenuItem openFile = new JMenuItem("Load File");
    private JMenuItem saveFile = new JMenuItem("Save File");
    private JMenu statsMenu = new JMenu("Stats");
    private JMenuItem memCount = new JMenuItem("Member Count");
    private JMenuItem nameOverTen = new JMenuItem("Old Names");
    private Team currTeam = new Team(0, null, null, null);


    public TourneForm() {
        setContentPane(panel);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        myTable.setModel(new TableModel());
        initMenu();
    }
    public void initMenu(){
        setJMenuBar(mainMenu);
        mainMenu.add(openMenu);
        mainMenu.add(statsMenu);
        openMenu.add(openFile);
        openMenu.add(saveFile);
        statsMenu.add(memCount);
        statsMenu.add(nameOverTen);
        memCount.addActionListener(e -> countMem());
        nameOverTen.addActionListener(e -> countMenMore());
        openFile.addActionListener(e -> fileChooser("OPEN"));
        saveFile.addActionListener(e -> fileChooser("SAVE"));

    }

    public void countMenMore(){
        int count = 0;
        for (Member mem: memList){
            if (mem.getTeam() == currTeam){
                if (mem.getStartNum() > 10){
                count++;
                }
            }
        }JOptionPane.showMessageDialog(this, "There are " + count + " menbers with starting num over 10");
    }

    public void countMem(){
        int count = 0;
        for (Member mem: memList){
            if (mem.getTeam() == currTeam){
                count++;
            }
        }JOptionPane.showMessageDialog(this, "There are " + count + " menbers");
    }
    public void fileChooser(String todo){
        JFileChooser fc = new JFileChooser(".");
        int result = JFileChooser.UNDEFINED_CONDITION;
        if (todo == "OPEN") {
            result = fc.showOpenDialog(this);
        } else if (todo == "SAVE") {
            result = fc.showSaveDialog(this);
        }
        if (result == JFileChooser.APPROVE_OPTION){
            if (todo == "OPEN")readFile(fc.getSelectedFile());
            else if (todo == "SAVE") saveFile(fc.getSelectedFile());
        }
    }
    public void saveFile(File file){
        try (
                PrintWriter wr = new PrintWriter(new BufferedWriter(new FileWriter(file)));
                ){
                    wr.write("");
                    for(Member m: memList){
                        wr.println(m.getName() + ";" + m.getStartNum() + ";" + m.getTeam());
                    }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void readFile(File file){
        try (
            Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
        )
        {
            Team team1 = new Team(1, null, null, null);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] blok = line.split(";");
                String name = blok[0];
                int num = Integer.parseInt(blok[1]);
                team1.setName(blok[2]);
                formTableLaber.setText("Team: " + team1.getName());
                memList.add(new Member(name,num, team1));
                currTeam = team1;
                myTable.setModel(new TableModel());
            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public class TableModel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return memList.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Member mem = memList.get(rowIndex);
            switch (columnIndex){
                case 0: return mem.getName();
                case 1:return mem.getStartNum();
            }
            return null;
        }
        public String getColumnName(int columnIndex){
            return switch (columnIndex) {
                case 0 -> "Jméno";
                case 1 -> "Číslo";
                default -> super.getColumnName(columnIndex);
            };
        }
    }
}