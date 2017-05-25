import javax.swing.JOptionPane;
import java.io.File;
//import java.util.Scanner;
public class delfile {
	public static void main(String args[]) {
		String Protect= "This is a password protected file";
		JOptionPane.showMessageDialog	(null, Protect);
		String password =JOptionPane.showInputDialog("Password:");
		if (
				password != null &&
				password.equals("enter"))
						{
						JOptionPane.showMessageDialog
						(null, "You’re in.");
				
						File evidence = new File("project1txt.txt");
						//Scanner keyboard = new Scanner(System.in);
				//		char reply;
							{
				
					
								String Reply=JOptionPane.showInputDialog("Delete evidence? (yes/no) ");
						//System.out.print("Delete evidence? (y/n) ");
						//reply =keyboard.findWithinHorizon(".",0).charAt(0);
					// while (Reply != "yes" && Reply != "no");
								if (Reply.equals("yes")) {
									JOptionPane.showMessageDialog
									(null, "Okay, here goes...");
									//System.out.println("Okay, here goes...");
									evidence.delete();
									JOptionPane.showMessageDialog
									(null, "The evidence has been deleted.");
									//System.out.println("The evidence has been deleted.");
													}
								else {
									JOptionPane.showMessageDialog
									(null, "Sorry, buddy. Just asking.");
					//	System.out.println("Sorry, buddy. Just asking.");}
										}
							}
						}
				 else {
				JOptionPane.showMessageDialog
				(null, "You’re suspicious.");
				}
	}
	}
