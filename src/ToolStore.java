public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(2, player, "Dükkan");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz!");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("1- Silahlar");
            System.out.println("2- Zırhlar");
            System.out.println("3- Çıkış Yap");
            System.out.print("Seçiminiz: ");
            int selectCase = input.nextInt();

            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Geçersiz Değer Lütfen Tekrar Giriniz: ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir Daha Bekleriz !");
                    showMenu= false;
                    break;
            }
        }
        return true;

    }


    public void printWeapon() {
        System.out.println("******** Silahlar ********");

        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "-"
                    + w.getName() + " <Para : "
                    + w.getPrice() + " , Hasar: "
                    + w.getDamage() + " >");
        }
        System.out.println("0- Çıkış Yap");
    }

    public void buyWeapon() {
        System.out.print("Bir Silah Seçiniz: ");
        int selectWeaponID = input.nextInt();

        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Geçersiz Değer Lütfen Tekrar Giriniz: ");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID !=0){
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Bakiyeniz Yetersiz!");
                } else {
                    System.out.println(selectedWeapon.getName() + " Satın Aldınız!");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Bakiye: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);

                }
            }
        }

    }

    public void printArmor() {
        System.out.println("******** Silahlar ********");

        for (Armor w : Armor.armors()) {
            System.out.println(w.getId() + "-"
                    + w.getName() + " <Para : "
                    + w.getPrice() + " , Zırh: "
                    + w.getBlock() + " >");
        }
        System.out.println("0- Çıkış Yap");

    }
    public void buyArmor(){
        System.out.print("Bir Zırh Seçiniz: ");
        int selectArmorID = input.nextInt();

        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Geçersiz Değer Lütfen Tekrar Giriniz: ");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Bakiyeniz Yetersiz!");
                } else {
                    System.out.println(selectedArmor.getName() + " Satın Aldınız!");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Bakiye: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);

                }
            }
        }

    }
}
