import java.util.Scanner;

public class Jay {
    public static void main(String[] args) {
        System.out.printf("Добро пожаловать в игру \nХотите узнать правила? \n Напишите ответ: Да или нет\n");

        for (int i = 0; i < 10000; i++) {
            Scanner scanner = new Scanner(System.in);
            String n = scanner.nextLine();
            if ("Да".equalsIgnoreCase(n)) {
                System.out.println("Инструкция к игре для 2-5 человек");
                System.out.println("\nВ этой игре вам будут выданы карточки оружия, стихий, брони и дополнительная карта. " +
                        "После раздачи карт игроки начинают сражения друг с другом. Вы можете выбрать, чем будете сражаться: стихиями или оружием. Если выбор не будет сделан, " +
                        "или если не удастся определить выбор, он будет сделан случайным образом. Каждой карте будет присвоен уровень от 1 до 5, который будет важен в дальнейшем. ");
                System.out.println("\nВ игре есть три стихии: Вода, Лед и Огонь. Каждая стихия побеждает другую по следующему принципу:\n- Вода побеждает Огонь\n- Огонь побеждает Лед\n" +
                        "- Лед побеждает Воду");
                System.out.println("Так же есть 3 типа оружий:\n-Посох побеждает Лук\n- Лук побеждает Меч\n- Меч побеждает Посох\n\nЕсли игроки выбрали одинаковые стихии или оружие," +
                        " то побеждает тот, у кого уровень карты выше. Если уровни одинаковые, раунд пропускается.\n");
                System.out.println("Защита\n" +
                        "\n" +
                        "В случае проигрыша вас может спасти броня, представлена тремя видами:\n" +
                        "- Зачарованный барьер Огня\n" +
                        "- Зачарованный барьер Льда\n" +
                        "- Зачарованный барьер Воды\n");

                System.out.println("Каждый зачерованный барьер защищает от определенных атак:\n" +
                        "- Зачарованный барьер Огня защищает от Меча и Льда\n" +
                        "- Зачарованный барьер Льда защищает от Посоха и Воды\n" +
                        "- Зачарованный барьер Воды защищает от Огня и Лука\n" +
                        "\n" +
                        "Если вы проигрываете, но вас спасает броня, раунд считается ничьей, но вы больше не сможете использовать эту броню.\n" +
                        "\n" +
                        "Игра продолжается до тех пор, пока кто-то не выиграет 3 раза, используя одно и то же оружие или одну и ту же стихию.");
                break;
            }
            if ("Нет".equalsIgnoreCase(n)) {
                System.out.println("Хорошо");
                break;
            } else {
                System.out.println("Похоже ты неправильно ответил на вопрос или ты Антон который захотел сломать мне код");
            }
        }
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        System.out.println("\nГотов играть?");
        if ("Да".equalsIgnoreCase(n)) {
            System.out.println("сколько человек будет играть?");
            game a = new game();
            a.main();

        }
    }
}
