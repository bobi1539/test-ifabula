package test.ifabula.contant;

import test.ifabula.exception.BusinessException;

public final class ValidationMessage {

    private ValidationMessage() {
        throw new BusinessException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static final String EMAIL_REQUIRED = "Email Tidak Boleh Kosong";
    public static final String PASSWORD_REQUIRED = "Password Tidak Boleh Kosong";
    public static final String PASSWORD_MIN = "Password Minimal 8 Karakter";
    public static final String TITLE_REQUIRED = "Judul Tidak Boleh Kosong";
    public static final String DESCRIPTION_REQUIRED = "Deskripsi Tidak Boleh Kosong";
    public static final String BOOK_ID_REQUIRED = "Id Buku Tidak Boleh Kosong";
    public static final String USER_ID_REQUIRED = "Id User Tidak Boleh Kosong";
    public static final String RETURN_DATE_REQUIRED = "Tanggal Kembali Tidak Boleh Kosong";
    public static final String BORROW_ID_REQUIRED = "Borrow Id Tidak Boleh Kosong";
}
