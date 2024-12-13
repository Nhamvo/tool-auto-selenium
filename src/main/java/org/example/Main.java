package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class  Main {

    public static void main(String[] args) {
        toolSEO();
    }

    // Hàm đọc danh sách proxy từ file
    public static List<String> loadProxyList(String filePath) throws IOException {
        List<String> proxyList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            proxyList.add(line.trim());
        }
        reader.close();
        return proxyList;
    }

    public static void toolSEO() {


        try {
            // Đường dẫn tới file proxy
//            String proxyFilePath = "C:\\path\\to\\your\\proxy_list.txt";
            Random random = new Random();
//            // Lấy một proxy ngẫu nhiên
//            String randomProxy = getRandomProxy(proxyFilePath);
            // Cài đặt đường dẫn đến ChromeDriver
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nham\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

//            List<String> proxyList = loadProxyList("C:\\Users\\Nham\\Downloads\\proxy_http_auth.txt");

//            String proxyAddress = proxyList.get(random.nextInt(proxyList.size()));

//            String proxyAddress = "hndc40.muaproxyvietnam.com:63871";
            // Cấu hình proxy trong Selenium
            Proxy proxy = new Proxy();
            // Khởi tạo Selenium WebDriver
            // Tạo tùy chọn cho Chrome
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

            // Đặt ngôn ngữ và vùng miền để giống như trình duyệt thật
            options.addArguments("--lang=en-US");

//            options.setProxy(proxy);
            options.addArguments("--headless");  // Chạy không giao diện
            options.addArguments("--window-size=1920,1080");  // Cấu hình kích thước cửa sổ giả lập
            options.addArguments("--remote-allow-origins=*"); // Cho phép mọi nguồn gốc từ xa
//            options.addArguments("--disable-web-security");   // Vô hiệu hóa bảo mật web (chỉ dùng cho phát triển)
//            options.addArguments("--no-sandbox");             // Tắt sandbox của Chrome
            options.addArguments("--disable-dev-shm-usage");  // Giảm thiểu sự cố bộ nhớ chia sẻ
            // Khởi tạo ChromeDriver với các tùy chọn
            WebDriver driver;
            String rotatingProxyUrl = "https://muap" +
                    " roxyvietnam.com/api/proxy-v2/rotating/change-ip/2bfca4f6-750e-4e2e-a7f6-0ca9beb2435b";
            String proxyAddress = "hndc40.muaproxyvietnam.com:63871";

            for (int i = 1; i < 52; i++) {
                Map<String, String> searchMap = new HashMap<>();
//                searchMap.put("innovar là gì", "Innova là gì trên Tiktok? “Muốn căng đét thì làm tí innova”");
//                searchMap.put("trang rao vặt miễn phí", "400+  các trang đăng tin rao vặt tại Việt Nam và nước ngoài");

                //                searchMap.put("so sánh bán hàng trên tiktok và shopee", "So Sánh Bán Hàng Trên TikTok và Shopee: Nên Kinh Doanh ");
//                searchMap.put("cách lấy video bán hàng trên tiktok", "Chia sẻ cách lấy video bán hàng trên TikTok cực dễ dàng");
//                searchMap.put("phản hồi chat shopee", "Tổng Hợp 8 Cách Tăng Tỷ Lệ Phản Hồi Chat Shopee x5");
                //
//                searchMap.put("Top sản phẩm bán chạy TikTok 2024", "Bùng Nổ Doanh Số Với Top Sản Phẩm Bán Chạy TikTok 2024");
//                searchMap.put("Tại sao không nhắn tin trên TikTok được", "Tại sao không gửi được tin nhắn trên Twitter? 5 Cách khắc phục");
//                searchMap.put("Thêm quản trị viên vào Fanpage trên điện thoại", "2 Cách Thêm Quản Trị Viên Vào Fanpage Trên Điện Thoại");
//                searchMap.put("công cụ tự động hoá linkedin", "Top 4 công cụ tự động hóa LinkedIn hàng đầu");
                //
                searchMap.put("link twitter", "2 cách lấy link Twitter trên điện thoại cực dễ chỉ với 5s");
//                searchMap.put("cách lấy video bán hàng trên tiktok", "Chia sẻ cách lấy video bán hàng trên TikTok cực dễ dàng");
//                searchMap.put("tại sao không gửi được tin nhắn trên twitter", "Tại sao không gửi được tin nhắn trên Twitter? 5 Cách khắc phục");
//                searchMap.put("kiếm tiền trên Shopee Mall", "8 Tips Kiếm Tiền Trên Shopee Mall, Tăng Doanh Thu Siêu Dễ");
//                searchMap.put("Cách tìm sản phẩm bằng hình ảnh trên TikTok", "Cách Tìm Sản Phẩm Bằng Hình Ảnh Trên TikTok Chỉ Trong 1s");
//                searchMap.put("cách tính giá bán hàng trên tiktok", "Chi Tiết Cách Tính Giá Bán Hàng Trên TikTok Shop");
//                //
                searchMap.put("content bán hàng tết", "500+ Mẫu content bán hàng tết 2025 bứt phá doanh thu mùa Tết");
                searchMap.put("phần mềm quản lý chat đa kênh", "Top 10+ Phần Mềm Quản Lý Chat Đa Kênh Tốt Nhất Hiện Nay");
                searchMap.put("Cách xem top sản phẩm bán chạy trên TikTok", "3 Cách Xem Top Sản Phẩm Bán Chạy Trên TikTok Hiện Nay");
                searchMap.put("những câu bán hàng tết hay", "Top 100+ những câu bán hàng tết hay bão đơn mùa Tết");
                searchMap.put("cách làm affiliate shopee trên tiktok", "Cách Làm Affiliate Shopee Trên TikTok Cho Người Mới Bắt Đầu");
                searchMap.put("kiếm tiền từ reels instagram", "7 cách kiếm tiền từ reels Instagram cực đơn giản và hiệu quả");
//                searchMap.put("cách đồng bộ tin nhắn Zalo", "Cách đồng bộ tin nhắn Zalo từ máy tính sang điện thoại từ A-Z");
                searchMap.put("ý tưởng content giáng sinh 2025", "Bỏ túi ngay 101 ý tưởng content giáng sinh 2025");
//                searchMap.put("quản lý tin nhắn đa kênh", "Top 10+ Phần Mềm Quản Lý Chat Đa Kênh Tốt Nhất Hiện Nay");
                searchMap.put("cách định giá sản phẩm trên tiktok shop", "Chi Tiết Cách Tính Giá Bán Hàng Trên TikTok Shop");
                searchMap.put("tìm kiếm hình ảnh trên tiktok", "Cách Tìm Sản Phẩm Bằng Hình Ảnh Trên TikTok Chỉ Trong 1s");
                searchMap.put("cách tìm kiếm hình ảnh trên tiktok", "Cách Tìm Sản Phẩm Bằng Hình Ảnh Trên TikTok Chỉ Trong 1s");
                searchMap.put("tìm hình ảnh trên tiktok", "Cách Tìm Sản Phẩm Bằng Hình Ảnh Trên TikTok Chỉ Trong 1s");
                searchMap.put("cách nhắn tin trên shopee", "3 Cách nhắn tin trên shopee siêu đơn giản, dễ thực hiện");
                searchMap.put("cách nhắn tin với bạn bè trên shopee", "3 Cách nhắn tin trên shopee siêu đơn giản, dễ thực hiện");
//                searchMap.put("cách gắn link affiliate shopee trên tiktok", "Cách Làm Affiliate Shopee Trên TikTok Cho Người Mới Bắt Đầu");
                searchMap.put("cài đặt tin nhắn tự động trên shopee", "Cách Cài Đặt Tin Nhắn Tự Động Trên Shopee Đơn Giản");
                searchMap.put("tin nhắn tự động shopee", "Cách Cài Đặt Tin Nhắn Tự Động Trên Shopee Đơn Giản");

                ///
//                searchMap.put("xóa tin nhắn facebook hàng loạt", "Hướng Dẫn Cách Xóa Tin Nhắn Facebook Hàng Loạt Chỉ Với");
                searchMap.put("cách rải link affiliate shopee hiệu quả", "5 Cách rải link Affiliate Shopee hiệu quả, kiếm tiền cực dễ");
//                searchMap.put("cách làm affiliate shopee trên tiktok", "Cách Làm Affiliate Shopee Trên TikTok Cho Người Mới Bắt Đầu");
                searchMap.put("spam tin nhắn Fanpage", "3 Cách Spam Tin Nhắn Fanpage An Toàn & Hiệu");
//                searchMap.put("phần mềm quản lý tin nhắn tiktok", "Phần mềm quản lý tin nhắn TikTok chuyên nghiệp nhất hiện nay");
//                searchMap.put("cách gửi video qua tin nhắn shopee", "Cách Gửi Video Qua Tin Nhắn Shopee Chỉ Với 1 Phút Đơn Giản");
                searchMap.put("content về giáng sinh", "Bỏ Túi Ngay 101 Ý Tưởng Content Giáng Sinh 2025");


                searchMap.put("cách tìm sản phẩm bằng hình ảnh trên tiktok", "Cách Tìm Sản Phẩm Bằng Hình Ảnh Trên TikTok Chỉ Trong 1s");
                searchMap.put("cách rải link shopee hiệu quả", "5 Cách rải link Affiliate Shopee hiệu quả, kiếm tiền cực dễ");
                searchMap.put("file tính giá bán tiktok", "Chi Tiết Cách Tính Giá Bán Hàng Trên TikTok Shop [Cập");
                searchMap.put("cách tính giá bán trên tiktok shop", "Chi Tiết Cách Tính Giá Bán Hàng Trên TikTok Shop [Cập");
                searchMap.put("rải link shopee ở đâu", "5 Cách rải link Affiliate Shopee hiệu quả, kiếm tiền cực dễ");
                searchMap.put("rải link shopee", "5 Cách rải link Affiliate Shopee hiệu quả, kiếm tiền cực dễ");
                searchMap.put("chỉnh sửa tin nhắn trên fanpage", "Hướng Dẫn 3 Bước Chỉnh Sửa Tin Nhắn Tự Động Trên");
                searchMap.put("cách nhắn tin với shop trên shopee", "3 Cách nhắn tin trên shopee siêu đơn giản, dễ thực hiện");
                searchMap.put("cài tin nhắn tự động shopee", "Cách Cài Đặt Tin Nhắn Tự Động Trên Shopee Đơn Giản");
//                searchMap.put("sub id trên shopee là gì", "Tổng Hợp 4 Cách Tạo Link Affiliate Trên Shopee Cho");
                searchMap.put("tiktok có tìm kiếm bằng hình ảnh không", "Cách Tìm Sản Phẩm Bằng Hình Ảnh Trên TikTok Chỉ Trong");
//                searchMap.put("stt 2025", "Kho Tàng 1001 STT Bán Hàng Tết 2025 Thu Hút Khách Hàng");
                searchMap.put("cách tạo link shopee", "Tổng Hợp 4 Cách Tạo Link Affiliate Trên Shopee Cho");
                searchMap.put("auto chat shopee", "Cách Cài Đặt Tin Nhắn Tự Động Trên Shopee Đơn");
                searchMap.put("hướng dẫn tạo link affiliate shopee", "Tổng Hợp 4 Cách Tạo Link Affiliate Trên Shopee Cho");

                ////////////////////

                Map<String, String> mapKeyTet = new HashMap<>();
                mapKeyTet.put("mẫu content giảng sinh 2025","Chia Sẻ List 99+ Mẫu Content Giáng Sinh 2025 Đa Lĩnh Vực");
                mapKeyTet.put("khuyến mãi giáng sinh 2025","59+ Mẫu Content Chương Trình Khuyến Mãi Giáng Sinh");
//                mapKeyTet.put("xu hướng kinh doanh tết 2025", "Cập Nhật Xu Hướng Kinh Doanh Tết 2025 Bứt Phá Doanh Số");
//                mapKeyTet.put("kinh doanh tết 2025", "Cập Nhật Xu Hướng Kinh Doanh Tết 2025 Bứt Phá Doanh Số");
                mapKeyTet.put("Những lĩnh vực kinh doanh tiềm năng dịp tết", "Tết Nên Bán Gì? Những Lĩnh Vực Kinh Doanh Tiềm Năng");
                mapKeyTet.put("những câu bán hàng tết hay", "Top 100+ những câu bán hàng tết hay bão đơn mùa Tết");
//                mapKeyTet.put("content giáng sinh 2025", "Chia Sẻ List 99+ Mẫu Content Giáng Sinh 2025 Đa Lĩnh Vực");
//                mapKeyTet.put("phần mềm quản lý chat đa kênh", "Top 10+ Phần Mềm Quản Lý Chat Đa Kênh Tốt Nhất Hiện Nay");
//                mapKeyTet.put("content về giáng sinh", "Chia Sẻ List 99+ Mẫu Content Giáng Sinh 2025 Đa Lĩnh Vực");
                mapKeyTet.put("mẫu content giáng sinh 2025", "Bỏ Túi Ngay 101 Ý Tưởng Content Giáng Sinh 2025 Chất");
                mapKeyTet.put("ý tưởng content giáng sinh 2025", "Bỏ Túi Ngay 101 Ý Tưởng Content Giáng Sinh 2025 Chất");
                mapKeyTet.put("stt bán hàng tết 2025", "999+ Mẫu Thơ Bán Hàng Tết 2025 Thu Hút Chốt TRIỆU");
                mapKeyTet.put("thơ bán hàng tết 2025", "999+ Mẫu Thơ Bán Hàng Tết 2025 Thu Hút Chốt TRIỆU");
                mapKeyTet.put("content bán hàng tết", "500+ Mẫu content bán hàng tết 2025 bứt phá doanh thu mùa");
                mapKeyTet.put("content khuyến mãi tết", "Chốt 1000 đơn hàng mùa Tết với content khuyến mãi");
                mapKeyTet.put("slogan khuyến mãi dịp tết 2025", "120+ Mẫu Slogan Khuyến Mãi Dịp Tết 2025 Theo Lĩnh");
                mapKeyTet.put("slogan khuyến mãi giáng sinh", "100+ Câu Slogan Khuyến Mãi Giáng Sinh Thu Hút Khách");


                Map<String, String> sanPhamKey = new HashMap<>();
                sanPhamKey.put("phần mềm quản lý comment facebook", "Top 10 phần mềm quản lý comment Facebook hiệu quả");
                sanPhamKey.put("phần mềm quản lý tin nhắn Zalo", "Top 7+ Phần Mềm Quản Lý Tin Nhắn Zalo OA Tốt Nhất");
                sanPhamKey.put("phần mềm quản lý chat đa kênh", "Top 10+ Phần Mềm Quản Lý Chat Đa Kênh Tốt Nhất Hiện Nay");
                sanPhamKey.put("phần mểm quản lý tin nhắn Fanpage miễn phí", "Top 7+ Phần Mềm Quản Lý Tin Nhắn Fanpage Miễn Phí");
//                sanPhamKey.put("phần mềm quản lý comment facebook", "Top 10 phần mềm quản lý comment Facebook hiệu quả");

////

                Map<String, String> noelKey = new HashMap<>();
                noelKey.put("mẫu content giảng sinh 2025","Chia Sẻ List 99+ Mẫu Content Giáng Sinh 2025 Đa Lĩnh Vực");
                noelKey.put("khuyến mãi giáng sinh 2025","59+ Mẫu Content Chương Trình Khuyến Mãi Giáng Sinh");
                mapKeyTet.put("thơ bán hàng tết 2025", "999+ Mẫu Thơ Bán Hàng Tết 2025 Thu Hút Chốt TRIỆU");
                mapKeyTet.put("slogan khuyến mãi dịp tết 2025", "120+ Mẫu Slogan Khuyến Mãi Dịp Tết 2025 Theo Lĩnh");

//                noelKey.put("","");
//                noelKey.put("","");
//                noelKey.put("","");
//                noelKey.put("","");
//                noelKey.put("", "");


                // Đổi proxy xoay
//                proxy.setHttpProxy(proxyAddress);
//                proxy.setSslProxy(proxyAddress);
//                options.setProxy(proxy);
                driver = new ChromeDriver(options);
//                driver.get(rotatingProxyUrl);
//                System.out.printf("rotatingProxyUrl " + rotatingProxyUrl);
//                Thread.sleep(4000);
                System.out.println("Truy cập lần thứ " + i);
                int randomScrollTime = random.nextInt(20) + 65;
                // Mở trang web
                int maxRetries = 8;  // Số lần thử lại tối đa khi gặp lỗi
                int attempt = 0;
                Random random2 = new Random();
                Object[] keys = mapKeyTet.keySet().toArray();
                String randomKey = (String) keys[random2.nextInt(keys.length)];
                String expectedTitle = mapKeyTet.get(randomKey);
                do {
                    try {
                        System.out.println(" lần thử " + (attempt + 1));
                        // Mở trang web
                        driver.get("https://www.google.com");
                        // Tìm hộp tìm kiếm và thực hiện thao tác
                        WebElement searchBox = driver.findElement(By.name("q")); // Tìm hộp tìm kiếm bằng tên thuộc tính "q"
                        searchBox.sendKeys(randomKey); // Nhập từ khóa tìm kiếm
                        System.out.printf("Tim kiem : \n" + randomKey);
                        searchBox.submit(); // Gửi biểu mẫu tìm kiếm
                        TimeUnit.SECONDS.sleep(2); // Đợi 2 giây cho Google tải kết quả
                        System.out.println("Trang đã tải thành công và tìm kiếm đã được thực hiện.");
                        break;  // Thoát khỏi vòng lặp nếu thành công
                    } catch (Exception e) {
                        attempt++;
                        System.out.println("Lỗi khi tải trang, thử lại lần " + attempt);
                        Thread.sleep(4000);
                        if (attempt >= maxRetries) {
                            System.out.println("Đã đạt đến số lần thử tối đa, bỏ qua thao tác này.");
                        }
                    }
                } while (attempt < maxRetries);

                // Xác định và nhấn vào trang mong muốn (ví dụ: tìm theo tiêu đề hoặc URL)
                boolean pageFound = false;
                int pageNum = 1; // Để theo dõi số trang
                while (!pageFound && pageNum <= 5) { // Giới hạn tìm kiếm trong 5 trang
                    // Lấy danh sách kết quả
                    List<WebElement> searchResults = driver.findElements(By.cssSelector("h3")); // Tìm tất cả các tiêu đề kết quả tìm kiếm
                    for (WebElement result : searchResults) {
                        // Kiểm tra tiêu đề mong muốn
                        if (result.getText().contains(expectedTitle)) {
                            result.click();
                            System.out.println("Result Search " + randomKey + " / ở trang" + pageNum);
                            pageFound = true;
                            break;
                        }
                    }
                    if (!pageFound) {
                        // Nếu chưa tìm thấy và còn trang sau
                        try {
                            WebElement nextButton = driver.findElement(By.id("pnnext")); // Tìm nút "Trang sau"
                            nextButton.click();
                            pageNum++;
                            TimeUnit.SECONDS.sleep(2); // Đợi trang tiếp theo tải xong
                        } catch (Exception e) {
                            System.out.println("Không tìm thấy nút trang tiếp theo.");
                            break; // Dừng nếu không còn trang sau
                        }
                    }
                }

                if (!pageFound) {
                    System.out.println("Không tìm thấy kết quả mong muốn sau khi kiểm tra " + pageNum + " trang.");
                }
                // Chờ tải kết quả và tìm đường link trang web mong muốn
                Actions actions = new Actions(driver);
                // Cuộn trang trong 3 giây để mô phỏng hành động lướt chuột
                for (int scroll = 0; scroll < randomScrollTime; scroll++) {
                    int scrollAmount = ThreadLocalRandom.current().nextInt(-80, 300);
                    actions.scrollByAmount(0, scrollAmount).perform();
                    // Thời gian chờ ngẫu nhiên
                    try {
                        Thread.sleep(random.nextInt(50) + 180);
//                        Thread.sleep(random.nextInt(50) + 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
                // Tìm tất cả các phần tử h1 với class mong muốn
                List<WebElement> headings = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.cssSelector("div.elementor-posts-container article")));
                boolean found = false;
                int check = random.nextInt(4);
                if (!headings.isEmpty() && (check == 1)) {
                    System.out.printf("Check " + check);
                    // Chọn ngẫu nhiên một thẻ h1 từ danh sách
                    WebElement randomHeading = headings.get(random.nextInt(headings.size()));
                    // Cuộn ngang cho đến khi phần tử h1 được nhìn thấy
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", randomHeading);
                    // Kiểm tra các thẻ a bên trong thẻ h1
                    List<WebElement> links = randomHeading.findElements(By.tagName("a"));
                    if (!links.isEmpty()) {
                        // Chọn ngẫu nhiên một thẻ <a> bên trong thẻ <h1>
                        WebElement randomLink = links.get(random.nextInt(links.size()));
                        // Lấy URL từ thẻ <a>
                        String randomUrl = randomLink.getAttribute("href");
                        // Điều hướng tới URL đã chọn
                        driver.get(randomUrl);
                        found = true;
                        System.out.println("Đã điều hướng tới URL ngẫu nhiên: " + randomUrl);
                    }
                } else {
                    System.out.printf("Check " + check);
                    System.out.println("Không tìm thấy thẻ <h1> nào với class 'elementor-heading-title elementor-size-default'.");
                }
                if (found) {
                    System.out.println("Gooo");
                    for (int scroll = 0; scroll < random.nextInt(10) + 55; scroll++) {
                        int scrollAmount = ThreadLocalRandom.current().nextInt(-100, 230);
                        actions.scrollByAmount(0, scrollAmount).perform();
                        // Thời gian chờ ngẫu nhiên
                        try {
                            Thread.sleep(random.nextInt(50) + 45);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                // Xóa cookie và session bằng Selenium
                driver.manage().deleteAllCookies();
                driver.quit();
                System.out.println("Đã xóa cookie và session");
                // Chờ 0.5 giây trước khi tiếp tục lặp lại
                Thread.sleep(500);
            }
            // Đóng trình duyệt sau khi hoàn thành
//            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}