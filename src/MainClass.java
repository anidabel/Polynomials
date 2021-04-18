public class MainClass {

    public static void main(String[] args) {
        System.out.print("polynom 1:	");
        Polynom Pol1 = new Polynom();
        Pol1.output();
        System.out.print('\n');

        System.out.print("\npolynom 2:	");
        Polynom Pol2 = new Polynom();
        Pol2.output();
        System.out.print("\n\n");

        Polynom Sum = new Polynom();
        Sum.add(Pol1, Pol2);
        System.out.print("sum of polynomials 1 & 2:	");
        Sum.output();
        System.out.print("\n\n");

        Polynom Mult = new Polynom();
        Mult.multiplication(Pol1, Pol2);
        System.out.print("multiplying polynomials 1 & 2:	");
        Mult.output();
        System.out.print('\n');

    }

}
