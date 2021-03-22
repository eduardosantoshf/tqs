import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StocksPortfolioTest {

    @Mock
    IStockMarket market;

    @InjectMocks
    StocksPortfolio portfolio;

    @BeforeEach
    public void setUp() {
        portfolio.setName("Pedro Basta");
    }

    @Test
    public void getTotalValue() {
        portfolio.addStock(new Stock("Testa", 689));
        portfolio.addStock(new Stock("Pear", 123));

        when(market.getPrice("Testa")).thenReturn(26.0);
        when(market.getPrice("Pear")).thenReturn(8.0);

        double total = 689 * 26 + 123 * 8;

        assertThat(portfolio.getTotalValue(), is(total));

        verify(market, times(2)).getPrice(anyString());
    }
}
