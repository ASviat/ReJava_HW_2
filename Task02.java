import java.io.BufferedReader;
import java.io.FileReader;

// Дана строка (получение через обычный текстовый файл!!!)

// "фамилия":"Иванов","оценка":"5","предмет":"Математика"
// "фамилия":"Петрова","оценка":"4","предмет":"Информатика"

// Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].

// Пример вывода в консоль:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

public class Task02 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("txtForTask02.txt"));
        StringBuilder sb = new StringBuilder();
        String incomingString;

        while ((incomingString = bufferedReader.readLine()) != null) {
            int i = 0;

            String[] x = incomingString.replaceAll("\"", "").split(",");

            sb.append("Студент ");

            sb.append(x[i].substring(x[i].indexOf(':') + 1));
            i++;
            sb.append(" получил(-а) ");
            sb.append(x[i].substring(x[i].indexOf(':') + 1));
            i++;
            sb.append(" по предмету ");
            sb.append(x[i].substring(x[i].indexOf(':') + 1) + ".");

            System.out.println(sb.toString());
            sb.delete(0, sb.length());
        }
        bufferedReader.close();
    }
}