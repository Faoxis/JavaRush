package com.javarush.test.level17.lesson10.home04;

/* Синхронизированные методы
Установить модификатор synchronized только тем методам, которым необходимо.
Объект класса Solution будет использоваться нитями.
*/

/*
* Начнем с того, что вспомним зачем вообще нужно синхронизировать.
* Делается это для того, что некоторый член класса нормально функционировал при работе сразу нескольких нитей,
* которые к нему обращаются.
 * Значит синхронизировать нужно те методы, в которых участвую члены класса.*/

public class Solution {
    private double param = Math.random();
    private StringBuilder sb = new StringBuilder();

    // Не надо синхранизировать, т.к. локальной переменной i привсваивается метод, который синхранизован
    private void method0() {
        double i = method3();
    }

    // Вызывается метод 0, который меняет переменную
    protected synchronized void method1(String param1) {
        Solution solution = new Solution();
        solution.method0();
    }

    // Тут нечего синхронизировать, меняется только локальная переменная
    public void method2(int param1) {
        param1++;
    }

    // Меняется param, синхронизировать!
    synchronized double method3() {
        double random = Math.random();
        param += 40.7;
        return random + param;
    }

    // Меняется sb, немедленно синхронизировать!
    private synchronized void method4() {
        sb.append(1).append(1).append(1).append(1);
    }

    // Ничего не  меняется
    protected void method5(String param2) {
        
        new StringBuffer().append(param2).append(param2).append(param2);
    }

    // Ну тут sb меняется, полюбому надо
    public synchronized String method6(int param2) {
        System.out.println("Thinking....");
        method7(5e-2);
        sb = new StringBuilder("Got it!.");
        return sb.toString();
    }

    // Ну тут понятно, никакие члены класса не меняются
    String method7(double param2) {
        return "" + param2;
    }

}
