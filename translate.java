import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Flow;

public class translate  extends JPanel implements ActionListener {
    private static final int SIZE=6; //size of total words
    private String MESSAGE = "No Image to display yet...";

    String englishWords[]={"Dog","Cat","Chicken","Head","Hand","Foot"};

    String spanishWords[]={"Perro","Gato","Pollo","Cabeza","Mano","Pie"};

    String imagesNames[]={"dog.jpg","cat.jpg","chicken.jpg","head.jpg","hand.jpg","foot.jpg"};

    JTextField lang1tf=new JTextField();
    JTextField lang2tf=new JTextField();
    JFrame frame=new JFrame();
    JPanel panel1;
    JPanel image_panel;
    JLabel label;
    public translate() {
        frame.setSize(800,512);
        frame.setLocationRelativeTo(null);


        FlowLayout flowLayout=new FlowLayout(FlowLayout.LEFT,20,0);


        panel1=new JPanel(flowLayout);
        panel1.setLayout(flowLayout);

        //English label
        JLabel label1=new JLabel();
        label1.setText(" English");
        label1.setSize(100,20);
        label1.setLocation(0,100);

        //Spanish label
        JLabel label2=new JLabel();
        label2.setText(" Spanish");
        label2.setSize(100,20);
        label2.setLocation(0,150);

        //Edit textfield for input of English
        lang1tf.setEditable(true);
        lang1tf.setColumns(15);
        lang1tf.setBounds(50,100,150,20);

        //Edit textfield for display of spanish translation
        lang2tf.setEditable(false);
        lang2tf.setColumns(15);
        lang2tf.setBounds(50,150,150,20);
        lang2tf.setVisible(true);

        //Button
        JButton translateButton=new JButton();
        translateButton.setText("translate");
        translateButton.setBounds(220,100,100,20);
        translateButton.addActionListener(this);
        //adding components to frame
        panel1.add(label1);
        panel1.add(lang1tf);
        panel1.add(label2);
        panel1.add(lang2tf);
        panel1.add(translateButton);

        frame.setLayout(flowLayout);
        frame.add(panel1);
//        frame.add(image_panel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String word = lang1tf.getText();
        System.out.println("Word:" + word);
        int i;
        for (i = 0; i < SIZE; i++) {
            if (word.equalsIgnoreCase(englishWords[i])) {
                System.out.println("I:" + i);
                break;
            }
        }
        if (i < SIZE) {
            lang2tf.setEditable(true);
            lang2tf.setText(spanishWords[i]);
        System.out.println("/resources/" + imagesNames[i]);

        if (image_panel != null)
            frame.remove(image_panel);

        image_panel = new JPanel(new BorderLayout());
        label = new JLabel(new ImageIcon(getClass().getResource("/resources/" + imagesNames[i])));
        image_panel.add(label, BorderLayout.EAST);
        image_panel.setBorder(BorderFactory.createMatteBorder(100, 200, 0, 100, getBackground()));
        frame.add(image_panel);
    }

        else{
            lang2tf.setEditable(true);
            lang2tf.setText("Translation not found");
            frame.remove(image_panel);
        }
        frame.revalidate();
        frame.repaint();
    }
    public static void main(String[] args) {
        translate t=new translate();
    }

}
