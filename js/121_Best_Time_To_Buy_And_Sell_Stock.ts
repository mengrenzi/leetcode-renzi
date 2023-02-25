function maxProfit(prices: number[]): number {
    let min : number = prices[0], res : number = 0;
    
    for(let i = 0; i < prices.length; i++) {
        min = Math.min(min, prices[i]);
        res = Math.max(prices[i] - min, res); 
    }
    return res;
};