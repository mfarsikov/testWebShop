/**
 * Created by Kot on 12.12.15.
 */
'use strict';

App.factory('BookService', ['$http', '$q', '$log', function ($http, $q, $log) {

    return {
        getAllBooks: function () {
            return $http.get('/shop/books')
                .then(function (response) {
                        $log.log(JSON.stringify(response));
                        return response.data;
                    },
                    function (errResponse) {
                        $log.log("err");
                        $log.log(JSON.stringify(errResponse));
                        return $q.reject(errResponse);
                    })
        },
        createBook: function (book) {
            return $http.post('/shop/books', book)
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error while creating book');
                        return $q.reject(errResponse);
                    }
                );
        }
    };


}]);

