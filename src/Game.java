import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera Oyununa Hoşgeldiniz!");
        System.out.print("Lütfen Bir İsim Giriniz: ");
        String playerName = input.next();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " bu karanlık ve sisli adaya hoşgeldin! Burada yaşananların hepsi gerçek!");
        player.selectChar();


        Location location;

        while (true) {
            player.printInfo();
            Location[] loc = {new SafeHouse(player), new ToolStore(player), new Cave(player), new Forest(player), new River(player)};
            System.out.println();
            System.out.println("########## Bölgeler ###########");
            System.out.println();
            System.out.println("ID: 0  \t Çıkış Yap");
            for (Location locations : loc) {
                System.out.println("ID: " + locations.getID() + "\t Lokasyon: " + locations.getName());
            }


            System.out.print("Gideceğiniz Bölgeyi Seçiniz: ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = (new SafeHouse(player));
                    break;
                case 2:
                    location = (new ToolStore(player));
                    break;
                case 3:
                    location = (new Cave(player));
                    break;
                case 4:
                    location = (new Forest(player));
                    break;
                case 5:
                    location = (new River(player));
                    break;
                default:
                    location = (new SafeHouse(player));
            }
            if (location == null) {
                System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin :)");
                break;
            }
            if (location == new SafeHouse(player)){
            if (player.getInventory().isFood() && player.getInventory().isFireWood() && player.getInventory().isWater()) {
                System.out.println("Tebrikler Oyunu Kazandınız !!!");
                break;
            }

            }
            if (!location.onLocation()) {
                System.out.println("Oyun Bitti...");
                break;
            }

        }
    }


}
