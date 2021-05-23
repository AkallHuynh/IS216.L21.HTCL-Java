## Đặc tả yêu cầu cho phần mềm "Quản lý chi tiêu"
### Chức năng phần mềm
Phần mềm quản lý quản lý chi tiêu cung cấp 4 chức năng chính:
- Nhập/xuất/sửa/xóa thông tin chi tiêu
- Kiểm tra lịch sử chi tiêu theo ngày, tháng
- Thống kê chi tiêu theo ngày, tháng, năm
- Giới hạn chi tiêu và cảnh bảo giới hạn chi tiêu theo tháng
### Yêu cầu
Ứng với mỗi chức năng, ta có các yêu cầu tương ứng
#### 1. Nhập/Xuất/Xóa/Sửa thông tin chi tiêu
Thông tin được nhập bao gồm:
- Lượng tiền đã chi
- Ngày chi
- Chi tiết chi tiêu <br>
Mỗi tháng sẽ có lưu tổng lượng tiền đã chi tiêu trong tháng đó. Tổng lượng tiền sẽ được đặt về không sau khi bắt đầu tháng mới.<br>
Lượng tiền chi tiêu sẽ được cộng vào tổng tiền chi tiêu trong tháng. Khi tổng tiền chi tiêu trong tháng còn cách giới hạn một khoảng nhỏ hơn hoặc bằng
một khoảng nhất định do người dùng chọn, một màn hình cảnh báo sẽ được hiển thị. <br>
Các chức năng xóa, sửa thông tin cần phải có xác nhận với người dùng trước khi thực hiện. Sau khi thực hiện, nếu giao dịch bị xóa, sửa thuộc tháng hiện tại, cần cập nhập lại tổng
tiền chi tiêu của tháng.
#### 2. Kiểm tra lịch sử chi tiêu theo ngày, tháng
Người dùng sẽ chọn ngày và tháng để hiển thị thông tin chi tiêu trong ngày tháng đó. Vị trí ngày có thể được bỏ trống thể hiển thị toàn bộ tháng. Thông tin sẽ được hiển thị dưới dạng bảng
| STT | Ngày giao dịch | Lượng tiền | Chi tiết |
|-----|----------------|------------|----------|
|     |                |            |          |
|     |                |            |          |
|     |                |            |          |
#### 3. Thống kê chi tiêu theo tháng, năm
Người dùng sẽ có 2 lựa chọn để thống kê là chọn theo tháng, hoặc năm để thống kê chi tiêu. <br>
Nếu chọn thống kê theo năm thì yêu cầu người dùng nhập năm cần thống kê.
Nếu chọn thống kê theo tháng thì yêu cầu người dùng nhập tháng và năm cần thống kê.
| STT | Ngày giao dịch | Lượng tiền | Chi tiết |
|-----|----------------|------------|----------|
|     |                |            |          |
|     |                |            |          |
|     |                |            |          |

|Tổng cộng:                                    |

** Cần bổ sung**
#### 4. Đặt giới hạn chi tiêu và cảnh báo khi người dùng sắp vượt giới hạn.
Người dùng sẽ được phép đặt một giới hạn chi tiêu hàng tháng. Giới hạn này sẽ được áp dụng cho tất cả các tháng kể từ khi giới hạn được thiết lập cho đến khi người dùng hủy giới
hạn này. Giới hạn mặc định sẽ bằng -1, tức là không có giới hạn. <br>
Đồng thời, người dùng được đặt một cảnh báo khi tổng lượng tiền giao dịch trong tháng còn cách giới hạn một lượng nhất đinh. Mặc định, khoảng này sẽ là 90%.
