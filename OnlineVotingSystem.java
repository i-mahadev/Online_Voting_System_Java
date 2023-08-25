import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineVotingSystem extends JFrame {

    private JLabel titleLabel;
    private JLabel nameLabel;
    private JLabel phoneLabel;
    private JTextField nameTextField;
    private JTextField phoneTextField;
    private JRadioButton optionAButton;
    private JRadioButton optionBButton;
    private JRadioButton optionCButton;
    private JButton voteButton;
    private JButton resultButton;

    private int votesPartyA = 0;
    private int votesPartyB = 0;
    private int votesPartyC = 0;

    public OnlineVotingSystem() {
        setTitle("Online Voting System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1, 10, 10));

        titleLabel = new JLabel("Vote for your favorite party:");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);

        nameLabel = new JLabel("Name:");
        nameTextField = new JTextField();
        add(nameLabel);
        add(nameTextField);

        phoneLabel = new JLabel("Phone:");
        phoneTextField = new JTextField();
        add(phoneLabel);
        add(phoneTextField);

        optionAButton = new JRadioButton("Party A");
        optionBButton = new JRadioButton("Party B");
        optionCButton = new JRadioButton("Party C");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(optionAButton);
        buttonGroup.add(optionBButton);
        buttonGroup.add(optionCButton);
        add(optionAButton);
        add(optionBButton);
        add(optionCButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        voteButton = new JButton("Vote");
        resultButton = new JButton("Check Result");
        buttonPanel.add(voteButton);
        buttonPanel.add(resultButton);

        voteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String phone = phoneTextField.getText();

                if (optionAButton.isSelected()) {
                    votesPartyA++;
                    JOptionPane.showMessageDialog(null, "Thank you, " + name + "! You voted for Party A.");
                } else if (optionBButton.isSelected()) {
                    votesPartyB++;
                    JOptionPane.showMessageDialog(null, "Thank you, " + name + "! You voted for Party B.");
                } else if (optionCButton.isSelected()) {
                    votesPartyC++;
                    JOptionPane.showMessageDialog(null, "Thank you, " + name + "! You voted for Party C.");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a party to vote.");
                }
            }
        });

        resultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Voting Results:\nParty A: " + votesPartyA + " votes\n" +
                        "Party B: " + votesPartyB + " votes\n" +
                        "Party C: " + votesPartyC + " votes");
            }
        });

        add(buttonPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OnlineVotingSystem();
            }
        });
    }
}
