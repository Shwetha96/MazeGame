import java.util.*;
import java.io.*;

class room
{
	int roomNo;
	int east;
	int west;
	int north;
	int south;
	room next;
}

public class MazeGame {
	static BufferedWriter bw = null;

	public static void main(String[] args) throws IOException {
		
		String  str;
		int i=0;
		room head=null;
		BufferedReader fin=null;
		//PrintWriter fout=null;
        
        File file = new File("output.txt");

			
		try
		{
			fin=new BufferedReader(new FileReader("CreateMaze.txt"));
			
			FileWriter fw = new FileWriter(file);
			while((str=fin.readLine())!=null)
			{
				String[] a=str.split(" ");
				
				
				
				head=create(a,head);
			
			}
			fin=new BufferedReader(new FileReader("TraverseMaze.txt"));
			
			while((str=fin.readLine())!=null)
			{
				String[] a=str.split(" ");
				int A[]=new int[a.length];
				for(i=0;i<a.length;i++)
				{
					A[i]=Integer.parseInt(a[i]);
					
				}
				
				int roomNo=traverse(A,head);
				 MazeGame m=new MazeGame();
				 m.Destination(roomNo,fw);
			}
			if(bw!=null)
			bw.close();
            
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

		
	}

	private static room create(String[] a,room head) {
		// TODO Auto-generated method stub
		try
		{
		int i=0;
		
		room t=new room();
		room p=head;
		
		if(head==null)
			{
				head=t;
			}
		
		
	
		
		t.next=null;
		
		t.roomNo=Integer.parseInt(a[i]);
		t.east=Integer.parseInt(a[++i]);
		t.west=Integer.parseInt(a[++i]);
		t.north=Integer.parseInt(a[++i]);
		t.south=Integer.parseInt(a[++i]);

		while(p!=null && p.next!=null)
		{
			p=p.next;
		}
                if(p!=null)
                {
		p.next=t;
		}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return head;
	}
	
	private static int traverse(int[] A,room head)
	{
		room p=head;
	
		
		int i=0,v=0;
		

		try
		{
			
			
		    while(p!=null)
		    {
		    	if(p.roomNo==A[i])
		    		break;
		    	
		    	p=p.next;
		    }
		 
		    for(i=1;i<A.length;i++)
		    {
		    	switch(A[i])
		    	{
		    	case 0:    
		    		v=p.east;
		    	           if(v!=0)
		    	           {
		    	        	   p=head;
		    	        	   while(p!=null)
		    	       	       {
		    	       	    	if(p.roomNo==v)
		    	       	    		break;
		    	       	    	
		    	       	    	p=p.next;
		    	       	       }
		    	           }
		    	          
	
		    	           break;
		    	           
		    	case 1:    v=p.west;
		
		    			   if(v!=0)
		    			   {
		        	           p=head;
		    				   while(p!=null)
		    				   {
		    					   if(p.roomNo==v)
		    						   break;
		       	    	
		    					   p=p.next;
		    				   }
		    			   }
		    			  
		    	
		    			   break;
		    			   
		    	case 2:    v=p.north;
				   		   if(v!=0)
				   		   {
	 	                       p=head;
				   			   while(p!=null)
				   			   {
				   				   if(p.roomNo==v)
				   					   break;
		    	
				   				   p=p.next;
				   			   }
				   		   }
				   		   break;
				   		   
		    	case 3:   
		    		
		    		       v=p.south;
		    			   if(v!=0)
		    			   {
                               p=head;
		    				   while(p!=null)
		    				   {
		    					   if(p.roomNo==v)
		    						   break;
		
		    					   p=p.next;
		    				   }
		    			   }
		    			   
		    			 
		    			  
		    			   break;
		    	        	   
		    	           
		    	}
		    	
		    }
		  
		   
		    System.out.println("room no="+p.roomNo);
		  
		    
		
		  
		    
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return p.roomNo;
		
	   
	}
        
        private  void Destination(int roomNo,FileWriter fw) throws IOException
        {
      	  bw = new BufferedWriter(fw);
    	  //bw.write(roomNo);
        	if(bw!=null)
        	{
        		bw.write(new Integer(roomNo).toString());
        		bw.newLine();
                bw.flush();

        	}
        		
    	  }
	}

	

