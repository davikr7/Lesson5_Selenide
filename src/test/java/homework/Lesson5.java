package homework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.*;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Lesson5 {
    SelenideElement solutions = $(".header-menu-wrapper").$(byText("Solutions"));
    SelenideElement enterprise = $(byText("Enterprise"));
    SelenideElement tagline = $(".h1-mktg.mb-3");

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void buildLikeTheBest() {
        open("https://github.com/");
        solutions.hover();
        enterprise.click();
        tagline.shouldHave(exactText("Build like the best"));
    }

    @Test
    void dragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
    }
}
