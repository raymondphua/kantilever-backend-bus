What is it?
-----------
####Microservices. TODO

####BIIntegrationService
This should be able to: <br />
<ul>
    <li>Externaly request a specific time in minutes to get the products in that time frame</li>
</ul>

####CatalogService
The catalog service handles the requirements 1, 2. <br />
With this you should be able to: <br />
<ul>
    <li>Get the product details</li>
</ul>

####InventoryService
This service should be able to: <br />
<ul>
    <li>Read the propertie file "config.properties"</li>
    <li>Set duration of the scheduled job</li>
    <li>Set the output folder for the csv file</li>
</ul>

Technology
-------------
<ul> 
    <li>Spring backend</li>
    <li>REST</li>
</ul>

API Example
-------------
You can test these examples with postman or a similar application. <br/>

#####Authentication Service
IMPORTANT: Only if you get a 401 status code (unauthorized) you should execute these steps. 
<br/>
<mark>POST</mark> Trough this route: <br/>

    /oauth/token

<br/>
Select x-www-form-urlencode, in the body you should add the following <br/>
<br/>
|grant_type     |    password           |
<br/>
|username       |    pieter@hotmail.com |
<br/>
|password       |    henkie             |
<br/>
|client_id      |    kantilever         |
<br/>
|client_secret  |    kantiSecret        |
<br/>


<br/>
Example return value:
<br/>
    
    {
      "access_token": "ff501505-0248-43f8-88e7-926da0ca1ba7",
      "token_type": not important,
      "refresh_token": not important,
      "expires_in": not important,
      "scope": not important
    }

<br/>
Now we need to add this to the headers of our request.
<br/>
|Authorization   |    Bearer ff501505-0248-43f8-88e7-926da0ca1ba7|
<br/>
|Content-Type    |    application/json|
<br/>

<br/>

#####Catalog Service
<br/>
<mark>GET</mark> Through this route you can retrieve all brands <br/>

    /catalog/brands

<br/>
Example return value:
<br/>
    
    [
      {
        "_id": "2",
        "name": "Jumbo"
      },
      {
        "_id": "1",
        "name": "Gazelle"
      },
      {
        "_id": "3",
        "name": "Carbon"
      },
      {
        "_id": "4",
        "name": "ForksInc"
      }
    ]
<br/>

<mark>GET</mark> Through this route you can retrieve all categories <br/>

    /catalog/categories
<br/>
Example return value:
<br/>

    [
      {
        "_id": "1",
        "name": "Frame",
        "cName": "frame",
        "imageUrl": "http://res.cloudinary.com/kantilever/image/upload/v1484171995/frame_sdz97a.jpg"
      },
      {
        "_id": "2",
        "name": "Fiets",
        "cName": "fiets",
        "imageUrl": "http://res.cloudinary.com/kantilever/image/upload/v1484171994/bike1_ksjo64.jpg"
      },
      {
        "_id": "3",
        "name": "Fork",
        "cName": "fork",
        "imageUrl": "http://res.cloudinary.com/kantilever/image/upload/v1484171994/fork3_svdu5x.jpg"
      }
    ]
<br/>

<mark>GET</mark> Through this route you can retrieve a category with a specific id<br/>

    /catalog/categories/{id}
<br/>

Example return value:
<br/>

    {
      "categoryId": "1",
      "name": "Frame",
      "imageUrl": "http://res.cloudinary.com/kantilever/image/upload/v1484171995/frame_sdz97a.jpg",
      "cname": "frame"
    }
<br/>

<mark>GET</mark> Through this route you can retrieve all products <br/>

    /catalog/products
<br/>
Example return value:
<br/>

    {
      "total": 8,
      "pageSize": 0,
      "currentPage": 0,
      "items": [
        {
          "id": "1",
          "supplierId": 2,
          "name": "Road-150 Red, 62",
          "description": "This bike is ridden by race winners. Developed with the Adventure Works Cycles professional race team, it has a extremely light heat-treated aluminum frame, and steering that allows precision control.",
          "imgUrl": "http://res.cloudinary.com/kantilever/image/upload/v1484171992/bike3_vhdpgz.png",
          "price": 1366,
          "availableFrom": {
            "year": 2017,
            "month": "JANUARY",
            "era": "CE",
            "dayOfYear": 25,
            "dayOfWeek": "WEDNESDAY",
            "leapYear": false,
            "dayOfMonth": 25,
            "monthValue": 1,
            "chronology": {
              "calendarType": "iso8601",
              "id": "ISO"
            }
          },
          "availableTo": {
            "year": 2017,
            "month": "JANUARY",
            "era": "CE",
            "dayOfYear": 26,
            "dayOfWeek": "THURSDAY",
            "leapYear": false,
            "dayOfMonth": 26,
            "monthValue": 1,
            "chronology": {
              "calendarType": "iso8601",
              "id": "ISO"
            }
          },
          "supplierProductId": "LJ-0192-S",
          "brand": {
            "brandId": "2",
            "name": "Jumbo"
          },
          "categories": [
            {
              "categoryId": "1",
              "name": "Frame",
              "imageUrl": "http://res.cloudinary.com/kantilever/image/upload/v1484171995/frame_sdz97a.jpg",
              "cname": "frame"
            },
            {
              "categoryId": "2",
              "name": "Fiets",
              "imageUrl": "http://res.cloudinary.com/kantilever/image/upload/v1484171994/bike1_ksjo64.jpg",
              "cname": "fiets"
            }
          ],
          "cname": "road-150-red-62"
        } etc..
    
<br/>

#####Catalog Service
<br/>
<mark>GET</mark> Through this route you can retrieve a product with a specific id<br/>

    /catalog/products/{id}
<br/>

Example return value:
<br/>

    {
      "id": "3",
      "supplierId": 2,
      "name": "Road-150 Frame Red, 62",
      "description": "Our lightest and best quality aluminum frame made from the newest alloy; it is welded and heat-treated for strength. Our innovative design results in maximum comfort and performance.",
      "imgUrl": "http://res.cloudinary.com/kantilever/image/upload/v1484171995/frame2_gpedbr.jpg",
      "price": 1349.6,
      "availableFrom": {
        "year": 2017,
        "month": "JANUARY",
        "era": "CE",
        "dayOfYear": 25,
        "dayOfWeek": "WEDNESDAY",
        "leapYear": false,
        "dayOfMonth": 25,
        "monthValue": 1,
        "chronology": {
          "calendarType": "iso8601",
          "id": "ISO"
        }
      },
      "availableTo": {
        "year": 2017,
        "month": "JANUARY",
        "era": "CE",
        "dayOfYear": 26,
        "dayOfWeek": "THURSDAY",
        "leapYear": false,
        "dayOfMonth": 26,
        "monthValue": 1,
        "chronology": {
          "calendarType": "iso8601",
          "id": "ISO"
        }
      },
      "supplierProductId": "FR-M94S-42",
      "brand": {
        "brandId": "3",
        "name": "Carbon"
      },
      "categories": [
        {
          "categoryId": "1",
          "name": "Frame",
          "imageUrl": "http://res.cloudinary.com/kantilever/image/upload/v1484171995/frame_sdz97a.jpg",
          "cname": "frame"
        }
      ],
      "cname": "road-150-frame-red-62"
    }

<br/>

<mark>GET</mark> Through this route you can retrieve a product with custom filters <br/>

    /catalog/products?name={productName}&page={number}&size={size}
<br/>

Example return value:
<br/>

    {
      "total": 1,
      "pageSize": 1,
      "currentPage": 0,
      "items": [
        {
          "id": "5",
          "supplierId": 5,
          "name": "Mountain-100 Silver, 42",
          "description": "Top-of-the-line competition mountain bike. Performance-enhancing options include the innovative HL Frame, super-smooth front suspension, and traction for all terrain.",
          "imgUrl": "http://res.cloudinary.com/kantilever/image/upload/v1484171994/bike1_ksjo64.jpg",
          "price": 1457.99,
          "availableFrom": {
            "year": 2017,
            "month": "JANUARY",
            "era": "CE",
            "dayOfYear": 25,
            "dayOfWeek": "WEDNESDAY",
            "leapYear": false,
            "dayOfMonth": 25,
            "monthValue": 1,
            "chronology": {
              "calendarType": "iso8601",
              "id": "ISO"
            }
          },
          "availableTo": {
            "year": 2017,
            "month": "JANUARY",
            "era": "CE",
            "dayOfYear": 26,
            "dayOfWeek": "THURSDAY",
            "leapYear": false,
            "dayOfMonth": 26,
            "monthValue": 1,
            "chronology": {
              "calendarType": "iso8601",
              "id": "ISO"
            }
          },
          "supplierProductId": "FR-M94S-42",
          "brand": {
            "brandId": "1",
            "name": "Gazelle"
          },
          "categories": [
            {
              "categoryId": "2",
              "name": "Fiets",
              "imageUrl": "http://res.cloudinary.com/kantilever/image/upload/v1484171994/bike1_ksjo64.jpg",
              "cname": "fiets"
            }
          ],
          "cname": "mountain-100-silver-42"
        }
      ]
    }
<br/>

Installation TODO
------------
How to run the microservice. Follow this pattern.

    Run the discovery-service. 
        wait for the service to start.
    
    Run the docker mongo database with the following command: 
        docker run -p 27017:27017 --name kantilever -d mongo
    
    Run the api-gateway. 
        wait for the service to start.        
        
    Run the catalog-service. (Available in the other project)
        wait for the service to start.
    
    Run the customer-service. 
            wait for the service to start.
        
    Run the authentication-server. 
        wait for the service to start.
            
    Run the order-service.
        wait for the service to start.
   
    Run the docker webapp with the following command:
        docker pull martidono/angularjsweb.
        docker run -p 3000:3000 --name webapp -d docker.io/martidono/angularjsweb.

License
---------

MIT License

Copyright (c) 2017 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

Contacts
--------

If you have a concrete bug report for team2 please contact us at 
team2@javaminor.com