package test.ifabula.contant;

import org.springframework.http.HttpStatus;

public enum GlobalMessage {
    SUCCESS(HttpStatus.OK, "Sukses"),
    WRONG_EMAIL_OR_PASSWORD(HttpStatus.UNAUTHORIZED, "Email Atau Password Salah"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "Forbidden"),
    DATA_NOT_FOUND(HttpStatus.BAD_REQUEST, "Data Tidak Ditemukan"),
    EMAIL_IS_REGISTERED(HttpStatus.BAD_REQUEST, "Email Telah Terdaftar"),
    EMAIL_NOT_VALID(HttpStatus.BAD_REQUEST, "Email Tidak Valid"),
    PASSWORD_MUST_CONTAIN_UPPER_CASE(HttpStatus.BAD_REQUEST, "Password Harus Terdiri Dari Huruf Kapital"),
    PASSWORD_MUST_NOT_CONTAIN_SYMBOL(HttpStatus.BAD_REQUEST, "Password Tidak Boleh Mengandung Spesial Karakter"),
    TOKEN_NOT_VALID(HttpStatus.BAD_REQUEST, "Token Tidak Valid"),
    BOOK_IS_BORROW(HttpStatus.BAD_REQUEST, "Buku Sedang Dipinjam"),
    RETURN_DATE_NOT_VALID(HttpStatus.BAD_REQUEST, "Tanggal Kembali Harus Setelah Hari Ini"),
    CANNOT_BORROW_BOOK(HttpStatus.BAD_REQUEST, "Kembalikan Buku Yang Sebelumnya Terlebih Dahulu"),
    CANNOT_INSTANCE_HELPER_CLASS(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    public final HttpStatus httpStatus;
    public final String message;

    GlobalMessage(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
