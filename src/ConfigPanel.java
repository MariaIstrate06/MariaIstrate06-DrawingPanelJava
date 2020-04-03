import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel; //regular polygons
    JSpinner sidesField;
    JSpinner sizeField;//number of sides
    JComboBox shapeCombo;
    JComboBox colorCombo; // the color of the shape

    public ConfigPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    private void init(){
        //create label and spinner
        JLabel sidesLabel = new JLabel("Number of sides: ");
        sidesField = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        sizeField = new JSpinner(new SpinnerNumberModel(0,0,50,1));
        sidesField.setValue(6); // default no of sides
        sizeField.setValue(10);
        //color - random and black
        String[] colors ={"Random", "Black","Eraser"};
        String[] shapes={"Regular Polygon","Square","Triangle"};
        shapeCombo = new JComboBox(shapes);
        colorCombo = new JComboBox(colors);

        add(new Label("Size: "));
        add(sizeField);
        add(sidesLabel);
        add(sidesField);
        add(new Label("Color: "));
        add(colorCombo);
        add(new Label("Shape:"));
        add(shapeCombo);
    }
}
