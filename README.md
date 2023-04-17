# GreedyMarket

Greedy shopping. There are two markets with five different items on sale. Each market has a money point that you can spend instead of paying.
As a customer, we will buy each item and try to minimize the money spent on items. As an example, if the values are :
</br>
```
int market1Prices[] = {5,7,12,3,4};
int market2Prices[] = {8,4,9,9,6};
int market1Point = 8;
int market2Point = 18;
```
The money spent from the greedy solution should be 4 dollar with the market order
</br>
```
Markets = { MARKET1,MARKET2,MARKET2,MARKET1,MARKET1,}
```
and market points

```
Market1 points = 0
Market2 points = 5
```

For the same prices, if we had 3 and 22 as market points, respectively. The result would be;
```
Additional Money spent = 4 TL
Market1 points = 0 Market2 points = 1
Markets = { MARKET2,MARKET2,MARKET2,MARKET1,MARKET1,}
```

Try to understand how the greedy approach works by analyzing the output. Keep in mind that, when you buy a product, you can not partially pay it with points.
It is either money or points

For grading, I'm going to check the existence of functions described in below. The function signatures and their names may be different, and the output may be "slightly different" than the presented on above.
However, the main goal is minimizing the money spent...
