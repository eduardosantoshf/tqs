import java.util.ArrayList;

public class StocksPortfolio {
    private String name;
    private IStockMarket market;
    private ArrayList<Stock> stocks = new ArrayList<>();

    public IStockMarket getMarketService() {
        return this.market;
    }

    public void setMarketService(IStockMarket market) {
       this.market = market;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalValue() {
        double totalValue = 0;

        for (Stock s: this.stocks) {
            totalValue += (market.getPrice(s.getName()) * s.getQuantity());
        }

        return totalValue;
    }

    public void addStock(Stock stock) {
        this.stocks.add(stock);
    }
}
