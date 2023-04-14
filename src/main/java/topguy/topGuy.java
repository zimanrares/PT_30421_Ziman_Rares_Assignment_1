package topguy;

import logic.Ops;
import poly.Polynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class topGuy {
    private JPanel panelMain;
    private JTextField textField1;
    private JTextField textField2;
    private JButton multiplyButton;
    private JButton addButton;
    private JButton minusBtn;
    private JButton divButton;
    private JTextField textField3;
    private JButton deriveButton;
    private JButton integrateButton;

    public topGuy() {
        JFrame frame = new JFrame("topGuy");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    multiplyButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            Polynomial p1 = new Polynomial(textField1.getText());
            Polynomial p2 = new Polynomial(textField2.getText());
            Polynomial res = Ops.multiply(p1, p2);
            textField3.setText(res.toString());

        }
    });

    addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial p1 = new Polynomial(textField1.getText());
            Polynomial p2 = new Polynomial(textField2.getText());

            Polynomial res = Ops.add(p1, p2);
            textField3.setText(res.toString());

        }
    });
    minusBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial p1 = new Polynomial(textField1.getText());
            Polynomial p2 = new Polynomial(textField2.getText());
            Polynomial res = Ops.subtract(p1, p2);
            textField3.setText(res.toString());
        }
    });
    divButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        Polynomial p1 = new Polynomial(textField1.getText());
        Polynomial p2 = new Polynomial(textField2.getText());
        Polynomial res = Ops.divide(p1, p2);
        textField3.setText(res.toString());

        }
    });

    integrateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 = new Polynomial(textField1.getText());
                Polynomial res = Ops.integrate(p1);
                textField3.setText(res.toString());
            }
        });
    deriveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial p1 = new Polynomial(textField1.getText());
                Polynomial res = Ops.derivative(p1);
                textField3.setText(res.toString());
            }
    });
    }
}
