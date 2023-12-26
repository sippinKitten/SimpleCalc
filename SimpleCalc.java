import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.MathContext;
public class SimpleCalc extends JFrame {
    public boolean isLightTheme;
    private JButton jbtNum1;
    private JButton jbtNum2;
    private JButton jbtNum3;
    private JButton jbtNum4;
    private JButton jbtNum5;
    private JButton jbtNum6;
    private JButton jbtNum7;
    private JButton jbtNum8;
    private JButton jbtNum9;
    private JButton jbtNum0;
    private JButton jbtPlusMinus;
    private JButton jbtAdd;
    private JButton jbtSubtract;
    private JButton jbtMultiply;
    private JButton jbtDivide;
    private JButton jbtSolve;
    private JButton jbtClear;
    private JButton jbtDecimal;
    private JButton jbtSinus;
    private JButton jbtCosinus;
    private JButton jbtTangens;
    private JButton jbtSquare;
    private JButton jbtDegree;
    private Font font = new Font("SanSerif", Font.BOLD, 20);
    private Font font2 = new Font("SanSerif", Font.BOLD, 25);
    private double TEMP;
    private double START;
    private double SolveTEMP;
    private JTextField jtfResult;
    private boolean addBool = false;
    private boolean subBool = false;
    private boolean divBool = false;
    private boolean mulBool = false;
    private boolean operatorClicked = false;
    private boolean sinBool = false;
    private boolean cosBool = false;
    private boolean tgBool = false;
    private boolean sqrBool = false;
    private boolean degBool = false;
    private boolean justSolved = false;
    public void setIsLightTheme(boolean isLightTheme) { this.isLightTheme = isLightTheme; }
    String display = "0";
    public SimpleCalc() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 5));

        p1.add(jbtNum7 = new JButton("7"));
        p1.add(jbtNum8 = new JButton("8"));
        p1.add(jbtNum9 = new JButton("9"));
        p1.add(jbtAdd = new JButton("+"));
        p1.add(jbtSinus = new JButton("sin"));
        p1.add(jbtNum4 = new JButton("4"));
        p1.add(jbtNum5 = new JButton("5"));
        p1.add(jbtNum6 = new JButton("6"));
        p1.add(jbtSubtract = new JButton("-"));
        p1.add(jbtCosinus = new JButton("cos"));
        p1.add(jbtNum1 = new JButton("1"));
        p1.add(jbtNum2 = new JButton("2"));
        p1.add(jbtNum3 = new JButton("3"));
        p1.add(jbtDivide = new JButton("/"));
        p1.add(jbtTangens = new JButton("tg"));
        p1.add(jbtNum0 = new JButton("0"));
        p1.add(jbtDecimal = new JButton("."));
        p1.add(jbtSolve = new JButton("="));
        p1.add(jbtMultiply = new JButton("*"));
        p1.add(jbtSquare = new JButton("sqrt"));

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(jtfResult = new JTextField(15));
        jtfResult.setHorizontalAlignment(JTextField.RIGHT);
        jtfResult.setEditable(false);

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 3));
        p3.add(jbtClear = new JButton("C"));
        p3.add(jbtPlusMinus = new JButton("+/-"));
        p3.add(jbtDegree = new JButton("x^y"));
        p1.setBackground(Color.BLACK);
        p2.setBackground(Color.BLACK);
        p3.setBackground(Color.BLACK);

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(p2, BorderLayout.NORTH);
        p.add(p1, BorderLayout.CENTER);
        p.add(p3, BorderLayout.SOUTH);

        add(p);
        jbtNum1.addActionListener(new ListenToButton());
        jbtNum2.addActionListener(new ListenToButton());
        jbtNum3.addActionListener(new ListenToButton());
        jbtNum4.addActionListener(new ListenToButton());
        jbtNum5.addActionListener(new ListenToButton());
        jbtNum6.addActionListener(new ListenToButton());
        jbtNum7.addActionListener(new ListenToButton());
        jbtNum8.addActionListener(new ListenToButton());
        jbtNum9.addActionListener(new ListenToButton());
        jbtNum0.addActionListener(new ListenToButton());
        jbtDecimal.addActionListener(new ListenToButton());
        jbtAdd.addActionListener(new ListenToAdd());
        jbtSubtract.addActionListener(new ListenToSubtract());
        jbtMultiply.addActionListener(new ListenToMultiply());
        jbtDivide.addActionListener(new ListenToDivide());
        jbtSolve.addActionListener(new ListenToSolve());
        jbtClear.addActionListener(new ListenToClear());
        jbtPlusMinus.addActionListener(new ListenToPlusMinus());
        jbtSinus.addActionListener(new ListenToSinus());
        jbtCosinus.addActionListener(new ListenToCosinus());
        jbtTangens.addActionListener(new ListenToTangens());
        jbtSquare.addActionListener(new ListenToSquare());
        jbtDegree.addActionListener(new ListenToDegree());
        jbtAdd.setFont(font);
        jbtAdd.setBackground(Color.BLACK);
        jbtAdd.setForeground(Color.WHITE);
        jbtClear.setFont(font);
        jbtClear.setBackground(Color.BLACK);
        jbtClear.setForeground(Color.WHITE);
        jbtDecimal.setFont(font);
        jbtDecimal.setBackground(Color.BLACK);
        jbtDecimal.setForeground(Color.WHITE);
        jbtDivide.setFont(font);
        jbtDivide.setBackground(Color.BLACK);
        jbtDivide.setForeground(Color.WHITE);
        jbtMultiply.setFont(font);
        jbtMultiply.setBackground(Color.BLACK);
        jbtMultiply.setForeground(Color.WHITE);
        jbtNum0.setFont(font);
        jbtNum0.setBackground(Color.BLACK);
        jbtNum0.setForeground(Color.WHITE);
        jbtNum1.setFont(font);
        jbtNum1.setBackground(Color.BLACK);
        jbtNum1.setForeground(Color.WHITE);
        jbtNum2.setFont(font);
        jbtNum2.setBackground(Color.BLACK);
        jbtNum2.setForeground(Color.WHITE);
        jbtNum3.setFont(font);
        jbtNum3.setBackground(Color.BLACK);
        jbtNum3.setForeground(Color.WHITE);
        jbtNum4.setFont(font);
        jbtNum4.setBackground(Color.BLACK);
        jbtNum4.setForeground(Color.WHITE);
        jbtNum5.setFont(font);
        jbtNum5.setBackground(Color.BLACK);
        jbtNum5.setForeground(Color.WHITE);
        jbtNum6.setFont(font);
        jbtNum6.setBackground(Color.BLACK);
        jbtNum6.setForeground(Color.WHITE);
        jbtNum7.setFont(font);
        jbtNum7.setBackground(Color.BLACK);
        jbtNum7.setForeground(Color.WHITE);
        jbtNum8.setFont(font);
        jbtNum8.setBackground(Color.BLACK);
        jbtNum8.setForeground(Color.WHITE);
        jbtNum9.setFont(font);
        jbtNum9.setBackground(Color.BLACK);
        jbtNum9.setForeground(Color.WHITE);
        jbtPlusMinus.setFont(font);
        jbtPlusMinus.setBackground(Color.BLACK);
        jbtPlusMinus.setForeground(Color.WHITE);
        jbtSolve.setFont(font);
        jbtSolve.setBackground(Color.BLACK);
        jbtSolve.setForeground(Color.WHITE);
        jbtSubtract.setFont(font);
        jbtSubtract.setBackground(Color.BLACK);
        jbtSubtract.setForeground(Color.WHITE);
        jtfResult.setFont(font2);
        jtfResult.setBackground(Color.BLACK);
        jtfResult.setForeground(Color.WHITE);
        jbtDegree.setFont(font);
        jbtDegree.setBackground(Color.BLACK);
        jbtDegree.setForeground(Color.WHITE);
        jbtCosinus.setFont(font);
        jbtCosinus.setBackground(Color.BLACK);
        jbtCosinus.setForeground(Color.WHITE);
        jbtSquare.setFont(font);
        jbtSquare.setBackground(Color.BLACK);
        jbtSquare.setForeground(Color.WHITE);
        jbtTangens.setFont(font);
        jbtTangens.setBackground(Color.BLACK);
        jbtTangens.setForeground(Color.WHITE);
        jbtSinus.setFont(font);
        jbtSinus.setBackground(Color.BLACK);
        jbtSinus.setForeground(Color.WHITE);
        jbtAdd.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtClear.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtDecimal.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtDivide.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtMultiply.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtNum0.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtNum1.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtNum2.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtNum3.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtNum4.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtNum5.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtNum6.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtNum7.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtNum8.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtNum9.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtPlusMinus.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtSolve.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtSubtract.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtDegree.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtCosinus.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtSquare.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtTangens.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jbtSinus.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        jtfResult.setBorder(null);
        JMenuBar menuBar = new JMenuBar();
        JMenu helpMenu = new JMenu("Ñïðàâêà");
        JMenu designMenu = new JMenu("Äèçàéí");
        JMenuItem developerItem = new JMenuItem("Î ðàçðàáîò÷èêå");
        JMenuItem designItem = new JMenuItem("Ñìåíèòü òåìó");
        designMenu.add(designItem);
        helpMenu.add(developerItem);
        menuBar.add(helpMenu);
        menuBar.add(designMenu);
        setJMenuBar(menuBar);


        designItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setIsLightTheme(!isLightTheme);
                if(isLightTheme) {
                    jbtAdd.setFont(font);
                    jbtAdd.setBackground(Color.LIGHT_GRAY);
                    jbtAdd.setForeground(Color.DARK_GRAY);
                    jbtClear.setFont(font);
                    jbtClear.setBackground(Color.LIGHT_GRAY);
                    jbtClear.setForeground(Color.DARK_GRAY);
                    jbtDecimal.setFont(font);
                    jbtDecimal.setBackground(Color.LIGHT_GRAY);
                    jbtDecimal.setForeground(Color.DARK_GRAY);
                    jbtDivide.setFont(font);
                    jbtDivide.setBackground(Color.LIGHT_GRAY);
                    jbtDivide.setForeground(Color.DARK_GRAY);
                    jbtMultiply.setFont(font);
                    jbtMultiply.setBackground(Color.LIGHT_GRAY);
                    jbtMultiply.setForeground(Color.DARK_GRAY);
                    jbtNum0.setFont(font);
                    jbtNum0.setBackground(Color.LIGHT_GRAY);
                    jbtNum0.setForeground(Color.DARK_GRAY);
                    jbtNum1.setFont(font);
                    jbtNum1.setBackground(Color.LIGHT_GRAY);
                    jbtNum1.setForeground(Color.DARK_GRAY);
                    jbtNum2.setFont(font);
                    jbtNum2.setBackground(Color.LIGHT_GRAY);
                    jbtNum2.setForeground(Color.DARK_GRAY);
                    jbtNum3.setFont(font);
                    jbtNum3.setBackground(Color.LIGHT_GRAY);
                    jbtNum3.setForeground(Color.DARK_GRAY);
                    jbtNum4.setFont(font);
                    jbtNum4.setBackground(Color.LIGHT_GRAY);
                    jbtNum4.setForeground(Color.DARK_GRAY);
                    jbtNum5.setFont(font);
                    jbtNum5.setBackground(Color.LIGHT_GRAY);
                    jbtNum5.setForeground(Color.DARK_GRAY);
                    jbtNum6.setFont(font);
                    jbtNum6.setBackground(Color.LIGHT_GRAY);
                    jbtNum6.setForeground(Color.DARK_GRAY);
                    jbtNum7.setFont(font);
                    jbtNum7.setBackground(Color.LIGHT_GRAY);
                    jbtNum7.setForeground(Color.DARK_GRAY);
                    jbtNum8.setFont(font);
                    jbtNum8.setBackground(Color.LIGHT_GRAY);
                    jbtNum8.setForeground(Color.DARK_GRAY);
                    jbtNum9.setFont(font);
                    jbtNum9.setBackground(Color.LIGHT_GRAY);
                    jbtNum9.setForeground(Color.DARK_GRAY);
                    jbtPlusMinus.setFont(font);
                    jbtPlusMinus.setBackground(Color.LIGHT_GRAY);
                    jbtPlusMinus.setForeground(Color.DARK_GRAY);
                    jbtSolve.setFont(font);
                    jbtSolve.setBackground(Color.LIGHT_GRAY);
                    jbtSolve.setForeground(Color.DARK_GRAY);
                    jbtSubtract.setFont(font);
                    jbtSubtract.setBackground(Color.LIGHT_GRAY);
                    jbtSubtract.setForeground(Color.DARK_GRAY);
                    jtfResult.setFont(font2);
                    jtfResult.setBackground(Color.LIGHT_GRAY);
                    jtfResult.setForeground(Color.DARK_GRAY);
                    jbtDegree.setFont(font);
                    jbtDegree.setBackground(Color.LIGHT_GRAY);
                    jbtDegree.setForeground(Color.DARK_GRAY);
                    jbtCosinus.setFont(font);
                    jbtCosinus.setBackground(Color.LIGHT_GRAY);
                    jbtCosinus.setForeground(Color.DARK_GRAY);
                    jbtSquare.setFont(font);
                    jbtSquare.setBackground(Color.LIGHT_GRAY);
                    jbtSquare.setForeground(Color.DARK_GRAY);
                    jbtTangens.setFont(font);
                    jbtTangens.setBackground(Color.LIGHT_GRAY);
                    jbtTangens.setForeground(Color.DARK_GRAY);
                    jbtSinus.setFont(font);
                    jbtSinus.setBackground(Color.LIGHT_GRAY);
                    jbtSinus.setForeground(Color.DARK_GRAY);
                    p1.setBackground(Color.LIGHT_GRAY);
                    p2.setBackground(Color.LIGHT_GRAY);
                    p3.setBackground(Color.LIGHT_GRAY);
                    jbtAdd.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtClear.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtDecimal.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtDivide.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtMultiply.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtNum0.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtNum1.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtNum2.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtNum3.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtNum4.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtNum5.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtNum6.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtNum7.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtNum8.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtNum9.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtPlusMinus.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtSolve.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtSubtract.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtDegree.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtCosinus.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtSquare.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtTangens.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jbtSinus.setBorder(new LineBorder(new Color(150, 150, 150), 1));
                    jtfResult.setBorder(null);
                    isLightTheme = true;
                } else {
                    jbtAdd.setFont(font);
                    jbtAdd.setBackground(Color.BLACK);
                    jbtAdd.setForeground(Color.WHITE);
                    jbtClear.setFont(font);
                    jbtClear.setBackground(Color.BLACK);
                    jbtClear.setForeground(Color.WHITE);
                    jbtDecimal.setFont(font);
                    jbtDecimal.setBackground(Color.BLACK);
                    jbtDecimal.setForeground(Color.WHITE);
                    jbtDivide.setFont(font);
                    jbtDivide.setBackground(Color.BLACK);
                    jbtDivide.setForeground(Color.WHITE);
                    jbtMultiply.setFont(font);
                    jbtMultiply.setBackground(Color.BLACK);
                    jbtMultiply.setForeground(Color.WHITE);
                    jbtNum0.setFont(font);
                    jbtNum0.setBackground(Color.BLACK);
                    jbtNum0.setForeground(Color.WHITE);
                    jbtNum1.setFont(font);
                    jbtNum1.setBackground(Color.BLACK);
                    jbtNum1.setForeground(Color.WHITE);
                    jbtNum2.setFont(font);
                    jbtNum2.setBackground(Color.BLACK);
                    jbtNum2.setForeground(Color.WHITE);
                    jbtNum3.setFont(font);
                    jbtNum3.setBackground(Color.BLACK);
                    jbtNum3.setForeground(Color.WHITE);
                    jbtNum4.setFont(font);
                    jbtNum4.setBackground(Color.BLACK);
                    jbtNum4.setForeground(Color.WHITE);
                    jbtNum5.setFont(font);
                    jbtNum5.setBackground(Color.BLACK);
                    jbtNum5.setForeground(Color.WHITE);
                    jbtNum6.setFont(font);
                    jbtNum6.setBackground(Color.BLACK);
                    jbtNum6.setForeground(Color.WHITE);
                    jbtNum7.setFont(font);
                    jbtNum7.setBackground(Color.BLACK);
                    jbtNum7.setForeground(Color.WHITE);
                    jbtNum8.setFont(font);
                    jbtNum8.setBackground(Color.BLACK);
                    jbtNum8.setForeground(Color.WHITE);
                    jbtNum9.setFont(font);
                    jbtNum9.setBackground(Color.BLACK);
                    jbtNum9.setForeground(Color.WHITE);
                    jbtPlusMinus.setFont(font);
                    jbtPlusMinus.setBackground(Color.BLACK);
                    jbtPlusMinus.setForeground(Color.WHITE);
                    jbtSolve.setFont(font);
                    jbtSolve.setBackground(Color.BLACK);
                    jbtSolve.setForeground(Color.WHITE);
                    jbtSubtract.setFont(font);
                    jbtSubtract.setBackground(Color.BLACK);
                    jbtSubtract.setForeground(Color.WHITE);
                    jtfResult.setFont(font2);
                    jtfResult.setBackground(Color.BLACK);
                    jtfResult.setForeground(Color.WHITE);
                    jbtDegree.setFont(font);
                    jbtDegree.setBackground(Color.BLACK);
                    jbtDegree.setForeground(Color.WHITE);
                    jbtCosinus.setFont(font);
                    jbtCosinus.setBackground(Color.BLACK);
                    jbtCosinus.setForeground(Color.WHITE);
                    jbtSquare.setFont(font);
                    jbtSquare.setBackground(Color.BLACK);
                    jbtSquare.setForeground(Color.WHITE);
                    jbtTangens.setFont(font);
                    jbtTangens.setBackground(Color.BLACK);
                    jbtTangens.setForeground(Color.WHITE);
                    jbtSinus.setFont(font);
                    jbtSinus.setBackground(Color.BLACK);
                    jbtSinus.setForeground(Color.WHITE);
                    jbtAdd.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtClear.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtDecimal.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtDivide.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtMultiply.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtNum0.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtNum1.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtNum2.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtNum3.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtNum4.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtNum5.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtNum6.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtNum7.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtNum8.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtNum9.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtPlusMinus.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtSolve.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtSubtract.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtDegree.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtCosinus.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtSquare.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtTangens.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jbtSinus.setBorder(new LineBorder(new Color(64, 64, 64), 1));
                    jtfResult.setBorder(null);
                    isLightTheme = false;
                    p1.setBackground(Color.BLACK);
                    p2.setBackground(Color.BLACK);
                    p3.setBackground(Color.BLACK);
                }
            }
        });
        menuBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        JFrame frame = new JFrame("Î ðàçðàáîò÷èêå");
        developerItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(frame, "Ðàçðàáîò÷èê: Èâàíîâ Äàíèë \nÑòóäåíò ãðóïïû 2À", "Î ðàçðàáîò÷èêå", JOptionPane.INFORMATION_MESSAGE);
            }
        });



    }
    class ListenToClear implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jtfResult.setText("0");
            addBool = subBool = mulBool = divBool = sinBool = cosBool = tgBool = sqrBool = degBool = operatorClicked = false;
            justSolved = false;
            START = TEMP = SolveTEMP = 0;
        }
    }
    class ListenToButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonLabel = button.getText();
            jtfResult.setText(justSolved || operatorClicked ? buttonLabel : jtfResult.getText().equals("0") ? buttonLabel : jtfResult.getText() + buttonLabel);
            justSolved = operatorClicked = false;
        }
    }

    class ListenToPlusMinus implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(jtfResult.getText());
            TEMP = TEMP * -1;
            roundCheck(TEMP);
        }
    }
    class ListenToAdd implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(jtfResult.getText());
            solveMethod(TEMP);
            START = TEMP;
            addBool = true;
            operatorClicked = true;
        }
    }
    class ListenToSubtract implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(jtfResult.getText());
            solveMethod(TEMP);
            START = TEMP;
            subBool = true;
            operatorClicked = true;
        }
    }
    class ListenToMultiply implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(jtfResult.getText());
            solveMethod(TEMP);
            START = TEMP;
            mulBool = true;
            operatorClicked = true;
        }
    }
    class ListenToDivide implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(jtfResult.getText());
            solveMethod(TEMP);
            START = TEMP;
            divBool = true;
            operatorClicked = true;
        }
    }
    class ListenToSolve implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            SolveTEMP = Double.parseDouble(  jtfResult.getText() );
            solveMethodEquals(SolveTEMP);
        }
    }
    class ListenToSinus implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(jtfResult.getText());
            solveMethod(TEMP);
            START = TEMP;
            sinBool = true;
            operatorClicked = true;
        }
    }
    class ListenToCosinus implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(jtfResult.getText());
            solveMethod(TEMP);
            START = TEMP;
            cosBool = true;
            operatorClicked = true;
        }
    }
    class ListenToTangens implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(jtfResult.getText());
            solveMethod(TEMP);
            START = TEMP;
            tgBool = true;
            operatorClicked = true;
        }
    }
    class ListenToSquare implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(jtfResult.getText());
            solveMethod(TEMP);
            START = TEMP;
            sqrBool = true;
            operatorClicked = true;
        }
    }
    class ListenToDegree implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            TEMP = Double.parseDouble(jtfResult.getText());
            solveMethod(TEMP);
            START = TEMP;
            degBool = true;
            operatorClicked = true;
        }
    }
    public void solveMethod(double d) {
        if ( addBool == true  ) {
            TEMP = TEMP + START;
        }
        else if ( subBool == true  ) {
            TEMP = START - TEMP;
        }
        else if ( mulBool == true  ) {
            TEMP = START * TEMP;
        }
        else if (divBool == true) {
            if (TEMP == 0) {
                JOptionPane.showMessageDialog(null, "Äåëåíèå íà íîëü", "Îøèáêà°", JOptionPane.ERROR_MESSAGE);
            } else {
                TEMP = START / TEMP;
            }
        }
        else if ( sinBool == true  ) {
            BigDecimal angle = new BigDecimal(d);
            BigDecimal result = new BigDecimal(Math.sin(Math.toRadians(angle.doubleValue())));
            TEMP = result.doubleValue();
        }
        else if ( cosBool == true  ) {
            BigDecimal angle = new BigDecimal(d);
            BigDecimal result = new BigDecimal(Math.cos(Math.toRadians(angle.doubleValue())));
            TEMP = result.doubleValue();
        }
        else if ( tgBool == true  ) {
            if (d == 90) {
                JOptionPane.showMessageDialog(null, "Òû áàëáåñ", "Îøèáêà", JOptionPane.ERROR_MESSAGE);
                return;}
            BigDecimal angle = new BigDecimal(d);
            BigDecimal result = new BigDecimal(Math.tan(Math.toRadians(angle.doubleValue())));
            TEMP = result.doubleValue();
        }
        else if ( sqrBool == true  ) {
            if (d < 0) {
                JOptionPane.showMessageDialog(null, "Íåëüçÿ âû÷èñëèòü êîðåíü èç îòðèöàòåëüíîãî ÷èñëà", "Îøèáêà", JOptionPane.ERROR_MESSAGE);
                return;
            }
            TEMP = Math.sqrt(d);
        }
        else if ( degBool == true) {

            TEMP = Math.pow(START, TEMP);
        }
        roundCheck(TEMP);
        addBool = subBool = mulBool = divBool = sinBool = cosBool = tgBool = sqrBool = degBool = operatorClicked = false;
        justSolved = true;
    }
    public void solveMethodEquals(double d) {
        if ( addBool == true  ) {
            SolveTEMP = TEMP + SolveTEMP;
        }
        else if ( subBool == true  ) {
            SolveTEMP = TEMP - SolveTEMP;
        }
        else if ( mulBool == true  ) {
            SolveTEMP = TEMP * SolveTEMP;
        }
        else if (divBool == true) {
            if (SolveTEMP == 0) {
                JOptionPane.showMessageDialog(null, "Äåëåíèå íà íîëü", "Îøèáêà", JOptionPane.ERROR_MESSAGE);
            } else {
                SolveTEMP = START / SolveTEMP;
            }
        }
        else if ( sinBool == true  ) {
            BigDecimal angle = new BigDecimal(d);
            BigDecimal result = new BigDecimal(Math.sin(Math.toRadians(angle.doubleValue())));
            SolveTEMP = result.doubleValue();
        }
        else if ( cosBool == true  ) {
            BigDecimal angle = new BigDecimal(d);
            BigDecimal result = new BigDecimal(Math.cos(Math.toRadians(angle.doubleValue())));
            SolveTEMP = result.doubleValue();
        }
        else if ( tgBool == true  ) {
            if (d == 90) {
                JOptionPane.showMessageDialog(null, "Íå ñóùåñòâóåò", "Îøèáêà", JOptionPane.ERROR_MESSAGE);
                return;}
            BigDecimal angle = new BigDecimal(d);
            BigDecimal result = new BigDecimal(Math.tan(Math.toRadians(angle.doubleValue())));
            SolveTEMP = result.doubleValue();
        }
        else if ( sqrBool == true  ) {
            if (d < 0) {
                JOptionPane.showMessageDialog(null, "Íåëüçÿ âû÷èñëèòü êîðåíü èç îòðèöàòåëüíîãî ÷èñëà", "Îøèáêà", JOptionPane.ERROR_MESSAGE);
                return;
            }
            SolveTEMP = Math.sqrt(d);
        }
        else if ( degBool == true) {

            SolveTEMP = Math.pow(START, SolveTEMP);
        }
        roundCheck(SolveTEMP);
        addBool = subBool = mulBool = divBool = sinBool = cosBool = tgBool = sqrBool = degBool = operatorClicked = false;
        justSolved = true;
    }
    public void roundCheck(double d) {
        if (d % 1 == 0) {
            int result = (int)d;
            Integer iresult = (Integer)result;
            jtfResult.setText(  Integer.toString( iresult ) );
        }
        else {
            jtfResult.setText(  Double.toString( d ) );
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SimpleCalc calc = new SimpleCalc();
        calc.pack();
        calc.setBackground(Color.BLACK);
        calc.setSize(360,400);
        calc.setResizable(false);
        calc.setLocationRelativeTo(null);
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setVisible(true);
        calc.setTitle("Êàëüêóëÿòîð");
    }
}
