angular.module('MyApp', [])
    .controller("MyController", function ($scope, $http, $log) {

        $scope.request = function () {
            $http.get('/shop/books')
                .then(function (response) {
                    $log.log(JSON.stringify(response));
                    $scope.books = response.data;
                }, function (response) {
                    $log.log("err");
                    $log.log(JSON.stringify(response));
                })
        }
    });
