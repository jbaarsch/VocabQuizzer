import javax.swing.*;
import java.io.IOException;

public class Quizzer {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Quizzer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new QuizPanel());

        frame.pack();
        frame.setVisible(true);




    }




}
