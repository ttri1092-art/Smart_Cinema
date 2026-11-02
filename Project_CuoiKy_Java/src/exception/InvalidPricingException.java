package exception;

// Ngoại lệ khi giá trị tính toán hoặc tỷ lệ giảm giá bị sai quy tắc âm/quá hạn mức
public class InvalidPricingException extends RuntimeException {
    public InvalidPricingException(String message) {
        super(message);
    }
}