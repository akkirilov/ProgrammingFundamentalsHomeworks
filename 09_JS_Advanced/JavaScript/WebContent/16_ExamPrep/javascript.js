// 01. Select and Print
function move(command) {
	if (command === "right") {
		$('#selected-towns').append($('#available-towns :selected'));
	} else if (command === "left") {
		$('#available-towns').append($('#selected-towns :selected'));
	} else if (command === "print") {
		$('#output').text($('#selected-towns option').toArray().map(x => x.value).join('; ')); 
	}
}

// 02. Sumator Class
// Tests in p16_ExamPrep
class Sumator {
	constructor() {
	  this.data = [];
	}
	add(item) {
	  this.data.push(item);
	}
	sumNums() {
	  let sum = 0;
	  for (let item of this.data)
	    if (typeof (item) === 'number') {
	    	sum += item;
	    }
	  	return sum;
	}
	removeByFilter(filterFunc) {
		this.data = this.data.filter(x => !filterFunc(x));
	}
	toString() {
		if (this.data.length > 0) {
			return this.data.join(", ");
		} else {
			return '(empty)';
		}
	}
}

// 03. Task
class Task {
	constructor(title, deadline) {
		this.title = title;
		this.deadline = deadline;
		this.status = "Open";
	}
	
	get deadline() {
		return this._deadline;
	}
	set deadline(deadline) {
		if (deadline < Date.now()) {
			throw new Error('Deadline cannot be set to a past date!');
		}
		this._deadline = deadline;
	}
	get isOverdue() {
		if (this.status === 'Completed') {
			return false;
		}
		return this.deadline < Date.now();
	}
	rank() {
		if(this.isOverdue && this.status != "Complete") {
			return 0;
		} else if(this.status === "In Progress") {
			return 1;
		} else if (this.status === "Open") {
			return 2;
		}  else if(this.status === "Complete") {
			return 3;
		}
	}
	static comparator(a, b) {
		let res = a.rank() - b.rank();
		if (res === 0) {
			return b.deadline < a.deadline;
		}
		return res;
	}
	toString() {
		let symbol;
		if (this.isOverdue && this.status !== "Complete") {
			symbol = '\u26A0';
			return `[${symbol}] ${this.title} (overdue)`;
		} else if (this.status === "Open") {
			symbol = '\u2731';
		} else if(this.status === "In Progress") {
			symbol = '\u219D';
		} else if(this.status === "Complete") {
			symbol = '\u2714';
			return `[${symbol}] ${this.title}`;
		}
		
		return `[${symbol}] ${this.title} (deadline: ${this.deadline})`;
	}
}
//let date1 = new Date();
//date1.setDate(date1.getDate() + 7); // Set date 7 days from now
//let task1 = new Task('JS Homework', date1);
//let date2 = new Date();
//date2.setFullYear(date2.getFullYear() + 1); // Set date 1 year from now
//let task2 = new Task('Start career', date2);
//console.log(task1 + '\n' + task2);
//console.log('===========');
//let date3 = new Date();
//date3.setDate(date3.getDate() + 3); // Set date 3 days from now
//let task3 = new Task('football', date3);
//// Create two tasks with deadline set to current time
//let task4 = new Task('Task 4', new Date()); 
//let task5 = new Task('Task 5', new Date());
//task1.status = 'In Progress';
//task3.status = 'In Progress';
//task5.status = "Complete";
//let tasks = [task1, task2, task3, task4, task5];
//setTimeout(() => {
//  tasks.sort(Task.comparator);
//  console.log(tasks.join('\n'));
//}, 1000); // Sort and print one second later

// 04. Contacts
class Contact {
	constructor(firstName, lastName, phone, email) {
		this.element = $('<article>');
		this.title = $(`<div class="title">${firstName} ${lastName}<button>&#8505;</button></div>`);
		this.online = false;
		this.element.append(this.title);
		this.info = $(`<div class="info">
				<span>&phone; ${phone}</span>
				<span>&#9993; ${email}</span>
				</div>`);
		this.info.css('display', 'none');
		this.element.append(this.info);
		this.element.find('button').on('click', () => {
			if (this.info.css('display') !== 'none') {
				this.info.css('display', 'none');
			} else {
				this.info.css('display', 'block');
			}
		});
	}
	get online() {
		return this._online;
	}
	set online(isOnline) {
		this._online = isOnline;
		if (isOnline) {
			this.title.addClass('online');
		} else {
			this.title.removeClass('online');
		}
	}
	render(id) {
		$('#' + id).append(this.element);
	}
}

module.exports = { Sumator };

