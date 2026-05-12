import SwiftUI

struct AiView: View {
    var body: some View {
        PlaceholderScreen(
            title: "AI",
            description: "Chat luyện lập trình, đánh giá code và chat với tài liệu sẽ dùng backend Examio hiện có.",
            note: "Mobile app không gọi trực tiếp AI provider và không hard-code provider trong app."
        )
    }
}
