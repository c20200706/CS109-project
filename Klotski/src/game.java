import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class game extends JFrame implements ActionListener ,KeyListener,MouseListener {
    Person[] hero= new Person[10];
    JButton left,right,up,down1,down2,down;
    JButton restart= new JButton("重来");
    JButton load=new JButton("保存");
    JButton win=new JButton("你赢啦");

    private Stack<GameState> history = new Stack<>();
    private JButton undoButton = new JButton("撤销");//撤销按钮新建

    private int i=0;
    private JButton STEP=new JButton(String.format("步数：%d", i));
    public game() {
        initial();
        setTitle("gogogo出发咯");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100, 100, 320, 500);
        setVisible(true);
        validate();
    }

    private class GameState {
        int stepCount;
        Point[] positions;
        public GameState(int steps, Person[] heros) {
            this.stepCount = steps;
            this.positions = new Point[10];
            for(int i=0; i<10; i++){
                this.positions[i] = heros[i].getLocation();
            }
        }
    }//状态存储与记录

    public void initial() {
        setLayout(null);
        add(restart);
        add(load);
        add(STEP);
        add(undoButton);

        undoButton.setBounds(182,320 , 66, 35);
        undoButton.addActionListener(e -> chexiao());

        restart.setBounds(50,320,66,35);
        restart.addActionListener(this);
        load.setBounds(116,320,66,35);
        STEP.setBounds(100,400,100,35);
    String[] name ={"曹操", "关羽", "马", "黄", "赵", "张", "兵", "兵", "兵", "兵"};
    String[] path ={"sucai/R-C (1).jpg","sucai/下载.jpg","sucai/OIP-C (2).jpg","sucai/OIP-C (3).jpg","sucai/OIP-C (4).jpg","sucai/t01c05b46981d572329.jpg","sucai/OIP-C.jpg","sucai/OIP-C.jpg","sucai/OIP-C.jpg","sucai/OIP-C.jpg"};

    for(int i=0;i<10;i++){
        hero[i] = new Person(i, name[i],path[i]);
        add(hero[i]);
        hero[i].addKeyListener(this);
    }
        hero[0].setBounds(104, 54, 100, 100);
        hero[1].setBounds(104, 154, 100, 50);
        hero[2].setBounds(54, 154, 50, 100);
        hero[3].setBounds(204, 154, 50, 100);
        hero[4].setBounds(54, 54, 50, 100);
        hero[5].setBounds(204, 54, 50, 100);
        hero[6].setBounds(54, 254, 50, 50);
        hero[7].setBounds(204, 254, 50, 50);
        hero[8].setBounds(104, 204, 50, 50);
        hero[9].setBounds(154, 204, 50, 50);

        left =new JButton();
        right =new JButton();
        up =new JButton();
        down1 =new JButton();
        down2=new JButton();
        down=new JButton();
        add(left);
        add(right);
        add(up);
        add(down1);
        add(down2);
        add(down);
        left.setBounds(49, 49, 5, 260);
        right.setBounds(254, 49, 5, 260);
        up.setBounds(49, 49, 210, 5);
        down1.setBounds(53, 304, 53, 5);
        down2.setBounds(202,304,53,5);
        down.setBounds(103,304,102,5);
        down.setBackground(Color.RED);
        down.setOpaque(true);;
        validate();
    }
    public void go(Person man,JButton direction){
        Rectangle bianjie=man.getBounds();
        int x= bianjie.x;
        int y= bianjie.y;
        if (direction == up) {
            y -= 50;
        } else if (direction == down) {
            y += 50;
        } else if (direction == left) {
            x -= 50;
        } else if (direction == right) {
            x += 50;
        }
        bianjie.setLocation(x, y);

        boolean move = true;
        for (int i = 0; i < 10; i++) {
            Rectangle personRect = hero[i].getBounds();
            if ((bianjie.intersects(personRect) && (man.number != i))) {
                move = false;
            }
        }
        Rectangle directionRect = direction.getBounds();
        if (bianjie.intersects(directionRect)) {
            move = false;
    }

        if(move){
            history.push(new GameState(i, hero));
            man.setLocation(x,y);
            i++;
            STEP.setText(String.format("步数：%d", i)); // 修改现有按钮文本
            STEP.revalidate(); // 强制刷新组件布局
            STEP.repaint();    // 触发重绘（非必须但建议）
            if(man.getNumber()==1){
                Rectangle c = man.getBounds();
                if(c.x == 104 && c.y == 204){
                    add(win);
                    win.setBounds(60,360,200,35);
                    win.setText(String.format("胜利咯！你的步数：%d", i));
                    win.repaint();  // 强制重绘
                    validate();     // 刷新布局
                }
            }
        }
}
    private void chexiao() {
        if(!history.isEmpty()) {
            GameState state = history.pop();
            // 恢复步数
            i = state.stepCount;
            STEP.setText(String.format("步数：%d", i));

            // 恢复所有角色位置
            for(int idx=0; idx<10; idx++){
                hero[idx].setLocation(state.positions[idx]);
                hero[idx].repaint();
            }

            // 检查胜利条件是否需要撤回
            if(win.getParent() != null){
                remove(win);
                validate();
                repaint();
            }
        } else {
            JOptionPane.showMessageDialog(this, "无法继续撤销");
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        new game();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Person man = (Person) e.getSource();
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            go(man, up);
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            go(man, down);
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            go(man, left);
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            go(man, right);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
