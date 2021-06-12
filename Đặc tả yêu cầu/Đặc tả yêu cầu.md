## Đặc tả yêu cầu cho phần mềm "Quản lý chi tiêu"
### Chức năng phần mềm
Phần mềm quản lý quản lý chi tiêu cung cấp 4 chức năng chính:
- Nhập/xuất/sửa/xóa thông tin chi tiêu
- Kiểm tra lịch sử chi tiêu theo ngày, tháng
- Thống kê chi tiêu theo ngày, tháng, năm
- Giới hạn chi tiêu và cảnh báo giới hạn chi tiêu theo tháng
### Yêu cầu
Ứng với mỗi chức năng, ta có các yêu cầu tương ứng
#### 1. Nhập/Xuất/Xóa/Sửa thông tin chi tiêu
Thông tin được nhập bao gồm:
- Mã chi tiêu: sẽ được tư động generate
- Số tiền đã chi
- Ngày chi
- Chi tiết chi tiêu  
Chi tiết chi tiêu là một danh sách hàng hóa chứa các thông tin như sau:  

| STT | Tên hàng hóa   | Số lượng   | Tổng     |
|-----|----------------|------------|----------|
|     |                |            |          |
|     |                |            |          |
|     |                |            |          |

Lượng tiền đã chi sẽ được tính tự động bằng tổng tiền đã chi với mỗi hàng hóa.
Mỗi tháng sẽ có lưu tổng lượng tiền đã chi tiêu trong tháng đó một cách thủ công. Tổng lượng tiền sẽ được đặt về không sau khi bắt đầu tháng mới.<br>
Lượng tiền chi tiêu sẽ được cộng vào tổng tiền chi tiêu trong tháng. Khi tổng tiền chi tiêu trong tháng còn cách giới hạn một khoảng nhỏ hơn hoặc bằng
một khoảng nhất định do người dùng chọn, một màn hình cảnh báo sẽ được hiển thị. <br>
Các chức năng xóa, sửa thông tin cần phải có xác nhận với người dùng trước khi thực hiện. Sau khi thực hiện, nếu giao dịch bị xóa, sửa thuộc tháng hiện tại, cần cập nhập lại tổng
tiền chi tiêu của tháng.
#### 2. Kiểm tra lịch sử chi tiêu theo lần chi tiêu
Người dùng có thể chọn một giao dịch để có thể xem chi tiết thông tin giao dịch dưới dạng bảng sau:  

| STT | Tên hàng hóa   | Số lượng   | Tổng     |
|-----|----------------|------------|----------|
|     |                |            |          |
|     |                |            |          |
|     |                |            |          |
#### 3. Thống kê chi tiêu theo tháng
Người dùng chọn 2 thông tin là tháng và năm.  
Thông tin thống kê bao gồm:
- Tổng chi tiêu trong tháng.  
- Ngày sử dụng nhiều nhất.  
- Khoảng cách tới hạn mức.  
- Lịch sử giao dịch trong tháng sẽ được thể hiện dưới dạng bảng.  

| Mã giao dịch | Ngày giao dịch | Lượng tiền | Chi tiết |          
|--------------|----------------|------------|----------|
|              |                |            |          |
|              |                |            |          |
|              |                |            |          |

#### 4. Đặt giới hạn chi tiêu và cảnh báo khi người dùng sắp vượt giới hạn.
Người dùng sẽ được phép đặt một giới hạn chi tiêu hàng tháng. Giới hạn này sẽ được áp dụng cho tất cả các tháng kể từ khi giới hạn được thiết lập cho đến khi người dùng hủy giới
hạn này. Giới hạn mặc định sẽ bằng 0, tức là không có giới hạn.  
Đồng thời, người dùng được đặt một cảnh báo khi tổng lượng tiền giao dịch trong tháng còn cách giới hạn một lượng nhất đinh. Mặc định, khoảng này sẽ là 90%.  



#### 5. Sửa
Thêm screen menu chính
Thêm 1 screen cho lần chi tiêu để hiện thông tin chi tiêu cho phép sửa, xóa.
