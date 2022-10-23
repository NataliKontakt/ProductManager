package ru.netology.repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {


    Book book1 = new Book(5, "Повести Белкина", 500, "Пушкин");
    Book book2 = new Book(7, "Бородино", 200, "Лермонтов");
    Book book3 = new Book(15, "Мастер и Маргарита", 300, "Булгаков");
    Smartphone smartphone1 = new Smartphone(5, "Телефон 1", 50, "iPhone");
    Smartphone smartphone2 = new Smartphone(2, "Телефон 2", 100, "Samsung");
    Smartphone smartphone3 = new Smartphone(3, "Телефон 3", 150, "Nokia");



    @Test
    public void testBook1 () {
        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.removeById(book2.getId());

        Product[] expected = {book1, book3};
        Product[] actual = repository.getProducts();
        Assertions.assertArrayEquals(actual, expected);
    }
    @Test
    public void testBook2 () {
        ProductRepository repository = new ProductRepository();
        repository.save(book1);

        Product[] expected = {book1};
        Product[] actual = repository.getProducts();
        Assertions.assertArrayEquals(actual, expected);
    }
    @Test
    public void testBook3 () {
        ProductRepository repository = new ProductRepository();

        Product[] expected = {};
        Product[] actual = repository.getProducts();
        Assertions.assertArrayEquals(actual, expected);
    }
    @Test
    public void testSmartphone1 () {
        ProductRepository repository = new ProductRepository();
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
        repository.removeById(smartphone2.getId());

        Product[] expected = {smartphone1, smartphone3};
        Product[] actual = repository.getProducts();
        Assertions.assertArrayEquals(actual, expected);
    }
    @Test
    public void testSmartphone2 () {
        ProductRepository repository = new ProductRepository();
        repository.save(smartphone1);

        Product[] expected = {smartphone1};
        Product[] actual = repository.getProducts();
        Assertions.assertArrayEquals(actual, expected);
    }
    @Test
    public void testSmartphone3 () {
        ProductRepository repository = new ProductRepository();

        Product[] expected = {};
        Product[] actual = repository.getProducts();
        Assertions.assertArrayEquals(actual, expected);
    }
}
