module.exports = {
    users: [
    	{  
    		'username':'user',
    		'password': '2a00c29680d1f69b972978056df1f3df56881dd919c8f4991b15cb78b4ea796e',//aaa
    		'rentedCars': [ ],
            'salt': 'salt',
    		'role': 'user'
    	}, 
    	{  
            'username':'admin',
            'password': '2a00c29680d1f69b972978056df1f3df56881dd919c8f4991b15cb78b4ea796e',//aaa
            'rentedCars': [ ],
            'role': 'admin',
            'salt': 'salt'
        }
    ],
    cars: [
        {
            'make': 'KIA',
            'model': 'Magentis',
            'color': 'Blue',
            'imageUrl': 'https://parkers-images.bauersecure.com/pagefiles/194507/cut-out/600x400/magentis-03.jpg',
            'rented': 0
        },
        {
            'make': 'Aston Martin',
            'model': 'RX',
            'color': 'silver',
            'imageUrl': 'http://www.motorplanextender.co.za/images/Motor%20Plan%20Extender%20Aston%20Martin.jpg',
            'rented': 0
        },
        {
            'make': 'Ford',
            'model': 'GT 500',
            'color': 'silver',
            'imageUrl': 'https://ccmarketplace.azureedge.net/cc-temp/listing/104/1601/10210745-1967-ford-mustang-shelby-gt500-std-c.jpg',
            'rented': 0
        }
    ]
};