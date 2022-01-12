package dialogGUI;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

import service.CreateXML;

public class SimpleGUI extends JFrame {
  
  private JButton button = new JButton("Create");
  private JTextField input = new JTextField("DDMMYY", 15);
  private JLabel spacer = new JLabel("\n");
  private JLabel label = new JLabel("\t\tDate for first edition:");
  // private JRadioButton radio1 = new JRadioButton("Select one");
  // private JRadioButton radio2 = new JRadioButton("Select two");
  // private JCheckBox check = new JCheckBox("Check", false);

  public SimpleGUI() {
    super("Create XML files for editions");

    this.setBounds(500, 200, 300, 100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container container = this.getContentPane();
    container.setLayout(new GridLayout(2, 2, 1, 2));
    container.add(label);
    container.add(input);
    container.add(spacer);

    // ButtonGroup group = new ButtonGroup();
    // group.add(radio1);
    // group.add(radio2);
    // container.add(radio1);
    // container.add(radio2);
    // radio1.setSelected(true);

    // container.add(check);
    button.addActionListener(new ButtonEventListener());
    container.add(button);
  }

  class ButtonEventListener implements ActionListener {

    public void actionPerformed(ActionEvent event) {
      try {
        CreateXML.create(input.getText());
      } catch (Exception e) {
        e.printStackTrace();
      }

      String message = "xml created...";
      JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.INFORMATION_MESSAGE);
    }
  }
}
