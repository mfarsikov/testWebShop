/**
 * Created by Kot on 23.12.15.
 */
App.config(function($routeProvider, $httpProvider){
    console.error("i am here");
    $routeProvider
        .when('/',{
                templateUrl:'home.html',
                controller: 'BookController'
            })
        .when('/login', {
            templateUrl:'login.html',
            controller:'NavigationController'
        })
        .otherwise('/');
    console.error("i am here");
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

})
    .controller('BookController', function($scope, $http) {
        $http.get('/').success(function(data) {
            $scope.greeting = data;
        })
    })
    .controller('NavigationController', function() {});

