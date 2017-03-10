package task1.container;

import task1.container.MyList;
import task1.entity.Fork;
import task1.entity.Tableware;
import task1.entity.ThermoMug;
import task1.entity.Type;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

/**
 * Created by Kseniia_Bohdan on 10/27/2016.
 */

public class MyListTest {

    @Test
    public void whenAddThenSuccess(){
        MyList list = new MyList();
        boolean actual = list.add("Test 1");
        assertTrue(actual);
    }

    @Test
    public void whenSizeChangeThenSuccess() {
        MyList list = new MyList();
        list.add("Test 1");
        assertTrue(list.size() == 1);
    }

    @Test
    public void whenContainsAddedElementThenSuccess() {
        MyList list = new MyList();
        list.add("Test 1");
        assertTrue(list.contains("Test 1"));
    }

    @Test
    public void whenContainsAddedElementToIndexThenSuccess() {
        MyList list = new MyList();
        list.add("Test 2");
        list.add("Test 3");
        list.add(1, "Test 1");
        assertTrue(list.contains("Test 1"));
    }

    @Test
    public void whenSizeChangeAfterAddingThenSuccess(){
        MyList list = new MyList();
        list.add("Test 2");
        list.add("Test 3");
        int s = list.size();
        list.add(1, "Test 1");
        assertTrue(s != list.size());
    }

    @Test
    public void whenElementEqualsAddedElementThenSuccess(){
        MyList list = new MyList();
        list.add("Test 2");
        list.add("Test 3");
        list.add("Test 4");
        list.add(2, "Test 1");
        assertTrue(list.get(2).equals("Test 1"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenException() {
        MyList list = new MyList();
        list.add("Test 2");
        list.add(2, "Test 1");
    }

    @Test
    public void whenElementWasReturnedThenSuccess()  {
        MyList list = new MyList();
        list.add("Test 1");
        boolean actual = list.remove("Test 1");
        assertTrue(actual);
    }

    @Test
    public void whenElementWasRemovedThenSuccess()  {
        MyList list = new MyList();
        list.add("Test 1");
        list.remove("Test 1");
        assertTrue(!list.contains("Test 1"));
    }

    @Test
    public void whenListIsEmptyThenSuccess()  {
        MyList list = new MyList();
        list.add("Test 1");
        list.remove("Test 1");
        assertTrue(list.size() == 0);
    }

    @Test
    public void whenReturnRemovedElementThenSuccess() {
        MyList list = new MyList();
        list.add("Test 1");
        Object actual = list.remove(0);
        assertTrue(actual.equals("Test 1"));
    }

    @Test
    public void whenListWasChangedThenSuccess() {
        MyList list = new MyList();
        list.add("Test 1");
        int s = list.size();
        list.remove(0);
        assertTrue(s != list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundThenException()  {
        MyList list = new MyList();
        list.remove(5);
    }

    @Test
    public void whenGetRightElementThenSuccess()  {
        MyList list = new MyList();
        list.add("Test 1");
        list.add("Test 2");
        list.add("Test 3");
        Object o = list.get(1);
        assertTrue("Test 2".equals(o));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrowException()  {
        MyList list = new MyList();
        list.add("Test 1");
        list.add("Test 2");
        list.get(-1);
    }

    @Test
    public void whenHasNextIsFalseThenSuccess() {
        MyList list = new MyList();
        Iterator i = list.iterator();
        boolean actual = i.hasNext();
        assertTrue(!actual);
    }

    @Test
    public void whenHasNextIsTrueThenSuccess() {
        MyList list = new MyList();
        list.add("Test 1");
        Iterator i = list.iterator();
        boolean actual = i.hasNext();
        actual = actual && i.hasNext();
        assertTrue(actual);
    }

    @Test
    public void whenElementIsNotNullThenSuccess() {
        MyList list = new MyList();
        list.add("Test 1");
        Iterator i = list.iterator();
        Object o = i.next();
        assertTrue(o != null);
    }

    @Test
    public void whenListChangedThenSuccess() {
        MyList list = new MyList();
        list.add("Test 1");
        Iterator i = list.iterator();
        i.next();
        i.remove();
        assertTrue(list.size() == 0);
    }

    @Test(expected = IllegalStateException.class)
    public void whenRemovedCalledNotAfterNextThenException() {
        MyList list = new MyList();
        list.add("Test 1");
        Iterator i = list.iterator();
        i.remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenListIsEmptyThenException() {
        MyList list = new MyList();
        Iterator i = list.iterator();
        i.next();
    }

    @Test
    public void whenGetOnlyForksThenSuccess() {
        MyList<Tableware> list = new MyList();
        Predicate p = o -> (o instanceof Fork);
        Iterator i = list.iterator(p);
        Fork f1 = new Fork();
        Fork f2 = new Fork();
        ThermoMug tm1 = new ThermoMug();
        list.add(f1);
        list.add(f1);
        list.add(tm1);
        list.add(f1);
        list.add(tm1);
        list.add(f2);
        Fork f = new Fork();
        while (i.hasNext()) {
            f = (Fork) i.next();
        }
        assertTrue(f.equals(f2));
    }

    @Test
    public void whenGetAllElementThenSuccess() {
        MyList<Tableware> list = new MyList();
        Predicate p = o -> (o instanceof Tableware);
        Iterator i = list.iterator(p);
        Fork f1 = new Fork();
        Fork f2 = new Fork();
        ThermoMug tm1 = new ThermoMug();
        list.add(f1);
        list.add(f1);
        list.add(tm1);
        list.add(f1);
        list.add(tm1);
        list.add(f2);
        int a = 0;
        while (i.hasNext()) {
            a++;
            i.next();
        }
        assertTrue(a == 6);
    }

    @Test
    public void whenGetForkWithTwoProngsThenSuccess() {
        MyList<Tableware> list = new MyList();
        Predicate p = new Predicate<Tableware>() {
            @Override
            public boolean test(Tableware o) {
                return ((o instanceof Fork) && ((Fork) o).getProng() == 2);
            }
        };
        Iterator i = list.iterator(p);
        Fork f1 = new Fork(new BigDecimal(123), "UK", "red", 3, Type.DESSERT, "Good");
        Fork f2 = new Fork(new BigDecimal(123), "USA", "red", 2, Type.DESSERT, "Bad");
        ThermoMug tm1 = new ThermoMug();
        list.add(f1);
        list.add(f1);
        list.add(tm1);
        list.add(f2);
        list.add(tm1);
        list.add(f2);
        int a = 0;
        while (i.hasNext()) {
            a++;
            i.next();
        }
        assertTrue(a == 2);
    }


}