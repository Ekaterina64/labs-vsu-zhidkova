import org.junit.Assert;
import org.junit.Test;

public class ContainerTests {

    @Test
    public void testGetElemByIndex() {
        Container<String> container = new Container<>();
        container.add_el("1");
        Assert.assertEquals("1", container.get_el(0));
    }

    @Test
    public void testAddElemToEnd() {
        Container<String> container = new Container<>();
        Assert.assertEquals(0, container.getSize());
        container.add_el("1");
        container.add_el("by");
        container.add_el("tom");
        Assert.assertEquals(3, container.getSize());
        Assert.assertEquals("tom", container.get_el(container.getSize()-1));
    }

    @Test
    public void testAddElemOnIndex() {
        Container<String> container = new Container<>();
        Assert.assertEquals(0, container.getSize());
        container.add_el("1");
        container.add_el("by");
        container.add_el(1,"tom");
        Assert.assertEquals(3, container.getSize());
        Assert.assertEquals("tom", container.get_el(1));
    }

    @Test
    public void testRemoveElem() {
        Container<String> container = new Container<>();
        container.add_el("1");
        container.add_el("2");
        Assert.assertEquals(2, container.getSize());
        container.remove("1");
        Assert.assertEquals(1, container.getSize());
        Assert.assertEquals("2", container.get_el(0));
    }

    @Test
    public void testSetElemOnIndex() {
        Container<String> container = new Container<>();
        container.add_el("1");
        container.add_el("2");
        Assert.assertEquals(2, container.getSize());
        container.set_el(0, "3");
        Assert.assertEquals(2, container.getSize());
        Assert.assertEquals("3", container.get_el(0));
    }

    @Test
    public void testContainsElem() {
        Container<String> container = new Container<>();
        container.add_el("1");
        Assert.assertTrue(container.contains("1"));
        Assert.assertFalse(container.contains("2"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        Container<String> emptyList = new Container<>();
        emptyList.get_el(0);
    }
}