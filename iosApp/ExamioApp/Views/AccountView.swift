import SwiftUI

struct AccountView: View {
    var body: some View {
        PlaceholderScreen(
            title: "Tài khoản",
            description: "Hồ sơ, cài đặt, ví/subscription và quản lý session sẽ được nối ở đây.",
            note: "Token phải lưu bằng Keychain, không dùng UserDefaults."
        )
    }
}
