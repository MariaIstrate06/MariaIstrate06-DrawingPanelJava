import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    final JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame){
        super();
        this.frame = frame;
        init();
    }
    private void init(){
        setLayout(new GridLayout(1,4));
        //add button
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        //listeners
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        //more
    }
    private void save(ActionEvent e){
        try{
            int returnValue = fileChooser.showSaveDialog(null);
            File selectedFile = new File("./");
            if(returnValue==JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
            }
            ImageIO.write(frame.canvas.image, "PNG", new FileOutputStream(selectedFile.getAbsolutePath()));
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
    private void load(ActionEvent e){
        int returnValue = fileChooser.showOpenDialog(null);
        File selectedFile = new File("./");
        if(returnValue==JFileChooser.APPROVE_OPTION){
            selectedFile=fileChooser.getSelectedFile();
        }
        try{
            frame.canvas.image=ImageIO.read(new FileInputStream(selectedFile.getAbsolutePath()));
            frame.canvas.graphics=frame.canvas.image.createGraphics();
        }
        catch(IOException ex){
            System.err.println(ex);
        }
    }
    private void reset(ActionEvent e){
        frame.canvas.graphics.setColor(Color.BLACK);
        frame.canvas.graphics.fillRect(0,0,frame.canvas.W,frame.canvas.H);
    }
    private void exit(ActionEvent e){
        System.exit(0);
    }


}
