package exception;
// Ngoại lệ khi dữ liệu đầu vào không hợp lệ (ví dụ: null)
public class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}

