package org.example.lesson4;



public class Triangle {
    public static double areaTriangle (double a, double b, double c) throws Exception {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new Exception("Значение стороны треугольника не может быть равно 0 или быть отрицательным значением");
        }
        double p = (a + b + c) / 2;

        double S = Math.sqrt(p*(p-a)*(p -b)*(p - c));

        return S;


    }

}

