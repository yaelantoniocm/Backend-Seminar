import java.util.Hashtable;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Category {
    public static int category_id;
    public static String category;

    static Hashtable<Integer, String> tabla_info = new Hashtable<Integer, String>();
    static Scanner datos_category = new Scanner(System.in);

    public Category(int category_id, String category) {
        Category.category_id = category_id;
        Category.category = category;

    }

    // Recibe desde la consola de comandos los datos de un objeto Category y los
    // registra en una lista.
    // @param category: String category
    public void createCategory(String category) {
        while (true) {
            System.out.println("\nEscriba el ID de la categoria que desea registrar:");
            try {
                category_id = datos_category.nextInt();
                if (tabla_info.containsKey(category_id)) {
                    System.out.println("\nEl ID ya existe, vuelva a intentarlo.");
                    // break;
                } else {
                    System.out.print("\nIngrese los datos de la categoria que se va a registrar: ");
                    category = datos_category.next();
                    tabla_info.put(category_id, category);
                    System.out.println("\nLa categoria se ha registrado correctamente.\n");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nDebes insertar un número, intenta nuevamente.");
                datos_category.next();
            }

        }

    }

    // Muestra en consola la lista con todas las categorias registradas
    public void getCategories() {
        if (tabla_info.isEmpty()) {
            System.out.println("\nNo hay categorias registradas");
        } else {
            System.out.println("\nLista de categorias:");
            for (Integer n : tabla_info.keySet()) {
                System.out.println("Id de Categoria:\t" + n + "\nDatos:\t" + tabla_info.get(n) + "\n");
            }
        }
    }

    // Recibe desde la consola el id de una categoría y muestra sus datos
    // (category id, category)
    // @param category_id
    public void getCategory(int category_id) {
        while (true) {
            if (tabla_info.isEmpty()) {
                System.out.println("\nNo existen categorias registradas.");
                break;
            }
            try {
                System.out.println("\nEscriba el ID de la categoria que desea ver:");
                category_id = datos_category.nextInt();
                if (tabla_info.containsKey(category_id)) {
                    System.out.println("\nDatos de la categoria:\n");
                    System.out.println("Datos:\t" + tabla_info.get(category_id) + "\n");
                    break;
                } else {
                    System.out.println("\nNo existe la categoria con el ID ingresado. Busque Nuevamente");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nDebes insertar un número, vuelve a intentarlo.");
                datos_category.next();
            }
        }

    }

    // Recibe desde la consola el id de una categorıa y elimina su registro de la
    // lista
    // @param category_id
    public void deleteCategory(int category_id) {
        while (true) {
            if (tabla_info.isEmpty()) {
                System.out.println("\nNo existen categorias registradas.");
                break;
            }
            try {
                System.out.println("\nEscriba el ID de la categoria que desea eliminar:");
                category_id = datos_category.nextInt();
                if (tabla_info.containsKey(category_id)) {
                    tabla_info.remove(category_id);
                    System.out.println("\nSe elimino la categoria con el ID ingresado.");
                    break;
                } else {
                    System.out.println("\nNo existe la categoria con el ID ingresado. Vuelva a buscar.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nDebes insertar un número");
                datos_category.next();
            }
        }

    }
}
