# Examio App — User Stories

## Mục tiêu sản phẩm

Examio App là phiên bản mobile của hệ thống Examio hiện tại. App không thêm domain mới so với web, mục tiêu là đưa đầy đủ chức năng web lên mobile với trải nghiệm native, dễ dùng trên điện thoại.

## Định hướng kỹ thuật

- Shared logic: Kotlin Multiplatform dùng cho business logic, networking, validation, local cache, state/repository chung.
- Android UI: Jetpack Compose vì nhẹ, hiện đại, native Kotlin, phù hợp phát triển nhanh và maintain lâu dài.
- iOS UI: SwiftUI để giữ trải nghiệm native iOS, tận dụng shared logic từ Kotlin.
- Backend/API: dùng lại API hiện có của Examio web, không tạo backend riêng cho mobile nếu không cần.
- Feature parity: chức năng mobile phải tương đương web, chỉ thay đổi layout/interaction để phù hợp màn hình nhỏ.

## Nhóm người dùng

### Student

Học sinh/sinh viên dùng app để học, luyện tập, thi, xem kết quả, chat với AI, tạo nội dung học tập và theo dõi tiến độ.

### Teacher / Content Creator

Người tạo nội dung học tập, đề thi, flashcard, quiz, dùng AI hỗ trợ tạo tài liệu và quản lý tài nguyên.

### Admin / Operator

Người quản trị hệ thống, theo dõi dữ liệu, người dùng, gói dịch vụ, thanh toán và vận hành.

## Nguyên tắc UX mobile

- Ưu tiên một tác vụ chính mỗi màn hình.
- Navigation rõ ràng bằng bottom tabs cho các khu vực chính.
- Các form dài cần chia bước, có autosave nếu phù hợp.
- Tất cả hành động async phải có loading, retry và error message rõ.
- Không nhồi UI desktop vào mobile; cùng chức năng nhưng layout native mobile.
- Hỗ trợ dark mode sau khi core flow ổn định, không làm trước nếu làm chậm MVP.

## Information Architecture đề xuất

### Bottom tabs chính

1. Trang chủ
2. Học tập
3. Thi của tôi
4. AI
5. Tài khoản

### Khu vực phụ

- Thông báo
- Ví và subscription
- Cài đặt
- Lịch sử hoạt động
- Quản lý tài liệu
- Admin tools nếu user có quyền

## Epic 1 — Authentication & Session

### US-001 — Đăng nhập bằng email/mật khẩu

Là người dùng, tôi muốn đăng nhập bằng email và mật khẩu để truy cập tài khoản Examio trên mobile.

Acceptance criteria:

- Người dùng nhập email và mật khẩu.
- App hiển thị lỗi rõ khi sai thông tin hoặc tài khoản chưa xác thực.
- Token được lưu an toàn bằng secure storage của từng nền tảng.
- Sau khi đăng nhập thành công, app điều hướng vào Trang chủ.

### US-002 — Đăng ký tài khoản

Là người dùng mới, tôi muốn đăng ký tài khoản để bắt đầu sử dụng Examio.

Acceptance criteria:

- Form có validate email, mật khẩu, xác nhận mật khẩu.
- App hiển thị trạng thái gửi mã/xác thực nếu backend yêu cầu.
- Không cho submit nhiều lần khi request đang chạy.

### US-003 — Quên mật khẩu

Là người dùng, tôi muốn đặt lại mật khẩu khi quên mật khẩu.

Acceptance criteria:

- Người dùng nhập email để nhận mã/link reset.
- Người dùng đặt mật khẩu mới sau khi xác thực.
- App hiển thị trạng thái thành công/thất bại rõ ràng.

### US-004 — OAuth login

Là người dùng, tôi muốn đăng nhập bằng OAuth nếu web đang hỗ trợ để không cần tạo mật khẩu riêng.

Acceptance criteria:

- App mở provider OAuth bằng browser/session an toàn.
- Sau callback, app lưu session và điều hướng về màn hình chính.
- Nếu callback lỗi hoặc bị hủy, app hiển thị thông báo dễ hiểu.

### US-005 — Quản lý session và logout

Là người dùng, tôi muốn đăng xuất và quản lý session an toàn.

Acceptance criteria:

- Logout xóa token/local session.
- Khi token hết hạn hoặc bị revoke, app tự điều hướng về đăng nhập.
- App không để lộ dữ liệu cá nhân sau logout.

## Epic 2 — Home Dashboard

### US-006 — Xem tổng quan học tập

Là student, tôi muốn xem dashboard tổng quan để biết việc cần làm tiếp theo.

Acceptance criteria:

- Hiển thị exam gần nhất, tiến độ học, shortcut vào AI, quiz, flashcard.
- Dữ liệu loading bằng skeleton hoặc shimmer.
- Empty state có hướng dẫn hành động tiếp theo.

### US-007 — Xem hoạt động gần đây

Là người dùng, tôi muốn xem các hoạt động gần đây để tiếp tục nhanh.

Acceptance criteria:

- Hiển thị danh sách hoạt động học/thi/chat gần đây.
- Bấm vào item mở đúng màn hình chi tiết.
- Có fallback khi không có hoạt động.

## Epic 3 — Exam & Practice

### US-008 — Xem danh sách kỳ thi của tôi

Là student, tôi muốn xem danh sách kỳ thi được giao để chuẩn bị và tham gia thi.

Acceptance criteria:

- Danh sách có trạng thái: sắp diễn ra, đang mở, đã kết thúc.
- Có filter/search cơ bản.
- Không gọi API lặp vô hạn khi vào màn hình.

### US-009 — Xem chi tiết phòng thi

Là student, tôi muốn xem thông tin phòng thi trước khi tham gia.

Acceptance criteria:

- Hiển thị thời gian, môn, số câu, quy định, trạng thái tham gia.
- Nếu chưa đủ điều kiện, app hiển thị lý do.
- Nếu được phép, có CTA vào thi rõ ràng.

### US-010 — Làm bài thi

Là student, tôi muốn làm bài thi trên mobile với trải nghiệm ổn định.

Acceptance criteria:

- Hiển thị câu hỏi, đáp án, tiến độ, timer.
- Tự lưu đáp án định kỳ hoặc theo từng thay đổi nếu backend hỗ trợ.
- Có cảnh báo khi rời màn hình trong lúc thi.
- Submit bài có xác nhận.

### US-011 — Xem kết quả thi

Là student, tôi muốn xem điểm và phân tích sau khi nộp bài.

Acceptance criteria:

- Hiển thị điểm, số câu đúng/sai, thời gian làm bài.
- Nếu backend cho phép, hiển thị lời giải/feedback.
- Có link luyện lại hoặc xem lại nội dung liên quan.

### US-012 — Luyện tập quiz

Là student, tôi muốn luyện quiz ngoài kỳ thi để ôn tập.

Acceptance criteria:

- Có danh sách quiz/practice set.
- Người dùng làm từng câu, xem đúng/sai và lời giải nếu có.
- Tiến độ luyện tập được lưu.

## Epic 4 — Flashcard

### US-013 — Xem bộ flashcard

Là student, tôi muốn xem các bộ flashcard để học nhanh trên mobile.

Acceptance criteria:

- Danh sách flashcard set có search/filter.
- Card hiển thị title, số lượng thẻ, tiến độ.
- Empty state hướng dẫn tạo/import nếu user có quyền.

### US-014 — Học flashcard

Là student, tôi muốn học flashcard bằng thao tác lật thẻ/swipe.

Acceptance criteria:

- Tap để lật thẻ.
- Swipe hoặc nút để chuyển thẻ.
- Có trạng thái nhớ/chưa nhớ nếu backend hỗ trợ.
- Layout không bị tràn trên màn hình nhỏ.

### US-015 — Tạo/chỉnh sửa flashcard

Là teacher/content creator, tôi muốn tạo và chỉnh sửa flashcard trên app.

Acceptance criteria:

- Tạo/sửa/xóa thẻ trong set.
- Validate nội dung bắt buộc.
- Có xác nhận trước khi xóa.

## Epic 5 — AI Student Programming

### US-016 — Chat luyện lập trình với AI

Là student, tôi muốn hỏi bài lập trình và nhận hướng dẫn từ AI.

Acceptance criteria:

- Chat hỗ trợ nhập đề bài, câu hỏi và code snippet.
- Tin nhắn AI hiển thị streaming nếu backend hỗ trợ.
- Có trạng thái loading và retry khi lỗi.

### US-017 — Sinh code theo yêu cầu

Là student, tôi muốn AI sinh code mẫu để tham khảo cách giải.

Acceptance criteria:

- Người dùng chọn ngôn ngữ nếu web đang hỗ trợ.
- Người dùng chọn model nếu backend trả danh sách model.
- App hiển thị code có syntax highlight hoặc format dễ đọc.

### US-018 — Chấm điểm tín nhiệm code sinh ra

Là student, tôi muốn xem điểm tín nhiệm của code/answer để biết mức độ đáng tin.

Acceptance criteria:

- App hiển thị điểm, nguồn điểm, mức tin cậy.
- Không hiển thị điểm LLM judge như điểm testcase thật.
- Label theo backend metadata:
  - `benchmark`: Chấm bằng benchmark.
  - `synthetic_tests`: Chấm bằng rule fallback.
  - `llm_judge`: Điểm tín nhiệm ước lượng.
  - `static_only`: Điểm phân tích tĩnh.
  - `unavailable`: Chưa đủ dữ liệu để chấm.
- Nếu `isEstimated=true`, app hiển thị cảnh báo điểm chỉ là ước lượng.

### US-019 — Xem issues và strengths của code

Là student, tôi muốn xem điểm mạnh và lỗi chính trong answer để biết cần cải thiện gì.

Acceptance criteria:

- Hiển thị strengths và issues nếu backend trả về.
- Không làm UI rối nếu danh sách dài; chỉ hiển thị ngắn gọn và cho mở rộng nếu cần.

## Epic 6 — AI Teacher / AI Content Generation

### US-020 — Sinh quiz bằng AI

Là teacher/content creator, tôi muốn sinh quiz bằng AI để tiết kiệm thời gian tạo nội dung.

Acceptance criteria:

- Người dùng nhập prompt/chủ đề/tham số cần thiết.
- App gọi backend generation hiện có.
- Hiển thị tiến trình hoặc loading phù hợp.
- Kết quả có thể xem lại và chỉnh sửa nếu web hỗ trợ.

### US-021 — Sinh flashcard bằng AI

Là teacher/content creator, tôi muốn sinh flashcard bằng AI từ nội dung học tập.

Acceptance criteria:

- Người dùng nhập chủ đề hoặc chọn tài liệu nguồn nếu có.
- App hiển thị flashcard được sinh ra.
- Người dùng có thể lưu/chỉnh sửa nếu web hỗ trợ.

### US-022 — Chọn model AI

Là người dùng, tôi muốn chọn model AI tương tự web để kiểm soát chất lượng/tốc độ.

Acceptance criteria:

- Danh sách model lấy từ backend hoặc config hiện có.
- Không hard-code provider trực tiếp trong app nếu backend đã quản lý provider.
- Khi model không khả dụng, app hiển thị lỗi dễ hiểu.

## Epic 7 — Document, OCR & RAG

### US-023 — Upload tài liệu

Là người dùng, tôi muốn upload tài liệu từ điện thoại để dùng cho học tập/AI.

Acceptance criteria:

- Hỗ trợ chọn file từ thiết bị.
- Kiểm tra size/type theo rule backend.
- Hiển thị tiến trình upload.
- Khi lỗi quota/permission, app hiển thị đúng message backend.

### US-024 — Theo dõi OCR/embedding job

Là người dùng, tôi muốn biết tài liệu đã xử lý xong chưa để dùng với AI.

Acceptance criteria:

- App poll hoặc subscribe status theo API hiện có.
- Trạng thái gồm: pending/running/completed/failed nếu backend có.
- Không poll vô hạn nếu job đã terminal.
- Có retry khi failed nếu backend hỗ trợ.

### US-025 — Chat với tài liệu

Là người dùng, tôi muốn hỏi AI dựa trên tài liệu đã upload.

Acceptance criteria:

- Người dùng chọn tài liệu/context.
- AI trả lời dựa trên tài liệu được chọn.
- App hiển thị lỗi khi tài liệu chưa OCR/embedding xong.

## Epic 8 — Quiz Set, Question Bank & Learning Resources

### US-026 — Xem tài nguyên học tập

Là người dùng, tôi muốn xem quiz set, question set, label, subject để tìm nội dung học.

Acceptance criteria:

- Danh sách có pagination hoặc infinite scroll an toàn.
- Có search/filter theo subject/label nếu web có.
- Màn hình mobile không tải toàn bộ dữ liệu lớn một lần.

### US-027 — Quản lý câu hỏi

Là teacher/content creator, tôi muốn tạo/sửa/xóa câu hỏi nếu web hỗ trợ role này.

Acceptance criteria:

- Form hỗ trợ các loại câu hỏi hiện có.
- Validate dữ liệu trước submit.
- Xóa có confirmation.

## Epic 9 — Wallet, Subscription & Payment

### US-028 — Xem ví và số dư

Là người dùng, tôi muốn xem ví/số dư/gói hiện tại trên mobile.

Acceptance criteria:

- Hiển thị số dư, subscription hiện tại, trạng thái gói.
- Dữ liệu được refresh khi vào màn hình.
- Không cache sai thông tin thanh toán nhạy cảm.

### US-029 — Xem lịch sử giao dịch

Là người dùng, tôi muốn xem lịch sử giao dịch để đối soát.

Acceptance criteria:

- Danh sách giao dịch có ngày, số tiền, trạng thái.
- Có pagination.
- Empty state rõ ràng.

### US-030 — Nâng cấp gói

Là người dùng, tôi muốn nâng cấp subscription để dùng tính năng premium.

Acceptance criteria:

- Hiển thị các gói như web.
- Flow thanh toán dùng backend hiện có.
- App xử lý trạng thái pending/success/failed.

## Epic 10 — Profile & Settings

### US-031 — Xem và chỉnh sửa hồ sơ

Là người dùng, tôi muốn xem và chỉnh sửa thông tin cá nhân.

Acceptance criteria:

- Hiển thị thông tin profile hiện tại.
- Cho phép cập nhật các field web đang hỗ trợ.
- Validate trước khi submit.

### US-032 — Cài đặt app

Là người dùng, tôi muốn cấu hình trải nghiệm app.

Acceptance criteria:

- Có setting theme nếu app hỗ trợ.
- Có setting notification nếu backend/mobile push hỗ trợ.
- Có thông tin phiên bản app.

### US-033 — Quản lý thiết bị/session

Là người dùng, tôi muốn xem hoặc quản lý thiết bị đăng nhập nếu web/backend hỗ trợ.

Acceptance criteria:

- Hiển thị danh sách session/device nếu API có.
- Cho phép revoke session nếu backend hỗ trợ.

## Epic 11 — Notification

### US-034 — Nhận thông báo học tập/thi

Là student, tôi muốn nhận thông báo về kỳ thi, deadline và kết quả.

Acceptance criteria:

- App xin quyền notification đúng thời điểm, không xin ngay khi mở app lần đầu nếu chưa cần.
- Notification mở đúng màn hình liên quan.
- Có fallback trong app notification center nếu push chưa triển khai.

### US-035 — Xem notification center

Là người dùng, tôi muốn xem thông báo trong app.

Acceptance criteria:

- Danh sách thông báo có trạng thái đã đọc/chưa đọc nếu backend hỗ trợ.
- Bấm thông báo điều hướng đúng.

## Epic 12 — Statistics & Analytics

### US-036 — Xem thống kê học tập cá nhân

Là student, tôi muốn xem thống kê học tập để biết tiến độ.

Acceptance criteria:

- Hiển thị điểm, tiến độ, lịch sử luyện tập/thi.
- Chart mobile dễ đọc, không quá nhiều dữ liệu trên một màn hình.
- Có empty state nếu chưa có dữ liệu.

### US-037 — Xem analytics cho teacher/admin

Là teacher/admin, tôi muốn xem thống kê lớp/kỳ thi/người học nếu web hỗ trợ.

Acceptance criteria:

- Có filter cơ bản.
- Chart/table phù hợp mobile.
- Không tải dataset quá lớn một lần.

## Epic 13 — Admin & Role-based Access

### US-038 — Điều hướng theo quyền

Là người dùng có role khác nhau, tôi muốn chỉ thấy tính năng mình được phép dùng.

Acceptance criteria:

- App ẩn hoặc disable tính năng không có quyền.
- API lỗi permission được hiển thị rõ.
- Không chỉ dựa vào UI để bảo vệ quyền; backend vẫn là nguồn kiểm soát.

### US-039 — Admin quản lý dữ liệu cốt lõi

Là admin, tôi muốn quản lý các entity quan trọng nếu web đang có màn admin tương ứng.

Acceptance criteria:

- Các màn admin mobile ưu tiên view/search/detail trước.
- Các thao tác nguy hiểm có confirmation.
- Không cố nhồi bảng desktop phức tạp vào màn hình nhỏ.

## Epic 14 — Offline, Cache & Reliability

### US-040 — Cache dữ liệu đọc gần đây

Là người dùng, tôi muốn app mở nhanh và xem được một số dữ liệu gần đây khi mạng yếu.

Acceptance criteria:

- Cache dữ liệu ít nhạy cảm như danh sách gần đây, flashcard đã học.
- Không cache token hoặc dữ liệu nhạy cảm ở storage không an toàn.
- Khi offline, app hiển thị trạng thái offline rõ.

### US-041 — Retry request thất bại

Là người dùng, tôi muốn thử lại khi mạng lỗi.

Acceptance criteria:

- Các màn hình lỗi có nút retry.
- Không retry vô hạn request ghi dữ liệu.
- App tránh duplicate submit khi mạng chập chờn.

## Epic 15 — Mobile Platform Requirements

### US-042 — Deep link vào màn hình chính

Là người dùng, tôi muốn mở app từ link thông báo/email và vào đúng nội dung.

Acceptance criteria:

- Link exam mở chi tiết exam/phòng thi.
- Link chat/document mở đúng context nếu user đã đăng nhập.
- Nếu chưa đăng nhập, sau login điều hướng về link đích.

### US-043 — Secure storage

Là người dùng, tôi muốn thông tin đăng nhập được lưu an toàn.

Acceptance criteria:

- Android dùng Keystore-backed secure storage.
- iOS dùng Keychain.
- Không lưu token ở plain preferences/user defaults.

### US-044 — App performance baseline

Là người dùng, tôi muốn app phản hồi nhanh và không giật lag.

Acceptance criteria:

- Màn chính load skeleton trong dưới 300ms sau khi mở màn.
- Danh sách dài dùng pagination/lazy loading.
- Image/file preview không gây OOM.
- Không block main thread khi parse dữ liệu lớn.

## MVP đề xuất

### MVP 1 — Core student app

- Login/logout/session.
- Home dashboard.
- My exams.
- Exam detail.
- Do exam.
- Result.
- Flashcard view/study.
- AI student programming chat + evaluation metadata.
- Profile.

### MVP 2 — AI & content

- AI quiz generation.
- AI flashcard generation.
- Upload document.
- OCR/embedding status.
- Chat with document.

### MVP 3 — Payment, analytics, admin

- Wallet/subscription.
- Transaction history.
- Statistics.
- Teacher/admin management flows.
- Notification center/push.

## Non-goals

- Không viết lại backend riêng cho mobile.
- Không gọi trực tiếp AI provider từ mobile app.
- Không thêm feature ngoài web trong phase đầu.
- Không clone layout desktop y nguyên nếu không phù hợp mobile.
- Không dùng Kotlin để vẽ UI iOS; iOS UI dùng SwiftUI native.

## Definition of Done chung

- Chức năng tương đương web theo từng story.
- Có loading, error, empty state.
- Có xử lý token/session hết hạn.
- Không crash khi API trả lỗi hoặc mạng mất.
- UI phù hợp màn hình nhỏ.
- Android và iOS dùng chung logic qua Kotlin Multiplatform ở mức hợp lý.
- Không duplicate business rules giữa Android và iOS nếu có thể đưa vào shared Kotlin.
