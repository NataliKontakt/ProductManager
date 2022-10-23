
package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book book1 = new Book(5, "Повести Белкина", 500, "Пушкин");
    Book book2 = new Book(7, "Бородино", 200, "Лермонтов");
    Book book3 = new Book(15, "Мастер и Маргарита", 300, "Булгаков");
    Book book4 = new Book(16, "Нокия", 300, "Коллектив авторов");
    Smartphone smartphone1 = new Smartphone(5, "Телефон 1", 50, "iPhone");
    Smartphone smartphone2 = new Smartphone(2, "Телефон 2", 100, "Samsung");
    Smartphone smartphone3 = new Smartphone(3, "Телефон 3", 150, "Nokia");
    Smartphone smartphone4 = new Smartphone(8, "Нокия", 160, "Nokia");



    @Test
    void shouldNoAdd() {

        Product[] expected = {};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldAdd() {
        manager.add(book1);
        Product[] expected = {book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldAddAll() {
        manager.add(book1);
        manager.add(smartphone2);
        Product[] expected = { book1, smartphone2 };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchBy1() {
        manager.add(book3);
        manager.add(smartphone2);

        String name = "Мастер и Маргарита";
        Product[] expected = {book3};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchWhenFewProductsSuit() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        String name = "Нокия";
        Product[] expected = { book4, smartphone4 };
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchWhenProductsNotSuit() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        String name = "Samsung";
        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }


}
