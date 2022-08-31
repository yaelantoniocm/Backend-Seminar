import java.util.Hashtable;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Pruebas {

    public static int category_id;
    public static String category;

    static Hashtable<Integer, String> tabla_info = new Hashtable<Integer, String>();
    static Scanner datos_category = new Scanner(System.in);

    public Pruebas(int category_id, String category) {
        Pruebas.category_id = category_id;
        Pruebas.category = category;

    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        Pruebas p = new Pruebas(category_id, category);

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
                        System.out.println("\nSe eligio la opción 1");
                        p.createCategory(category);
                        break;
                    case 2:
                        System.out.println("\nHas seleccionado la opcion 2");
                        p.getCategories();
                        break;
                    case 3:
                        System.out.println("\nHas seleccionado la opcion 3");
                        p.getCategory(category_id);
                        break;
                    case 4:
                        System.out.println("\nHas seleccionado la opcion 4");
                        p.deleteCategory(category_id);
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("\nSolo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nDebes insertar un número");
                sn.next();
            }
        }
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
                    System.out.print("\nIngrese los datos de la categoria: ");
                    category = datos_category.next();
                    tabla_info.put(category_id, category);
                    System.out.println("\nLa categoria se ha registrado correctamente");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nDebes insertar un número, intenta nuevamente");
                datos_category.next();
            }

        }

    }

    // Muestra en consola la lista con todas las categorias registradas
    public void getCategories() {
        System.out.println("\nLista de categorias:\n");
        for (Integer n : tabla_info.keySet()) {
            System.out.println("Id de Categoria:\t" + n + "\nDatos:\t" + tabla_info.get(n) + "\n");
        }
    }

    // recibe desde la consola el id de una categoría y muestra sus datos
    // (category id, category)
    // @param category_id
    public void getCategory(int category_id) {
        while (true) {
            System.out.println("\nEscriba el ID de la categoria");
            try {
                category_id = datos_category.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nDebes insertar un número");
                datos_category.next();
            }
        }
        if (tabla_info.isEmpty()) {
            System.out.println("\nNo existen categorias registradas");
        } else if (tabla_info.containsKey(category_id)) {
            System.out.println("\nDatos de la categoria:\n");
            System.out.println("Datos:\t" + tabla_info.get(category_id) + "\n");
        } else {
            System.out.println("\nNo existe la categoria con el ID ingresado");
        }
    }

    // Recibe desde la consola el id de una categorıa y elimina su registro de la
    // lista
    // @param category_id
    public void deleteCategory(int category_id) {
        while (true) {
            System.out.println("\nEscriba el ID de la categoria");
            try {
                category_id = datos_category.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nDebes insertar un número");
                datos_category.next();
            }
        }
        if (tabla_info.isEmpty()) {
            System.out.println("\nNo existen categorias registradas");
        } else if (tabla_info.containsKey(category_id)) {
            tabla_info.remove(category_id);
            System.out.println("\nSe elimino la categoria con el ID ingresado");
        } else {
            System.out.println("\nNo existe la categoria con el ID ingresado");
        }
    }
}
