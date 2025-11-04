package sample;

import javax.swing.*; import java.awt.event.*; import java.util.HashMap;

public class LoginApp {
static HashMap<String, String> users = new HashMap<>();


public static void main(String[] args) { new RegisterFrame();
}
 
}

class RegisterFrame extends JFrame { JTextField usernameField; JPasswordField passwordField;

RegisterFrame() { setTitle("User Registration"); setSize(400, 250); setLayout(null); setLocationRelativeTo(null);

JLabel title = new JLabel("Register", SwingConstants.CENTER); title.setBounds(120, 10, 150, 30); title.setFont(title.getFont().deriveFont(18f));
add(title);


JLabel userLabel = new JLabel("Username:"); userLabel.setBounds(70, 60, 100, 25); add(userLabel);

usernameField = new JTextField(); usernameField.setBounds(170, 60, 150, 25); add(usernameField);

JLabel passLabel = new JLabel("Password:"); passLabel.setBounds(70, 100, 100, 25); add(passLabel);

passwordField = new JPasswordField();
 
passwordField.setBounds(170, 100, 150, 25); add(passwordField);

JButton registerBtn = new JButton("Register"); registerBtn.setBounds(140, 150, 100, 30); add(registerBtn);

registerBtn.addActionListener(e -> {
String username = usernameField.getText();
String password = new String(passwordField.getPassword());

if (username.isEmpty() || password.isEmpty()) { JOptionPane.showMessageDialog(this, "All fields are required!");
} else {
LoginApp.users.put(username, password); JOptionPane.showMessageDialog(this, "Registration Successful!"); dispose();
new LoginFrame();
}
});


setDefaultCloseOperation(EXIT_ON_CLOSE); setVisible(true);
}
}

class LoginFrame extends JFrame { JTextField usernameField; JPasswordField passwordField;
 
LoginFrame() { setTitle("User Login"); setSize(400, 250); setLayout(null);
setLocationRelativeTo(null);


JLabel title = new JLabel("Login", SwingConstants.CENTER); title.setBounds(120, 10, 150, 30); title.setFont(title.getFont().deriveFont(18f));
add(title);

JLabel userLabel = new JLabel("Username:"); userLabel.setBounds(70, 60, 100, 25); add(userLabel);

usernameField = new JTextField(); usernameField.setBounds(170, 60, 150, 25); add(usernameField);

JLabel passLabel = new JLabel("Password:"); passLabel.setBounds(70, 100, 100, 25); add(passLabel);

passwordField = new JPasswordField(); passwordField.setBounds(170, 100, 150, 25); add(passwordField);

JButton loginBtn = new JButton("Login"); loginBtn.setBounds(140, 150, 100, 30); add(loginBtn);
 

loginBtn.addActionListener(e -> {
String username = usernameField.getText();
String password = new String(passwordField.getPassword());


if (LoginApp.users.containsKey(username) && LoginApp.users.get(username).equals(password)) {
JOptionPane.showMessageDialog(this, "Login Successful!");
} else {
JOptionPane.showMessageDialog(this, "Login Failed! Invalid credentials.");
}
});

setDefaultCloseOperation(EXIT_ON_CLOSE); setVisible(true);
}
}
