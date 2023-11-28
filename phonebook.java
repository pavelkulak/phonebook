import java.util.*;


public class PhoneBook {
    public static void main(String[] args) {
        // Добавляем хранилище - книга контактов.
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Добавляем контакты для примера
        addContact(phoneBook, "Ivanov", "123456", "789012");
        addContact(phoneBook, "Petrov", "456789");
        addContact(phoneBook, "Sidorov", "111222", "333444", "555666", "144109");
        addContact(phoneBook, "Ivanov", "777888");

        // Вызываем метод отображения книги контактов с применением сортировки
        displayPhoneBook(phoneBook);
    }

    // Метод добавления контакта
    private static void addContact(Map<String, List<String>> phoneBook, String name, String... phones) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).addAll(Arrays.asList(phones));
    }

    // Метод отображения книги контактов с сортировкой по убыванию, по количеству номеров
    private static void displayPhoneBook(Map<String, List<String>> phoneBook) {
        phoneBook.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                .forEach(entry -> {
                    System.out.print(entry.getKey() + ": ");
                    System.out.println(String.join(", ", entry.getValue()));
                });
    }
}