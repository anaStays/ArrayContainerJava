package com.java1;

import java.util.Random;

//Класс для тестирования контейнера  ArrayCont
public class ArrayContTest {
    //Метод для получения рандомного элемента
    //@param min - минимальное сгенерированное число
    //@param max - максимальное сгенерированное число
    //@return - значение случайного элемента
    private int getRandomElem(int min, int max)
    {
        Random random=new Random();
        return random.ints(min, max+1).findFirst().getAsInt();
    }
    //Метод для тестирования всех методов контейнера
    public void ACtest()
    {
        System.out.println("Тест 1. Тестирвоание контейнера на базе массива");
        ArrayCont test_cont=new ArrayCont();
        int size= test_cont.getSize();
        System.out.println("Размер контейнера = " + size);
        //Заполним контейнер случайными числами
        for (int i=0; i<size; i++)
        {
            test_cont.addElem(i,getRandomElem(-20,20));
        }
        //Печать элементов
        test_cont.printElems();
        //Попробуем получить элемент с индексом -5
        System.out.println("Получить элемент с индексом -5");
        try{
            System.out.println("Элемент с индексом -5 = " + test_cont.getElem(-5));
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Получить элемент с индексом 27");
        //Попробуем получить элемент с индексом 27 > size
        try{
            System.out.println("Элемент с индексом 27 = " + test_cont.getElem(27));
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        //Попробуем получить элемент с индексом 4 в диапозоне от 0 до size
        System.out.println("Элемент с индексом 4 = " + test_cont.getElem(4));
        //Попробуем изменить размер контейнера на отрицательное значение
        System.out.println("Изменить размер контейнера на -16");
        try{
            test_cont.setNewSize(-16);
            test_cont.printElems();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        //Попробуем изменить размер контейнера на нулевое значение
        System.out.println("Изменить размер контейнера на 0");
        try{
            test_cont.setNewSize(0);
            test_cont.printElems();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        //Попробуем изменить размер контейнера на значение большее, чем было
        System.out.println("Изменить размер контейнера на 23");
        test_cont.setNewSize(23);
        test_cont.printElems();
        //Попробуем изменить размер контейнера на значение меньшее, чем было
        System.out.println("Изменить размер контейнера на 7");
        test_cont.setNewSize(7);
        test_cont.printElems();
        //Добавим элемент с индексом, выходящим за размер контейнера
        System.out.println("Добавить элемент с индексом, выходящим за размер контейнера");
        test_cont.addElem(13,getRandomElem(-20,20));
        test_cont.printElems();
        //Попробуем удалить элемент с отрицательным индексом и сократить контейнер
        System.out.println("Удалить элемент с отрицательным индексом и сократить контейнер");
        try{
            test_cont.delElem_and_setNewSize(-7);
            test_cont.printElems();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        //Попробуем удалить элемент со значением большим, чем размер контейнера, и сократить контейнер
        System.out.println("Удалить элемент со значением большим, чем размер контейнера, и сократить контейнер");
        try{
            test_cont.delElem_and_setNewSize(29);
            test_cont.printElems();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        //Удалим элемент и сократим контейнер
        System.out.println("Удалить элемент с индексом 0 и сократить контейнер");
        test_cont.delElem_and_setNewSize(0);
        test_cont.printElems();
        //Попробуем удалить элемент с отрицательным индексом
        System.out.println("Удалить элемент с отрицательным индексом");
        try{
            test_cont.delElem(-7);
            test_cont.printElems();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        //Попробуем удалить элемент со значением большим, чем размер контейнера
        System.out.println("Удалить элемент со значением большим, чем размер контейнера");
        try{
            test_cont.delElem(29);
            test_cont.printElems();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        //Удалим элемент
        System.out.println("Удалить элемент с индексом 0");
        test_cont.delElem(0);
        test_cont.printElems();
        //Обнуление контейнера
        System.out.println("Обнулить контейнер");
        test_cont.clearElems();
        test_cont.printElems();
    }
}
