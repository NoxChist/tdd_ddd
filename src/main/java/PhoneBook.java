import java.util.HashMap;

public class PhoneBook {

    private int counter;
    HashMap<String, Integer> namesMap;
    HashMap<String, Integer> numbersMap;

    public PhoneBook() {
        namesMap = new HashMap<>();
        numbersMap = new HashMap<>();
        counter = 0;
    }

    public int add(String name, String number) {
        if (!namesMap.containsKey(name)) {
            counter++;
            namesMap.put(name, counter);
            numbersMap.put(number, counter);
        }
        return namesMap.size();
    }
}
