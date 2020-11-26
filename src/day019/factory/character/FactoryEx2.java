package day019.factory.character;

public class FactoryEx2 {
    public static void main(String[] args) {
        CharacterFactory characterFactory = new CharacterFactory();
        characterFactory.create(new AType());

        characterFactory.m_weapon.drawWeapon();
        characterFactory.m_bomb.drawBomb();

        characterFactory.create(new BType());

        characterFactory.m_weapon.drawWeapon();
        characterFactory.m_bomb.drawBomb();
    }
}

class CharacterFactory {
    public Weapon m_weapon;
    public Bomb m_bomb;
    public void create(AbstractItem item) {
        m_weapon = item.createWeapon();
        m_bomb = item.createBomb();
    }
}

interface AbstractItem {
    Weapon createWeapon();
    Bomb createBomb();
}


class AType implements AbstractItem {
    /* Gun, C4 */

    @Override
    public Weapon createWeapon() {
        return new Gun();
    }

    @Override
    public Bomb createBomb() {
        return new C4();
    }
}

class BType implements AbstractItem {
    /* Sword, Dynamite */

    @Override
    public Weapon createWeapon() {
        return new Sword();
    }

    @Override
    public Bomb createBomb() {
        return new Dynamite();
    }
}


interface Weapon {
    void drawWeapon();
}

class Gun implements Weapon {
    @Override
    public void drawWeapon() {
        System.out.println("Weapon : Gun");
    }
}

class Sword implements Weapon {
    @Override
    public void drawWeapon() {
        System.out.println("Weapon : Sword");
    }
}


interface Bomb {
    void drawBomb();
}

class Dynamite implements Bomb {
    @Override
    public void drawBomb() {
        System.out.println("Bomb : Dynamite");
    }
}

class C4 implements Bomb {
    @Override
    public void drawBomb() {
        System.out.println("Bomb : C4");
    }
}