package utils.urlBuilder;

/**
 * Created by SYSTEM on 26.04.2017.
 */
public class UrlTest {
    public static void main(String[] args) {
        String url = new UrlBuilder()
                .withProtocol(true)
                .withDomain("andreyb.ixloo.com")
                .withPort("9000")
                .withPass("cars-for-sale")
                .withParams("debug", "true")
                .withParams("version","1.5.2")
                .withAnchor("#cars")
                .builder();



        System.out.println(url);
    }
}
