/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.credit;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Base64;
import java.util.Base64.Encoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author Prajapati
 */
public class U {

    /* PATH at which images are stored on development machine  */
    public static final String PATH_CUSTOMER = "C:\\Javaprg\\Viram\\Code\\CreditSocApp\\web\\images\\Customers\\";

    /***
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
    
    public static boolean verifyHashPassword(String hash,String newPass) {
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

}
