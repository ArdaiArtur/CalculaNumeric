/**
 * MetLuiJacobi
 */
public class MetLuiJacobi {

    public static void main(String[] args) {
        double eps=0.0001;
        int n=3;
    double[] b =new double []{10,4,-7};
        double [][]a=new double[][]{{5,1,1},{1,6,4},{1,1,10}};
        System.out.println("nu");
        calc(n, b, a,eps);
    }

    public static void calc(int n,double[] b,double[][]a,double eps )
    {
        
        double [][]x=new double [n][n];
        for (int i = 0; i < n; i++) {
            x[0][i]=b[i]/a[i][i];
        }
        
        double max=0;
        int k=0;
        do
        {   
            
            for (int i = 0; i <n; i++) {
                double S1=0;
                for (int j = 0; j < n; j++) {
                    if(j!=i)
                    {
                        //poate aici
                        S1=S1+a[i][j]*x[k-1][j];
                         x[k][i]=(b[i]-S1)/a[i][i];
                    }
                   
                }
                
            
            }
            double S=0;
            for (int i = 0; i <n; i++) {
                S+= Math.abs(x[k][i]-x[k-1][i]);
            }
            
      
        }while(max>=eps);

        for (int i = 0; i <n; i++) {
            System.out.println(x[k][i]+"nu ");           
        }
    }
}