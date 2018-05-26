var myApp = angular.module('myApp', ['ngRoute'])
    .constant('NK_API', 'http://172.31.98.252:8080');




myApp.config(['$routeProvider', function($routeProvider) {




    $routeProvider.




    when('/home', {
        templateUrl: 'views/home.html',
        controller: 'homeController'
    }).

    when('/zomato', {
        templateUrl: 'views/zomato.html',
        controller: 'ZomatoController'
    }).

    when('/tripadvisor', {
        templateUrl: 'views/tripadvisor.html',
        controller: 'TripAdvisorController'
    }).




    otherwise({
        redirectTo: '/home'
    });

}]);