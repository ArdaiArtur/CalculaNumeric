public class MLNPSNL {
    

    private static double f1(double x, double y) {
        return 2 * Math.pow(x, 3) - Math.pow(y, 2) - 1;
    }
    
    private static double f2(double x, double y) {
        return x * Math.pow(y, 3) - y - 4;
    }
    
    // The derivatives of the equations in the nonlinear system
    private static double df1dx(double x, double y) {
        return Math.pow(x, 2) * 6;
    }
    
    private static double df1dy(double x, double y) {
        return -2 * y;
    }
    
    private static double df2dx(double x, double y) {
        return Math.pow(y, 3);
    }
    
    private static double df2dy(double x, double y) {
        return 3 * x * Math.pow(y, 2) - 1;
    }
    
    // Compute the Jacobian matrix using the derivatives of the equations
    private static double[][] computeJacobian(double x, double y) {
        double[][] jacobian = new double[2][2];
        jacobian[0][0] = df1dx(x, y);
        jacobian[0][1] = df1dy(x, y);
        jacobian[1][0] = df2dx(x, y);
        jacobian[1][1] = df2dy(x, y);
        return jacobian;
    }
    
    // Compute the inverse of the Jacobian matrix
    private static double[][] computeInverseJacobian(double[][] jacobian) {
        double determinant = jacobian[0][0] * jacobian[1][1] - jacobian[0][1] * jacobian[1][0];
        double[][] inverseJacobian = new double[2][2];
        inverseJacobian[0][0] = jacobian[1][1] / determinant;
        inverseJacobian[0][1] = -jacobian[0][1] / determinant;
        inverseJacobian[1][0] = -jacobian[1][0] / determinant;
        inverseJacobian[1][1] = jacobian[0][0] / determinant;
        return inverseJacobian;
    }

/* 
    private static double[] newtonStep(double x, double y, double[][] jacobian) {
        double[] f = new double[] { f1(x, y), f2(x, y) };
        double[][] inverseJacobian = computeInverseJacobian(jacobian);
    
        double deltaX = inverseJacobian[0][0] * f[0] + inverseJacobian[0][1] * f[1];
        double deltaY = inverseJacobian[1][0] * f[0] + inverseJacobian[1][1] * f[1];
    
        return new double[] { x - deltaX, y - deltaY };
    }
    */



    public static void main(String[] args) {
        // Set the initial guess for the solution
        double x = 1;
        double y = 1;
    
        // Set the maximum number of iterations and the tolerance
        int maxIterations = 100;
        double tolerance = 1e-6;
    
        // Iterate until the solution converges or the maximum number of iterations is reached
        for (int i = 0; i < maxIterations; i++) {
            // Compute the functions and the Jacobian matrix
            double f1 = f1(x, y);
            double f2 = f2(x, y);
            double[][] jacobian = computeJacobian(x, y);
    
            // Compute the inverse of the Jacobian matrix
            double[][] inverseJacobian = computeInverseJacobian(jacobian);
    
            // Compute the change in the variables
            double dx = -(inverseJacobian[0][0] * f1 + inverseJacobian[0][1] * f2);
            double dy = -(inverseJacobian[1][0] * f1 + inverseJacobian[1][1] * f2);
    
            // Update the variables
            x += dx;
            y += dy;
    
            // Check for convergence
            if (Math.abs(dx) < tolerance && Math.abs(dy) < tolerance) {
                break;
            }
        }
    
        // Print the solution
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
    
}
