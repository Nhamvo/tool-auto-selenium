package org.example;

import org.openqa.selenium.*;
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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {



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

            String proxyAddress = "rd1.muaproxyvietnam.com:8904";
            System.out.println("Sử dụng proxy: " + proxyAddress);
            // Cấu hình proxy trong Selenium
            Proxy proxy = new Proxy();
            proxy.setHttpProxy(proxyAddress);
            proxy.setSslProxy(proxyAddress);


            // Khởi tạo Selenium WebDriver
            // Tạo tùy chọn cho Chrome
            ChromeOptions options = new ChromeOptions();
//            options.setProxy(proxy);
//            options.addArguments("--headless");  // Chạy không giao diện
//            options.addArguments("--window-size=1920,1080");  // Cấu hình kích thước cửa sổ giả lập
            options.addArguments("--remote-allow-origins=*"); // Cho phép mọi nguồn gốc từ xa
//            options.addArguments("--disable-web-security");   // Vô hiệu hóa bảo mật web (chỉ dùng cho phát triển)
//            options.addArguments("--no-sandbox");             // Tắt sandbox của Chrome
            options.addArguments("--disable-dev-shm-usage");  // Giảm thiểu sự cố bộ nhớ chia sẻ
//            options.addArguments("--proxy-server=" + randomProxy); // Thêm proxy vào Chrome

            // Khởi tạo ChromeDriver với các tùy chọn
            WebDriver driver = new ChromeDriver(options);
            // Đường dẫn đến bài viết cần truy cập
            String articleUrl = "https://vi.qrgateway.com/vi/qr-code-scanner";



            for (int i = 0; i < 50; i++) {
//                driver.get("https://muaproxyvietnam.com/api/proxy-v2/rotating/change-ip/badff849-37a7-41bf-98b3-ed5ce99083e8");
                System.out.println("Truy cập lần thứ " + (i + 1));
                int randomScrollTime = random.nextInt(45) + 45;
                // Mở trang web
                driver.get("https://www.google.com");
                WebElement searchBox = driver.findElement(By.name("q")); // Tìm hộp tìm kiếm bằng tên thuộc tính "q"
                searchBox.sendKeys("phần mềm upviral"); // Nhập từ khóa tìm kiếm
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
                    if (result.getText().contains("Trang chủ - Upviral - Phần mềm chat đa kênh")) {
                        result.click(); // Nhấp vào liên kết đó
                        System.out.println("Đã nhấp vào kết quả mong muốn.");
                        break;
                    }
                }


                // Chờ tải kết quả và tìm đường link trang web mong muốn
                Actions actions = new Actions(driver);
                System.out.println("Đã nhấn vào đường link");
                System.out.printf("Số random scoll time " + randomScrollTime + "\n");
                int windowHeight = driver.manage().window().getSize().getHeight();

                // Cuộn trang trong 3 giây để mô phỏng hành động lướt chuột
                for (int scroll = 0; scroll < randomScrollTime; scroll++) {
                    int scrollAmount = ThreadLocalRandom.current().nextInt(-150, 535);
                    actions.scrollByAmount(0, scrollAmount).perform();
                    // Thời gian chờ ngẫu nhiên
                    try {
                        Thread.sleep(random.nextInt(40) + 55);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));


                // Tìm tất cả các thẻ <h1> có class "elementor-heading-title elementor-size-default"
                // Tìm tất cả các phần tử h1 với class mong muốn
                List<WebElement> headings = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.cssSelector("h1.elementor-heading-title.elementor-size-default")));


                boolean found = false;

                int check = random.nextInt(4);
                if (!headings.isEmpty() && check != 2) {
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
                        System.out.println("URL được chọn ngẫu nhiên: " + randomUrl);

                        // Điều hướng tới URL đã chọn
                        driver.get(randomUrl);
                        found = true;

                        System.out.println("Đã điều hướng tới URL ngẫu nhiên: " + randomUrl);
                    }
                } else {
                    System.out.println("Không ấn vàooooo");
                    System.out.println("Không tìm thấy thẻ <h1> nào với class 'elementor-heading-title elementor-size-default'.");
                }


                if (found) {
                    System.out.println("Gooo");
                    for (int scroll = 0; scroll < random.nextInt(20) + 40; scroll++) {
                        int scrollAmount = ThreadLocalRandom.current().nextInt(-100, 480);
                        actions.scrollByAmount(0, scrollAmount).perform();
                        // Thời gian chờ ngẫu nhiên
                        try {
                            Thread.sleep(random.nextInt(50) + 55);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
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



    List<WebElement> searchResults = driver.findElements(By.cssSelector("h3")); // Tìm tất cả các tiêu đề kết quả tìm kiếm

    // git demo
                for (WebElement result : searchResults) {
        // Kiểm tra nếu kết quả chứa URL hoặc tiêu đề mà bạn muốn nhấp vào
        if (result.getText().contains("Trang chủ - Upviral - Phần mềm chat đa kênh")) {
            result.click(); // Nhấp vào liên kết đó
            System.out.println("Đã nhấp vào kết quả mong muốn.");
            break;
        }
    }
}