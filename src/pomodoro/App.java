//Made by Alessio Mercurio 2020 Pomodoro App(github repo)

package pomodoro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    private final JFrame frame;
    private Timer timer;
    private final int delay = 1000; //Milliseconds -> 1000ms = 1s
    private final int fixedMinutes = 40;
    private int timerMinute = 40;
    private int timerSeconds = 0;

    public App (){
        this.frame = new JFrame("Pomodoro App"); 
        this.frame.setBounds(new Rectangle(600 , 400));
        this.frame.setVisible(true);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initApp(){
        JLabel timerArea = new JLabel("Timer:", SwingConstants.CENTER);
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(timerMinute == 0) {
                    timer.stop();
                }
                if(timerSeconds == 0) {
                    timerSeconds = 59;
                    --timerMinute;
                }
                else
                    --timerSeconds;
                timerArea.setText(timerMinute + " : " + timerSeconds);
            }
        });
        timer.setRepeats(true);

        JButton startBtn = new JButton("Start/Pause");
        startBtn.setBackground(new Color(42,222,114));
        startBtn.setPreferredSize(new Dimension(100,60));
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(timer.isRunning())
                    timer.stop();
                else
                    timer.start();
            }
        });

        JButton endBtn = new JButton("End");
        endBtn.setBackground(new Color(222,42,42));
        endBtn.setPreferredSize(new Dimension(100,60));
        endBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                timerMinute = fixedMinutes;
                timerSeconds = 0;
                timerArea.setText(timerMinute + " : " + timerSeconds);
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
        initGridLayout(timerArea ,startBtn, endBtn, settingBtn);
    }

    public void initGridLayout(JLabel timerArea, JButton startBtn, JButton endBtn, JButton settingBtn){
        this.frame.getContentPane().setBackground(new Color(46,46,46));

        //Initializing our layout for out JFrame
        GridBagLayout gridLayout = new GridBagLayout();
        GridBagConstraints gridConstraints = new GridBagConstraints();
        this.frame.setLayout(gridLayout);

        //Setting JLabel to represent our timer
        timerArea.setFont(new Font("Serif", Font.BOLD, 48));
        timerArea.setForeground(Color.WHITE);
        timerArea.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        //Global GridBagConstraints parameters
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.insets = new Insets(50,50,20,50);

        //Local parameters
        gridConstraints.gridx = 0;
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
        this.frame.add(endBtn, gridConstraints);

        gridConstraints.gridx = 0;
        gridConstraints.gridy = 6;
        this.frame.add(settingBtn, gridConstraints);
    }

    //To Run our application
    public static void main(String[] args) {
        App pomodoroApp = new App();
        pomodoroApp.initApp();
    }

}
