import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * @author Julia Pyke I have adhered to the Honor Code in this assignment.
 * 
 */

public class MyArrayListTest {

    @Test
    public void testSize() {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	ArrayList<Integer> real = new ArrayList<Integer>();
	assertEquals("Size after construction", real.size(), test.size());
	test.add(0, 5);
	real.add(0, 5);
	assertEquals("Size after add", real.size(), test.size());
    }

    @Test
    public void testMyArrayListInt() {
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
	Scanner input = null;
	Scanner input2 = null;
	try {
	    input = new Scanner(new File("test1.txt"));
	    while (input.hasNextLine())
		test.add(input.nextLine());

	    input2 = new Scanner(new File("test1.txt"));
	    while (input2.hasNextLine())
		real.add(input2.nextLine());
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	    System.exit(1);
	}
	for (int i = 0; i < real.size(); i++) {
	    assertEquals("Lines added from file", real.get(i), test.get(i));
	}

    }

    @Test
    public void testMyArrayList() {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	ArrayList<Integer> real = new ArrayList<Integer>();
	assertEquals("Size after construction", real.size(), test.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetInt() {
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
	Scanner input = null;
	Scanner input2 = null;
	try {
	    input = new Scanner(new File("test1.txt"));
	    while (input.hasNextLine())
		test.add(input.nextLine());

	    input2 = new Scanner(new File("test1.txt"));
	    while (input2.hasNextLine())
		real.add(input2.nextLine());
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	    System.exit(1);
	}
	assertEquals("Lines added from file", real.get(-1), test.get(-1));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIntAnyType() {
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
	Scanner input = null;
	Scanner input2 = null;
	try {
	    input = new Scanner(new File("test1.txt"));
	    while (input.hasNextLine())
		test.add(input.nextLine());

	    input2 = new Scanner(new File("test1.txt"));
	    while (input2.hasNextLine())
		real.add(input2.nextLine());
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	    System.exit(1);
	}
	assertEquals("Lines added from file", real.get(real.size() + 1),
		test.get(test.size() + 1));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAnyType() {
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
	Scanner input = null;
	Scanner input2 = null;
	try {
	    input = new Scanner(new File("test1.txt"));
	    while (input.hasNextLine())
		test.add(input.nextLine());

	    input2 = new Scanner(new File("test1.txt"));
	    while (input2.hasNextLine())
		real.add(input2.nextLine());
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	    System.exit(1);
	}
	assertEquals("Lines added from file", real.get(real.size()),
		test.get(test.size()));
    }

    @Test
    public void testClear() {
	MyArrayList<String> test = new MyArrayList<String>();

	Scanner input = null;

	try {
	    input = new Scanner(new File("test1.txt"));
	    while (input.hasNextLine())
		test.add(input.nextLine());


	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	    System.exit(1);
	}
	test.clear();
	for (int i = 0; i < test.size(); i++) {
	    assertNull("Cleared?", test.get(i));
	}
    }

    @Test
    public void testSet() {
	String temp = null;
	String temp2 = null;
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
	Scanner input = null;
	Scanner input2 = null;
	try {
	    input = new Scanner(new File("test1.txt"));
	    while (input.hasNextLine())
		test.add(input.nextLine());

	    input2 = new Scanner(new File("test1.txt"));
	    while (input2.hasNextLine())
		real.add(input2.nextLine());
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	    System.exit(1);
	}
	for (int i = 0; i < test.size() / 2; i++) {
	    temp = test.get(i);
	    temp2 = test.get(test.size() - 1 - i);
	    test.set(test.size() - i - 1, temp);
	    test.set(i, temp2);
	}
	for (int i = 0; i < test.size() / 2; i++) {
	    temp = real.get(i);
	    temp2 = real.get(test.size() - 1 - i);
	    real.set(real.size() - i - 1, temp);
	    real.set(i, temp2);
	}
	for (int i = 0; i < real.size(); i++) {
	    assertEquals("Reversed list", real.get(i), test.get(i));
	}

    }

    @Test
    public void testRemoveInt() {
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
	Scanner input = null;
	Scanner input2 = null;
	try {
	    input = new Scanner(new File("test1.txt"));
	    while (input.hasNextLine())
		test.add(input.nextLine());

	    input2 = new Scanner(new File("test1.txt"));
	    while (input2.hasNextLine())
		real.add(input2.nextLine());
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	    System.exit(1);
	}
	MyArrayList<String> removed = new MyArrayList<String>();
	ArrayList<String> realRemoved = new ArrayList<String>();
	for (int i = 0; i < test.size(); i++) {
	    removed.add(test.remove(i));
	    realRemoved.add(real.remove(i));
	}

	for (int i = 0; i < test.size(); i++) {
	    assertEquals("Removed", real.get(i), test.get(i));
	    assertEquals("RemovedList", removed.get(i), realRemoved.get(i));
	}

    }

    @Test
    public void testIsEmpty() {
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
	Scanner input = null;
	Scanner input2 = null;
	try {
	    input = new Scanner(new File("test1.txt"));
	    while (input.hasNextLine())
		test.add(input.nextLine());

	    input2 = new Scanner(new File("test1.txt"));
	    while (input2.hasNextLine())
		real.add(input2.nextLine());
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	    System.exit(1);
	}
	assertEquals("Empty?", real.isEmpty(), test.isEmpty());
	MyArrayList<String> test2 = new MyArrayList<String>();
	ArrayList<String> real2 = new ArrayList<String>();
	assertEquals("Empty?", real2.isEmpty(), test2.isEmpty());
    }

    @Test
    public void testAddE() {
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
	Scanner input = null;
	Scanner input2 = null;
	try {
	    input = new Scanner(new File("test1.txt"));
	    while (input.hasNextLine())
		test.add(input.nextLine());

	    input2 = new Scanner(new File("test1.txt"));
	    while (input2.hasNextLine())
		real.add(input2.nextLine());
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	    System.exit(1);
	}
	for (int i = 0; i < real.size(); i++) {
	    assertEquals("Lines added from file", real.get(i), test.get(i));
	}
    }

    @Test
    public void testAddIntEFront() {
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
	Scanner input = null;
	Scanner input2 = null;
	try {
	    input = new Scanner(new File("test1.txt"));
	    while (input.hasNextLine())
		test.add(0, input.nextLine());

	    input2 = new Scanner(new File("test1.txt"));
	    while (input2.hasNextLine())
		real.add(0, input2.nextLine());
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	    System.exit(1);
	}
	for (int i = 0; i < real.size(); i++) {
	    assertEquals("Lines added from file", real.get(i), test.get(i));
	}
    }

    @Test
    public void testAddIntEBack() {
	MyArrayList<String> test = new MyArrayList<String>();
	ArrayList<String> real = new ArrayList<String>();
	Scanner input = null;
	Scanner input2 = null;
	try {
	    input = new Scanner(new File("test1.txt"));
	    while (input.hasNextLine())
		test.add(test.size() / 2, input.nextLine());

	    input2 = new Scanner(new File("test1.txt"));
	    while (input2.hasNextLine())
		real.add(real.size() / 2, input2.nextLine());
	} catch (FileNotFoundException e) {
	    System.out.println("Problem opening file: " + e.getMessage());
	    System.exit(1);
	}
	for (int i = 0; i < real.size(); i++) {
	    assertEquals("Lines added from file", real.get(i), test.get(i));
	}
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testForAddLeftException() throws Exception {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	test.add(-1, 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testForAddRightException() throws Exception {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	test.add(test.size() + 1, 5);
    }

    @Ignore
    @Test
    public void testAddEfficiency() {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	int i = 1;
	while (i <= 1000000) {
	    test.add(i);// add to end of list
	    if (i % 10000 == 0)
		System.out.print(i + " ");// print out every 10000th digit
	    i++;
	}
	System.out.println();
	  
	   MyArrayList<Integer> test2 = new MyArrayList<Integer>(); 
	   int j =1; 
	while (j <= 1000000) {
	       test2.add(0, j);// add to front of list 
	    if (j % 10000 == 0)
		System.out.print(j + " ");// print out every 10000th digit
	    j++;
	  
	}
	 
    }

    @Ignore
    @Test
    public void testRemoveEfficiency() {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	int i = 1;
	while (i <= 1000000) {
	    test.add(i);// add to end of list
	    i++;
	}
	int j = test.size() - 1;
	while (j >= 0) {
	    if (j % 10000 == 0)
		System.out.print(j + " ");
	    test.remove(j);
	    j--;
	}
    }

    @Ignore
    @Test
    public void testMemory() {
	MyArrayList<Integer> test = new MyArrayList<Integer>();
	int i = 1;
	while (i > 0) {
	    test.add(i);
	    if (i % 10000 == 0)
		System.out.print(i + " ");
	    i++;
	}
    }

}
