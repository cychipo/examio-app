# Examio App

Mobile app shell for Examio, built with Kotlin Multiplatform shared logic, Android Jetpack Compose, and iOS SwiftUI.

## Current scope

This codebase is an MVP shell only:

- Shared Kotlin module for platform-neutral contracts.
- Android Compose host app with five bottom tabs.
- iOS SwiftUI host app with matching five tabs.
- No mobile-specific backend.
- No direct AI provider calls from the app.
- No real auth/session persistence until secure storage is implemented with Android Keystore and iOS Keychain.

## Product direction

See `user-stories.md` for the complete mobile roadmap. MVP 1 starts with:

- Login/logout/session.
- Home dashboard.
- My exams.
- Exam detail and exam session.
- Result.
- Flashcard view/study.
- AI student programming chat and evaluation metadata.
- Profile.

## Structure

```text
examio-app/
├── androidApp/      # Android native UI with Jetpack Compose
├── iosApp/          # iOS native UI with SwiftUI
├── shared/          # Kotlin Multiplatform shared contracts
├── mockups/         # Existing HTML mockups
└── user-stories.md  # Mobile product stories
```

## Android

From `examio-app/`:

```bash
gradle :androidApp:assembleDebug
```

If a Gradle wrapper is added later, prefer:

```bash
./gradlew :androidApp:assembleDebug
```

## Shared Kotlin

From `examio-app/`:

```bash
gradle :shared:compileKotlinMetadata
```

## iOS

Open the project:

```bash
open iosApp/ExamioApp.xcodeproj
```

CLI build example:

```bash
xcodebuild -project iosApp/ExamioApp.xcodeproj -scheme ExamioApp -destination 'platform=iOS Simulator,name=iPhone 16' build
```

## Security notes

- Do not store tokens in Android SharedPreferences or iOS UserDefaults.
- Android auth work must use Keystore-backed secure storage.
- iOS auth work must use Keychain.
- Backend APIs remain the system of record.
- The mobile app must not hard-code AI provider credentials or call providers directly.
