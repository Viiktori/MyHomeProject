package org.example;

import org.example.Lesson_4.ExceptionClass;
import org.example.Lesson_4.MainClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleTest {
    @Test
    void test() throws ExceptionClass {
        MainClass exampleClass = new MainClass();
        Assertions.assertEquals(30,exampleClass.someMethod(10,20, 15));
        Assertions.assertThrows(ExceptionClass.class,()-> exampleClass.someMethod(-10,20, 15));
    }

    @ParameterizedTest
    @CsvSource({ "10, 20, 15","100, 200, 280","1, 2, 3"})
    void testWithCsvSource(int a, int b, int result) throws ExceptionClass {
        MainClass exampleClass = new MainClass();
        Assertions.assertEquals(result,exampleClass.someMethod(a,b));

    }

    @ParameterizedTest
    @CsvSource({ "-10, 20, 15","-100, 200, 0","1, -2, -7"})
    void testWithCsvSourceN(int a, int b, int c) throws ExceptionClass {
        MainClass exampleClass = new MainClass();
        Assertions.assertThrows(ExceptionClass.class,()-> exampleClass.someMethod(a,b,c));

    }
}
