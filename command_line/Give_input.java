package command_line;
import java.io.*;

public class Give_input
{

	
	public static void main(String[] args) throws IOException 
	{
		int num_of_ntw=0;
		int srv_cls=0;
		double[][] rank;
		System.out.println("Enter number of networks");
      	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      	num_of_ntw = Integer.parseInt(br.readLine());
      	System.out.println("Enter 1,2,3 or 4 as the running service class (1 for Conversational,2 for Streaming,3 for Interactive and 4 for Background)");
      	br = new BufferedReader(new InputStreamReader(System.in));
      	srv_cls = Integer.parseInt(br.readLine());
      	
      	double[][] ntw = new double[num_of_ntw][5];
      	int col,j,i;
      	String read_line;
      	for(i=0;i<num_of_ntw;i++)
      	{
      		System.out.println("Enter ANT,RP,IC,CB,SE values for network "+(i+1)+" separated by '-' between each value.Eg:2-3-4-5-6");
      		br = new BufferedReader(new InputStreamReader(System.in));
      		read_line = br.readLine();
			col=0;
			while(read_line.indexOf("-")!=-1)
			{
				
				j=read_line.indexOf("-");
				ntw[i][col++] = Double.parseDouble(read_line.substring(0,j));
				read_line=read_line.substring(j+1);
			}
			ntw[i][col++] = Double.parseDouble(read_line);
      		
      	}
      	
      	Calculate_ntw obj=new Calculate_ntw(num_of_ntw,srv_cls);
      	obj.set_ntw(ntw);
      	rank = obj.do_it();
      	/*for(i=0;i<num_of_ntw;i++)
		{
			for(j=0;j<5;j++)
				System.out.print(ntw[i][j]+"\t");
			System.out.println();
		}*/
      	for(i=0;i<num_of_ntw;i++)
   		{

    				System.out.println(rank[i][0]+"\t"+rank[i][1]);

    		}
	}

}
