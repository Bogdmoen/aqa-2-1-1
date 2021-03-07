package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class CallbackTest {

    @Test
    void shouldTestV1() {
        open("http://localhost:9999");
        $("[class='input__control'][type='text']").setValue("Василий");
        $("[class='input__control'][type='tel']").setValue("+79270000000");
        $(".checkbox__box").click();
        $("[type='button'][class='button button_view_extra button_size_m button_theme_alfa-on-white']").click();
        $(".Success_successBlock__2L3Cw").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

}
