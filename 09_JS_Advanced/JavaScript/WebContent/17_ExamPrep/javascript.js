// 01. Sort Table
function sort(colIndex, descending) {
	let trs = $('tbody tr');
	if (colIndex === 0) {
		if (descending) {
			$('tbody').append(
					trs.toArray()
					.sort((a, b) => $(b).find('td').eq(0).text().localeCompare($(a).find('td').eq(0).text())));
		} else {
			$('tbody').append(
					trs.toArray()
					.sort((a, b) => $(a).find('td').eq(0).text().localeCompare($(b).find('td').eq(0).text())));
		}
	} else {
		if (descending) {
			$('tbody').append(
					trs.toArray()
					.sort((a, b) =>  Number($(b).find('td').eq(1).text()) - Number($(a).find('td').eq(1).text())));
		} else {
			$('tbody').append(
					trs.toArray()
					.sort((a, b) =>  Number($(a).find('td').eq(1).text()) - Number($(b).find('td').eq(1).text())));
		}
	}
}

// 02. String Builder
// Tests in p17_ExamPrep
class StringBuilder {
	  constructor(string) {
	    if (string !== undefined) {
	      StringBuilder._vrfyParam(string);
	      this._stringArray = Array.from(string);
	    } else {
	      this._stringArray = [];
	    }
	  }

	  append(string) {
	    StringBuilder._vrfyParam(string);
	    for(let i = 0; i < string.length; i++) {
	      this._stringArray.push(string[i]);
	    }
	  }

	  prepend(string) {
	    StringBuilder._vrfyParam(string);
	    for(let i = string.length - 1; i >= 0; i--) {
	      this._stringArray.unshift(string[i]);
	    }
	  }

	  insertAt(string, startIndex) {
	    StringBuilder._vrfyParam(string);
	    this._stringArray.splice(startIndex, 0, ...string);
	  }

	  remove(startIndex, length) {
	    this._stringArray.splice(startIndex, length);
	  }

	  static _vrfyParam(param) {
	    if (typeof param !== 'string') throw new TypeError('Argument must be string');
	  }

	  toString() {
	    return this._stringArray.join('');
	  }
}

// 03. Repository
class Repository {
	constructor(props) {
		this.props = props;
		this.data = new Map();
		this.id = 0;
	}
	
	get count() {
		return this.data.size;
	}
	
	add(e) {
		this.validate(e);
		let id = this.id++;
		this.data.set(id, e);
		return id;
	}
	del(i) {
		this.isExist(i);
		this.data.delete(i);
	}
	get(i) {
		this.isExist(i);
		return this.data.get(i);
	}
	update(i, e) {
		this.isExist(i);
		this.validate(e);
		this.data.set(i, e);
	}
	validate(e) {
		for(let p in this.props) {
			if (!e.hasOwnProperty(p)) {
				throw new Error(`Property ${p} is missing from the entity!`);
			}
			if (typeof e[p] !== this.props[p]) {
				throw new TypeError(`Property ${p} is of incorrect type!`);
			}
		}
	}
	isExist(i) {
		if (!this.data.has(i)) {
			throw new Error(`Entity with id: ${i} does not exist!`);
		}
	}
}
// let properties = {
// name: "string",
// age: "number",
// birthday: "object"
// };
// //Initialize the repository
// let repository = new Repository(properties);
// // Add two entities
// let entity = {
// name: "Kiril",
// age: 19,
// birthday: new Date(1998, 0, 7)
// };
// console.log(repository.add(entity)); // Returns 0
// console.log(repository.add(entity)); // Returns 1
// console.log(repository.get(0));
// console.log(repository.get(1));
// console.log(repository.count);

// 04. Dialog
class Dialog {
	constructor(textMessage, callback) {
		this.box = $(`<div class="overlay">
					  <div class="dialog">
					    <p>${textMessage}</p>

					    <button>OK</button>
					    <button>Cancel</button>
					  </div>
					</div>`);
		this.box.find('button').eq(0).on('click', () => {
			let data = {};
			let inputs = this.box.find('input');
			for (let i of inputs) {
				data[$(i).attr('name')] = $(i).val();
			}
			callback(data);
			this.box.remove();
		});
		this.box.find('button').eq(1).on('click', () => {
			this.box.remove();
		});
		
	}
	addInput(label, name, type) {
		this.box.find('button').eq(0).before(`<label>${label}</label><input name="${name}" type="${type}">`);
	}
	render() {
		$('body').append(this.box);
		this.box.show();
	}
}


module.exports = { StringBuilder };