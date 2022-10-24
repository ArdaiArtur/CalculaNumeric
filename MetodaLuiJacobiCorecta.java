public class MetodaLuiJacobiCorecta {
    public static void main(String[] args) {
        double eps=0.001;
        int n=3;
    double[] b =new double []{-2,1,4};
        double [][]a=new double[][]{{3,-1,1},{0,4,1},{1,1,5}};
        double[]y=new double[]{-0.66,0.25,0.8};
        Jac(n, b, a,y,eps);
    }
//ax=x+R cos(alfa)
//x=x+R cos(alfa)
    public static void Jac(int n,double[]b,double[][]a,double[]y,double eps)
    {
        double[]x=new double[n];
        double s=eps+1;double s1=0;
         while(s>=eps)
         {
            for (int i = 0; i < n; i++) {
                s1=0;
                for (int j = 0; j < n; j++) {
                    if(j!=i)
                    {
                        s1+=a[i][j]*y[j];
                        x[i]=(b[i]-s1)/a[i][i];
                    
                    }
                }
            }
            s=0;
            for (int i = 0; i < n; i++) {
                    s+=Math.abs(x[i]-y[i]);
            }
            for (int i = 0; i < n; i++) {
                y[i]=x[i];
            }
        }
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]+" ");
        }
    }
}
