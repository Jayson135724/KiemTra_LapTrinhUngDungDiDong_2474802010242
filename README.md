# BÀI KIỂM TRA THỰC HÀNH - CÂU 1

- Họ tên: Võ Hoàng Minh
- MSSV: 2474802010242

## Câu 1 - Login và kiểm tra dữ liệu
- `LoginActivity` dùng ConstraintLayout phẳng: tiêu đề, EditText Email, EditText Password, nút Login, TextView trạng thái.
- Ánh xạ view bằng `findViewById` (không dùng ViewBinding).
- Kiểm tra: để trống Email/Password, sai định dạng email (`Patterns.EMAIL_ADDRESS`), Password < 6 ký tự; hợp lệ thì hiện "Validation Successful!".
