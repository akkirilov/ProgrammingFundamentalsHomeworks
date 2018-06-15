const mongoose = require('mongoose');

const productSchema = mongoose.Schema({
	name : { type: mongoose.Schema.Types.String, required: true },
	description: { type: mongoose.Schema.Types.String },
	price: { type: mongoose.Schema.Types.Number, default: 0, min: 0, max: Number.MAX_SAFE_INTEGER },
	image: { type: mongoose.Schema.Types.String },
	creator: { type: mongoose.Schema.ObjectId, ref: 'User', required: true },
	buyer: { type: mongoose.Schema.ObjectId, ref: 'User' },
	category: { type: mongoose.Schema.ObjectId, ref: 'Category', required: true },
	isBought: { type: mongoose.Schema.Types.Boolean, default: false }
});

productSchema.path('price').validate(function(v) {
	if (this.price == null) {
		this.price = 0;
	}
});

let Product = mongoose.model('Product', productSchema);

module.exports = Product;
