package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductManagerTest {
    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(1, "book1", 100, "author1");
    Book book2 = new Book(2, "cat", 200, "author2");
    Book book3 = new Book(3, "book3", 300, "author3");
    Book book4 = new Book(4, "friends", 400, "author4");

    Smartphone smartphone1 = new Smartphone(10, "smart1", 1000, "factory1");
    Smartphone smartphone2 = new Smartphone(20, "smart2", 2000, "factory1");
    Smartphone smartphone3 = new Smartphone(30, "smart3", 3000, "factory1");
    Smartphone smartphone4 = new Smartphone(40, "nokia", 4000, "factory1");



    @Test
    public void searchByBook() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);

        Product[] expected = {book1, book3};
        Product[] actual = manager.searchBy("book");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchBySmartphone() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

        Product[] expected = {smartphone1, smartphone2, smartphone3};
        Product[] actual = manager.searchBy("smart");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById(){
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);
        repo.add(smartphone1);
        repo.removeById(2);

        Product[] expected = {book1, book3, book4, smartphone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}