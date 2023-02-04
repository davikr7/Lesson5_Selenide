package homework;

import org.junit.jupiter.api.Test;
import com.codeborne.selenide.*;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Lesson5 {
    @Test
    void buildLikeTheBest() {
        Configuration.holdBrowserOpen = true;
        open("https://github.com/");
        SelenideElement solutions = $(".header-menu-wrapper").$(byText("Solutions"));
        solutions.hover();
        SelenideElement enterprise = $(byText("Enterprise"));
        enterprise.click();
        SelenideElement tagline = $(".h1-mktg.mb-3");
        tagline.shouldHave(exactText("Build like the best"));
    }

    @Test
    void dragAndDrop() {
        Configuration.holdBrowserOpen = true;
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
    }
}
