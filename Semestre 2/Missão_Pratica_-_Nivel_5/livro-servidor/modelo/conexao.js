const mongoose = require('mongoose');

const options = {
  useUnifiedTopology: true,
  useNewUrlParser: true
};

mongoose.connect('mongodb://localhost:27017/livraria', options);

module.exports = mongoose;
