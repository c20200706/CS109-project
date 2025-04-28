//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class GameFrame extends JFrame implements ActionListener, KeyListener, MouseListener {
//    Person[] people = new Person[10];
//    JButton left, right, above, below;
//    JButton restart = new JButton("重新开始");
//
//    public GameFrame() {
//        init();
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setBounds(100, 100, 320, 500);
//        setVisible(true);
//        validate();
//    }
//
//    public void init() {
//        setLayout(null);
//        add(restart);
//        restart.setBounds(100, 320, 120, 35);
//        restart.addActionListener(this);
//
//        String[] name = {"曹操", "关羽", "马", "黄", "赵", "张", "兵", "兵", "兵", "兵"};
//        String[] path ={"sucai/R-C (1).jpg","sucai/下载.jpg","sucai/OIP-C (2).jpg","sucai/OIP-C (3).jpg","sucai/OIP-C (5).jpg","sucai/t01c05b46981d572329.jpg","sucai/OIP-C.jpg","sucai/OIP-C.jpg","sucai/OIP-C.jpg","sucai/OIP-C.jpg"};
//        for (int i = 0; i < name.length; i++) {
//            people[i] = new Person(i, name[i],path[i]);
//            people[i].addKeyListener(this);
//            people[i].addMouseListener(this);
//            add(people[i]);
//        }
//
//        people[0].setBounds(104, 54, 100, 100);
//        people[1].setBounds(104, 154, 100, 50);
//        people[2].setBounds(54, 154, 50, 100);
//        people[3].setBounds(204, 154, 50, 100);
//        people[4].setBounds(54, 54, 50, 100);
//        people[5].setBounds(204, 54, 50, 100);
//        people[6].setBounds(54, 254, 50, 50);
//        people[7].setBounds(204, 254, 50, 50);
//        people[8].setBounds(104, 204, 50, 50);
//        people[9].setBounds(154, 204, 50, 50);
//
//        left = new JButton();
//        right = new JButton();
//        above = new JButton();
//        below = new JButton();
//        add(left);
//        add(right);
//        add(above);
//        add(below);
//        left.setBounds(49, 49, 5, 260);
//        right.setBounds(254, 49, 5, 260);
//        above.setBounds(49, 49, 210, 5);
//        below.setBounds(49, 304, 210, 5);
//        validate();
//    }
//
//    public void go(Person man, JButton direction) {
//        Rectangle manRect = man.getBounds();
//        int x = manRect.x;
//        int y = manRect.y;
//        if (direction == above) {
//            y -= 50;
//        } else if (direction == below) {
//            y += 50;
//        } else if (direction == left) {
//            x -= 50;
//        } else if (direction == right) {
//            x += 50;
//        }
//        manRect.setLocation(x, y);
//
//        boolean move = true;
//        for (int i = 0; i < 10; i++) {
//            Rectangle personRect = people[i].getBounds();
//            if ((manRect.intersects(personRect) && (man.number != i))) {
//                move = false;
//            }
//        }
//        Rectangle directionRect = direction.getBounds();
//        if (manRect.intersects(directionRect)) {
//            move = false;
//        }
//
//        if (move) {
//            man.setLocation(x, y);
//        }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        dispose();
//        new GameFrame();
//    }
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        Person man = (Person) e.getSource();
//        int keyCode = e.getKeyCode();
//        if (keyCode == KeyEvent.VK_UP) {
//            go(man, above);
//        }
//        if (keyCode == KeyEvent.VK_DOWN) {
//            go(man, below);
//        }
//        if (keyCode == KeyEvent.VK_LEFT) {
//            go(man, left);
//        }
//        if (keyCode == KeyEvent.VK_RIGHT) {
//            go(man, right);
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        Person man = (Person) e.getSource();
//        int x = e.getX();
//        int y = e.getY();
//        int w = man.getBounds().width;
//        int h = man.getBounds().height;
//        if (y < h / 2) {
//            go(man, above);
//        }
//        if (y > h / 2) {
//            go(man, below);
//        }
//        if (x < w / 2) {
//            go(man, left);
//        }
//        if (x > w / 2) {
//            go(man, right);
//        }
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
//}