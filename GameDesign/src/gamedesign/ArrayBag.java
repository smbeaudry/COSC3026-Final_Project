package gamedesign;

// File: IntArrayBag.java from the package edu.colorado.collections
// Additional javadoc documentation is available from the IntArrayBag link in:
//   http://www.cs.colorado.edu/~main/docs

/******************************************************************************
* An ArrayBag is a collection of objects.
* The same object may appear multiple times in a bag.
*
* @note
*   (1) The capacity of one of these bags can change after it's created, but
*   the maximum capacity is limited by the amount of free memory on the 
*   machine. The constructor, addItem, clone, 
*   and union will result in an OutOfMemoryError
*   when free memory is exhausted
*   <p>
*   (2) Because of the slow linear algorithms of this
*   class, large bags will have poor performance.
*
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jul 24, 2013
*
* modified by: Luc Breault
* modified by ID: MYSTERYYYYYY
******************************************************************************/
import java.util.Random;
public class ArrayBag<E> implements Cloneable
{
   // Invariant of the ArrayBag class:
   //   1. The number of elements in the bag is in the instance variable 
   //      manyItems, which is no more than data.length.
   //   2. For an empty bag, we do not care what is stored in any of data;
   //      for a non-empty bag, the elements in the bag are stored in data[0]
   //      through data[manyItems-1], and we don�t care what�s in the
   //      rest of data.
   private Object[] data;
   private int manyItems; 
   private Random randNum;
   
   /**
   * Initialize an empty bag with an initial capacity of 10.  Note that the
   * addItem method works efficiently (without needing more
   * memory) until this capacity is reached.
   * @param - none
   * @postcondition
   *   This bag is empty and has an initial capacity of 10.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for: 
   *   new Object[10].
   **/   
   public ArrayBag( )
   {
      this(10, new Random());
   }
     

   /**
   * Initialize an empty bag with a specified initial capacity. Note that the
   * addItem method works efficiently (without needing more
   * memory) until this capacity is reached.
   * @param initialCapacity
   *   the initial capacity of this bag
   * @precondition
   *   initialCapacity is non-negative.
   * @postcondition
   *   This bag is empty and has the given initial capacity.
   * @exception IllegalArgumentException
   *   Indicates that initialCapacity is negative.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for: new Object[initialCapacity].
   **/   
   public ArrayBag(int initialCapacity, Random rand)
   {
      if (initialCapacity < 0)
         throw new IllegalArgumentException
         ("The initialCapacity is negative: " + initialCapacity);
      data = new Object[initialCapacity];
      manyItems = 0;
      randNum = rand;
   }
        
 
   /**
   * Add a new element to this bag. If the new element would take this
   * bag beyond its current capacity, then the capacity is increased
   * before adding the new element.
   * @param element
   *   the new element that is being inserted
   * @postcondition
   *   A new copy of the element has been added to this bag.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for increasing the bag's capacity.
   * @note
   *   An attempt to increase the capacity beyond
   *   Integer.MAX_VALUE will cause the bag to fail with an
   *   arithmetic overflow.
   **/
   public void add(E element)
   {
      if (manyItems == data.length)
      {  // Ensure twice as much space as we need.
         ensureCapacity((manyItems + 1)*2);
      }
      int index;
      for (index = 0; (index < manyItems) && (element != data[index]); index++){
        // No work is needed in the body of this for-loop.
      }
         
      if (index == manyItems){
        // The target was not found, so add the item
        data[manyItems] = element;
        manyItems++;
      }
      
   }

  /**
   * Change the current capacity of this bag.
   * @param minimumCapacity
   *   the new capacity for this bag
   * @postcondition
   *   This bag's capacity has been changed to at least minimumCapacity.
   *   If the capacity was already at or greater than minimumCapacity,
   *   then the capacity is left unchanged.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for: new int[minimumCapacity].
   **/
   public void ensureCapacity(int minimumCapacity)
   {
      Object[] biggerArray;
      
      if (data.length < minimumCapacity)
      {
         biggerArray = new Object[minimumCapacity];
         System.arraycopy(data, 0, biggerArray, 0, manyItems);
         data = biggerArray;
      }
   }
   
   /**
   * Accessor method to get the current capacity of this bag. 
   * The add method works efficiently (without needing
   * more memory) until this capacity is reached.
   * @param - none
   * @return
   *   the current capacity of this bag
   **/
   public int getCapacity( )
   {
      return data.length;
   }

   /**
   * Determine the number of elements in this bag.
   * @param - none
   * @return
   *   the number of elements in this bag
   **/ 
   public int size( )
   {
      return manyItems;
   }
  
   /**
   * Reduce the current capacity of this bag to its actual size (i.e., the
   * number of elements it contains).
   * @param - none
   * @postcondition
   *   This bag's capacity has been changed to its current size.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for altering the capacity. 
   **/
   public void trimToSize( )
   {
      Object[ ] trimmedArray;
      
      if (data.length != manyItems)
      {
         trimmedArray = new Object[manyItems];
         System.arraycopy(data, 0, trimmedArray, 0, manyItems);
         data = trimmedArray;
      }
   }
      
   /**
    * Grab an element from the bag to use it but don't remove it from the bag.  Since
    * the elements are un-ordered, a random element is returned.
    * @return a random element from the bag
    */
   public E grab(){
	   int element = randNum.nextInt(manyItems);
           E result = (E)data[element];
           manyItems--;
           data[element] = data[manyItems];
	   return result;
   }
   
   /**
    * Return a String representation of the bag.
    */
   public String toString(){
	   String result = "";

	   for(int i = 0; i<manyItems; i++)
		   if(i == manyItems - 1)
			   result += data[i];
		   else {
			   result += data[i] + ", ";
		   }
	   return result;
   }
   
   
   /**
   * Generate a copy of this bag.
   * @param - none
   * @return
   *   The return value is a copy of this bag. Subsequent changes to the
   *   copy will not affect the original, nor vice versa.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public ArrayBag<E> clone()
   {  // Clone an IntArrayBag object.
	   ArrayBag<E> answer;
      
      try
      {
         answer = (ArrayBag<E>)super.clone();
      }
      catch (CloneNotSupportedException e)
      {  // This exception should not occur. But if it does, it would probably
         // indicate a programming error that made super.clone unavailable.
         // The most common error would be forgetting the "Implements Cloneable"
         // clause at the start of this class.
         throw new RuntimeException
         ("This class does not implement Cloneable");
      }
      
      answer.data = data.clone();
      
      return answer;
   }
   
}
           
