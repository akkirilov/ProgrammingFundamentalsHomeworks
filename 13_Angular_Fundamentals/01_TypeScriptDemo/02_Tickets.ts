
class Ticket {
    public destination : String;
    public price : Number;
    public status : String;

    constructor(destination : String, price : Number, status : String) {
        this.destination = destination;
        this.price = price;
        this.status = status;
    }
}

function getTicketsData(destinations : Array<String>, sortCriteria : String) {
	
    let tickets = [];
    
    destinations.forEach(x => {
        let tempArr = x.split('|');
        tickets.push(new Ticket(tempArr[0], Number(tempArr[1]), tempArr[2]));
    });
	
    if (sortCriteria === 'destination') {
        tickets = tickets.sort((a, b) => {
            return a.destination.localeCompare(b.destination);
        });
    } else if (sortCriteria === 'price') {
        tickets = tickets.sort((a, b) => {
            return a.price - b.price;
        });
    } else {
        tickets = tickets.sort((a, b) => {
            return a.status.localeCompare(b.status);
        });
    }
    
    console.log(tickets);
    
}

getTicketsData(['Philadelphia|94.20|available',
             'New York City|95.99|available',
             'New York City|95.99|sold',
             'Boston|126.20|departed'],
            'price');
