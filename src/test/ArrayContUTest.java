package test;
import com.java1.ArrayCont;
import java.util.Random;
import org.junit.*;

import static org.junit.Assert.*;
//Класс для юнит тестов
public class ArrayContUTest {

    //Метод для получения рандомного элемента
    //@param min - минимальное сгенерированное число
    //@param max - максимальное сгенерированное число
    //@return - значение случайного элемента
    private int getRandomElem(int min, int max)
    {
        Random random=new Random();
        return random.ints(min, max+1).findFirst().getAsInt();
    }
    //При создании контейнера отрицательным параметром должно сработать исключение
    @Test
    public void createACWithNegativeIndexShouldNotBe()
    {
        boolean mist;
        try
        {
            mist=true;
            ArrayCont arrayCont=new ArrayCont(-15);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        assertFalse(mist);
    }
    //При создании контейнера параметром = 0 должно сработать исключение
    @Test
    public void createACWithIndexZeroShouldNotBe()
    {
        boolean mist;
        try
        {
            mist=true;
            ArrayCont arrayCont=new ArrayCont(0);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        assertFalse(mist);
    }
    //При создании контейнера с положительным параметром должен создать контейнер
    @Test
    public void createACWithPositiveIndexShouldBe()
    {
        boolean mist;
        try
        {
            mist=true;
            ArrayCont arrayCont=new ArrayCont(11);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        assertTrue(mist);
    }
    //При получении размера контейнера д получить верное значение
    @Test
    public void getSizeShouldBeCorrect()
    {
        ArrayCont arrayCont=new ArrayCont(15);
        assertTrue(arrayCont.getSize()==15);
    }
    //При получении элемента с отрицательным индексом должно сработать исключение
    @Test
    public void getElemWithNegativeIndexShouldNotBe()
    {
        boolean mist;
        ArrayCont arrayCont=new ArrayCont();
        try{
            mist=true;
            arrayCont.getElem(-5);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        assertFalse(mist);
    }
    //При получении элемента с индексом > size должно сработать исключение
    @Test
    public void getElemWithPositiveIndexMoreSizeShouldNotBe()
    {
        boolean mist;
        ArrayCont arrayCont=new ArrayCont();
        try{
            mist=true;
            arrayCont.getElem(27);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        assertFalse(mist);
    }
    //При получении элемента с индексом > 0 и < size должны получить элемент
    @Test
    public void getElemWithPositiveIndexLessSizeShouldBe()
    {
        boolean mist;
        ArrayCont arrayCont=new ArrayCont();
        for (int i=0; i<arrayCont.getSize(); i++)
        {
            arrayCont.addElem(i,i);
        }
        try{
            mist=true;
            arrayCont.getElem(4);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        if (mist==true && arrayCont.getElem(4)!=4) mist=false;
        assertTrue(mist);
    }
    //Попробуем изменить размер контейнера на отрицательное значение дс исключение
    @Test
    public void setNewSizeWithNegativeSizeShouldNotBe()
    {
        boolean mist;
        ArrayCont arrayCont=new ArrayCont();
        try{
            mist=true;
            arrayCont.setNewSize(-16);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        assertFalse(mist);
    }
    //Попробуем изменить размер контейнера на нулевое значение дс исключение
    @Test
    public void setNewSizeWithZeroSizeShouldNotBe()
    {
        boolean mist;
        ArrayCont arrayCont=new ArrayCont();
        try{
            mist=true;
            arrayCont.setNewSize(0);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        assertFalse(mist);
    }
    //Попробуем изменить размер контейнера на значение большее, чем было
    //размер должен измениться, элементы сохраняются в ячейках, а в последующих эл-ты = 0
    @Test
    public void setNewSizeWithSizeMoreOldShouldNotBe()
    {
        boolean mist;
        ArrayCont arrayCont=new ArrayCont(10);
        for (int i=0; i<arrayCont.getSize(); i++)
        {
            arrayCont.addElem(i,i);
        }
        try{
            mist=true;
            arrayCont.setNewSize(23);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        if (mist==true && arrayCont.getElem(9)==9 && arrayCont.getElem(10)==0 && arrayCont.getSize()==23) mist=true;
        else mist=false;
        assertTrue(mist);
    }
    //Попробуем изменить размер контейнера на значение меньшее, чем было
    //размер должен измениться, элементы сохраняются в оставшихся ячейках
    @Test
    public void setNewSizeWithSizeLessOldShouldNotBe()
    {
        boolean mist;
        ArrayCont arrayCont=new ArrayCont(10);
        for (int i=0; i<arrayCont.getSize(); i++)
        {
            arrayCont.addElem(i,i);
        }
        try{
            mist=true;
            arrayCont.setNewSize(5);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        if (mist==true && arrayCont.getElem(4)==4 && arrayCont.getSize()==5) mist=true;
        else mist=false;
        assertTrue(mist);
    }
    //Добавим элемент с индексом, выходящим за размер контейнера
    //Размер контейнера должен увеличиться, значение оказаться на заданной позиции
    @Test
    public void addElemWithIndexMoreSizeShouldBeCorrect()
    {
        boolean mist;
        ArrayCont arrayCont=new ArrayCont(10);
        try{
            mist=true;
            arrayCont.addElem(21,7);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        if (mist==true && arrayCont.getElem(21)==7 && arrayCont.getSize()==22) mist=true;
        else mist=false;
        assertTrue(mist);
    }
    //Добавим элемент с отрицательным индексом, дс исключение
    @Test
    public void addElemWithNegativeIndexShouldNotBe()
    {
        boolean mist;
        ArrayCont arrayCont=new ArrayCont(10);
        try{
            mist=true;
            arrayCont.addElem(-14,7);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        assertFalse(mist);
    }
    //Добавим элемент с корректным индексом, должны получить корректное значение на нужной позиции
    @Test
    public void addElemWithCorrectIndexShouldBeCorrect()
    {
        boolean mist;
        ArrayCont arrayCont=new ArrayCont(10);
        try{
            mist=true;
            arrayCont.addElem(4,7);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        if (mist && arrayCont.getElem(4)!=7) mist=false;
        assertTrue(mist);
    }
    //Попробуем удалить элемент с отрицательным индексом и сократить контейнер -  дс исключение
    @Test
    public void del_and_setElemWithNegativeIndexShouldNotBe()
    {
        boolean mist;
        ArrayCont arrayCont=new ArrayCont(10);
        try{
            mist=true;
            arrayCont.delElem_and_setNewSize(-5);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        assertFalse(mist);
    }
    //Попробуем удалить элемент со значением большим, чем размер контейнера, и сократить контейнер - дс исключение
    @Test
    public void del_and_setElemWithIndexMoreSizeShouldNotBe()
    {
        boolean mist;
        ArrayCont arrayCont=new ArrayCont(10);
        try{
            mist=true;
            arrayCont.delElem_and_setNewSize(24);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        assertFalse(mist);
    }
    //Удалим элемент и сократим контейнер с корректным параметром
    @Test
    public void del_and_setElemWithCorrectIndexShouldBeCorrect()
    {
        boolean mist;
        ArrayCont arrayCont=new ArrayCont(10);
        try{
            mist=true;
            arrayCont.delElem_and_setNewSize(5);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        if (mist==true && arrayCont.getSize()==9) mist=true;
        else mist=false;
        assertTrue(mist);
    }
    //Попробуем удалить элемент с отрицательным индексом - дс исключение
    @Test
    public void delElemWithNegativeIndexShouldNotBe()
    {
        boolean mist;
        ArrayCont arrayCont=new ArrayCont(10);
        try{
            mist=true;
            arrayCont.delElem(-5);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        assertFalse(mist);
    }
    //Попробуем удалить элемент со значением большим, чем размер контейнера, дс исключение
    @Test
    public void delElemWithIndexMoreSizeShouldNotBe()
    {
        boolean mist;
        ArrayCont arrayCont=new ArrayCont(10);
        try{
            mist=true;
            arrayCont.delElem(24);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        assertFalse(mist);
    }
    //Удалим элемент и сократим контейнер с корректным параметром
    @Test
    public void delElemWithCorrectIndexShouldBeCorrect()
    {
        boolean mist;
        ArrayCont arrayCont=new ArrayCont(10);
        for (int i=0; i<arrayCont.getSize(); i++)
        {
            arrayCont.addElem(i,i);
        }
        try{
            mist=true;
            arrayCont.delElem(5);
        }
        catch(Exception ex){
            mist=false;
            System.out.println(ex.getMessage());
        }
        if (mist==true && arrayCont.getSize()==10 && arrayCont.getElem(9)==0 && arrayCont.getElem(5)!=5)
            mist=true;
        else mist=false;
        assertTrue(mist);
    }
    //Все элементы после очищения должны быть = 0
    @Test
    public void allElemsAfterClearShouldBeZero()
    {
        boolean mist=false;//переменная результата, есть ошибка = 1
        ArrayCont arrayCont=new ArrayCont(10);
        //Заполним контейнер случайными числами
        for (int i=0; i<10; i++)
        {
            arrayCont.addElem(i,getRandomElem(-20,20));
        }
        arrayCont.clearElems();
        int i=0;
        while (!mist && i<10)
        {
            if (arrayCont.getElem(i)!=0) mist=true;
            i++;
        }
        assertFalse(mist);
    }
}
