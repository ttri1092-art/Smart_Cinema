package model.Enum;

public enum TrangThaiGiaoDichEnum {
    CHO_XU_LY,     // Giao dịch mới tạo, chưa thanh toán
    DA_THANH_TOAN, // Giao dịch đã thu tiền thành công
    THAT_BAI,      // Giao dịch thanh toán không thành công
    DA_HUY         // Đơn đặt chỗ/hóa đơn đã bị hủy
}
