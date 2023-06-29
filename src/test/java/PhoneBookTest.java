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
}
