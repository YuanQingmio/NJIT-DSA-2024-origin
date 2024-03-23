package oy.tol.tra;


public class QueueImplementation<E> implements QueueInterface<E> {

   private Object [] itemArray;
   private int capacity;
   private int a=0;
   private int b=-1;
   private int currentIndex = -1;
   private static final int DEFAULT_Queue_SIZE = 10;

   
   public QueueImplementation() throws QueueAllocationException {
      
      capacity = DEFAULT_Queue_SIZE; 
      itemArray = new Object[DEFAULT_Queue_SIZE];
   }

   
   public QueueImplementation(int capacity) throws QueueAllocationException {
    if(capacity < 2) {
        throw new QueueAllocationException("Capacity must be at least 2.");
     }
    
     this.capacity=capacity;
     itemArray=new Object[capacity];
   }

   @Override
   public int capacity() {
      
      return capacity;
   }

   @Override
   public void enqueue(E element) throws QueueAllocationException, IllegalArgumentException {
    if (element == null) {
        throw new IllegalArgumentException("Element cannot be null.");
    }

    if (currentIndex + 1 == capacity) {
        // Resize array if necessary
        resizeArray();
    }

    if (currentIndex + 1 >= capacity) {
        throw new QueueAllocationException("Queue capacity exceeded.");
    }

    itemArray[++currentIndex] = element;
}


   @SuppressWarnings("unchecked")
   @Override
   public E dequeue() throws QueueIsEmptyException {
    if (isEmpty()) {
        throw new QueueIsEmptyException("Queue is empty.");
     }
     E dequeuedElement = (E) itemArray[a];
     System.arraycopy(itemArray, 1, itemArray, 0, currentIndex);
     itemArray[currentIndex--] = null;
     return dequeuedElement;
   }

   @SuppressWarnings("unchecked")
   @Override
   public E element() throws QueueIsEmptyException {
    if (isEmpty()) {
        throw new QueueIsEmptyException("Queue is empty.");
     }
     return (E) itemArray[a];
   
   }
   @Override
   public int size() {
      
      return currentIndex+1;
   }

   @Override
   public void clear() {
    for (int i = 0; i <= currentIndex; i++) {
        itemArray[i] = null;
    }
    currentIndex = -1;
   }

   @Override
   public boolean isEmpty() {
      
      return currentIndex == -1;
   }

   @Override
   public String toString() {
    StringBuilder builder = new StringBuilder("[");
    for (int i = 0; i <= currentIndex; i++) {
        builder.append(itemArray[i]);
        if (i < currentIndex) {
            builder.append(", ");
        }
    }
    builder.append("]");
    return builder.toString();
   }

   private void resizeArray() {
    Object[] newArray = new Object[capacity * 2];
    System.arraycopy(itemArray, 0, newArray, 0, capacity);
    capacity *= 2;
    itemArray = newArray;
  }
}

