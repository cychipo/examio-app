import SwiftUI

struct PlaceholderScreen: View {
    let title: String
    let description: String
    let note: String

    var body: some View {
        NavigationStack {
            VStack(alignment: .leading, spacing: 12) {
                Text(title)
                    .font(.largeTitle)
                    .fontWeight(.semibold)

                Text(description)
                    .font(.body)

                Text(note)
                    .font(.callout)
                    .foregroundStyle(.secondary)

                Spacer()
            }
            .frame(maxWidth: .infinity, alignment: .leading)
            .padding(24)
            .background(Color(red: 0.98, green: 0.98, blue: 0.96))
            .navigationTitle(title)
        }
    }
}
