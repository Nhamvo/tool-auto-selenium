package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    public static String getRandomProxy(String filePath) throws IOException {
        List<String> proxyList = Files.readAllLines(Paths.get(filePath)); // Đọc tất cả các proxy từ file
        Random random = new Random();
        return proxyList.get(random.nextInt(proxyList.size())); // Chọn proxy ngẫu nhiên
    }

    public static void main(String[] args) {
        toolSEO();
    }



    public static void toolSEO() {
        try {

            // Đường dẫn tới file proxy
//            String proxyFilePath = "C:\\path\\to\\your\\proxy_list.txt";
//
//            // Lấy một proxy ngẫu nhiên
//            String randomProxy = getRandomProxy(proxyFilePath);
//            System.out.println("Sử dụng proxy: " + randomProxy);
            // Cài đặt đường dẫn đến ChromeDriver
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nham\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

            // Khởi tạo Selenium WebDriver
            // Tạo tùy chọn cho Chrome
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*"); // Cho phép mọi nguồn gốc từ xa
            options.addArguments("--disable-web-security");   // Vô hiệu hóa bảo mật web (chỉ dùng cho phát triển)
            options.addArguments("--no-sandbox");             // Tắt sandbox của Chrome
            options.addArguments("--disable-dev-shm-usage");  // Giảm thiểu sự cố bộ nhớ chia sẻ
//            options.addArguments("--proxy-server=" + randomProxy); // Thêm proxy vào Chrome

            // Khởi tạo ChromeDriver với các tùy chọn
            WebDriver driver = new ChromeDriver(options);
            // Đường dẫn đến bài viết cần truy cập
            String articleUrl = "https://vi.qrgateway.com/vi/qr-code-scanner";

            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                System.out.println("Truy cập lần thứ " + (i + 1));
                int randomScrollTime = random.nextInt(40) + 38;
                // Mở trang web
                driver.get("https://www.google.com");
                WebElement searchBox = driver.findElement(By.name("q")); // Tìm hộp tìm kiếm bằng tên thuộc tính "q"
                searchBox.sendKeys("seo web bằng phần mềm mkt"); // Nhập từ khóa tìm kiếm
                searchBox.submit(); // Gửi biểu mẫu tìm kiếm

//                PointerInfo pointerInfo = MouseInfo.getPointerInfo();
//                Point point = pointerInfo.getLocation();
//                int mouseX = (int) point.getX();
//                int mouseY = (int) point.getY();
//
//                // Khởi tạo Robot class
//                Robot robot = new Robot();
//                robot.mouseMove(mouseX+400, mouseY);
//                // Nhấn chuột trái
//                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//                Thread.sleep(1000); // Chờ 1 giây để chuột di chuyển
//

                TimeUnit.SECONDS.sleep(2); // Đợi 2 giây cho Google tải kết quả

                // Lấy danh sách các kết quả tìm kiếm (liên kết)
                List<WebElement> searchResults = driver.findElements(By.cssSelector("h3")); // Tìm tất cả các tiêu đề kết quả tìm kiếm

                // Xác định và nhấn vào trang mong muốn (ví dụ: tìm theo tiêu đề hoặc URL)
                for (WebElement result : searchResults) {
                    // Kiểm tra nếu kết quả chứa URL hoặc tiêu đề mà bạn muốn nhấp vào
                    if (result.getText().contains("TOP 12+ phần mềm SEO Website miễn phí và trả phí hữu")) {
                        result.click(); // Nhấp vào liên kết đó
                        System.out.println("Đã nhấp vào kết quả mong muốn.");
                        break;
                    }
                }


                // Chờ tải kết quả và tìm đường link trang web mong muốn
                Actions actions = new Actions(driver);
                System.out.println("Đã nhấn vào đường link");
                System.out.printf("Số random scoll time" + randomScrollTime);
                int windowHeight = driver.manage().window().getSize().getHeight();

                // Cuộn trang trong 3 giây để mô phỏng hành động lướt chuột
                for (int scroll = 0; scroll < randomScrollTime; scroll++) {
                    int scrollAmount = ThreadLocalRandom.current().nextInt(-200, 900);
                    actions.scrollByAmount(0, scrollAmount).perform();
                    // Thời gian chờ ngẫu nhiên
                    try {
                        Thread.sleep(random.nextInt(100) + 35);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                List<WebElement> articles = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("h3")));

                boolean found = false;

                // Duyệt qua tất cả các thẻ h3 để tìm bài viết liên quan
                for (WebElement article : articles) {
                    if (article.getText().contains("Anchor Text là gì? Cách triển khai SEO anchor text hiệu quả")) {
                        // Cuộn tới phần tử
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("arguments[0].scrollIntoView(true);", article);

                        // Chờ cho phần tử có thể nhấp
                        wait.until(ExpectedConditions.elementToBeClickable(article));

                        // Nhấp vào phần tử
                        Actions s = new Actions(driver);
                        s.moveToElement(article).click().perform();

                        System.out.println("Đã nhấp vào bài viết có chủ đề 'Anchor Text là gì? Cách triển khai SEO anchor text hiệu quả'.");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Không tìm thấy bài viết có chủ đề 'Anchor Text là gì? Cách triển khai SEO anchor text hiệu quả'.");
                } else {
                    for (int scroll = 0; scroll < random.nextInt(40) + 10; scroll++) {
                        int scrollAmount = ThreadLocalRandom.current().nextInt(-70, 1000);
                        actions.scrollByAmount(0, scrollAmount).perform();
                        // Thời gian chờ ngẫu nhiên
                        try {
                            Thread.sleep(random.nextInt(100) + 35);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                // Ở lại trang trong 3 giây trước khi thoát
                Thread.sleep(1000);
                // Xóa cookie và session bằng Selenium
                driver.manage().deleteAllCookies();
                System.out.println("Đã xóa cookie và session");
                // Chờ 1 giây trước khi tiếp tục lặp lại
                Thread.sleep(1000);
            }
            // Đóng trình duyệt sau khi hoàn thành
//            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}