package test.ifabula.helper;

import test.ifabula.contant.GlobalMessage;
import test.ifabula.exception.BusinessException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Util {

    private Util() {
        throw new BusinessException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static boolean isStringContainUpperCaseLetter(String value) {
        for (char c : value.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isStringContainSpecialChar(String value) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }
}
