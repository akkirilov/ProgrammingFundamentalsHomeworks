const Meme = require('../models/Meme');
const formidable = require('formidable');
const util = require('util');
const shortid = require('shortid');
const fs = require('fs');
const path = require('path');
const pathPrefix = path.normalize(path.join(__dirname, "../"));
const memeStoragePath = "public/memeStorage/";
const saveImagePath = pathPrefix  + memeStoragePath;

function viewAll(req, res) {
	let filePath = pathPrefix + "/views/viewAll.html";
	fs.readFile(filePath, 'utf-8', function(err, html) {
		if (err) {
			console.log(err);
			res.writeHead(404);
			res.end();
			return;
		}
		Meme.find({})
		.then(function(data) {
			let content = '';
			for (let meme of data) {
				content += `<div class="meme">
			          <a href="/getDetails?id=${meme._id}">
			          <img class="memePoster" src="${meme.memeSrc}"/></a>          
			 </div>`;
			}
			res.writeHead(200, {
				'Content-Type': 'text/html'
			});
			res.write(html.replace('<div id="replaceMe">{{replaceMe}}</div>', content));
			res.end();
		})
		.catch(function(err) {
			console.log(err);
		});
	});
}

function viewAddMeme(req, res) {
	let filePath = pathPrefix + "/views/addMeme.html";
	fs.readFile(filePath, 'utf-8', function(err, html) {
		if (err) {
			console.log(err);
			res.writeHead(404);
			res.end();
			return;
		}
		res.writeHead(200, {
			'Content-Type': 'text/html'
		});
		res.write(html);
		res.end();
	});
}

function getDetails(req, res) {
	let filePath = pathPrefix + "/views/details.html";
	fs.readFile(filePath, 'utf-8', function(err, html) {
		if (err) {
			console.log(err);
			res.writeHead(404);
			res.end();
			return;
		}
		Meme.findById(req.params.id)
		.then(function(targetedMeme) {
			let content = `<div class="content">
			    <img src="${targetedMeme.memeSrc}" alt=""/>
			    <h3>Title  ${targetedMeme.title}</h3>
			    <p> ${targetedMeme.description}</p>
			    <a href="${targetedMeme.memeSrc}" download><button>Download Meme</button></a>
			    </div>`;
			res.writeHead(200, {
				'Content-Type': 'text/html'
			});
			res.write(html.replace('<div id="replaceMe">{{replaceMe}}</div>', content));
			res.end();
		})
		.catch(function(err) {
			console.log(err);
			res.writeHead(404);
			res.end();
		});
	});
}

function addMeme(req, res) {
	let form = new formidable.IncomingForm();
    form.parse(req, function (err, fields, files) {
    	let tempPath;
    	let filename;
    	let newPath;
    	
    	let newMeme = { 
    			title: fields.title,
    			description: fields.description,
    	};
    	if (fields.privacy === 'on') {
    		newMeme.privacy = false;
		} else {
			newMeme.privacy = true;
		}
    	if (files.memeSrc.name !== '') {
    		tempPath = files.memeSrc.path;
       	 	filename = shortid.generate() + '.' + files.memeSrc.type.split('/').pop();

       	 	newPath = saveImagePath + filename;
            fs.rename(tempPath, newPath, function (err) {
            	if (err) {
            		console.log(err);
            	}
            });
		}
    	
    	if (filename) {
    		newMeme.memeSrc = memeStoragePath + filename;
    	}
    	Meme.create(newMeme)
    	.then(function(data) {
    		res.writeHead(302, {
				'Location': 'http://' + req.headers.host + '/getDetails?id=' + data._id
			});
			res.end();
		})
    	.catch(function(err) {
			console.log(err);
		});
    });
}

module.exports = (req, res) => {
	if (req.pathname === '/viewAllMemes' && req.method === 'GET') {
		viewAll(req, res);
	} else if (req.pathname === '/addMeme' && req.method === 'GET') {
    viewAddMeme(req, res)
	} else if (req.pathname === '/addMeme' && req.method === 'POST') {
    addMeme(req, res)
	} else if (req.pathname.startsWith('/getDetails') && req.method === 'GET') {
    getDetails(req, res)
	} else {
		return true;
	}
}
