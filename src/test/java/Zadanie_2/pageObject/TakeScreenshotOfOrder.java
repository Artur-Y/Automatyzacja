package zadanie_2.pageObject;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class TakeScreenshotOfOrder {
    private WebDriver driver;

    public TakeScreenshotOfOrder(WebDriver driver) {
        this.driver = driver;
    }

    public void TakeScreenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File tmpScreenshot = screenshot.getScreenshotAs(OutputType.FILE);

        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(),
                Paths.get("C:", "Coders", "Screenshots", "screen" + currentDateTime + ".png"));
    }
}
