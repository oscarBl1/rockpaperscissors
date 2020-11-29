package rockpaperscissors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RockPaperScissors {

    public static String playInput;
    static String compIn;
    static int compInput;
    static int compWin = 0;
    static int playWin = 0;
    static Icon rockIm = new ImageIcon("rock.JPG");
    static JButton rock = new JButton(rockIm);
    static Icon paperIm = new ImageIcon("paper.JPG");
    static JButton paper = new JButton(paperIm);
    static Icon scissorsIm = new ImageIcon("scissors.JPG");
    static JButton scissors = new JButton(scissorsIm);
    static JFrame f1 = new JFrame();
    
    public static void buttons(){
        rock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playInput = "rock";
            }
        });
        paper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playInput = "paper";
            }
        });
        scissors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playInput = "scissors";
            }
        });
    }

    public static void frame() {
        //creates frame
        
        //buttons

        rock.setBounds(0, 200, 500, 500);
        f1.add(rock);

        paper.setBounds(600, 200, 500, 500);
        f1.add(paper);

        scissors.setBounds(1200, 200, 500, 500);
        f1.add(scissors);
        f1.setSize(1715, 1500);
        f1.setLayout(null);
        f1.setVisible(true);

        
        
        //labels
        JLabel rockText = new JLabel("Rock");
        rockText.setFont(rockText.getFont().deriveFont(32.0f));
        rockText.setBounds(200, 100, 100, 100);
        f1.add(rockText);
        JLabel paperText = new JLabel("Paper");
        paperText.setFont(paperText.getFont().deriveFont(32.0f));
        paperText.setBounds(800, 100, 100, 100);
        f1.add(paperText);
        JLabel scissorsText = new JLabel("Scissors");
        scissorsText.setFont(scissorsText.getFont().deriveFont(32.0f));
        scissorsText.setBounds(1400, 100, 200, 100);
        f1.add(scissorsText);
        
        //close on exit
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        frame();

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        boolean keepGoing = true;

        while (keepGoing) {
            while(playInput == null){
            buttons();
            }
            // text();
            //players input
//            while (true) {
//                playInput = scan.nextLine();
//                if (playInput.equalsIgnoreCase("rock") || playInput.equalsIgnoreCase("paper") || playInput.equalsIgnoreCase("scissors")) {
//                    break;
//                } else {
//                    System.out.println("Incorrect choice please try again");
//                }
//
//            }
            //computers choice
            compInput = rand.nextInt(3) + 1;
            if (compInput == 1) {
                compIn = "Rock";
            } else if (compInput == 2) {
                compIn = "Paper";
            } else {
                compIn = "Scissors";
            }

            //decides winner
            winner();

            while (true) {
                System.out.println("Would you like to play again? y/n");
                String play = scan.nextLine();
                if (play.equalsIgnoreCase("y")) {
                    keepGoing = true;
                    break;
                } else if (play.equalsIgnoreCase("n")) {
                    keepGoing = false;
                    break;
                } else {
                    System.out.println("Invalid choice please try again");
                }
            }
        }

    }

    public static void text() {

        try {
            System.out.println("Rock");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Paper");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Scissors");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Shoot:");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void winner() {
        JLabel win = new JLabel("You win");
        win.setFont(win.getFont().deriveFont(64.0f));
        win.setBounds(858, 1400, 200, 200);
        f1.add(win);
        win.setVisible(false);
        JLabel lose = new JLabel("You lose");
        lose.setFont(lose.getFont().deriveFont(64.0f));
        lose.setBounds(858, 1400, 200, 200);
        f1.add(lose);
        lose.setVisible(false);
        JLabel draw = new JLabel("Draw");
        draw.setFont(draw.getFont().deriveFont(64.0f));
        draw.setBounds(858, 1400, 200, 200);
        f1.add(draw);
        draw.setVisible(false);
        
        JLabel winCount = new JLabel();
        winCount.setText(String.valueOf(playWin));
        winCount.setSize(0,1000);
        f1.add(winCount);
        JLabel loseCount  = new JLabel();
        loseCount.setText(String.valueOf(compWin));
        loseCount.setSize(1000,1000);
        f1.add(loseCount);
        
        if (playInput.equalsIgnoreCase("rock") && compIn.equalsIgnoreCase("rock")) {
            System.out.println("Draw!");
            draw.setVisible(true);
        } else if (playInput.equalsIgnoreCase("rock") && compIn.equalsIgnoreCase("paper")) {
            System.out.println("Computer Wins!");
            compWin++;
            System.out.println("Computer has won: " + compWin + " times");
            System.out.println("Player has won: " + playWin + " times");
            lose.setVisible(true);
        } else if (playInput.equalsIgnoreCase("rock") && compIn.equalsIgnoreCase("scissors")) {
            System.out.println("Player Wins!");
            playWin++;
            System.out.println("Computer has won: " + compWin + " times");
            System.out.println("Player has won: " + playWin + " times");
            win.setVisible(true);
        } else if (playInput.equalsIgnoreCase("paper") && compIn.equalsIgnoreCase("rock")) {
            System.out.println("Player Wins!");
            playWin++;
            System.out.println("Computer has won: " + compWin + " times");
            System.out.println("Player has won: " + playWin + " times");
            win.setVisible(true);
        } else if (playInput.equalsIgnoreCase("paper") && compIn.equalsIgnoreCase("paper")) {
            System.out.println("Draw!");
            draw.setVisible(true);
        } else if (playInput.equalsIgnoreCase("paper") && compIn.equalsIgnoreCase("scissors")) {
            System.out.println("Computer Wins!");
            compWin++;
            System.out.println("Computer has won: " + compWin + " times");
            System.out.println("Player has won: " + playWin + " times");
            lose.setVisible(true);
        } else if (playInput.equalsIgnoreCase("scissors") && compIn.equalsIgnoreCase("rock")) {
            System.out.println("Computer Wins!");
            compWin++;
            System.out.println("Computer has won: " + compWin + " times");
            System.out.println("Player has won: " + playWin + " times");
            lose.setVisible(true);
        } else if (playInput.equalsIgnoreCase("scissors") && compIn.equalsIgnoreCase("paper")) {
            System.out.println("Player Wins!");
            playWin++;
            System.out.println("Computer has won: " + compWin + " times");
            System.out.println("Player has won: " + playWin + " times");
            win.setVisible(true);
        } else if (playInput.equalsIgnoreCase("scissors") && compIn.equalsIgnoreCase("scissors")) {
            System.out.println("Draw!");
            draw.setVisible(true);
        }
    }

}
