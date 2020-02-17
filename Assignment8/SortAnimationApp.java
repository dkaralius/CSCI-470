/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 8          Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Thursday, 05/02/2019           *
 *                                                          *
 *  SortAnimationApp                                        *
 *                                                          *
 *  SortAnimationApp is a class that is used to set up the  *
 *  GUI for the program. Sets the title of the application  *
 *  and also has the button handling for the buttons to be  *
 *  used in the application.                                *
 ************************************************************/ 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Random;

public class SortAnimationApp extends JFrame
{
   SortPanel panelLeft = new SortPanel();
   SortPanel panelRight = new SortPanel();
   
   private JButton populate = new JButton("Populate");
   private JPanel buttons = new JPanel();
   
   private String[] speeds = {"Slow","Medium","Fast"};
   private JComboBox sortSpeed = new JComboBox<>(speeds);
   
   private JButton sortButton = new JButton("Sort");
   private JButton pauseButton = new JButton("Pause");
   private JButton resumeButton = new JButton("Resume");
   
   /**************************************************************
   * Uses the invokeLater SwingUtility to start the application. *
   **************************************************************/
   public static void main(String[] args)
   { 
     SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() 
            { 
               SortAnimationApp frame = new SortAnimationApp("Sorting Application"); 
               frame.createAndShowGUI();
            }});
   }
   
   /**************************************************************
   * Sets the name of the application window.                    *
   **************************************************************/
   private SortAnimationApp(String title)
   {
      super(title);
   }
   
   /**************************************************************
   * Creates the main GUI for the program. Sets the size and     *
   * layout for the panels. Adds the panels,buttons, and enables *
   * certain ones. Also adds button handling for the buttons.    *
   **************************************************************/
   private void createAndShowGUI()
   {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(1200,730);
      this.setLayout(new FlowLayout());
      this.setLocationRelativeTo(null);
      this.setVisible(true);
     
      this.add(panelLeft);
      this.add(panelRight);
     
      buttons.add(populate);
      buttons.add(sortSpeed);
      buttons.add(sortButton);
      this.add(buttons);
      sortButton.setEnabled(false);
      sortSpeed.setEnabled(false);

      //Button handling for "Populate"
      PopulateButtonHandler popButton = new PopulateButtonHandler();
      populate.addActionListener(popButton);
      
      //Button handling for "Sort"
      SortButtonHandler sorButton = new SortButtonHandler();
      sortButton.addActionListener(sorButton);
   }
   /**************************************************************
   * If "Populate" is clicked, sets the "Populate" button to     *
   * "Reset" and populates both panels. Then sets the "Sort"     *
   * button and speed combo box enabled. If user clicks "Reset", *
   * clears the array of integers, sets the "Sort" button back   *
   * to "Sort" , sets the "Reset" button to "Populate", and      *
   * enables the speed combo box for each panel.                 *
   **************************************************************/
   public class PopulateButtonHandler implements ActionListener
   {
      @Override
      public void actionPerformed(ActionEvent event)
      {
          String e = event.getActionCommand();
          if(e.equals("Populate"))
          {
             populate.setEnabled(false);
       
             panelLeft.populate();
             panelRight.populate();
             
             sortButton.setText("Sort");
             sortButton.setEnabled(true);
             sortSpeed.setEnabled(true);
         }
         if(e.equals("Reset"))
         {
            panelLeft.kill();
            panelRight.kill();
            
            sortButton.setText("Sort");
            sortButton.setEnabled(false);
            sortSpeed.setEnabled(false);
            populate.setText("Populate");
            
            panelLeft.enableBox();
            panelRight.enableBox();
         }
      }
   }
   /**************************************************************
   * If "Sort" is clicked, the program starts sorting the panels *
   * using the algorith selected at the speed selected. Then     *
   * disables the speed combo boxes and enables the "Populate"   *
   * button, but changes its name to "Reset". The "Sort" button  *
   * is renamed to "Pause". If "Pause" is clicked, interrupts    *
   * the threads and thus the sorting and "Pause" is renamed to  *
   * "Resume". If "Resume" is clicked, notify() is called and    *
   * sorting is continued, then "Resume" is renamed to "Pause".  *
   **************************************************************/
   public class SortButtonHandler implements ActionListener
   {
      @Override
      public void actionPerformed(ActionEvent event)
      {
        
         String e = event.getActionCommand();
       
         if(e.equals("Sort"))
         {
            sortButton.setText("Pause");
            sortSpeed.setEnabled(false);
            String speed = sortSpeed.getSelectedItem().toString();
            panelLeft.work(speed);
            panelRight.work(speed);
            panelLeft.disableBox();
            panelRight.disableBox();
            populate.setEnabled(true);
            populate.setText("Reset");
         }
         if(e.equals("Pause"))
         {
            panelLeft.pauseAnimation();
            panelRight.pauseAnimation();
            sortButton.setText("Resume");
         }
         if(e.equals("Resume"))
         {
            panelLeft.resumeAnimation();
            panelRight.resumeAnimation();
            sortButton.setText("Pause");
         }
      }
   }
}