public class PolinomulDeIntamplareBinominalaTayloer {
    double binomialSeries(int n, double x) {
        double result = 0;
        for (int k = 0; k <= n; k++) {
          double term = 1;
          for (int i = 0; i < k; i++) {
            term *= (n-i)/(i+1);
          }
          term *= Math.pow(x, k);
          result += term;
        }
        return result;
      }
      
}
