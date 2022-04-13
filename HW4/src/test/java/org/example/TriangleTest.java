package org.example;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.example.lesson4.Triangle.areaTriangle;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger("TriangleTest");

    @BeforeAll
    static void  beforeAll(){
        System.out.println("Метод выполнится 1 раз перед всеми тестами");
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("Метод выполнится перед каждым тестом");

    }

    @Test
    void exceptedResult() throws Exception {
        assertEquals(areaTriangle(5,4,3),6);
        logger.debug("Debug log");
        logger.info("Info log");
    }

    @Test
    void notExceptedResult() throws Exception {
        assertEquals(areaTriangle(5,4,3),2);
        logger.debug("Debug log");
        logger.info("Info log");
    }

    @Test
    void checkException() throws Exception {
        assertEquals(areaTriangle(5,-4,3),6);
        logger.debug("Debug log");
        logger.info("Info log");
    }

    @Test
    void checkNotice() {
        Throwable thrown = assertThrows(Exception.class, () -> {
                areaTriangle(5, -4, 2);
            });
            assertEquals("Значение стороны треугольника не может быть равно 0 или быть отрицательным значением"
                    ,thrown.getMessage());
        logger.debug("Debug log");
        logger.info("Info log");
        }

    @AfterEach
    void afterEach(){
        System.out.println("Метод выполнится после каждого теста");

    }
    @AfterAll
    static void afterAll(){

        System.out.println("Метод выполнится 1 раз после всех тестов");
    }

}
