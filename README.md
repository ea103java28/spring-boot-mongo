## Dockerfile

### MongoDB:

 ```
$ docker pull mongo:4.2.19 && docker tag mongo:4.2.19 my-mongo
$ docker run --name my-mongo -p 27017:27017 -d -v $(pwd)/data:/data/db my-mongo
 ```


### Product Features:

1. Create/Read/Update/Delete Products (CRUD)

   |*method*|*url*|*description*|
   |--|--|--|
   |POST|`localhost:8888/products`|Create|
   |GET|`localhost:8888/products/{id}`|Read|
   |PUT|`localhost:8888/products/{id}`|Update|
   |DELETE|`localhost:8888/products/{id}`|Delete|
   |GET|`localhost:8888/products`|Read All|


   POST & PUT request body
     ```
      {
           "name": "test mongo",
           "price": 666
      }
      ```