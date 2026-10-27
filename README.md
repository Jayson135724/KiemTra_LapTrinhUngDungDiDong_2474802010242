# BÀI KIỂM TRA THỰC HÀNH - CÂU 3

- Họ tên: Võ Hoàng Minh
- MSSV: 2474802010242

## Câu 1 - Login và kiểm tra dữ liệu
- `LoginActivity` dùng ConstraintLayout phẳng: tiêu đề, EditText Email, EditText Password, nút Login, TextView trạng thái.
- Ánh xạ view bằng `findViewById` (không dùng ViewBinding).
- Kiểm tra: để trống Email/Password, sai định dạng email (`Patterns.EMAIL_ADDRESS`), Password < 6 ký tự; hợp lệ thì hiện "Validation Successful!".

## Câu 2 - Chuyển màn hình bằng Intent
- `ProfileActivity`: tiêu đề "Account Information", TextView Email, nút Log Out (ánh xạ bằng `findViewById`).
- Đăng nhập hợp lệ thì mở `ProfileActivity` bằng explicit Intent, truyền email qua `putExtra()` và hiển thị lại.
- Nút Log Out gọi `finish()` để quay về `LoginActivity`.

## Câu 3 - ListView và ArrayAdapter
- Thêm `ListView` vào `ProfileActivity` (bên dưới Email và nút Log Out), ánh xạ bằng `findViewById`.
- Danh sách 7 môn học/kỹ năng, gắn bằng `ArrayAdapter` với `android.R.layout.simple_list_item_1`.
- `setOnItemClickListener`: chạm vào một mục thì hiện Toast với đúng tên mục đó.
