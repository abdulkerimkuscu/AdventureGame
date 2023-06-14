import java.util.Scanner;

public class Player {
    private int damage, health, money, defaultHealth;
    private String name, charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;
    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        GameChar[] charList = {new Samurai(), new Archer(), new Knigth()};
        System.out.println("Karakterler");
        System.out.println("---------------------------");
        for (GameChar gameChar : charList) {
            System.out.println("ID: " + gameChar.getId() +
                    "\tKarater: " + gameChar.getName() +
                    "\t\t Hasar: " + gameChar.getDamage() +
                    "\t\t Sağlık: " + gameChar.getHealth() +
                    "\t\t Para: " + gameChar.getMoney());
        }
        System.out.println("---------------------------");
        System.out.print("Lütfen Bir Karakter Seçiniz: ");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knigth());
                break;
            default:
                initPlayer(new Samurai());

        }

    }

    public void printInfo(){
        System.out.println("Karakteriniz: " + getCharName() + ", " +
                "Silahınız: " + getInventory().getWeapon().getName() + ", " +
                "Zırhınız: " + getInventory().getArmor().getName() + ", " +
                "Engellemeniz: " + getInventory().getArmor().getBlock() + ", " +
                "Hasarınız: " + getTotalDamage() + ", " +
                "Sağlığınız: " + getHealth() + ", " +
                "Paranız: " + getMoney() + ", " );

    }


    public void initPlayer(GameChar gameChar) {
        this.setCharName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setDefaultHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());

    }
    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health<0){
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int rHealth) {
        this.defaultHealth = rHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
