
public class Main {
    public static void main(String[] args) {
        String line = "986574312";
        System.out.println(sort(line));

    }


    public static String sort(String line) {
        if (line.length() < 2) {
            return line; // возвращаем его, как есть
        }

        // разбить на две половинки
        int mid = line.length() / 2;
        String left = line.substring(0, mid);
        String right = line.substring(mid);

        System.out.println("=== sort(" + line + ") ===");
        System.out.println("left = " + left);
        System.out.println("right = " + right);

        // отсортировать каждую
        left = sort(left);
        right = sort(right);

        // слить две половинки
        return merge(left, right);
    }


    private static String merge(String list1, String list2) {

        System.out.println("=== merge(" + list1 + ", " + list2 + ") ===");
        StringBuilder result = new StringBuilder();
        int i1 = 0;
        int i2 = 0;

        while (i1 < list1.length() && i2 < list2.length()) {
            // пока оба списка не закончились
            char first = list1.charAt(i1);
            char second = list2.charAt(i2);
            if (first < second) {
                result.append(first);
                ++i1;
            } else {
                result.append(second);
                ++i2;
            }
        }
        // покинули цикл - или list1, или list2 уже закончился

        // list1 не закончился - значит, list2 уже закончился, иначе мы были бы в цикле while
        // и можно безопасно добавлять остаток list1 в конец result
        while (i1 < list1.length()) {
            result.append(list1.charAt(i1));
            ++i1;
        }

        // list2 не закончился - значит, list1 уже закончился, иначе мы были бы в цикле while
        // и можно безопасно добавлять остаток list2 в конец result
        while (i2 < list2.length()) {
            result.append(list2.charAt(i2));
            ++i2;
        }

        System.out.println("result = " + result);
        return result.toString();
    }

}