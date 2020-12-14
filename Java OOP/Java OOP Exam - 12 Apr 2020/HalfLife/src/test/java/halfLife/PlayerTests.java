package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTests {
    Player player;
    @Before
    public void setUp() {
        player = new Player("Kiki", 100);
        player.addGun(new Gun("Kobra", 100));
    }

    @Test
    public void testGetUsername() {
        Assert.assertEquals(player.getUsername(), "Kiki");
    }

    @Test(expected = NullPointerException.class)
    public void testReturnExceptionWhenUsernameIsNull() {
        Player player = new Player(null, 100);
    }

    @Test(expected = NullPointerException.class)
    public void testReturnExceptionWhenUsernameIsBlank() {
        Player player = new Player(" ", 100);
    }

    @Test
    public void testReturnTheRightAmountOfHealth() {
        Assert.assertEquals(player.getHealth(), 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetWrongAmountOfHealth() {
        Player player = new Player("K", -1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testListUnmodifiable() {
        player.getGuns().add(new Gun("Kobra", 100));
    }

    @Test
    public void testTakenDamage() {
        player.takeDamage(50);
        Assert.assertEquals(player.getHealth(), 50);
    }

    @Test(expected = IllegalStateException.class)
    public void testPlayerIsAlreadyDead() {
        player.takeDamage(100);
        player.takeDamage(1);
    }

    @Test(expected = NullPointerException.class)
    public void testThrowExceptionWhenAddingNullGun() {
        player.addGun(null);
    }

    @Test
    public void testFindsGun() {
        player.getGun("Kobra");
    }

    @Test
    public void testReturnNullIfNoSuchGunExists() {
        Assert.assertNull(player.getGun(" "));
    }

    @Test
    public void testRemovesGun() {
        player.removeGun(player.getGun("Kobra"));
        Assert.assertEquals(0, player.getGuns().size());
    }

    @Test
    public void testGunBullets() {
        Assert.assertEquals(100, player.getGun("Kobra").getBullets());
    }

    @Test
    public void testHealthNeverNegative() {
        player.takeDamage(101);
        Assert.assertEquals(0, player.getHealth());
    }

}
