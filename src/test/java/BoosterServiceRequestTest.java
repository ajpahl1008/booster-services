import com.pahlsoft.booster.BoosterRequestService;
import junit.framework.Assert;
import org.junit.Test;

public class BoosterServiceRequestTest {

    @Test
    public void retrieveListOf9Items() {
        BoosterRequestService boosterRequestService = new BoosterRequestService();
        Assert.assertEquals(boosterRequestService.retrieveServerList().size(), 10);
    }


}
