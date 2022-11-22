function convertCurrency(rates, from, to) {
    const graph = {};
    for (const [f, t, rate] of rates) {
        if (!graph.hasOwnProperty(t)) graph[t] = [];
        if (!graph.hasOwnProperty(f)) graph[f] = [];

        graph[f].push([t, rate]);
        graph[t].push([f, 1/rate]);
    }
    console.log("graph", graph)

    const visited = new Set();
    let minRate = Number.MIN_SAFE_INTEGER;

    function convertCurrencyHelper(currency, currRate) {
        if (currency === to) {
            minRate = Math.min(minRate, currRate);
            return;
        }

        visited.add(currency);
        const neighbors = graph[currency];

        for (const [neighbor, rate] of neighbors) {
            if (!visited.has(neighbor)) {
                convertCurrencyHelper(neighbor, currRate*rate);
            }
        }
    }

    convertCurrencyHelper(from, 1);

    return minRate;
}

const rates = [['USD', 'JPY', 110], ['USD', 'AUD', 1.45], ['JPY', 'GBP', 0.0070]];
const from = 'GBP';
const to = 'AUD';

console.log(convertCurrency(rates, from, to));