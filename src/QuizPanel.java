//import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.*;

public class QuizPanel extends JPanel{

    List<String> terms;
    JPanel termDisplayPanel;
    JLabel termLabel;
    ArrayList<TeamScorePanel> teamScorePanels;
    JPanel teamDisplayPanel;
    JPanel buttonPanel;
    JButton addTeamButton, nextTermButton;




    public QuizPanel() throws IOException{
        terms = new ArrayList();
        initializeTerms();

        teamScorePanels =  new ArrayList();
        teamDisplayPanel = new JPanel();
        teamDisplayPanel.setPreferredSize(new Dimension(800, 500));
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(800, 50));
        termDisplayPanel = new JPanel();
        termLabel = new JLabel(terms.removeFirst());

        this.setPreferredSize(new Dimension(1000, 750));
        this.setBackground(Color.LIGHT_GRAY);

        termDisplayPanel.setPreferredSize(new Dimension(800, 200));
        termLabel.setFont(new Font("sans-serif", Font.BOLD, 72));
        termDisplayPanel.add(termLabel);

        addTeamButton = new JButton("Add a Team");
        addTeamButton.addActionListener(new AddATeamListener());
        buttonPanel.add(addTeamButton);

        nextTermButton = new JButton("Next Term");
        nextTermButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                termLabel.setText(terms.removeFirst());
            }
        });
        buttonPanel.add(nextTermButton);

        this.add(termDisplayPanel);
        this.add(buttonPanel);
        this.add(teamDisplayPanel);







    }

    public void repaint() {
        super.repaint();
    }

    private void initializeTerms() throws IOException {

        Stream<String> lines = Files.lines(Path.of("terms.txt"));
        terms = lines.collect(Collectors.toList());
        Collections.shuffle(terms);




    }

    private class AddATeamListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = JOptionPane.showInputDialog("Please enter Team Name");

            TeamScorePanel newTeam = new TeamScorePanel(name);
            teamScorePanels.add(newTeam);
            teamDisplayPanel.add(newTeam);
            teamDisplayPanel.repaint();
            repaint();





        }
    }

}
