import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamScorePanel extends JPanel {

    String name;
    int score;
    JLabel scoreLabel;
    JButton scoreButton;

    public TeamScorePanel(String name) {
        this.name = name;
        this.score = 0;

        scoreLabel = new JLabel("" + score);
        scoreLabel.setFont(new Font("sans-serif", Font.BOLD, 32));
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("sans-serif", Font.BOLD, 32));


        JPanel namePanel = new JPanel();
        namePanel.setPreferredSize(new Dimension(150, 100));

        JPanel scorePanel = new JPanel();
        scorePanel.setPreferredSize(new Dimension(150, 50));

        scoreButton = new JButton("Add a Point");
        scoreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPoint();
            }
        });

        namePanel.add(nameLabel);
        scorePanel.add(scoreLabel);

        this.add(namePanel);
        this.add(scorePanel);
        this.add(scoreButton);
        this.setPreferredSize(new Dimension(180, 230));
        this.setBackground(Color.LIGHT_GRAY);



    }

    public void addPoint() {
        this.score++;
        scoreLabel.setText("" + score);
    }

    public void resetScore() {
        this.score = 0;
        scoreLabel.setText("" + score);
    }




}
