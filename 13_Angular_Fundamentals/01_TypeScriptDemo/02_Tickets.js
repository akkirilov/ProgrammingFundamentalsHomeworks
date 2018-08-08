var Ticket = (function () {
    function Ticket(destination, price, status) {
        this.destination = destination;
        this.price = price;
        this.status = status;
    }
    return Ticket;
}());
function getTicketsData(destinations, sortCriteria) {
    var tickets = [];
    destinations.forEach(function (x) {
        var tempArr = x.split('|');
        tickets.push(new Ticket(tempArr[0], Number(tempArr[1]), tempArr[2]));
    });
    if (sortCriteria === 'destination') {
        tickets = tickets.sort(function (a, b) {
            return a.destination.localeCompare(b.destination);
        });
    }
    else if (sortCriteria === 'price') {
        tickets = tickets.sort(function (a, b) {
            return a.price - b.price;
        });
    }
    else {
        tickets = tickets.sort(function (a, b) {
            return a.status.localeCompare(b.status);
        });
    }
    console.log(tickets);
}
getTicketsData(['Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'], 'price');
