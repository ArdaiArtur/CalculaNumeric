public class MetodaLuiNewtonPeSistemeNeliniare {
    
    private double []x;
    private double []y;
    private double eps;
    private int n;
    public   MetodaLuiNewtonPeSistemeNeliniare(int n,double[]x,double[]y)
    {
        this.x=x;
        this.y=y;
        this.n=n;
        this.eps=0.00001;
    }
//can you give me newton's method for nonlinear systems in java code
    public void afis()
    {
        double[]j=new double[n+1];
        j[0]=dF1(x[0], y[0])*dG2(x[0], y[0])-dF2(x[0], y[0])*dG1(x[0], y[0]);
        x[1]=x[0]-(F(x[0], y[0])*dG2(x[0], y[0])-G(x[0], y[0])*dF2(x[0], y[0]))/j[0];
        y[1]=y[0]-(dF1(x[0], y[0])*G(x[0], y[0])-dG1(x[0], y[0])*F(x[0], y[0]))/j[0];
        for (int i = 1; i <n; i++) {
            if(Math.abs(x[n]-x[n-1])>=eps ||Math.abs(y[n]-y[n-1])>=eps)
            {
                j[i]=dF1(x[i], y[i])*dG2(x[i], y[i])-dF2(x[i], y[i])*dG1(x[i], y[i]);    
                x[i+1]=x[i]-(F(x[i], y[i])*dG2(x[i], y[i])-G(x[i], y[i])*dF2(x[i], y[i]))/j[i];
                y[i+1]=y[i]-(dF1(x[i], y[i])*G(x[i], y[i])-dG1(x[i], y[i])*F(x[i], y[i]))/j[i];
        
            }
        }
        System.out.println("x[n]");
        for (int i = 1; i < j.length; i++) {
            System.out.print(x[i]+" ");
        }
        System.out.println("y[n]");
        for (int i = 1; i < j.length; i++) {
            System.out.print(y[i]+" ");
        }

    }

    private double F(double x,double y)
    {
        return 2*Math.pow(x, 3)-Math.pow(y, 2)-1;
    }
    private double G(double x,double y)
    {
        return x*Math.pow(y, 3)-y-4;
    }
    private double dF1(double x,double y)
    {
        return Math.pow(x, 2)*6;
    }
    private double dF2(double x,double y)
    {
        return -2*y;
    }
    private double dG1(double x,double y)
    {
        
        return Math.pow(y, 3);
    }
    private double dG2(double x,double y)
    {
        return 3*x*Math.pow(y, 2)-1;        
    }





public static void main(String[] args) {
   int n=8;
    double[]x=new double[n+1];
    double[]y=new double[n+1];
      MetodaLuiNewtonPeSistemeNeliniare a=new MetodaLuiNewtonPeSistemeNeliniare(n,x,y);
    a.afis();
}
}
