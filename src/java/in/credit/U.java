package in.credit;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Properties;
import java.util.Random;
import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.apache.commons.lang.math.JVMRandom;

/**
 *
 * @author Team
 */
public class U {

    /* PATH at which images are stored on development machine  */
    public static final String PATH_CUSTOMER = "C:\\Javaprg\\Viram\\Code\\CreditSocApp\\web\\images\\Customers\\";

    /**
     * *
     *
     * @return java.sql.Connection
     */
    public static java.sql.Connection genConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_credit", "root", "");
        } catch (SQLException ex) {
            System.err.println("Error while obtaining connection : " + ex);
        }
        return null;
    }

    /**
     * *
     *
     * @param hashPassword
     * @return String
     */
    public static String hashPassword(String plain) {
        try {
            byte[] plainBytes = plain.getBytes();
            java.security.MessageDigest hash = java.security.MessageDigest
                    .getInstance("sha");
            byte[] hashBytes = hash.digest(plainBytes);
            Encoder enc = Base64.getEncoder();
            return new String(enc.encode(hashBytes));
        } catch (Exception e) {
            System.err.println("hashPassword :" + e);
        }
        return "";
    }

    public static boolean verifyHashPassword(String hash, String newPass) {
        String newPassHash = hashPassword(newPass);
        return newPassHash.equals(hash);
    }

    public static boolean saveImage(Part file, String destPath) {
        if (file == null) {
            return false;
        }
        if (!file.getContentType().startsWith("image")) {
            return false;
        }
        try {
            file.write(destPath);
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    public static String param(HttpServletRequest request, String key) {
        String str = request.getParameter(key);
        if (str == null) {
            return "";
        }
        return str;
    }

    public static int paramInt(HttpServletRequest request, String key) {
        String str = request.getParameter(key);
        if (str == null) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception ex) {
            return 0;
        }
    }

    public static double paramDbl(HttpServletRequest request, String key) {
        String str = request.getParameter(key);
        if (str == null) {
            return 0;
        }
        try {
            return Double.parseDouble(str);
        } catch (Exception ex) {
            return 0;
        }
    }

    public static Date paramDate(HttpServletRequest request, String key) {
        String str = request.getParameter(key);
        if (str == null) {
            return null;
        }
        try {
            return Date.valueOf(str);
        } catch (Exception ex) {
            return null;
        }
    }

    public static BigDecimal paramDecml(HttpServletRequest request, String key) {
        String str = request.getParameter(key);
        if (str == null) {
            return BigDecimal.ZERO;
        }
        try {
            return BigDecimal.valueOf(Double.parseDouble(str));
        } catch (Exception ex) {
            return BigDecimal.ZERO;
        }
    }

    public static boolean paramBool(HttpServletRequest request, String key) {
        String str = request.getParameter(key);
        if (str == null) {
            return false;
        }
        try {
            return Boolean.valueOf(str);
        } catch (Exception ex) {
            return false;
        }
    }

    public static java.util.Date now() {
        return new java.util.Date();
    }

    public static int userId(HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        try {
            return userId;
        } catch (Exception e) {
            return 0;
        }
    }
    
    /***
     * 
     * Random Password
     */

    public static String getRandomPassword() {
        String str = "ABCDEFGHJIKMLNAXZPQERTpadszbcmvghrtq123456789";
        StringBuilder sb=new StringBuilder();
        Random rnd=new Random();
        for(int i=1;i<=7;i++) {
            sb.append(str.charAt(rnd.nextInt(str.length()-1)));
        }
        return sb.toString();
    }
    /**
     *
     * sendEmail
     */
    public static String sendEmail(String toEmail, String toName, String subject, String body) {

        try {
            String username = "account@gmail.com";
            String password = "password";
            Properties prop = new Properties();
            prop.put("mail.debug", "true");
            prop.put("mail.smtp.ssl.enable", "true");

//2. Create Session object 
            Session session = Session.getDefaultInstance(prop);

//3. Compose message
            MimeMessage message = new MimeMessage(session);
            message.setSubject(subject);
            message.setText(body);
            message.setFrom(new InternetAddress(username, "Mr. Full Name"));
//4. Don't forget the commit changes
            message.saveChanges();

//5. Define receipant  
            Address[] addr = new InternetAddress[]{
                new InternetAddress(toEmail, toName)};
//6. Obtain Transport object  
            Transport trans = session.getTransport("smtp");
            trans.connect("smtp.gmail.com", 465, username, password);
            trans.sendMessage(message, addr);
            return "OK";
        } catch (Exception e) {
        }
        return "Error";
    }
}
