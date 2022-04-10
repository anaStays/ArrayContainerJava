package com.java1;

public class ArrayCont {

    private int size; //размер контейнера
    private int[] elems;//массив с элементами

    //Конструктор по умолчанию, сделаем по умолчанию
    //размер = 10
    public ArrayCont()
    {
        size=10;
        elems=new int[size];
    }

    //Конструктор с параметром, задающим размер контейнера
    //@param user_size - размер контейнера
    public ArrayCont(int user_size)
    {
        if (user_size<=0)//проверяем корректность данных, поданных на вход
        {
            System.err.println("Размер контейнера не может быть отрицательным значением или быть 0");
            throw new IllegalArgumentException("Размер контейнера не может быть отрицательным значением или быть 0");
        }
        else
        {
            size=user_size;
            elems=new int[size];
        }
    }

    //Метод для получения размера контейнера
    //@return - размер контейнера
    public int getSize() {
        return size;
    }

    //Метод для получения элемента контейнера по индексу
    //@param index - индекс элемента контейнера
    //@return - значение элемента по заданному индексу index
    public int getElem(int index)
    {
        if (index>=0 && index<size)
        {
            return elems[index];
        }
        else
        {
            System.err.println("Индекс элемента не может быть отрицательным значением или быть больше размера контейнера");
            throw new IllegalArgumentException("Индекс элемента не может быть отрицательным значением");

        }
    }

    //Метод для изменения размера контейнера
    //@param new_size - новый размер
    public void setNewSize(int new_size)
    {
        if (new_size<=0)//проверка на корректность входного параметра
        {
            System.err.println("Размер контейнера не может быть отрицательным значением или быть 0");
            throw new IllegalArgumentException("Размер контейнера не может быть отрицательным значением или быть 0");

        }
        else
        {
            int[] new_elems=new int[new_size];
            if (new_size<size)
            {
                for (int i=0; i<new_size; i++) {
                    new_elems[i] = elems[i];
                }
            }
            else
            {
                for (int i=0; i<size;i++)
                {
                    new_elems[i]=elems[i];
                }
                //Этот цикл можно не писать, так как при объявлении
                // весь новенький массив проинициализируется 0
                for(int i=size; i<new_size; i++)
                {
                    new_elems[i]=0;
                }
            }
            size=new_size;
            elems=new_elems;
        }
    }

    //Метод для добавления элемента в контейнер
    //Если значение индекса добавляемого объекта больше размера контейнера,
    //изменяем размер контейнера так, чтобы вставляемый элемент оказался последним
    //@param index - индекс позиции, на которую хотим поставить элемент
    //@param new_elem - значение добавляемого элемента
    public void addElem(int index, int new_elem)
    {
        if (index<0)//проверка на корректность входного параметра
        {
            System.err.println("Индекс не может быть отрицательным значением");
            throw new IllegalArgumentException("Индекс не может быть отрицательным значением");
        }
        else
        {
            if (index>=size) {
                setNewSize(index + 1);
            }
            elems[index]=new_elem;
        }
    }

    //Метод для удаления элемента и уменьшения размера контейнера
    //@param index - индекс удаляемого элемента
    public void delElem_and_setNewSize(int index)
    {
        if (index<0 || index>=size)//проверка на корректность входного параметра
        {
            System.err.println("Индекс не может быть отрицательным значением или быть больше значения размера контейнера");
            throw new IllegalArgumentException("Индекс не может быть отрицательным значением или быть больше значения размера контейнера");
        }
        else
        {
            for (int i=index; i<size-1;i++)
            {
                elems[i]=elems[i+1];
            }
            //Для исключения возможных ошибок в работе, если размер контейнера =1,
            //не будем сокращать его размер, а только обнулим элемент
            if (size>1) setNewSize(size-1);
            else elems[0]=0;
        }
    }

    //Метод для удаления (обнуления) элемента без изменения размера контейнера
    //обнуленный элемент помещается в конец контейнера
    //@param index - индекс удаляемого элемента
    public void delElem(int index)
    {
        if (index<0 || index>=size)//проверка на корректность входного параметра
        {
            System.err.println("Индекс не может быть отрицательным значением или быть больше значения размера контейнера");
            throw new IllegalArgumentException("Индекс не может быть отрицательным значением или быть больше значения размера контейнера или быть больше значения размера контейнера");
        }
        else
        {
            for (int i=index; i<size-1;i++)
            {
                elems[i]=elems[i+1];
            }
            elems[size-1]=0;
        }
    }

    //Метод для печати всех элементов
    public void printElems()
    {
        for (int i=0; i<size; i++)
        {
            System.out.print(elems[i]+" ");
        }
        System.out.println();
    }

    //Метод для очищения (обнуления) контейнера
    public void clearElems()
    {
        for (int i=0; i<size; i++)
        {
            elems[i]=0;
        }
    }
}
