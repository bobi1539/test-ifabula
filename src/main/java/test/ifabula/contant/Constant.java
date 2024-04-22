package test.ifabula.contant;

import test.ifabula.exception.BusinessException;

public final class Constant {

    private Constant() {
        throw new BusinessException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static final String ERROR = "Error : ";
    public static final String X_API_KEY = "X_API_KEY";
    public static final String API_KEY = "RGNYpOvJK5VfvRKzPNVQQ7Xh2ZXMBKdol8q1qtBpUdgUhG3P2d";
}
