package geocoding;

import connection.TqsBasicHttpClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeocodeTestIT {
    private AddressResolver resolver = new AddressResolver(new TqsBasicHttpClient());

    @Test
    void whenGoodAlboiGps_returnAddress() throws ParseException, IOException, URISyntaxException, org.json.simple.parser.ParseException {
        //test
        Address result = resolver.findAddressForLocation(40.640661, -8.656688);
        Address expected = new Address( "Cais do Alboi", "Glória e Vera Cruz", "Centro", "3800-246", null);

        //return
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void whenBadCoordidates_throwBadArrayindex() throws IOException, URISyntaxException, ParseException {
        assertThrows(IndexOutOfBoundsException.class, () -> resolver.findAddressForLocation(40.640661, -8.656688));
    }
}
