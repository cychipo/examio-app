import SwiftUI

struct HomeView: View {
    var body: some View {
        PlaceholderScreen(
            title: "Trang chủ",
            description: "Tổng quan học tập, kỳ thi gần nhất, tiến độ và shortcut vào AI sẽ nằm ở đây.",
            note: "Trạng thái cần hỗ trợ: loading, retry, empty state và session hết hạn."
        )
    }
}
