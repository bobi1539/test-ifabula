package test.ifabula.contant;

import test.ifabula.exception.BusinessException;

public final class ValidationMessage {

    private ValidationMessage() {
        throw new BusinessException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static final String EMAIL_REQUIRED = "Email Tidak Boleh Kosong";
    public static final String PASSWORD_REQUIRED = "Password Tidak Boleh Kosong";
    public static final String PASSWORD_MIN = "Password Minimal 8 Karakter";
}
