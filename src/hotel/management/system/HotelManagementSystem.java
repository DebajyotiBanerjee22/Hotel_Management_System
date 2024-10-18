package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    private FadingLabel text;
    private FadingButton next;
    private float alpha = 0f; // Start with fully transparent components
    private Timer timer;

    HotelManagementSystem() {
        setBounds(0, 0, 1920, 1080);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1920, 1080);
        add(image);

        text = new FadingLabel("HOTEL MANAGEMENT SYSTEM", 50);
        text.setBounds(30, 50, 1000, 90);
        image.add(text);

        next = new FadingButton("Next");
        next.setBounds(1300, 700, 150, 50);
        next.setBackground(new Color(251, 163, 65));
        next.setForeground(new Color(66, 84, 26));
        next.setBorderPainted(false); // Remove border
        next.addActionListener(this);
        next.setFont(new Font("Tahoma", Font.PLAIN, 24));
        image.add(next);

        setVisible(true);

        // Timer for fade-in animation
        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                alpha += 0.05f;
                if (alpha >= 1) {
                    alpha = 1;
                    timer.stop();
                }
                text.setAlpha(alpha);
                next.setAlpha(alpha);
            }
        });
        timer.start();
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Dashboard();
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }

    // Custom JLabel for fading effect
    class FadingLabel extends JLabel {
        private float alpha;

        public FadingLabel(String text, int fontSize) {
            super(text);
            setForeground(new Color(136, 57, 48));
            setFont(new Font("Serif", Font.BOLD, fontSize));
            alpha = 0f; // Start with fully transparent text
        }

        public void setAlpha(float alpha) {
            this.alpha = alpha;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            super.paintComponent(g2d);
        }
    }

    // Custom JButton for fading effect
    class FadingButton extends RoundedButton {
        private float alpha;

        public FadingButton(String text) {
            super(text);
            alpha = 0f; // Start with fully transparent button
        }

        public void setAlpha(float alpha) {
            this.alpha = alpha;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            super.paintComponent(g2d);
        }
    }
}
