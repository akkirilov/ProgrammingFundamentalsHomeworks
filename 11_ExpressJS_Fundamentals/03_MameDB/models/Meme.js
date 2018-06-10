const mongoose = require('mongoose');

const schema = mongoose.Schema({
    title: { type: mongoose.Schema.Types.String },
    memeSrc: { type: mongoose.Schema.Types.String },
    description: { type: mongoose.Schema.Types.String },
    privacy: { type: mongoose.Schema.Types.Boolean, default: false },
    dateStamp: { type: mongoose.Schema.Types.Date, default: Date.now }
  });

module.exports = mongoose.model('Meme', schema);
