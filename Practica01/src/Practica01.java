import java.util.Scanner;
import java.util.InputMismatchException;

public class Practica01 {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        Category p = new Category(Category.category_id, Category.category);

        while (!salir) {
            System.out.println("\nPresiona el número 1 si desea registrar los datos de una categoria.");
            System.out.println("\nPresiona el número 2 si desea ver la lista con todas las categorías registradas.");
            System.out.println("\nPresiona el número 3 si quiere ver los datos de un ID");
            System.out.println("\nPresiona el número 4 si desea eliminar los datos de un ID.");
            System.out.println("\nPresiona el número 5 si desea finalizar el programa.");
            System.out.println("\nEscriba una de las opciones");

            try {
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        p.createCategory(Category.category);
                        break;
                    case 2:
                        p.getCategories();
                        break;
                    case 3:
                        p.getCategory(Category.category_id);
                        break;
                    case 4:
                        p.deleteCategory(Category.category_id);
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("\nSolo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nDebes insertar un número.");
                sn.next();
            }
        }
    }

}
