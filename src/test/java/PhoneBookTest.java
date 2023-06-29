import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class PhoneBookTest {
    PhoneBook pb;

    @BeforeEach
    public void createPhoneBook() {
        pb = new PhoneBook();
    }

    @Test
    public void addTest() {
        String name = "Катя", number = "+79008007060";
        int expected = 1, result;

        result = pb.add(name, number);

        Assert.assertEquals(result, expected);
    }

    @Test
    public void addSameNameTest() {
        String name = "Катя", number = "+79008007060", number_ = "+79008000000";
        int expected = 1, result;
        pb.add(name, number);

        result = pb.add(name, number_);

        Assert.assertEquals(result, expected);
    }

    @Test
    public void findByNumberTest() {
        String name = "Катя", name_ = "Петя", number = "+79008007060", number_ = "+79008000000";
        String expected = "Катя: +79008007060", result;
        pb.add(name, number);
        pb.add(name_, number_);

        result = pb.findByNumber(number);

        Assert.assertEquals(result, expected);
    }

    @Test
    public void findByNumberTestIfNot() {
        String name = "Катя", name_ = "Петя", number = "+79008007060", number_ = "+79008000000", number__ = "+70000000000";
        String expected = "Нет такого контакта.", result;
        pb.add(name, number);
        pb.add(name_, number_);

        result = pb.findByNumber(number__);

        Assert.assertEquals(result, expected);
    }

    @Test
    public void findByNameTest() {
        String name = "Катя", name_ = "Петя", number = "+79008007060", number_ = "+79008000000";
        String expected = "Катя: +79008007060", result;
        pb.add(name, number);
        pb.add(name_, number_);

        result = pb.findByName(name);

        Assert.assertEquals(result, expected);
    }

    @Test
    public void findByNameTestIfNot() {
        String name = "Катя", name_ = "Петя", name__ = "Вася", number = "+79008007060", number_ = "+79008000000";
        String expected = "Нет такого контакта.", result;
        pb.add(name, number);
        pb.add(name_, number_);

        result = pb.findByName(name__);

        Assert.assertEquals(result, expected);
    }
}
