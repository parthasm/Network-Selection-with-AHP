package command_line;

public class Calculate_ntw 
{
	private int num_of_ntw;
	private int srv_class;
	
	private double[][] ant = {{0.578,0.295,0.079,0.048},
		{0.062,0.168,0.184,0.587},
		{0.083,0.207,0.136,0.574},
		{0.059,0.1,0.169,0.672}};
	private double[][] ari_cs = {{.122,.648,.230,.62,.38},
								{.187,.098,.715,.52,.48},
								{.162,.087,.75,.42,.58},
								{.230,.122,.648,.666667,.33333}};
	
	private double[][] ntw ;
	
	public Calculate_ntw(int n,int sc)
	{
		num_of_ntw = n;
		srv_class = sc;

	}
	public void set_ntw(double[][] x)
	{
		ntw = x;
	}
	
	public double[][] do_it()
	{
		int i,j;
		int x;
		for(i=0;i<num_of_ntw;i++)
		{
			x = (int)ntw[i][0];
			ntw[i][0] = ant[srv_class-1][x-1];
			
		}
		//replaced ant values
		double[][] a = new double[num_of_ntw][num_of_ntw];
		double[][] r = new double[num_of_ntw][num_of_ntw];
		double[][] ic = new double[num_of_ntw][num_of_ntw];
		double[] cpb = new double[num_of_ntw];
		double[][] sec = new double[num_of_ntw][num_of_ntw];
		
		double[] a_cs = new double[num_of_ntw];
		double[] r_cs = new double[num_of_ntw];
		double[] ic_cs = new double[num_of_ntw];
		double[] sec_cs = new double[num_of_ntw];
		
		double[] a_pv = new double[num_of_ntw];
		double[] r_pv = new double[num_of_ntw];
		double[] ic_pv = new double[num_of_ntw];
		double[] sec_pv = new double[num_of_ntw];
		
		double Z = 3.00000;
		double temp,temp_indx;
		
		double[] ben = new double[num_of_ntw];
		
		double[][] ben_sort = new double[num_of_ntw][2];
		
		double sum=0.000;
		for(i=0;i<num_of_ntw;i++)
		{
			sum+=ntw[i][3];
		}
		for(i=0;i<num_of_ntw;i++)
		{
			cpb[i]=ntw[i][3]/sum;
		}
		for(i=0;i<num_of_ntw;i++)
		{
			for(j=0;j<num_of_ntw;j++)
			{
				a[i][j]= ntw[i][0]/ntw[j][0];
				r[i][j]= ntw[i][1]/ntw[j][1];
				ic[i][j]= ntw[i][2]/ntw[j][2];
				sec[i][j]= ntw[i][4]/ntw[j][4];
			}
		}
		//initialised matrices for 1st 3 criterion
		
		for(i=0;i<num_of_ntw;i++)
		{
			a_cs[i]=0;
			r_cs[i]=0;
			ic_cs[i]=0;
			sec_cs[i]=0;
			a_pv[i]=0;
			r_pv[i]=0;
			ic_pv[i]=0;
			sec_pv[i]=0;
			ben[i]=0;
		}
		//initialised column sum matrices & priority vector matrices & benefit matrix to zero
		
		for(i=0;i<num_of_ntw;i++)
		{
			for(j=0;j<num_of_ntw;j++)
			{
				a_cs[i]+= a[j][i];
				r_cs[i]+= r[j][i];
				ic_cs[i]+= ic[j][i];
				sec_cs[i]+= sec[j][i];
			}
		}
		// found column sums
		
		for(i=0;i<num_of_ntw;i++)
		{
			for(j=0;j<num_of_ntw;j++)
			{
				a[j][i] = a[j][i]/a_cs[i];
				r[j][i] = r[j][i]/r_cs[i];
				ic[j][i] = ic[j][i]/ic_cs[i];
				sec[j][i] = sec[j][i]/sec_cs[i];
			}
		}
		//normalised matrices
		
		for(i=0;i<num_of_ntw;i++)
		{
			for(j=0;j<num_of_ntw;j++)
			{
				a_pv[i]+= (a[i][j]/Z);
				r_pv[i]+= (r[i][j]/Z);
				ic_pv[i]+= (ic[i][j]/Z);
				sec_pv[i]+= (sec[i][j]/Z);
			}
		}
		//found normalised priority vectors
		
		for(i=0;i<num_of_ntw;i++)
		{
			ben[i]= ben[i]+(a_pv[i]*ari_cs[srv_class-1][0]);
			ben[i]= ben[i]+(r_pv[i]*ari_cs[srv_class-1][1]);
			ben[i]= ben[i]+(ic_pv[i]*ari_cs[srv_class-1][2]);
		}
		//found relative ranking of networks with respect to 1st 3 criteria
		
		
		
		for(i=0;i<num_of_ntw;i++)
		{
			ben[i] = (ben[i]*sec_pv[i]*ari_cs[srv_class-1][4])/(cpb[i]*ari_cs[srv_class-1][3]);
		}
		//found final relative ranking of networks
		
		
		
		
		for(i=0;i<num_of_ntw;i++)
		{
			ben_sort[i][0]= i+1;
			ben_sort[i][1]= ben[i];
		}
		for(i=1;i<num_of_ntw;i++)
		{
			temp = ben_sort[i][1];
			temp_indx = ben_sort[i][0];
			j=i-1;
			while(j>=0 && ben_sort[j][1]<temp)
			{
				ben_sort[j+1][1]=ben_sort[j][1];
				ben_sort[j+1][0]=ben_sort[j][0];
				j--;
			}
			ben_sort[j+1][1]=temp;
			ben_sort[j+1][0]=temp_indx;
		}
		//produced sorted list of networks

		return ben_sort;
	
	}
	
}

