import java.util.Random;

public class Polynom {

    static final int MAX_A = 10;
    Random rand = new Random();
    //coefficients
    int[] Array = null;
    //degree of the polynomial
    int n = -1;

    //calculating the degree of a polynomial
    public int getN() {
        return this.n;
    }

    public Polynom() {
        int st = rand.nextInt(MAX_A);
        assert(st >= 0);
        int array[] = new int[st + 1];
        for(int i = 0; i < st; i++) {
            array[i] = rand.nextInt() % (i + 1);
        }
        this.Array = array;
        this.n = st;
    }

    public Polynom(int m) {
        assert(m > 0);
        this.n = m + 1;
        int array[] = new int [n];
        for(int i = 0; i < n; i++) {
            array[i] = rand.nextInt() % (i + 1);
        }
        this.Array = array;
    }

    public Polynom(int[] array) {
        assert(array != null);
        n = array.length;
        this.Array = new int[array.length];
        for(int i = 0; i < n; i++)
            this.Array[i] = array[i];
    }

    public Polynom(Polynom p) {
        if (this.Array != null) {
            this.n = p.n;
            this.Array = p.Array;
        }
        this.n = p.n;
        this.Array = p.Array;
    }

    //output of the polynomial
    public void output() {
        assert(this.Array != null);
        boolean k = false;
        for(int i = n -1; i >=0; i--)
            if (this.Array[i] != 0)
                k = true;
        if (k == true) {
            for(int i = n - 1; i >= 0; i--) {
                if(this.Array[i] != 0) {
                    if ((this.Array[i - 1] > 0) && (i != 1))
                        System.out.print(this.Array[i] + "*x^" + i + " +");
                    else
                        System.out.print(this.Array[i] + "*x^" + i + " ");
                }
            }
            System.out.print("\n");
            System.out.print("full output of the polynomial:	");
            for(int j = n - 1; j > 0; j--) {
                if (this.Array[j - 1] >= 0 )
                    System.out.print(this.Array[j] + "*x^" + j + " + ");
                else
                    System.out.print(this.Array[j] + "*x^" + j + " ");
            }
            System.out.print(this.Array[0]);
            //System.out.print("\n");
        }
        else
            System.out.print(0);
    }

    //sum of polynomials
    public void add(Polynom P1, Polynom P2) {
        assert(P1.Array != null);
        assert(P2.Array != null);
        Polynom pol_S;
        if (P1.getN() > P2.getN()) {
            pol_S = P1;
            for(int i = 0; i < P2.getN(); i++)
                pol_S.Array[i] += P2.Array[i];
        }
        else {
            pol_S = P2;
            for(int i = 0; i < P1.getN(); i++)
                pol_S.Array[i] += P1.Array[i];
        }
        this.n = pol_S.n;
        this.Array = pol_S.Array;
    }

    //multiplying polynomials
    public void multiplication(Polynom P1, Polynom P2) {
        assert(P1.Array != null);
        assert(P2.Array != null);
        int m;
        if (P1.getN() == 0 && P2.getN() == 0)
            m = 0;
        else
            m = P1.getN() + P2.getN() - 1;
        int Mult[] = new int [m];
        for(int i = 0; i < m; i++) {
            Mult[i] = 0;
        }
        for(int i = 0; i < P1.getN(); i++) {
            for(int j = 0; j < P2.getN(); j++)
                Mult[i+j] += P1.Array[i]*P2.Array[j];
        }
        this.n = m;
        this.Array = Mult;
    }
}
