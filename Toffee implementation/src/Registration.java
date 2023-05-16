import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

/**
 * the registration class to enable the user to register in the system
 * the successful registration done by unique email wasn't entered before
 */
public class Registration {
    private String email,password,address,phone;

    public Registration(){}
    //to make the user enter his unique email and his password and address
    public void Register() {
        Scanner sc = new Scanner(System.in);
        Login l=new Login();
        while(true){
            System.out.print("Enter your email address: ");
            this.email = sc.nextLine();
            if(!l.Emailexist(this.email)){
                break;
            }
            else{
                System.out.print("The email Already exists please, ");
            }
        }
        System.out.print("Enter your password: ");
        this.password = sc.nextLine();
        // Validate password here using secure password guidelines
        System.out.print("Enter your address: ");
        this.address = sc.nextLine();
        System.out.print("Enter your phone: ");
        this.phone = sc.nextLine();
        l.Store_User(this.email,this.password,this.address,this.phone);
    }
    //sending otp number to the registered user email
    public static boolean sendOtp(String to) {
        String from="javaemailacount@gmail.com",password="usbikdhupmdrfwlb";
        // Generate a random OTP
        int otp = (int)(Math.random() * 9000) + 1000,enterotp;

        // Set up email properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Authenticate and create a new email session
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

        try {
            // Create a new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("OTP for login");
            message.setText("Your OTP is: " + otp);

            // Send the email message
            Transport.send(message);

            System.out.println("please enter the  otp number that sent in your email: ");
            Scanner in=new Scanner(System.in);
            enterotp=in.nextInt();

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return (otp==enterotp);
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
}