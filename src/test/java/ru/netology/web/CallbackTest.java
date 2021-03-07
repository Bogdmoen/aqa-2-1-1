package ru.netology.web;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class CallbackTest {

    @Test
    void shouldGetSuccessForm() {
        open("http://localhost:9999");
        $("[class='input__control'][type='text']").setValue("Василий");
        $("[class='input__control'][type='tel']").setValue("+79270000000");
        $(".checkbox__box").click();
        $("[type='button'][class='button button_view_extra button_size_m button_theme_alfa-on-white']").click();
        $(".Success_successBlock__2L3Cw").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldGetEmptyNameAlert() {
        open("http://localhost:9999");
        $("[type='button'][class='button button_view_extra button_size_m button_theme_alfa-on-white']").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldGetEmptyPhoneAlert() {
        open("http://localhost:9999");
        $("[class='input__control'][type='text']").setValue("Василий");
        $("[type='button'][class='button button_view_extra button_size_m button_theme_alfa-on-white']").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldGetIncorrectNameAlert() {
        open("http://localhost:9999");
        $("[class='input__control'][type='text']").setValue("test");
        $("[class='input__control'][type='tel']").setValue("+79270000000");
        $("[type='button'][class='button button_view_extra button_size_m button_theme_alfa-on-white']").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldGetIncorrectPhoneAlert() {
        open("http://localhost:9999");
        $("[class='input__control'][type='text']").setValue("Иван");
        $("[class='input__control'][type='tel']").setValue("955");
        $("[type='button'][class='button button_view_extra button_size_m button_theme_alfa-on-white']").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldGetCheckboxAlert() {
        open("http://localhost:9999");
        $("[class='input__control'][type='text']").setValue("Иван");
        $("[class='input__control'][type='tel']").setValue("+79270000000");
        $("[type='button'][class='button button_view_extra button_size_m button_theme_alfa-on-white']").click();
        $(".input_invalid[data-test-id='agreement']").shouldHave(Condition.exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));
    }

}
