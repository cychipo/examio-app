import SwiftUI

struct MyExamsView: View {
    var body: some View {
        PlaceholderScreen(
            title: "Thi của tôi",
            description: "Danh sách kỳ thi, chi tiết phòng thi, làm bài và kết quả sẽ phát triển từ tab này.",
            note: "Không gọi API lặp vô hạn; các request ghi dữ liệu cần chống duplicate submit."
        )
    }
}
