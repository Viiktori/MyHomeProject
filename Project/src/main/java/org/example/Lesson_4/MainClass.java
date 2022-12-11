package org.example.Lesson_4;

public class MainClass {
    public int someMethod(int a, int b, int c) throws ExceptionClass {
        if(a<0 || b<0 || c<0) throw new ExceptionClass("Некорректно введено значение сторон");
        int p = (a+b+c)/2;
        double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return (int) s;
    }

}
