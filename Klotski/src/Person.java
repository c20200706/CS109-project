import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Person extends JButton implements FocusListener {
    int number;
    private BufferedImage backgroundImage;
    private boolean isSelected;
    private static final Color SELECTED_COLOR = Color.RED;
    private static final int BORDER_WIDTH = 3;

    public int getNumber() {
        return number;
    }

    public Person(int number, String s, String imagePath) {
        super(s);
        this.number = number;
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentAreaFilled(false);
        setBorder(BorderFactory.createEmptyBorder(BORDER_WIDTH, BORDER_WIDTH, BORDER_WIDTH, BORDER_WIDTH));
        setFocusPainted(false);
        addFocusListener(this);

    }

    @Override
    protected void paintComponent(Graphics g) {
        // 绘制背景图片
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        // 父类绘制（文字）
        super.paintComponent(g);

        // 绘制选中/焦点状态边框
        if (isSelected || hasFocus()) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(SELECTED_COLOR);
            g2d.setStroke(new BasicStroke(BORDER_WIDTH));
            g2d.drawRect(BORDER_WIDTH/2, BORDER_WIDTH/2,
                    getWidth() - BORDER_WIDTH,
                    getHeight() - BORDER_WIDTH);
            g2d.dispose();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        setSelectionState(true);
    }

    @Override
    public void focusLost(FocusEvent e) {
        setSelectionState(false);
    }

    public void setSelectionState(boolean selected) {
        if (isSelected != selected) {
            isSelected = selected;
            repaint();
        }
    }
}