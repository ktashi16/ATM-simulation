/**
* Programmer: Karma Gurung
* Project: ATM Machine
* Date: July 14, 2022
* Note: Use pin = 7890
*/
import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame{
  private JPanel panel;
  private JLabel welcomeLabel;
  private JLabel pinLabel;
  private JLabel amountLabel;
  private JLabel transactionLabel;
  private JTextField amountTextField;
  private JTextField pinTextField;
  private JButton balanceButton;
  private JButton depositButton;
  private JButton withdrawButton;
  private JButton enterButton;
  private JButton nextTransactionButton;
  private JButton exitButton;
  
  private final int WINDOW_WIDTH = 350;
  private final int WINDOW_HEIGHT = 250;
  public int balanceAmt = 10000;

  //constructor
  public Main() {
    setTitle("ATM Machine");
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    buildPanel();
    add(panel);

    setVisible(true);
  }//end of class Main


  private void buildPanel(){
    pinLabel = new JLabel("Enter Pin ");
    welcomeLabel = new JLabel("Welcome to TD Bank!");
    transactionLabel = new JLabel("Select a transaction: ");
    amountLabel = new JLabel("Enter the amount: ");
 
    amountTextField = new JTextField(10);
    pinTextField = new JTextField(4);
    
    balanceButton = new JButton("Balance");
    depositButton = new JButton("Deposit");
    withdrawButton = new JButton("Withdraw");
    enterButton = new JButton("Enter");
    nextTransactionButton = new JButton("Another Transaction");
    exitButton = new JButton("Exit");
    
    balanceButton.addActionListener(new ButtonListener());
    depositButton.addActionListener(new ButtonListener());
    withdrawButton.addActionListener(new ButtonListener());
    enterButton.addActionListener(new ButtonListener());
    nextTransactionButton.addActionListener(new ButtonListener());
    exitButton.addActionListener(new ButtonListener());

    panel= new JPanel();
    //splash page
    panel.add(pinLabel);
    panel.add(pinTextField);
    panel.add(enterButton);
    
    //transaction options page
    panel.add(welcomeLabel);
    panel.add(transactionLabel);
    panel.add(amountLabel);
    panel.add(amountTextField);
    panel.add(balanceButton);
    panel.add(depositButton);
    panel.add(withdrawButton);
    panel.add(nextTransactionButton);
    panel.add(exitButton);
    
    //hide transaction options page
    welcomeLabel.setVisible(false);
    transactionLabel.setVisible(false);
    amountLabel.setVisible(false);
    amountTextField.setVisible(false);
    balanceButton.setVisible(false);
    depositButton.setVisible(false);
    withdrawButton.setVisible(false);
    nextTransactionButton.setVisible(false);
    exitButton.setVisible(false);
  }//end of buildPanel()
  
    private void displayTransaction(){
       //display transation options page
       welcomeLabel.setVisible(true);
       transactionLabel.setVisible(true);
    
       balanceButton.setVisible(true);
       depositButton.setVisible(true);
       withdrawButton.setVisible(true);
       
       //hide splash page
       amountLabel.setVisible(false);
       amountTextField.setVisible(false);
       pinLabel.setVisible(false);
       pinTextField.setVisible(false);
       enterButton.setVisible(false);
    }
    
    
  private class ButtonListener implements ActionListener{
   public void actionPerformed(ActionEvent e){
   String actionCommand = e.getActionCommand();

   if (actionCommand.equals("Enter")){
      final int pinExpected=7890;
      int pinUser;
      
      pinUser=Integer.parseInt(pinTextField.getText());
      
      if (pinUser==pinExpected){
         displayTransaction();
      }
      else{
         JOptionPane.showMessageDialog(null, "Incorrect Pin!");
      }
   
   }//end of enter button
   
   else if (actionCommand.equals("Balance")){
      JOptionPane.showMessageDialog(null, "Your balance is $"+ balanceAmt + ".");
   }//end of balance button
   
   else if (actionCommand.equals("Deposit")){
      amountLabel.setVisible(true);
      amountTextField.setVisible(true);
      nextTransactionButton.setVisible(true);
      exitButton.setVisible(true);
      
      //hide
      balanceButton.setVisible(false);
      withdrawButton.setVisible(false);
      
      int amount = Integer.parseInt(amountTextField.getText());
      JOptionPane.showMessageDialog(null, "You deposited $" + amount + ".");
      balanceAmt +=amount;
      JOptionPane.showMessageDialog(null, "Your balance is now $"+ balanceAmt + ".");
   }//end of deposit button
   
   else if (actionCommand.equals("Withdraw")){
      amountLabel.setVisible(true);
      amountTextField.setVisible(true);
      nextTransactionButton.setVisible(true);
      exitButton.setVisible(true);
      
      //hide
      balanceButton.setVisible(false);
      depositButton.setVisible(false);
      
      int amount = Integer.parseInt(amountTextField.getText());
      JOptionPane.showMessageDialog(null, "Your withdrawed $" + amount + ".");
      balanceAmt -=amount;
      JOptionPane.showMessageDialog(null, "Your balance is now $"+ balanceAmt + ".");
   }//end of withdraw button
   
   else if (actionCommand.equals("Another Transaction")){
      displayTransaction();
      amountTextField.setText("");
   }
      
   else if (actionCommand.equals("Exit")){
      System.exit(0);
   }
  
   
   }//end of actionPerformed()

  }//end of ButtonlListener()


  public static void main(String[] args){
  //Main mywindow = new Main();
  new Main();
  }//end of main function


}//end of program