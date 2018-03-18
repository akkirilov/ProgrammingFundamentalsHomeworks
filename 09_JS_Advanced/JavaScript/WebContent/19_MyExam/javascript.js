// 01. Restaurant Bill
function addProduct() {
	let inputs = $('input');
	let productTd = inputs.eq(0);
	let priceTd = inputs.eq(1);
	if (productTd.val() === "" || priceTd.val() === "") {
		return;
	}
	let totalTd = $('tfoot tr td').eq(1);
	let total = Number($(totalTd).text());
	let product = $(productTd).val();
	let price = Number($(priceTd).val());
	
	$('tbody')
		.append($('<tr>')
			.append($('<td>').text(product))
			.append($('<td>').text(price)));
	total += price;
	totalTd.text(total);
	
	productTd.val('');
	priceTd.val('');
	
}

// p02
// Tests in p19_MyExam
class PaymentPackage {
	  constructor(name, value) {
	    this.name = name;
	    this.value = value;
	    this.VAT = 20;      // Default value    
	    this.active = true; // Default value
	  }

	  get name() {
	    return this._name;
	  }

	  set name(newValue) {
	    if (typeof newValue !== 'string') {
	      throw new Error('Name must be a non-empty string');
	    }
	    if (newValue.length === 0) {
	      throw new Error('Name must be a non-empty string');
	    }
	    this._name = newValue;
	  }

	  get value() {
	    return this._value;
	  }

	  set value(newValue) {
	    if (typeof newValue !== 'number') {
	      throw new Error('Value must be a non-negative number');
	    }
	    if (newValue < 0) {
	      throw new Error('Value must be a non-negative number');
	    }
	    this._value = newValue;
	  }

	  get VAT() {
	    return this._VAT;
	  }

	  set VAT(newValue) {
	    if (typeof newValue !== 'number') {
	      throw new Error('VAT must be a non-negative number');
	    }
	    if (newValue < 0) {
	      throw new Error('VAT must be a non-negative number');
	    }
	    this._VAT = newValue;
	  }

	  get active() {
	    return this._active;
	  }

	  set active(newValue) {
	    if (typeof newValue !== 'boolean') {
	      throw new Error('Active status must be a boolean');
	    }
	    this._active = newValue;
	  }

	  toString() {
	    const output = [
	      `Package: ${this.name}` + (this.active === false ? ' (inactive)' : ''),
	      `- Value (excl. VAT): ${this.value}`,
	      `- Value (VAT ${this.VAT}%): ${this.value * (1 + this.VAT / 100)}`
	    ];
	    return output.join('\n');
	  }
	}
module.exports = { PaymentPackage };

// p03
class PaymentProcessor {
	constructor(options) {
		this.payments = {};
		this.setOptions(options);
	}
	
	setOptions(options) {
		if (this.options === undefined) {
			this.options = { types: ["service", "product", "other"], precision: 2 };
		}
		if (options !== undefined) {
			if (options.hasOwnProperty('types')) {
				this.options.types = options.types;
			}
			if (options.hasOwnProperty('precision')) {
				this.options.precision = options.precision;
			}
		}
	}
	
	getPaymentInString(payment) {
		return `Details about payment ID: ${payment.id}
- Name: ${payment.name}
- Type: ${payment.type}
- Value: ${payment.value}`;
	}
	
	get(id) {
		if(!this.payments.hasOwnProperty(id)) {
			throw new Error('ERROR');
		}
		return this.getPaymentInString(this.payments[id]);
	}
	
	deletePayment(id) {
		if(!this.payments.hasOwnProperty(id)) {
			throw new Error('ERROR');
		}
		delete this.payments[id];
	}
	
	registerPayment(id, name, type, value) {
		if (this.payments.hasOwnProperty(id) || typeof id !== 'string' || id === ''
			|| typeof name !== 'string' || name === ''
			|| typeof value !== 'number' || !(this.options.types.indexOf(type) >= 0)) {
			throw new Error('ERROR');
		}
		let newPayment = {
				id, name, type, value: Number(value).toFixed(this.options.precision)
		}
		this.payments[id] = newPayment;
	}
	
	toString() {
		let keys = Object.keys(this.payments);
		let balance = Number(0);
		for (let k of keys) {
			balance += Number(this.payments[k].value);
		}
		return `Summary:
- Payments: ${keys.length}
- Balance: ${balance}`;
	}
}

// p04
class PaymentManager {
	constructor(name) {
		this.element = $(`<table>
    <caption>${name} Payment Manager</caption>
    <thead>
        <tr>
            <th class="name">Name</th>
            <th class="category">Category</th>
            <th class="price">Price</th>
            <th>Actions</th>
        </tr>
	</thead>
    <tbody class="payments">
      
    </tbody>
    <tfoot class="input-data">
        <tr>
            <td><input name="name" type="text"></td>
            <td><input name="category" type="text"></td>
            <td><input name="price" type="number"></td>
            <td><button>Add</button></td></tr>
    </tfoot>
	</table>`);
	$(this.element).find('.input-data button').on('click', () => {
	let pNameInput = $(this.element).find('input[name=name]');
	let pCategoryInput = $(this.element).find('input[name=category]');
	let pPriceInput = $(this.element).find('input[name=price]');
	if (pNameInput.val() === "" || pCategoryInput.val() === "" || pPriceInput.val() === "") {
		return;
	}
	let pName = pNameInput.val();
	let pCategory = pCategoryInput.val();
	let pPrice = Number(Number(pPriceInput.val()).toString());
	pNameInput.val('');
	pCategoryInput.val('');
	pPriceInput.val('');
	$(this.element).find('.payments')
		.append($('<tr>')
			.append($('<td>').text(pName))
			.append($('<td>').text(pCategory))
			.append($('<td>').text(pPrice))
			.append($('<td>')
				.append($('<button>Delete</button>').on('click', function() {
					$(this).parent().parent().remove();
				}))
			)
		);
	})
	}
	
	render(id) {
		$('#'+id).append(this.element);
	}
}

