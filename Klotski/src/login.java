
import javax.swing.*;
import java.awt.*;


//public class login extends JFrame {
//    private JTextField username;
//    private JTextField password;
//    private JButton submitBtn;
//    private JButton resetBtn;
//    private game gameFrame;
//    public login() {
//        initial();
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setBounds(100, 100, 320, 500);
//        setVisible(true);
//        validate();
//    }
//    public void initial () {
//        this.setTitle("Login Frame");
//        this.setLayout(null);
//
//        JLabel userLabel = FrameUtil.createJLabel(this, new Point(50, 20), 70, 40, "username:");
//        JLabel passLabel = FrameUtil.createJLabel(this, new Point(50, 80), 70, 40, "password:");
//        username = FrameUtil.createJTextField(this, new Point(120, 20), 120, 40);
//        password = FrameUtil.createJTextField(this, new Point(120, 80), 120, 40);
//
//        submitBtn = FrameUtil.createButton(this, "Confirm", new Point(40, 140), 100, 40);
//        resetBtn = FrameUtil.createButton(this, "Reset", new Point(160, 140), 100, 40);
//
//        submitBtn.addActionListener(e -> {
//            System.out.println("Username = " + username.getText());
//            System.out.println("Password = " + password.getText());
//            if (this.gameFrame != null) {
//                this.gameFrame.setVisible(true);
//                this.setVisible(false);
//            }
//            //todo: check login info
//
//        });
//        resetBtn.addActionListener(e -> {
//            username.setText("");
//            password.setText("");
//        });
//
//        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);}
//        public void setGameFrame(game gameFrame) {
//            this.gameFrame = gameFrame;
//        }
//    }