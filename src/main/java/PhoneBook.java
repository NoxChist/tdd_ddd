import java.util.HashMap;

public class PhoneBook {

    private int counter;
    HashMap<String, Integer> namesMap;
    HashMap<String, Integer> numbersMap;
    HashMap<Integer, Contact> contactMap;

    public PhoneBook() {
        namesMap = new HashMap<>();
        numbersMap = new HashMap<>();
        contactMap = new HashMap<>();
        counter = 0;
    }

    public int add(String name, String number) {
        if (!namesMap.containsKey(name)) {
            counter++;
            Contact c = new Contact(counter, name, number);
            namesMap.put(c.name, c.id);
            numbersMap.put(c.number, c.id);
            contactMap.put(c.id, c);
        }
        return namesMap.size();
    }

    public String findByNumber(String number) {
        if (numbersMap.containsKey(number)) {
            int id = numbersMap.get(number);
            return contactMap.get(id).toString();
        }
        return "Нет такого контакта.";
    }

    protected class Contact {
        int id;
        String name;
        String number;

        protected Contact(int id, String name, String number) {
            this.id = id;
            this.name = name;
            this.number = number;
        }

        @Override
        public String toString() {
            return name + ": " + number;
        }
    }
}
