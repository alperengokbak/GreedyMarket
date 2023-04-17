public class GreedyMarket {
    private static final boolean Market1 = true;
    private static final boolean Market2 = false;
    private static final int ItemCount = 5;
    private static int market1Point = 5;
    private static int market2Point = 10;

    private static int buyItems(int[] market1Prices, int[] market2Prices, boolean[] markets) {
        int additionalSpent = 0;
        int result = 0;

        for (int i = 0; i < markets.length; i++) {
            if (market1Point >= market1Prices[i] || (market2Point < market2Prices[i] && market1Prices[i] <= market2Prices[i])) {
                if (market1Prices[i] >= market2Prices[i] && market2Point > market2Prices[i]){
                    markets[i] = Market2;
                    if (market2Prices[i] > market2Point) {
                        additionalSpent = market2Prices[i] - market2Point;
                        result += additionalSpent;
                        market2Point = 0;
                        continue;
                    }
                    market2Point -= market2Prices[i];
                    continue;
                }
                markets[i] = Market1;
                if (market1Prices[i] > market1Point) {
                    additionalSpent = market1Prices[i] - market1Point;
                    result += additionalSpent;
                    continue;
                }
                market1Point -= market1Prices[i];
            } else if (market1Point < market1Prices[i] || market1Prices[i] >= market2Prices[i]) {
                markets[i] = Market2;
                if (market2Prices[i] > market2Point) {
                    additionalSpent = market2Prices[i] - market2Point;
                    result += additionalSpent;
                    market2Point = 0;
                    continue;
                }
                market2Point -= market2Prices[i];
            }
        }
        return result;
    }

    private static void printMarkets(boolean[] markets){
        for (int i = 0; i < markets.length; i++) {
            System.out.print("Item " + (i+1) + " bought from ");
            if (markets[i] == Market1) {
                System.out.println("MARKET1");
            } else if (markets[i] == Market2) {
                System.out.println("MARKET2");
            }
        }
    }

    public static void main(String[] args) {
        int[] market1Prices = {5, 7, 12, 3, 4};
        int[] market2Prices = {8, 4, 9, 9, 6};
        boolean[] markets = new boolean[ItemCount];

        int additionalMoneySpent = buyItems(market1Prices, market2Prices, markets);
        System.out.println("Additional Money spent: " + additionalMoneySpent);
        System.out.println("Market1 points = " + market1Point + "\n" + "Market2 points = " + market2Point + "\n");
        printMarkets(markets);
    }
}
