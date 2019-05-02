# Array (contiguous strorage)
## Create an array
1) String[] names = new String[5];
2) int[] scores = new int {100, 99, 60};
## Benifits
random access
## Drawbacks
1) Fixed size
2) no support for insert or delete
## Example
``` Java
public class Arrays{
	public static void main (String[] args){
		int[] x = {0,1,2,3,4};
		int index=0;
		
		//Selection
		//Find the element with value = 3
		int target=3;
		for(int i=0;i<x.length;i++){
			if(x[i]==target){
				System.out.println("Target value was found at position "+i);
				index=i;
			}
		}
		
		//Accessing the element
		int myValue=x[index];
		
		//Inserting an element
		//Insert a value of 8 at position 3.
		int newValue=8;
		int insertPosition=3;
		boolean insertMade=false;
                
		int[] temp = new int[x.length+1];
		for(int i=0;i<x.length;i++){
			if(i==insertPosition && !insertMade){
				temp[i]=newValue; 
				insertMade=true; 
				i--;
			}   //Executed during the insertion.
			else if(i>=insertPosition && insertMade){
				temp[i+1]=x[i];
			} //Executed after the insertion.
			else{
				temp[i]=x[i];
			} //Executed before the insertion.
		}
		x=temp;
		
		//Print the array
		for(int i=0;i<x.length;i++){
			System.out.print(x[i]+" ");
		}
		System.out.println();
		
                
		//Deleting an element
		//Delete element at position 3.
		int deletePosition=3;
		
		
		temp=new int[x.length-1];
		for(int i=0;i<=temp.length;i++){
			if(i==deletePosition ){continue;} //Executed during the deletion.
			else if(i>=deletePosition ){
				temp[i-1]=x[i];
			} //Executed after the deletion.
			else{
				temp[i]=x[i];
			} //Executed before the deletion.
		}
		x=temp;
		
		//Print the array
		for(int i=0;i<x.length;i++){
			System.out.print(x[i]+" ");
		}
                System.out.println();
	}
}
```
