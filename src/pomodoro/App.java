//Made by Alessio Mercurio 2020 Pomodoro App(github repo)

package pomodoro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    private final JFrame frame;

    public App (){
        this.frame = new JFrame("Pomodoro App");
        this.frame.setBounds(new Rectangle(600 , 400));
        this.frame.setVisible(true);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initGui(){
        JButton startBtn = new JButton("Start");
        startBtn.setBackground(new Color(42,222,114));
        startBtn.setPreferredSize(new Dimension(100,60));
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: To start the timer
            }
        });

        JButton endBtn = new JButton("End");
        endBtn.setBackground(new Color(222,42,42));
        endBtn.setPreferredSize(new Dimension(100,60));
        endBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: To end and reset the timer
            }
        });

        JButton pauseBtn = new JButton("Pause");
        pauseBtn.setBackground(new Color(255,255,255));
        pauseBtn.setPreferredSize(new Dimension(100,60));
        pauseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: To pause the timer
            }
        });

        JButton settingBtn = new JButton("Option");
        settingBtn.setBackground(new Color(255,255,255));
        settingBtn.setPreferredSize(new Dimension(100,60));
        settingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: Setting Button to adjust the time of timer, pauses and longer pauses
            }
        });
        initGridLayout(startBtn, endBtn, pauseBtn, settingBtn);
    }

    public void initGridLayout(JButton startBtn, JButton endBtn,JButton pauseBtn, JButton settingBtn){
        this.frame.getContentPane().setBackground(new Color(46,46,46));

        //Initializing our layout for out JFrame
        GridBagLayout gridLayout = new GridBagLayout();
        GridBagConstraints gridConstraints = new GridBagConstraints();
        this.frame.setLayout(gridLayout);

        //Setting JLabel to represent our timer
        JLabel timerArea = new JLabel("Timer:", SwingConstants.CENTER);
        timerArea.setFont(new Font("Serif", Font.BOLD, 48));
        timerArea.setForeground(Color.WHITE);
        timerArea.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        //Global GridBagConstraints parameters
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.insets = new Insets(50,50,20,50);

        //Local parameters
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        gridConstraints.weightx = 1;
        gridConstraints.weighty = 1;
        gridConstraints.anchor = GridBagConstraints.NORTH;
        this.frame.add(timerArea, gridConstraints);

        //Changing global Insets
        gridConstraints.insets = new Insets(0,5,10,5);

        gridConstraints.gridx = 0;
        gridConstraints.gridy = 5;
        this.frame.add(startBtn, gridConstraints);

        gridConstraints.gridx = 1;
        gridConstraints.gridy = 5;
        this.frame.add(pauseBtn, gridConstraints);

        gridConstraints.gridx = 2;
        gridConstraints.gridy = 5;
        this.frame.add(endBtn, gridConstraints);

        gridConstraints.gridx = 1;
        gridConstraints.gridy = 6;
        this.frame.add(settingBtn, gridConstraints);
    }

    //To Run our application
    public static void main(String[] args) {
        App pomdoroApp = new App();
        pomdoroApp.initGui();
    }

}
