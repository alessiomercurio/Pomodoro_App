package pomodoro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame{

    public Window() {
        setTitle("Pomodoro App");
        setBounds(new Rectangle(900, 800));
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init(){
        JButton startBtn = new JButton("Start");
        startBtn.setBackground(new Color(42,222,114));
        startBtn.setPreferredSize(new Dimension(100,60));
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton endBtn = new JButton("End");
        endBtn.setBackground(new Color(222,42,42));
        endBtn.setPreferredSize(new Dimension(100,60));
        endBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton pauseBtn = new JButton("Pause");
        pauseBtn.setBackground(new Color(255,255,255));
        pauseBtn.setPreferredSize(new Dimension(100,60));
        pauseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton settingBtn = new JButton("Option");
        settingBtn.setBackground(new Color(255,255,255));
        settingBtn.setPreferredSize(new Dimension(100,60));
        settingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        gridStyle(startBtn, endBtn, pauseBtn, settingBtn);
    }

    private void gridStyle(JButton startBtn, JButton endBtn, JButton pauseBtn, JButton settingBtn){
        getContentPane().setBackground(new Color(46,46,46));

        GridBagLayout gridLayout = new GridBagLayout();
        GridBagConstraints gridConstraints = new GridBagConstraints();
        setLayout(gridLayout);


        JLabel timerArea = new JLabel("C", SwingConstants.CENTER);
        timerArea.setFont(new Font("Serif", Font.BOLD, 48));
        timerArea.setForeground(Color.WHITE);
        timerArea.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        //Global GridBagConstraints
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.insets = new Insets(100,50,20,50);

        //Local parameters
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        gridConstraints.weightx = 1;
        gridConstraints.weighty = 1;
        gridConstraints.anchor = GridBagConstraints.NORTH;
        add(timerArea, gridConstraints);

        gridConstraints.insets = new Insets(0,50,20,50);

        gridConstraints.gridx = 0;
        gridConstraints.gridy = 5;
        add(startBtn, gridConstraints);

        gridConstraints.gridx = 1;
        gridConstraints.gridy = 5;
        add(pauseBtn, gridConstraints);

        gridConstraints.gridx = 2;
        gridConstraints.gridy = 5;
        add(endBtn, gridConstraints);

        gridConstraints.gridx = 1;
        gridConstraints.gridy = 6;
        add(settingBtn, gridConstraints);
    }
}
