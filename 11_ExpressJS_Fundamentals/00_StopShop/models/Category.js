const mongoose = require('mongoose');

const categorySchema = mongoose.Schema({
	name: { type: mongoose.Schema.Types.String, required: true, unique: true },
	creator: { type: mongoose.Schema.ObjectId, ref: 'User', required: true },
	products: [{ type: mongoose.Schema.Types.ObjectId, ref: 'Product' }]
});

module.exports = mongoose.model('Category', categorySchema);
