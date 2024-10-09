package com.testselenium.TuanMinh;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.testng.annotations.Test;

public class DangKy {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("User Registration");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(50, 50, 100, 30);
		frame.add(usernameLabel);
		JTextField usernameField = new JTextField();
		usernameField.setBounds(150, 50, 200, 30);
		frame.add(usernameField);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(50, 100, 100, 30);
		frame.add(passwordLabel);
		JTextField passwordField = new JPasswordField();
		passwordField.setBounds(150, 100, 200, 30);
		frame.add(passwordField);
		
		JLabel resultLabel = new JLabel("");
		resultLabel.setBounds(50, 200, 300, 30);
		frame.add(resultLabel);
	}
  @Test
  public void f() {
  }
}
