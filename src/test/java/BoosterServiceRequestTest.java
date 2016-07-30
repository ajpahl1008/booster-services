import com.pahlsoft.booster.com.pahlsoft.booster.service.BoosterRequestService;
import org.junit.Assert;
import org.junit.Test;

public class BoosterServiceRequestTest {

    static BoosterRequestService boosterRequestService = new BoosterRequestService();

    @Test
    public void retrieveListOfItemsShouldBe10() {
        Assert.assertEquals(boosterRequestService.retrieveServerList().size(), 10);
    }

    @Test
    public void findServerByOwnerShouldBe10() {
        Assert.assertEquals(boosterRequestService.findServersByOwnerId("x1234111").size(),10);
    }

}
