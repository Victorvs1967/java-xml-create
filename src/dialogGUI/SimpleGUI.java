package dialogGUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import service.CreateXML;

public class SimpleGUI extends JFrame {
  
  private JButton button = new JButton("Create");
  private JTextField input = new JTextField("DDMMYY", 15);
  private JLabel spacer = new JLabel("");
  private JLabel label = new JLabel("\t\tDate for first edition:");

  public SimpleGUI() {
    super("Create XML files for editions");

    this.setBounds(500, 200, 300, 100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container container = this.getContentPane();
    container.setLayout(new GridLayout(2, 2, 1, 2));
    container.add(label);
    container.add(input);
    container.add(spacer);

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

      JOptionPane.showMessageDialog(null, "xml created...", "Finishing", JOptionPane.INFORMATION_MESSAGE);
    }
  }
}
