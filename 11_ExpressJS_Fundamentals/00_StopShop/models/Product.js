const mongoose = require('mongoose');

let productSchema = mongoose.Schema({
	name : { type: mongoose.Schema.Types.String, required: true },
	description: { type: mongoose.Schema.Types.String },
	price: { type: mongoose.Schema.Types.Number, default: 0, min: 0, max: Number.MAX_SAFE_INTEGER },
	image: { type: mongoose.Schema.Types.String },
	category: { type: mongoose.Schema.ObjectId, ref: 'Category' },
	isBought: { type: mongoose.Schema.Types.Boolean, default: false }
});

productSchema.path('price').validate(function(v) {
	if (this.price == null) {
		this.price = 0;
	}
});

let Product = mongoose.model('Product', productSchema);

module.exports = Product;
