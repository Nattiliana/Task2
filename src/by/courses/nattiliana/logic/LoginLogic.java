package by.courses.nattiliana.logic;

public class LoginLogic {
    private final static String ADMIN_LOGIN = "admin";
    private final static String ADMIN_PASS = "123";
    private final static String USER_LOGIN = "user";
    private final static String USER_PASS = "123";


    public static boolean checkAdminLogin(String enterLogin, String enterPass) {
        return ADMIN_LOGIN.equals(enterLogin) && ADMIN_PASS.equals(enterPass);
    }

    public static boolean checkUserLogin(String enterLogin, String enterPass) {
        return USER_LOGIN.equals(enterLogin) && USER_PASS.equals(enterPass);
    }
}