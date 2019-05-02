public class ArrayList<E> {
	 private Object[] elementData;
	 private int size;
	 private final int DEFAULT_INIT_CAPACITY=10;
	 private final double DEFAULT_EXPANSION_FACTOR=1.5;
	    
     public ArrayList(int capacity) {
    	 this.elementData = new Object[capacity];
    	 this.size = 0;
     }
     
     public ArrayList() {
    	 this.elementData = new Object[this.DEFAULT_INIT_CAPACITY];
    	 this.size = 0;
     }
     
     public int size() {
    	 return this.size;
     }
     
     public boolean isEmpty() {
    	 return this.size == 0;
     }

     public E get(int index) {
    	 return (E)this.elementData[index];
     }
     
     public E set(int index, Object element) {
    	 if (index > 0 && index < size) {
    		 this.elementData[index] = element;
    		 return (E)element;
    	 }
    	 else {
    		 throw new IllegalArgumentException("Set failed, index illegal.");
    	 }
     }
     
     public int indexOf(Object element) {
    	 int result = -1;//*
    	 for(int i = 0; i < this.size; i++) {
    		 if (this.elementData[i].equals(element)) {
    			 result = i;
    			 break;//*
    		 }
    	 }
    	 return result;
     }
     
     public E remove(int index) {
    	 E result = (E)this.elementData[index];
    	 for (int i = index + 1; i < this.size; i ++) {
    		 this.elementData[i-1] = this.elementData[i];
    	 }
    	 size --;
    	 return result;
     }
     
     public E remove(Object element) {
    	 int targetIndex = this.indexOf(element);
    	 if (targetIndex != -1) {
    		 return this.remove(targetIndex);
    	 }
    	 else {
    		 throw new IllegalArgumentException("Remove failed, index illegal.");
    	 }
     }
     
     public void ensureCapacity(int minCapacity){
         int oldCapacity = this.elementData.length;
         if(minCapacity > oldCapacity){
             //Do an expansion and a copy.
             Object[] oldData = this.elementData;
             int newCapacity = (int)((double)oldCapacity*this.DEFAULT_EXPANSION_FACTOR+1);
             this.elementData=new Object[newCapacity];
             System.arraycopy(oldData, 0, this.elementData, 0, this.size);
         }
     }
     
     public void add(E element){
         add(this.size, element);
     }
     
     public void add(int index, E element){
         ensureCapacity(this.size + 1);
         for (int i = this.size; i > index; i --) {
        	 this.elementData[i] = this.elementData[i-1];
         }
         this.elementData[index] = element;
         this.size ++;
     }
     
     @Override
     public String toString(){
         String result = "[";
         for(int i=0;i<this.size;i++){
             result+=this.elementData[i].toString()+",";
         }
         result=result.substring(0,result.length()-1);//Remove last comma.
         result+="]";
         return result;
     }




	public static void main(String[] args) {
	    ArrayList<String> myList = new ArrayList<>(3);
	    myList.add("apple");
	    myList.add("banana");
	    myList.add("carrot");
	    myList.add("durian");
	    myList.add("elephant");
	    System.out.println(myList);
	    System.out.println("Size: "+myList.size());
	    myList.add(1,"bear");
	    System.out.println(myList);
	    System.out.println("Size: "+myList.size());
	    myList.remove(0);
	    System.out.println(myList);
	    System.out.println("Size: "+myList.size());
	    
	    
	}
}
