/************************************************************
 *                                                          *
 *  CSCI 470-1/502-1    Assignment 8          Spring 2019   *
 *                                                          *
 *  Programmer:  Dominykas Karalius - Z1809478              *  
 *                                                          *
 *  Date Due:    11:59 PM on Thursday, 05/02/2019           *
 *                                                          *
 *  SortPanel                                               *
 *                                                          *
 *  SortPanel is a class that is used to set up the layout  *
 *  for each SortPanel that will be used to show the array  *
 *  of integers. This class has a few methods which are     *
 *  used to call to methods in the SortAnimationPanel       *
 *  class.                                                  *
 ************************************************************/ 
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

public class SortPanel extends JPanel
   {
   private String[] sortMethods = {"Selection Sort","Insertion Sort","Bubble Sort","Shell Sort"};
   private JComboBox sortingMethod = new JComboBox<>(sortMethods);
   private JPanel test = new JPanel();
   
   public SortAnimationPanel animationPanel;
   
   public SortPanel()
   {
      animationPanel = new SortAnimationPanel();
      animationPanel.setPreferredSize(new Dimension(500,600));
      
      GridBagLayout layout = new GridBagLayout();
      GridBagConstraints gbc = new GridBagConstraints();
      
      test.setLayout(layout);
      
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridx = 0;
      gbc.gridy = 0;
      test.add(animationPanel,gbc);
      
      gbc.gridx = 0;
      gbc.gridy = 1;
      test.add(sortingMethod,gbc);

      this.add(test);
   }
   /**************************************************************
   * Method that, when called, will redirect to the              *
   * populateArray() method in the SortAnimationPanel class.     *
   * Is used to populate the array with random integers.         *
   **************************************************************/ 
   public void populate()
   {
      animationPanel.populateArray();      
   }
   /**************************************************************
   * Method that, when called, will set the JComboBox that lists *
   * the sorting algorithms to disabled. This will prevent the   *
   * user from swapping around the algorithms, while sorting.    *
   **************************************************************/ 
   public void disableBox()
   {
      sortingMethod.setEnabled(false); 
   }
   /**************************************************************
   * Method that, when called, will set the JComboBox that lists *
   * the sorting algorithms to enabled.                          *
   **************************************************************/ 
   public void enableBox()
   {
      sortingMethod.setEnabled(true); 
   }
   /**************************************************************
   * Method that, when called, get the selected sorting          *
   * algorithm from the JComboBox and uses the speed from        *
   * SortAnimationApp to be used in the SortAnimationPanel class *
   **************************************************************/ 
   public void work(String speed)
   {
     String selectedType = this.sortingMethod.getSelectedItem().toString();
     animationPanel.setSpeed(speed);
     animationPanel.initializeThread(selectedType);
   }
   /**************************************************************
   * Method that, when called, will call the pause() method in   *
   * the SortAnimationPanel class. Used to pause the thread.     *
   **************************************************************/ 
   public void pauseAnimation()
   {
      animationPanel.pause();
   }
   /**************************************************************
   * Method that, when called, will call the resume() method in  *
   * the SortAnimationPanel class. Used to resume the thread.    *
   **************************************************************/ 
   public void resumeAnimation()
   {
      animationPanel.resume();
   }
   /**************************************************************
   * Method that, when called, will call the kill() method in    *
   * the SortAnimationPanel class. Used to stop and clear the    *
   * array.                                                      *
   **************************************************************/ 
   public void kill()
   {
      animationPanel.stop(); 
   }
}