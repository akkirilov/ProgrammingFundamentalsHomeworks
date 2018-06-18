const mongoose = require('mongoose');
const encryption = require('../utilities/encryption');
const propertyIsRequired = '{0} is required.';

const userSchema = mongoose.Schema({
	email: {
		type: mongoose.Schema.Types.String,
		required: propertyIsRequired.replace('{0}', 'Email'),
		unique: true
	},
	password: {
		type: mongoose.Schema.Types.String,
		required: propertyIsRequired.replace('{0}', 'Password')
	},
	salt: {
		type: mongoose.Schema.Types.String,
		required: true
	},
	roles: [{ type: mongoose.Schema.Types.String }],
	createdArticles: [{ type: mongoose.Schema.Types.ObjectId, ref: 'Article' }]
});

userSchema.method({
	authenticate: function(password) {
		let hashedPassword = encryption.generateHashedPassword(this.salt, password)
		if (hashedPassword === this.password) {
			return true
		}
		return false
	},
	isAdmin : function() {
		return this.roles.includes('admin');
	}
});

module.exports = mongoose.model('User', userSchema);
