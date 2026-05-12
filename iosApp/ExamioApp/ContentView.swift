import SwiftUI

struct ContentView: View {
    var body: some View {
        TabView {
            HomeView()
                .tabItem { Label("Trang chủ", systemImage: "house") }

            StudyView()
                .tabItem { Label("Học tập", systemImage: "book") }

            MyExamsView()
                .tabItem { Label("Thi của tôi", systemImage: "doc.text") }

            AiView()
                .tabItem { Label("AI", systemImage: "sparkles") }

            AccountView()
                .tabItem { Label("Tài khoản", systemImage: "person.crop.circle") }
        }
        .tint(Color(red: 0.8, green: 0.47, blue: 0.36))
    }
}
